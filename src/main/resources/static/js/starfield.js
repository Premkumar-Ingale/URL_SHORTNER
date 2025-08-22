let stars = [];

function setup() {
    let cnv = createCanvas(windowWidth, windowHeight);
    cnv.position(0, 0);
    cnv.style('position', 'fixed'); // fixed position
    cnv.style('z-index', '-1');     // put behind content
    cnv.style('top', '0');
    cnv.style('left', '0');

    // Create stars
    for (let i = 0; i < 800; i++) {
        stars.push(new Star());
    }
}



function draw() {
    background(0);

    let centerX = width / 2;
    let maxDist = centerX;
    let distFromCenter = abs(mouseX - centerX);
    let speed = map(distFromCenter, 0, maxDist, 0, 50);

    translate(width / 2, height / 2);
    for (let star of stars) {
        star.update(speed);
        star.show();
    }
}

class Star {
    constructor() {
        this.x = random(-width, width);
        this.y = random(-height, height);
        this.z = random(width);
        this.pz = this.z;
    }
    update(speed) {
        this.z -= speed;
        if (this.z < 1) {
            this.z = width;
            this.x = random(-width, width);
            this.y = random(-height, height);
            this.pz = this.z;
        }
    }
    show() {
        let sx = map(this.x / this.z, 0, 1, 0, width);
        let sy = map(this.y / this.z, 0, 1, 0, height);
        let px = map(this.x / this.pz, 0, 1, 0, width);
        let py = map(this.y / this.pz, 0, 1, 0, height);
        this.pz = this.z;
        stroke(255);
        line(px, py, sx, sy);
    }
}

function windowResized() {
    resizeCanvas(windowWidth, windowHeight);
}
