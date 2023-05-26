package com.example.aroundhub.data.repository;

import com.example.aroundhub.data.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {

    ShortUrl findByUrl(String url);

    ShortUrl findByOrgUrl(String originalUrl);

}
