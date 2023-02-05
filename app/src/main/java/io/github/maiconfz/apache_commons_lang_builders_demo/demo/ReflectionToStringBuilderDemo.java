package io.github.maiconfz.apache_commons_lang_builders_demo.demo;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.github.maiconfz.apache_commons_lang_builders_demo.data.Account;
import io.github.maiconfz.apache_commons_lang_builders_demo.data.Role;

@Component
public class ReflectionToStringBuilderDemo implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionToStringBuilderDemo.class);

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("## Starting ReflectionToStringBuilderDemo");
        final var account = new Account(BigInteger.ONE, "maicon", "demo@demo.com", "12345",
                new HashSet<>(Arrays.asList(Role.ADMIN)));
        LOGGER.info("  Account.class toString: {}", account);
        LOGGER.info("  Account.class ReflectionToStringBuilder toString:");
        LOGGER.info("    DEFAULT_STYLE: {}", ReflectionToStringBuilder.toString(account));
        LOGGER.info("    DEFAULT_STYLE: {}", ReflectionToStringBuilder.toString(account, ToStringStyle.DEFAULT_STYLE));
        LOGGER.info("    JSON_STYLE: {}", ReflectionToStringBuilder.toString(account, ToStringStyle.JSON_STYLE));
        LOGGER.info("    MULTI_LINE_STYLE: {}",
                ReflectionToStringBuilder.toString(account, ToStringStyle.MULTI_LINE_STYLE));
        LOGGER.info("    NO_CLASS_NAME_STYLE: {}",
                ReflectionToStringBuilder.toString(account, ToStringStyle.NO_CLASS_NAME_STYLE));
        LOGGER.info("    NO_FIELD_NAMES_STYLE: {}",
                ReflectionToStringBuilder.toString(account, ToStringStyle.NO_FIELD_NAMES_STYLE));
        LOGGER.info("    SHORT_PREFIX_STYLE: {}",
                ReflectionToStringBuilder.toString(account, ToStringStyle.SHORT_PREFIX_STYLE));
        LOGGER.info("    SIMPLE_STYLE: {}",
                ReflectionToStringBuilder.toString(account, ToStringStyle.SIMPLE_STYLE));
        LOGGER.info("    Excluding field email: {}",
                new ReflectionToStringBuilder(account, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("email")
                        .toString());

        LOGGER.info("## End of ReflectionToStringBuilderDemo\n\n");

    }

}
