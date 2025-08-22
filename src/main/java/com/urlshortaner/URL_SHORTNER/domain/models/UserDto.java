package com.urlshortaner.URL_SHORTNER.domain.models;

import java.io.Serializable;

/**
 * DTO for {@link com.urlshortaner.URL_SHORTNER.domain.entities.User}
 */
public record UserDto(Long id, String name) implements Serializable {
}