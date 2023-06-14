package com.example.aroundhub.data.repository;

import com.example.aroundhub.data.dto.ShortUrlResponseDto;
import org.springframework.data.repository.CrudRepository;

public interface ShortUrlRedisRepository extends CrudRepository<ShortUrlResponseDto, String> {
}
