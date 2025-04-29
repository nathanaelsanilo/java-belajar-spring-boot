package com.nathan.belajar_springboot.dto;

import java.util.List;

public record ResultPageResponseDto<T>(
        List<T> result,
        int page,
        Long totalElement) {

}
