package com.urlshortaner.URL_SHORTNER;

import com.urlshortaner.URL_SHORTNER.domain.entities.ShortUrl;
import com.urlshortaner.URL_SHORTNER.domain.models.ShortUrlDto;
import com.urlshortaner.URL_SHORTNER.domain.service.ShortUrlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final ShortUrlService shortUrlService;

    public HomeController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<ShortUrlDto> shortUrls = shortUrlService.findAllPublicShortUrls();
        model.addAttribute("shortUrls", shortUrls);
        model.addAttribute("baseUrl", "http://localhost:8080");
        return "index";
    }
}
