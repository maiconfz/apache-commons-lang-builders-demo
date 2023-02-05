package io.github.maiconfz.apache_commons_lang_builders_demo.demo;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;

import org.apache.commons.lang3.builder.DiffResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.github.maiconfz.apache_commons_lang_builders_demo.data.Account;
import io.github.maiconfz.apache_commons_lang_builders_demo.data.Role;

@Component
public class ReflectionDiffBuilderDemo implements CommandLineRunner {
        private final Logger LOGGER = LoggerFactory.getLogger(ReflectionDiffBuilderDemo.class);

        @Override
        public void run(String... args) throws Exception {
                LOGGER.info("## Starting ReflectionDiffBuilderDemo");
                final var account1 = new Account(BigInteger.ONE, "admin", "admin@demo.com", "12345",
                                new HashSet<>(Arrays.asList(Role.ADMIN)));
                final var account2 = new Account(BigInteger.TWO, "guest", "guest@demo.com", "12345",
                                new HashSet<>(Arrays.asList(Role.GUEST)));

                final var diffResult = account1.diff(account2);
                LOGGER.info("  DiffResult of account1 and account2: {}", diffResult);
                LOGGER.info("  Diffs: {}", diffResult.getDiffs());

                LOGGER.info("## End of ReflectionDiffBuilderDemo\n\n");

        }

}
