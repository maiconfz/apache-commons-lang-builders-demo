package io.github.maiconfz.apache_commons_lang_builders_demo.data;

import java.math.BigInteger;
import java.util.Set;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.HashCodeExclude;
import org.apache.commons.lang3.builder.ReflectionDiffBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Account implements Diffable<Account>, Comparable<Account> {
    private final BigInteger id;

    @HashCodeExclude
    @EqualsExclude
    private final String username;

    @HashCodeExclude
    @EqualsExclude
    private final String email;

    @ToStringExclude
    @HashCodeExclude
    @EqualsExclude
    private final String password;

    @HashCodeExclude
    @EqualsExclude
    private final Set<Role> roles;

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
    }

    @Override
    public DiffResult<Account> diff(Account obj) {
        return new ReflectionDiffBuilder<>(this, obj, ToStringStyle.SHORT_PREFIX_STYLE).build();
    }

    @Override
    public int compareTo(Account o) {
        return new CompareToBuilder()
                .append(this, o,
                        (Account o1, Account o2) -> new CompareToBuilder().append(o1.getId(), o2.getId())
                                .toComparison())
                .toComparison();
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

}
