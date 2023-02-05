package io.github.maiconfz.apache_commons_lang_builders_demo.data;

import java.math.BigInteger;
import java.util.Set;

import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ReflectionDiffBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Account implements Diffable<Account> {
    private final BigInteger id;
    private final String username;
    private final String email;
    @ToStringExclude
    private final String password;

    private final Set<Role> roles;

    @Override
    public String toString(){
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
    }

    @Override
    public DiffResult<Account> diff(Account obj) {
        return new ReflectionDiffBuilder<>(this, obj, ToStringStyle.SHORT_PREFIX_STYLE).build();
    }

}
