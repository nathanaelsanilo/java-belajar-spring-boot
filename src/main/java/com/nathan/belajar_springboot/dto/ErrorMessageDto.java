package com.nathan.belajar_springboot.dto;

import java.util.List;

public record ErrorMessageDto(int code, List<String> message) {

}
