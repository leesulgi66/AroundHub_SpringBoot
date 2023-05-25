package com.example.aroundhub.service;

import com.example.aroundhub.data.dto.ShortUrlResponseDto;

public interface ShortUrlService {

    ShortUrlResponseDto getShortUrl(String clientId, String clientSecret, String originalUrl);

    ShortUrlResponseDto generateShortUrl(String clientId, String clientSecret, String originalUrl);

    ShortUrlResponseDto updateShortUrl(String clientId, String clientSecret, String originalUrl);

    ShortUrlResponseDto deleteByshortUrl(String shortUrl);

    ShortUrlResponseDto deleteByOriginalUrl(String originalUrl);

}
