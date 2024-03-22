package com.example.flatservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDate;

@Data
@Schema(description = "DTO for the page where all flats will be showed")
public class FlatDtoForViewAll {
    private Long id;
    private Integer price;
    private Integer numberOfRooms;
    private Integer fullArea;
    private String address;
    private String image;
    private LocalDate updatedDate;
}