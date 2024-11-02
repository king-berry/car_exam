package com.example.demo.specification;

import com.example.demo.entity.CustomerReceiveAlertPrice;
import com.example.demo.form.CustomerReceiveAlertPrice.CustomerReceiveAlertPriceFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CustomerReceiveAlertPriceSpecification {
    public static Specification<CustomerReceiveAlertPrice> buildSpec(CustomerReceiveAlertPriceFilterForm form) {
        return (root, query, builder) -> {
            if (form == null) {
                return null;
            }
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(form.getName())) {
                String pattern = "%" + form.getName().trim() + "%";
                Path<String> fullName = root.get("fullName");
                Predicate hasFullNameLike = builder.like(fullName, pattern);
                predicates.add(builder.or(hasFullNameLike));
            }

            if (StringUtils.hasText(form.getPhone())) {
                String pattern = "%" + form.getPhone().trim() + "%";
                Path<String> phoneNumber = root.get("phoneNumber");
                Predicate hasPhoneNumberLike = builder.like(phoneNumber, pattern);
                predicates.add(builder.or(hasPhoneNumberLike));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
