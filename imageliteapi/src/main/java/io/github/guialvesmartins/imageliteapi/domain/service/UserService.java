package io.github.guialvesmartins.imageliteapi.domain.service;

import io.github.guialvesmartins.imageliteapi.domain.AccessToken;
import io.github.guialvesmartins.imageliteapi.domain.entity.Image;
import io.github.guialvesmartins.imageliteapi.domain.entity.User;
import io.github.guialvesmartins.imageliteapi.domain.enums.ImageExtension;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User getByEmail(String email);
    User save(User user);
    AccessToken autheticate(String email, String password);
}
