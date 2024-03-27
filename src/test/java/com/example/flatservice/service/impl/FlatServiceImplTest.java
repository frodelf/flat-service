package com.example.flatservice.service.impl;

import com.example.flatservice.dto.FlatDtoForAdd;
import com.example.flatservice.dto.FlatDtoForFilter;
import com.example.flatservice.dto.FlatDtoForViewAll;
import com.example.flatservice.entity.Flat;
import com.example.flatservice.entity.enums.StatusState;
import com.example.flatservice.mapper.FlatMapperForAdd;
import com.example.flatservice.mapper.FlatMapperForInformationPage;
import com.example.flatservice.mapper.FlatMapperForViewAll;
import com.example.flatservice.repository.FlatRepository;
import com.example.flatservice.specification.FlatSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class FlatServiceImplTest {

    @Mock
    private FlatRepository flatRepository;

    @Mock
    private FlatMapperForViewAll flatMapperForViewAll;
    @Mock
    private FlatMapperForAdd flatMapperForAdd;

    @Mock
    private FlatMapperForInformationPage flatMapperForInformationPage;

    @InjectMocks
    private FlatServiceImpl flatService;

    @Test
    void getAllForAdminByCorpId() {
        Integer page = 0;
        Integer pageSize = 10;
        Long corpId = 1L;
        Pageable pageable = Pageable.unpaged();
        Page<Flat> flatPage = mock(Page.class);
        Page<FlatDtoForViewAll> resultPage = mock(Page.class);
        when(flatRepository.findAllByCorps(corpId, pageable)).thenReturn(flatPage);
        when(flatMapperForViewAll.toDtoPage(any())).thenReturn(resultPage);

        Page<FlatDtoForViewAll> result = flatService.getAllForAdminByCorpId(page, pageSize, corpId);

        assertEquals(result, resultPage);
    }

    @Test
    void getAllForCustomer() {
        FlatDtoForFilter flatDtoForFilter = new FlatDtoForFilter();
        flatDtoForFilter.setPage(0);
        flatDtoForFilter.setPageSize(10);
        Specification<Flat> specification = new FlatSpecification(flatDtoForFilter);
        Pageable pageable = PageRequest.of(flatDtoForFilter.getPage(), flatDtoForFilter.getPageSize(), Sort.by(Sort.Order.desc("id")));
        Page<Flat> flatPage = new PageImpl<>(Collections.emptyList());
        Page<FlatDtoForViewAll> resultPage = mock(Page.class);
        when(flatRepository.findAll(specification, pageable)).thenReturn(flatPage);
        when(flatMapperForViewAll.toDtoPage(any())).thenReturn(resultPage);

        Page<FlatDtoForViewAll> result = flatService.getAllForCustomer(flatDtoForFilter);

        assertEquals(result, resultPage);
    }

    @Test
    void getById() {
        Long flatId = 1L;
        Flat flat = new Flat();
        when(flatRepository.findById(flatId)).thenReturn(java.util.Optional.of(flat));

        Flat result = flatService.getById(flatId);

        assertNotNull(result);
        verify(flatRepository).findById(flatId);
    }

    @Test
    void getByIdWithException() {
        Long flatId = 1L;
        when(flatRepository.findById(flatId)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> flatService.getById(flatId));
        verify(flatRepository).findById(flatId);
    }

    @Test
    void changeStatus() {
        Long flatId = 1L;
        Flat flat = new Flat();
        when(flatRepository.findById(flatId)).thenReturn(java.util.Optional.of(flat));

        flatService.changeStatus(flatId, StatusState.DELETED);

        assertEquals(StatusState.DELETED, flat.getStatusState());
        verify(flatRepository).save(flat);
    }

    @Test
    void save() {
        Flat flat = new Flat();
        flatService.save(flat);
        verify(flatRepository).save(flat);
    }

    @Test
    void getFlatForInformationPage() {
        Long flatId = 1L;
        Flat flat = new Flat();
        when(flatRepository.findById(flatId)).thenReturn(java.util.Optional.of(flat));
        flatService.getFlatForInformationPage(flatId);
        verify(flatMapperForInformationPage).toDtoFromEntity(flat);
    }

    @Test
    void add() throws IOException {
        FlatDtoForAdd flatDtoForAdd = new FlatDtoForAdd();
        Flat flat = new Flat();
        when(flatMapperForAdd.updateEntityFromDto(flatDtoForAdd, flatService)).thenReturn(flat);
        flatService.add(flatDtoForAdd);
        verify(flatRepository).save(flat);
    }
}
