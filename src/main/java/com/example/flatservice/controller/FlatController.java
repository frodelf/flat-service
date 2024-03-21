package com.example.flatservice.controller;

import com.example.flatservice.dto.FlatDtoForAdd;
import com.example.flatservice.dto.FlatDtoForFilter;
import com.example.flatservice.dto.FlatDtoForViewAll;
import com.example.flatservice.entity.enums.StatusState;
import com.example.flatservice.service.FlatService;
import com.example.flatservice.validator.FlatValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flat")
public class FlatController {
    private final FlatService flatService;
    private final FlatValidator flatValidator;
    @GetMapping("/admin/get-all/{corpsId}")
    public ResponseEntity<Page<FlatDtoForViewAll>> getAllForAdminByCorpId(@RequestParam Integer page, @RequestParam Integer pageSize, @PathVariable Long corpsId){
        return ResponseEntity.ok(flatService.getAllForAdminByCorpId(page, pageSize, corpsId));
    }
    @GetMapping("/get-all-for-consumer")
    public ResponseEntity<Page<FlatDtoForViewAll>> getAllForConsumer(@ModelAttribute FlatDtoForFilter flatDtoForFilter){
        return ResponseEntity.ok(flatService.getAllForCustomer(flatDtoForFilter));
    }
    @PutMapping("/admin/delete/{flatId}")
    public ResponseEntity<String> deleteById(@PathVariable Long flatId){
        flatService.changeStatus(flatId, StatusState.DELETED);
        return ResponseEntity.ok("deleted");
    }
    @PutMapping("/admin/rejected/{flatId}")
    public ResponseEntity<String> rejectedById(@PathVariable Long flatId){
        flatService.changeStatus(flatId, StatusState.REJECTED);
        return ResponseEntity.ok("changed");
    }
    @PutMapping("/admin/approved/{flatId}")
    public ResponseEntity<String> approvedById(@PathVariable Long flatId){
        flatService.changeStatus(flatId, StatusState.APPROVED);
        return ResponseEntity.ok("changed");
    }
    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> add(@ModelAttribute @Valid FlatDtoForAdd flatDtoForAdd, BindingResult bindingResult) throws IOException {
        flatValidator.validate(flatDtoForAdd, bindingResult);
        Map<String, String> errorsMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> errorsMap.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsMap);
        }
        flatService.add(flatDtoForAdd);
        return ResponseEntity.ok().body(Collections.singletonMap("status", "saved"));
    }
}