package io.github.guialvesmartins.imageliteapi.intra.repository;
import io.github.guialvesmartins.imageliteapi.domain.entity.Image;
import io.github.guialvesmartins.imageliteapi.domain.enums.ImageExtension;
import io.github.guialvesmartins.imageliteapi.intra.repository.specs.GenericSpecs;
import io.github.guialvesmartins.imageliteapi.intra.repository.specs.ImageSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.github.guialvesmartins.imageliteapi.intra.repository.specs.GenericSpecs.*;
import static io.github.guialvesmartins.imageliteapi.intra.repository.specs.ImageSpecs.*;
import static org.springframework.data.jpa.domain.Specification.where;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query){

        //SELECT * FROM IMAGE WHERE 1 = 1
        Specification<Image> spec = where(conjunction());

        if(extension != null){
            //AND EXTENSION = 'PNG'
            spec = spec.and(extensionEqual(extension));
        }

        if(StringUtils.hasText(query)){
            //AND (NAME LIKE 'QUERY' OR TAGS LIKE 'QUERY')
            spec = spec.and(Specification.anyOf( nameLike(query), tagsLike(query)));
        }

        return findAll(spec);
    }
}
