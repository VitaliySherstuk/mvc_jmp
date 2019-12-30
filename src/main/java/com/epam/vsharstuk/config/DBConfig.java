package com.epam.vsharstuk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DBConfig {

    /*@Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;*/


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("org.h2.Driver");
        source.setUrl("jdbc:h2:mem:testdb;create=true");
        source.setUsername("sa");
        source.setPassword("");
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("file:src/main/resources/createDB.sql")
                .build();
       /*String url = "jdbc:h2:~/data/createDB;DB_CLOSE_DELAY=-1";
       String user = "sa";
       String password = "";
       String driver = "org.h2.Driver";
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(url, user, password);
        driverManagerDataSource.setDriverClassName(driver);
        return driverManagerDataSource;*/
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
}
