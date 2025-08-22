package com.urlshortaner.URL_SHORTNER.domain.service;

import com.urlshortaner.URL_SHORTNER.domain.entities.ShortUrl;
import com.urlshortaner.URL_SHORTNER.domain.entities.User;
import com.urlshortaner.URL_SHORTNER.domain.models.ShortUrlDto;
import com.urlshortaner.URL_SHORTNER.domain.models.UserDto;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {
    public ShortUrlDto toShortUrlDto(ShortUrl shortUrl) {
        UserDto userDto = null;
        if(shortUrl.getCreatedBy() != null) {
            userDto = toUserDto(shortUrl.getCreatedBy());
        }

        return new ShortUrlDto(
                shortUrl.getId(),
                shortUrl.getShortKey(),
                shortUrl.getOriginalUrl(),
                shortUrl.getIsPrivate(),
                shortUrl.getExpiresAt(),
                userDto,
                shortUrl.getClickCount(),
                shortUrl.getCreatedAt()
        );
    }

    public UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getName());
    }
}
