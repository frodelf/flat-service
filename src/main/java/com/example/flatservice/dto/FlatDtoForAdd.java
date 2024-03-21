package com.example.flatservice.dto;

import com.example.flatservice.entity.enums.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Data
public class FlatDtoForAdd {
    private Long id;
    @Max(value = 100, message = "{error.field.max-value}")
    private Integer numberOfRooms;
    @Max(value = 10000, message = "{error.field.max-value}")
    private Integer fullArea;
    @Max(value = 1000, message = "{error.field.max-value}")
    private Integer kitchenArea;
    @NotNull(message = "{error.field.empty}")
    private Boolean thereIsBalcony;
    @Size(max = 100, message = "{error.field.size.max}")
    @NotNull(message = "{error.field.empty}")
    private String calculationOptions;
    @Max(value = 1000000, message = "{error.field.max-value}")
    private Integer agencyCommission;
    @Size(max = 100, message = "{error.field.size.max}")
    @NotNull(message = "{error.field.empty}")
    private String description;
    @Max(value = 10000000, message = "{error.field.max-value}")
    private Integer price;
    @NotNull(message = "{error.field.empty}")
    private LocalDate updatedDate;
    @NotNull(message = "{error.field.empty}")
    private StatusState statusState;
    @NotNull(message = "{error.field.empty}")
    private Appointment appointment;
    @NotNull(message = "{error.field.empty}")
    private FoundationDocument foundationDocument;
    @NotNull(message = "{error.field.empty}")
    private LivingCondition livingCondition;
    @NotNull(message = "{error.field.empty}")
    private Layout layout;
    @NotNull(message = "{error.field.empty}")
    private Heating heating;
    @NotNull(message = "{error.field.empty}")
    private List<MultipartFile> images;
    @NotNull(message = "{error.field.empty}")
    private Long corps;
    @NotNull(message = "{error.field.empty}")
    private Long notary;
}