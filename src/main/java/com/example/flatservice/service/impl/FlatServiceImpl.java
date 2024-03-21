package com.example.flatservice.service.impl;

import com.example.flatservice.dto.FlatDtoForAdd;
import com.example.flatservice.dto.FlatDtoForFilter;
import com.example.flatservice.dto.FlatDtoForInformationPage;
import com.example.flatservice.dto.FlatDtoForViewAll;
import com.example.flatservice.entity.Flat;
import com.example.flatservice.entity.enums.StatusState;
import com.example.flatservice.mapper.FlatMapperForAdd;
import com.example.flatservice.mapper.FlatMapperForInformationPage;
import com.example.flatservice.mapper.FlatMapperForViewAll;
import com.example.flatservice.repository.FlatRepository;
import com.example.flatservice.service.FlatService;
import com.example.flatservice.specification.FlatSpecification;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FlatServiceImpl implements FlatService {
    private final FlatRepository flatRepository;
    private final FlatMapperForAdd flatMapperForAdd;
    private final FlatMapperForViewAll flatMapperForViewAll;
    private final FlatMapperForInformationPage flatMapperForInformationPage;
    @Override
    public Page<FlatDtoForViewAll> getAllForAdminByCorpId(Integer page, Integer pageSize, Long corpId) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Order.desc("id")));
        return flatMapperForViewAll.toDtoPage(flatRepository.findAllByCorps(corpId, pageable));
    }

    @Override
    public Page<FlatDtoForViewAll> getAllForCustomer(FlatDtoForFilter flatDtoForFilter) {
        Specification<Flat> specification = new FlatSpecification(flatDtoForFilter);
        Pageable pageable = PageRequest.of(flatDtoForFilter.getPage(), flatDtoForFilter.getPageSize(), Sort.by(Sort.Order.desc("id")));
        Page<FlatDtoForViewAll> result =  flatMapperForViewAll.toDtoPage(flatRepository.findAll(specification, pageable));
        return result;
    }
    @Override
    public Flat getById(Long flatId) {
        return flatRepository.findById(flatId).orElseThrow(
                ()-> {
                    throw new EntityNotFoundException("Building with id="+flatId+" not found");
                }
        );
    }
    @Override
    public void changeStatus(Long flatId, StatusState statusState) {
        Flat flat = getById(flatId);
        flat.setStatusState(statusState);
        save(flat);
    }
    @Override
    @Transactional
    public void save(Flat flat) {
        flatRepository.save(flat);
    }
    @Override
    public FlatDtoForInformationPage getFlatForInformationPage(Long flatId) {
        return flatMapperForInformationPage.toDtoFromEntity(getById(flatId));
    }
    @Override
    @Transactional
    public void add(FlatDtoForAdd flatDtoForAdd) throws IOException {
        save(flatMapperForAdd.updateEntityFromDto(flatDtoForAdd, this));
    }
}