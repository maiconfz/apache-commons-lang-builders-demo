package io.github.maiconfz.apache_commons_lang_builders_demo.demo;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.github.maiconfz.apache_commons_lang_builders_demo.data.Account;
import io.github.maiconfz.apache_commons_lang_builders_demo.data.Role;

@Component
public class CompareToHashCodeEqualsBuildersDemo implements CommandLineRunner {
        private static final Logger LOGGER = LoggerFactory.getLogger(CompareToHashCodeEqualsBuildersDemo.class);

        @Override
        public void run(String... args) throws Exception {
                LOGGER.info("## Starting CompareToHashCodeEqualsBuildersDemo");
                final var account1 = new Account(BigInteger.ONE, "admin", "admin@demo.com", "12345",
                                new HashSet<>(Arrays.asList(Role.ADMIN)));
                final var account2 = new Account(BigInteger.TWO, "guest", "guest@demo.com", "12345",
                                new HashSet<>(Arrays.asList(Role.GUEST)));

                LOGGER.info("  account1 compareTo account2: {}", account1.compareTo(account2));
                LOGGER.info("  account1 compareTo account1: {}", account1.compareTo(account1));
                LOGGER.info("  account2 compareTo account1: {}", account2.compareTo(account1));

                LOGGER.info("  account1 compareTo null: {}", account1.compareTo(null));

                LOGGER.info("  account1 equals account2: {}", account1.equals(account2));
                LOGGER.info("  account1 equals null: {}", account1.equals(null));

                LOGGER.info("  account1 hashCode: {}", account1.hashCode());
                LOGGER.info("  account2 hashCode: {}", account2.hashCode());

                LOGGER.info("## End of CompareToHashCodeEqualsBuildersDemo\n\n");

        }

}
