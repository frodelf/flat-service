package com.example.flatservice.mapper;

import com.example.flatservice.dto.FlatDtoForAdd;
import com.example.flatservice.entity.Flat;
import com.example.flatservice.service.FlatService;
import com.example.flatservice.service.client.MinioServiceClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.io.IOException;

@Mapper(componentModel = "spring")
public interface FlatMapperForAdd {
    @Mapping(target = "images", ignore = true)
    void updateEntityFromDto(FlatDtoForAdd flatDtoForAdd, @MappingTarget Flat flat);
    default Flat updateEntityFromDto(FlatDtoForAdd flatDtoForAdd, FlatService flatService) throws IOException {
        Flat flat = new Flat();
        if(flatDtoForAdd.getId()!=null)flat = flatService.getById(flatDtoForAdd.getId());
        updateEntityFromDto(flatDtoForAdd, flat);
        if(flatDtoForAdd.getImages()!=null)
            flat.getImages().addAll(MinioServiceClient.saveAll(flatDtoForAdd.getImages()));
        return flat;
    }
}