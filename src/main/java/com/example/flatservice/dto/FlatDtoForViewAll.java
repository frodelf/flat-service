package com.example.flatservice.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FlatDtoForViewAll {
    private Long id;
    private Integer price;
    private Integer numberOfRooms;
    private Integer fullArea;
    private String address;
    private String image;
    private LocalDate updatedDate;
}