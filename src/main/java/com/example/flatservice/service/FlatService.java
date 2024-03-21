package com.example.flatservice.service;

import com.example.flatservice.dto.FlatDtoForAdd;
import com.example.flatservice.dto.FlatDtoForFilter;
import com.example.flatservice.dto.FlatDtoForInformationPage;
import com.example.flatservice.dto.FlatDtoForViewAll;
import com.example.flatservice.entity.Flat;
import com.example.flatservice.entity.enums.StatusState;
import org.springframework.data.domain.Page;

import java.io.IOException;

public interface FlatService {
    Page<FlatDtoForViewAll> getAllForAdminByCorpId(Integer page, Integer pageSize, Long corpId);
    Page<FlatDtoForViewAll> getAllForCustomer(FlatDtoForFilter flatDtoForFilter);
    Flat getById(Long flatId);
    void changeStatus(Long flatId, StatusState statusState);
    void save(Flat flat);
    FlatDtoForInformationPage getFlatForInformationPage(Long flatId);
    void add(FlatDtoForAdd flatDtoForAdd) throws IOException;
}