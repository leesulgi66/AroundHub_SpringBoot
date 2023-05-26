package com.example.aroundhub.controller;


import com.example.aroundhub.data.dto.ShortUrlResponseDto;
import com.example.aroundhub.service.ShortUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/short-url")
public class ShortUrlController {

    private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlController.class);

    @Value("${around.hub.short.url.id}")
    private String CLIENT_ID;

    @Value("${around.hub.short.url.secret}")
    private String CLIENT_SECRET;

    ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping()
    public ShortUrlResponseDto generateShortUrl(String originalUrl) {

        LOGGER.info("[generateShortUrl] perform API. CLIENT_ID : {}, CLIENT_SECRET : {}", CLIENT_ID, CLIENT_SECRET);

        return shortUrlService.generateShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
    }

    @GetMapping()
    public ShortUrlResponseDto getShortUrl(String originalUrl) {
        ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto("ss", "ss");

        return shortUrlService.getShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
    }

    @PutMapping("/")
    public ShortUrlResponseDto updateshortUrl(String originalUrl) { return null; }

    @DeleteMapping("/")
    public ShortUrlResponseDto deleteShortUrl(String url) { return null; }
}
