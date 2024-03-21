package com.example.flatservice.specification;

import com.example.flatservice.dto.FlatDtoForFilter;
import com.example.flatservice.entity.Flat;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class FlatSpecification implements Specification<Flat> {
    private FlatDtoForFilter flatDtoForFilter;

    public FlatSpecification(FlatDtoForFilter flatDtoForFilter) {
        this.flatDtoForFilter = flatDtoForFilter;
    }

    @Override
    public Predicate toPredicate(Root<Flat> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if(flatDtoForFilter.getMinPrice()!=null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), flatDtoForFilter.getMinPrice()));
        }
        if(flatDtoForFilter.getMaxPrice()!=null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), flatDtoForFilter.getMaxPrice()));
        }
        if(flatDtoForFilter.getMinArea()!=null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("fullArea"), flatDtoForFilter.getMinPrice()));
        }
        if(flatDtoForFilter.getMaxArea()!=null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("fullArea"), flatDtoForFilter.getMaxPrice()));
        }
        if(flatDtoForFilter.getNumberOfRooms()!=null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("numberOfRooms"), flatDtoForFilter.getNumberOfRooms()));
        }
        if(flatDtoForFilter.getLayout()!=null) {
            predicates.add(criteriaBuilder.equal(root.get("layout"), flatDtoForFilter.getLayout()));
        }
        if(flatDtoForFilter.getLivingCondition()!=null) {
            predicates.add(criteriaBuilder.equal(root.get("livingCondition"), flatDtoForFilter.getLivingCondition()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
