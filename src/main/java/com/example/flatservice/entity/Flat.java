package com.example.flatservice.entity;

import com.example.flatservice.entity.enums.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ElementCollection
    private List<String> images;
    private Long corps;
    private Long notary;
}