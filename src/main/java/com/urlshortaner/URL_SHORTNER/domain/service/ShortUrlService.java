package com.urlshortaner.URL_SHORTNER.domain.service;

import com.urlshortaner.URL_SHORTNER.domain.entities.ShortUrl;
import com.urlshortaner.URL_SHORTNER.domain.models.ShortUrlDto;
import com.urlshortaner.URL_SHORTNER.domain.repositories.ShortUrlRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShortUrlService {
    private final ShortUrlRepository shortUrlRepository;
    private final EntityMapper entityMapper;

    public ShortUrlService(ShortUrlRepository shortUrlRepository, EntityMapper entityMapper) {
        this.shortUrlRepository = shortUrlRepository;
        this.entityMapper = entityMapper;
    }

    public List<ShortUrlDto> findAllPublicShortUrls() {
        return shortUrlRepository.findPublicShortUrls().stream().map(entityMapper::toShortUrlDto).toList();
    }
}
