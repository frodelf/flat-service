package com.example.flatservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@Tag(name = "Enum controller", description = "Enum API")
public interface EnumController {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all appointments for select")
    ResponseEntity<Map<String, String>> getAllAppointment();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all construction technologies for select")
    ResponseEntity<Map<String, String>> getConstructionTechnologies();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all electricities for select")
    ResponseEntity<Map<String, String>> getElectricity();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all foundation documents for select")
    ResponseEntity<Map<String, String>> getFoundationDocument();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all gases for select")
    ResponseEntity<Map<String, String>> getGas();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all heats for select")
    ResponseEntity<Map<String, String>> getHeating();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all layout for select")
    ResponseEntity<Map<String, String>> getLayout();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all levels for select")
    ResponseEntity<Map<String, String>> getLevel();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all living conditions for select")
    ResponseEntity<Map<String, String>> getLivingCondition();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all sewage for select")
    ResponseEntity<Map<String, String>> getSewage();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all status building for select")
    ResponseEntity<Map<String, String>> getStatusBuilding();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all status state for select")
    ResponseEntity<Map<String, String>> getStatusState();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all status user for select")
    ResponseEntity<Map<String, String>> getStatusUser();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all territory for select")
    ResponseEntity<Map<String, String>> getTerritory();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all type building for select")
    ResponseEntity<Map<String, String>> getTypeBuilding();
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
    })
    @Operation(summary = "The request to get all water supply for select")
    ResponseEntity<Map<String, String>> getWaterSupply();
}