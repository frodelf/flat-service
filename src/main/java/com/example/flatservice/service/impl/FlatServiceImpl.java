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
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Log4j2
@Service
@RequiredArgsConstructor
public class FlatServiceImpl implements FlatService {
    private final FlatRepository flatRepository;
    private final FlatMapperForAdd flatMapperForAdd;
    private final FlatMapperForViewAll flatMapperForViewAll;
    private final FlatMapperForInformationPage flatMapperForInformationPage;
    @Override
    public Page<FlatDtoForViewAll> getAllForAdminByCorpId(Integer page, Integer pageSize, Long corpId) {
        log.info("FlatServiceImpl-getAllForAdminByCorpId start");
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Order.desc("id")));
        Page<FlatDtoForViewAll> res = flatMapperForViewAll.toDtoPage(flatRepository.findAllByCorps(corpId, pageable));
        log.info("FlatServiceImpl-getAllForAdminByCorpId finish");
        return res;
    }

    @Override
    public Page<FlatDtoForViewAll> getAllForCustomer(FlatDtoForFilter flatDtoForFilter) {
        log.info("FlatServiceImpl-getAllForCustomer start");
        Specification<Flat> specification = new FlatSpecification(flatDtoForFilter);
        Pageable pageable = PageRequest.of(flatDtoForFilter.getPage(), flatDtoForFilter.getPageSize(), Sort.by(Sort.Order.desc("id")));
        Page<FlatDtoForViewAll> result =  flatMapperForViewAll.toDtoPage(flatRepository.findAll(specification, pageable));
        log.info("FlatServiceImpl-getAllForCustomer finish");
        return result;
    }
    @Override
    public Flat getById(Long flatId) {
        log.info("FlatServiceImpl-getById start");
        Flat flat = flatRepository.findById(flatId).orElseThrow(
                ()-> {
                    throw new EntityNotFoundException("Building with id="+flatId+" not found");
                }
        );
        log.info("FlatServiceImpl-getById finish");
        return flat;
    }
    @Override
    public void changeStatus(Long flatId, StatusState statusState) {
        log.info("FlatServiceImpl-changeStatus start");
        Flat flat = getById(flatId);
        flat.setStatusState(statusState);
        save(flat);
        log.info("FlatServiceImpl-changeStatus finish");
    }
    @Override
    @Transactional
    public void save(Flat flat) {
        log.info("FlatServiceImpl-save start");
        flatRepository.save(flat);
        log.info("FlatServiceImpl-save finish");
    }
    @Override
    public FlatDtoForInformationPage getFlatForInformationPage(Long flatId) {
        log.info("FlatServiceImpl-getFlatForInformationPage start");
        FlatDtoForInformationPage flatDtoForInformationPage = flatMapperForInformationPage.toDtoFromEntity(getById(flatId));
        log.info("FlatServiceImpl-getFlatForInformationPage finish");
        return flatDtoForInformationPage;
    }
    @Override
    @Transactional
    public void add(FlatDtoForAdd flatDtoForAdd) throws IOException {
        log.info("FlatServiceImpl-add start");
        save(flatMapperForAdd.updateEntityFromDto(flatDtoForAdd, this));
        log.info("FlatServiceImpl-add finish");
    }
}