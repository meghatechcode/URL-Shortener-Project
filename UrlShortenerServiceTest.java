 package com.example.urlshortener.service;

import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.repository.UrlMappingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UrlShortenerServiceTest {

    @InjectMocks
    private UrlShortenerService urlShortenerService;

    @Mock
    private UrlMappingRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShortenUrlReturnsShortCode() {
        UrlMapping saved = new UrlMapping();
        saved.setId(123L);
        saved.setOriginalUrl("https://example.com");

        when(repository.save(any(UrlMapping.class))).thenReturn(saved);

        String result = urlShortenerService.shortenUrl("https://example.com");
        assertNotNull(result);
        assertTrue(result.length() > 0);
    }

    @Test
    void testGetOriginalUrlReturnsCorrectUrl() {
        UrlMapping mapping = new UrlMapping();
        mapping.setShortCode("abc123");
        mapping.setOriginalUrl("https://example.com");
        mapping.setAccessCount(0);

        when(repository.findByShortCode("abc123")).thenReturn(Optional.of(mapping));

        String result = urlShortenerService.getOriginalUrl("abc123");
        assertEquals("https://example.com", result);
        verify(repository, times(1)).save(any(UrlMapping.class));
    }

    @Test
    void testGetOriginalUrlThrowsIfNotFound() {
        when(repository.findByShortCode("notfound")).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> urlShortenerService.getOriginalUrl("notfound"));
    }
}
