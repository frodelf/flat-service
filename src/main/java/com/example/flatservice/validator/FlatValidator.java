package com.example.flatservice.validator;

import com.example.flatservice.dto.FlatDtoForAdd;
import com.example.flatservice.validator.util.ValidUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class FlatValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return FlatDtoForAdd.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FlatDtoForAdd flatDtoForAdd = (FlatDtoForAdd) target;
        if(flatDtoForAdd.getId()!=null){
            if(flatDtoForAdd.getImages()==null || flatDtoForAdd.getImages().get(0)==null){
                errors.rejectValue("images", "", "Can't br null");
            }else {
                for (MultipartFile image : flatDtoForAdd.getImages()) {
                    ValidUtil.validImage(image, errors, "images");
                }
            }
        }else {
            if(flatDtoForAdd.getImages()!=null && flatDtoForAdd.getImages().get(0)!=null){
                for (MultipartFile image : flatDtoForAdd.getImages()) {
                    ValidUtil.validImage(image, errors, "images");
                }
            }
        }
    }
}