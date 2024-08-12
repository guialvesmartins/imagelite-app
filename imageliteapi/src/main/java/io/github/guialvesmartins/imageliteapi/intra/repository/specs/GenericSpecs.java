package io.github.guialvesmartins.imageliteapi.intra.repository.specs;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecs {
    private  GenericSpecs(){}

    public static <T> Specification<T> conjunction (){
        return (root, qry, criteriaBuilder) -> criteriaBuilder.conjunction();
    }
}
