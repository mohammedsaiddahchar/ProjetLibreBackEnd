package net.atos.persistence;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:test")
                .username("SA")
                .password("");
        return dataSourceBuilder.build();
    }
}
