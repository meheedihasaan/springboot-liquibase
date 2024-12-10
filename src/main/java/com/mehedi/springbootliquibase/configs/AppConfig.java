package com.mehedi.springbootliquibase.configs;

import com.mehedi.springbootliquibase.audits.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditingAuditorProvider", dateTimeProviderRef = "auditingDateTimeProvider")
public class AppConfig {

    @Bean(name = "auditingAuditorProvider")
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

    @Bean(name = "auditingDateTimeProvider")
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(OffsetDateTime.now(ZoneOffset.UTC));
    }
}
