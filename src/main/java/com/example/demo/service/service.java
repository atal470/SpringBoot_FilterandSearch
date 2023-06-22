package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class service {

    public static Specification<Product> getSpec(String msn, String od, String Title) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (msn != null && !msn.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("msn"), msn));
            }

            if (od != null && !od.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("od"), od));
            }

            if (Title != null && !Title.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("Title"), Title));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
