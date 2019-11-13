package com.codeyatra.springbatch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codeyatra.springbatch.dto.Product;
import com.codeyatra.springbatch.listener.JobCompletionNotificationListener;
import com.codeyatra.springbatch.listener.StepCompletionNotificationListener;
import com.codeyatra.springbatch.processor.ProductProcessor;
import com.codeyatra.springbatch.reader.ProductReader;

/**
 * 
 * @author codeYatra
 *
 */

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Autowired
    public ProductProcessor productProcessor;
	
	@Autowired
    public ProductReader productReader;
    
	@Autowired 
	StepCompletionNotificationListener stepCompletionNotificationListener;

	@Autowired
	JobLauncher jobLauncher;
	
	
	@Bean
	public JdbcBatchItemWriter<Product> writer(DataSource dataSource){
		return new JdbcBatchItemWriterBuilder<Product>()
	            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	            .sql("INSERT INTO product (product_name, product_description, price) VALUES "
	            		+ "(:productName, :productDescription, :price)")
	            .dataSource(dataSource)
	            .build();
	}
	
	@Bean
	public Job loadProductsJob(JobCompletionNotificationListener listener, Step step1) {
		
		return jobBuilderFactory.get("loadProductsJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}
	
	@Bean
	public Step step1(JdbcBatchItemWriter<Product> writer) {
		return stepBuilderFactory.get("step1")
				.<Product, Product> chunk(10)
				.reader(productReader)
				.processor(productProcessor)
				.writer(writer)
				.listener(stepCompletionNotificationListener)
				.build();
	}
}
