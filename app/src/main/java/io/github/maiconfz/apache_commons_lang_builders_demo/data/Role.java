package io.github.maiconfz.apache_commons_lang_builders_demo.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN(1, "ADMIN"), USER(2, "USER"), GUEST(3, "GUEST");

    private final Integer id;
    private final String name;
}
