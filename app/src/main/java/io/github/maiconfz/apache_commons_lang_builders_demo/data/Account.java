package io.github.maiconfz.apache_commons_lang_builders_demo.data;

import java.math.BigInteger;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Account {
    private final BigInteger id;
    private final String username;
    private final String email;
    @ToStringExclude
    private final String password;

    private final Set<Role> roles;
}
