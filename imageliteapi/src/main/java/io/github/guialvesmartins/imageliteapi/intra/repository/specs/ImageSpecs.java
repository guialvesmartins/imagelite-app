package io.github.guialvesmartins.imageliteapi.intra.repository.specs;

import io.github.guialvesmartins.imageliteapi.domain.entity.Image;
import io.github.guialvesmartins.imageliteapi.domain.enums.ImageExtension;
import org.springframework.data.jpa.domain.Specification;

public class ImageSpecs {
    private ImageSpecs() {}

    public static Specification<Image> extensionEqual(ImageExtension extension){
        return (root, qry, criteriaBuilder) -> criteriaBuilder.equal(root.get("extension"), extension);
    }

    public static Specification<Image> nameLike(String name){
        return (root, qry, criteriaBuilder) -> criteriaBuilder.like( criteriaBuilder.upper(root.get("name")), "%" + name.toUpperCase() + "%");
    }

    public static Specification<Image> tagsLike(String tags){
        return (root, qry, criteriaBuilder) -> criteriaBuilder.like( criteriaBuilder.upper(root.get("name")), "%" + tags.toUpperCase() + "%");
    }
}
