package com.example.flatservice.dto;

import com.example.flatservice.entity.enums.Layout;
import com.example.flatservice.entity.enums.LivingCondition;
import lombok.Data;

@Data
public class FlatDtoForFilter {
    private Integer page;
    private Integer pageSize;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer minArea;
    private Integer maxArea;
    private Integer numberOfRooms;
    private LivingCondition livingCondition;
    private Layout layout;
}