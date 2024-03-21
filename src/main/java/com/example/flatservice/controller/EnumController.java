package com.example.flatservice.controller;

import com.example.flatservice.entity.enums.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enum")
public class EnumController {
    @GetMapping("/appointment")
    public ResponseEntity<Map<String, String>> getAllAppointment(){
        Map<String, String> result = new HashMap<>();
        for (Appointment appointment : Appointment.values()) {
            result.put(appointment.name(), appointment.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/construction-technologies")
    public ResponseEntity<Map<String, String>> getConstructionTechnologies(){
        Map<String, String> result = new HashMap<>();
        for (ConstructionTechnologies value : ConstructionTechnologies.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/electricity")
    public ResponseEntity<Map<String, String>> getElectricity(){
        Map<String, String> result = new HashMap<>();
        for (Electricity value : Electricity.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/foundation-document")
    public ResponseEntity<Map<String, String>> getFoundationDocument(){
        Map<String, String> result = new HashMap<>();
        for (FoundationDocument value : FoundationDocument.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/gas")
    public ResponseEntity<Map<String, String>> getGas(){
        Map<String, String> result = new HashMap<>();
        for (Gas value : Gas.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/heating")
    public ResponseEntity<Map<String, String>> getHeating(){
        Map<String, String> result = new HashMap<>();
        for (Heating value : Heating.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/layout")
    public ResponseEntity<Map<String, String>> getLayout(){
        Map<String, String> result = new HashMap<>();
        for (Layout value : Layout.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/level")
    public ResponseEntity<Map<String, String>> getLevel(){
        Map<String, String> result = new HashMap<>();
        for (Level value : Level.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/living-condition")
    public ResponseEntity<Map<String, String>> getLivingCondition(){
        Map<String, String> result = new HashMap<>();
        for (LivingCondition value : LivingCondition.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/sewage")
    public ResponseEntity<Map<String, String>> getSewage(){
        Map<String, String> result = new HashMap<>();
        for (Sewage value : Sewage.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/status-building")
    public ResponseEntity<Map<String, String>> getStatusBuilding(){
        Map<String, String> result = new HashMap<>();
        for (StatusBuilding value : StatusBuilding.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/status-state")
    public ResponseEntity<Map<String, String>> getStatusState(){
        Map<String, String> result = new HashMap<>();
        for (StatusState value : StatusState.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/status-user")
    public ResponseEntity<Map<String, String>> getStatusUser(){
        Map<String, String> result = new HashMap<>();
        for (StatusUser value : StatusUser.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/territory")
    public ResponseEntity<Map<String, String>> getTerritory(){
        Map<String, String> result = new HashMap<>();
        for (Territory value : Territory.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/type-building")
    public ResponseEntity<Map<String, String>> getTypeBuilding(){
        Map<String, String> result = new HashMap<>();
        for (TypeBuilding value : TypeBuilding.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/water-supply")
    public ResponseEntity<Map<String, String>> getWaterSupply(){
        Map<String, String> result = new HashMap<>();
        for (WaterSupply value : WaterSupply.values()) {
            result.put(value.name(), value.name());
        }
        return ResponseEntity.ok(result);
    }
}