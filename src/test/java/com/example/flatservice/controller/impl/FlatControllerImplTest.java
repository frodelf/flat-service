package com.example.flatservice.controller.impl;

import com.example.flatservice.dto.FlatDtoForAdd;
import com.example.flatservice.dto.FlatDtoForFilter;
import com.example.flatservice.dto.FlatDtoForViewAll;
import com.example.flatservice.entity.enums.StatusState;
import com.example.flatservice.service.FlatService;
import com.example.flatservice.validator.FlatValidator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class FlatControllerImplTest {
    @Mock
    private FlatService flatService;
    @Mock
    private FlatValidator flatValidator;
    @InjectMocks
    private FlatControllerImpl flatController;
    @Test
    void getAllForAdminByCorpId() {
        Integer page = 0;
        Integer pageSize = 10;
        Long corpsId = 1L;
        Page<FlatDtoForViewAll> flatPage = Mockito.mock(Page.class);
        when(flatService.getAllForAdminByCorpId(page, pageSize, corpsId)).thenReturn(flatPage);

        ResponseEntity<Page<FlatDtoForViewAll>> response = flatController.getAllForAdminByCorpId(page, pageSize, corpsId);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertSame(flatPage, response.getBody());
    }
    @Test
    void getAllForConsumer() {
        FlatDtoForFilter flatDtoForFilter = new FlatDtoForFilter();
        Page<FlatDtoForViewAll> flatPage = Mockito.mock(Page.class);
        when(flatService.getAllForCustomer(flatDtoForFilter)).thenReturn(flatPage);

        ResponseEntity<Page<FlatDtoForViewAll>> response = flatController.getAllForConsumer(flatDtoForFilter);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertSame(flatPage, response.getBody());
    }

    @Test
    void deleteById() {
        Long flatId = 1L;

        ResponseEntity<String> response = flatController.deleteById(flatId);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("deleted", response.getBody());
        verify(flatService).changeStatus(flatId, StatusState.DELETED);
    }

    @Test
    void rejectedById() {
        Long flatId = 1L;

        ResponseEntity<String> response = flatController.rejectedById(flatId);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("changed", response.getBody());
        verify(flatService).changeStatus(flatId, StatusState.REJECTED);
    }

    @Test
    void approvedById() {
        Long flatId = 1L;

        ResponseEntity<String> response = flatController.approvedById(flatId);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("changed", response.getBody());
        verify(flatService).changeStatus(flatId, StatusState.APPROVED);
    }

    @Test
    void add() throws IOException {
        FlatDtoForAdd flatDtoForAdd = new FlatDtoForAdd();
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);

        ResponseEntity<Map<String, String>> response = flatController.add(flatDtoForAdd, bindingResult);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("saved", response.getBody().get("status"));
        verify(flatService).add(flatDtoForAdd);
    }
    @Test
    void addWhenValidationErrorsExist() throws IOException {
        FlatDtoForAdd flatDtoForAdd = new FlatDtoForAdd();
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(true);

        ResponseEntity<Map<String, String>> response = flatController.add(flatDtoForAdd, bindingResult);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertFalse(response.getBody().containsKey("field"));
        verify(flatService, never()).add(flatDtoForAdd);
    }
}