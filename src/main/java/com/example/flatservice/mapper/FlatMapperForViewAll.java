package com.example.flatservice.mapper;

import com.example.flatservice.dto.FlatDtoForViewAll;
import com.example.flatservice.entity.Flat;
import com.example.flatservice.service.client.BuildingServiceClient;
import com.example.flatservice.service.client.MinioServiceClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface FlatMapperForViewAll {
    @Mappings({
            @Mapping(target = "address", ignore = true),
            @Mapping(target = "image", ignore = true)
    })
    FlatDtoForViewAll toDto(Flat flat);
    default FlatDtoForViewAll toDtoFromEntity(Flat flat){
        FlatDtoForViewAll flatDtoForViewAll = toDto(flat);
        if(flat.getImages()!=null && flat.getImages().get(0)!=null)flatDtoForViewAll.setImage(MinioServiceClient.getUrl(flat.getImages().get(0)));
        if(flat.getCorps()!=null)flatDtoForViewAll.setAddress(BuildingServiceClient.getAddressByCorpId(flat.getCorps()));
        return flatDtoForViewAll;
    }
    default Page<FlatDtoForViewAll> toDtoPage(Page<Flat> flats){
        return new PageImpl<>(flats.getContent().stream()
                .map(this::toDtoFromEntity)
                .collect(Collectors.toList()), flats.getPageable(), flats.getTotalElements());
    }
}