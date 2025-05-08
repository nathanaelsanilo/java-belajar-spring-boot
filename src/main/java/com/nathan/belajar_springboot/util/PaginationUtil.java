package com.nathan.belajar_springboot.util;

import org.springframework.data.domain.Sort;

public class PaginationUtil {

    public static Sort.Direction getSortDirection(String direction) {
        if (direction.equalsIgnoreCase("asc")) {
            return Sort.Direction.ASC;
        }

        return Sort.Direction.DESC;
    }
}
