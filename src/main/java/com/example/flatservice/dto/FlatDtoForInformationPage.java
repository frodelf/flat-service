package com.example.flatservice.dto;

import com.example.flatservice.entity.enums.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FlatDtoForInformationPage {
    private Long id;
    private Integer numberOfRooms;
    private Integer fullArea;
    private Integer kitchenArea;
    private Boolean thereIsBalcony;
    private String calculationOptions;
    private Integer agencyCommission;
    private String description;
    private Integer price;
    private LocalDate updatedDate;
    private StatusState statusState;
    private Appointment appointment;
    private FoundationDocument foundationDocument;
    private LivingCondition livingCondition;
    private Layout layout;
    private Heating heating;
    private List<String> images;
}