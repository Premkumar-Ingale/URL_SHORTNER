package com.urlshortaner.URL_SHORTNER.domain.repositories;

import com.urlshortaner.URL_SHORTNER.domain.entities.ShortUrl;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
    @Query("select su from ShortUrl su left join fetch su.createdBy where su.isPrivate = false order by su.createdAt desc")
//@Query("select su from ShortUrl su where su.isPrivate = false order by su.createdAt desc")
//@EntityGraph(attributePaths = {"CreatedBy"})
List<ShortUrl> findPublicShortUrls();
}
