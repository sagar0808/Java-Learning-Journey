package in.master.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class applicationConfig {
    
    @Bean
    public DriverManagerDataSource datasource() {
	
	DriverManagerDataSource datasource = new DriverManagerDataSource();
	
	datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	datasource.setUrl("jdbc:mysql://localhost:3306/springjdbcnpjt");
	datasource.setUsername("root");
	datasource.setPassword("root");
	
	return datasource;
    }
    
    @Bean
    public NamedParameterJdbcTemplate myJdbcTemplate() {
	
	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(datasource());
	
	return template;
    }
}
