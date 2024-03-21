package com.example.flatservice.mapper;

import com.example.flatservice.dto.FlatDtoForInformationPage;
import com.example.flatservice.entity.Flat;
import com.example.flatservice.service.client.MinioServiceClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FlatMapperForInformationPage {
    @Mapping(target = "images", ignore = true)
    FlatDtoForInformationPage toDto(Flat flat);
    default FlatDtoForInformationPage toDtoFromEntity(Flat flat){
        FlatDtoForInformationPage flatDtoForInformationPage = toDto(flat);
        if(flatDtoForInformationPage.getImages()!=null)flatDtoForInformationPage.setImages(MinioServiceClient.getUrl(flat.getImages()));
        return flatDtoForInformationPage;
    }
}