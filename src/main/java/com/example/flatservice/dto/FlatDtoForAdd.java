package com.example.flatservice.dto;

import com.example.flatservice.entity.enums.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Data
@Schema(description = "DTO for adding flat")
public class FlatDtoForAdd {
    private Long id;
    @Max(value = 100, message = "{error.field.max-value}")
    @Schema(defaultValue = "3")
    private Integer numberOfRooms;
    @Max(value = 10000, message = "{error.field.max-value}")
    @Schema(defaultValue = "280")
    private Integer fullArea;
    @Max(value = 1000, message = "{error.field.max-value}")
    @Schema(defaultValue = "80")
    private Integer kitchenArea;
    @NotNull(message = "{error.field.empty}")
    @Schema(defaultValue = "true")
    private Boolean thereIsBalcony;
    @Size(max = 100, message = "{error.field.size.max}")
    @NotNull(message = "{error.field.empty}")
    @Schema(defaultValue = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula.")
    private String calculationOptions;
    @Max(value = 1000000, message = "{error.field.max-value}")
    @Schema(defaultValue = "1500")
    private Integer agencyCommission;
    @Size(max = 100, message = "{error.field.size.max}")
    @NotNull(message = "{error.field.empty}")
    @Schema(defaultValue = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula.")
    private String description;
    @Max(value = 10000000, message = "{error.field.max-value}")
    @Schema(defaultValue = "35000")
    private Integer price;
    @NotNull(message = "{error.field.empty}")
    private LocalDate updatedDate;
    @NotNull(message = "{error.field.empty}")
    @Schema(defaultValue = "UPDATED")
    private StatusState statusState;
    @NotNull(message = "{error.field.empty}")
    @Schema(defaultValue = "OFFICE")
    private Appointment appointment;
    @NotNull(message = "{error.field.empty}")
    @Schema(defaultValue = "PROPERTY")
    private FoundationDocument foundationDocument;
    @NotNull(message = "{error.field.empty}")
    @Schema(defaultValue = "NEED_REPAIR")
    private LivingCondition livingCondition;
    @NotNull(message = "{error.field.empty}")
    @Schema(defaultValue = "LOFTY")
    private Layout layout;
    @NotNull(message = "{error.field.empty}")
    @Schema(defaultValue = "AUTOMATIC")
    private Heating heating;
    @NotNull(message = "{error.field.empty}")
    private List<MultipartFile> images;
    @NotNull(message = "{error.field.empty}")
    private Long corps;
    @NotNull(message = "{error.field.empty}")
    private Long notary;
}