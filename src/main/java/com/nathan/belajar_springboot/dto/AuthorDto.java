package com.nathan.belajar_springboot.dto;

import com.nathan.belajar_springboot.validation.annotation.ValidName;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthorDto(
                @ValidName @NotBlank(message = "name cannot blank!") @Size(min = 3, max = 25) String name,
                @NotBlank(message = "description cannot blank!") String description) {

}
