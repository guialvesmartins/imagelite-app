package io.github.guialvesmartins.imageliteapi.intra.repository;

import io.github.guialvesmartins.imageliteapi.domain.entity.Image;
import io.github.guialvesmartins.imageliteapi.domain.entity.User;
import io.github.guialvesmartins.imageliteapi.domain.enums.ImageExtension;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.github.guialvesmartins.imageliteapi.intra.repository.specs.GenericSpecs.conjunction;
import static io.github.guialvesmartins.imageliteapi.intra.repository.specs.ImageSpecs.*;
import static org.springframework.data.jpa.domain.Specification.where;

public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);
}
