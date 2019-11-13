package com.codeyatra.springbatch.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.codeyatra.springbatch.dto.Product;

/**
 * 
 * @author codeYatra
 *
 */

@Component("productReader")
public class ProductReader extends FlatFileItemReader<Product> {

	DefaultLineMapper<Product> productMapper = new DefaultLineMapper<Product>();
	DelimitedLineTokenizer productTokenizer = new DelimitedLineTokenizer(",");
	BeanWrapperFieldSetMapper<Product> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<Product>();

	public ProductReader() {
		Resource localResource = new ClassPathResource("product-data.csv");
		super.setResource(localResource);

		productTokenizer.setNames(new String[] { "productName", "productDescription", "price" });
		beanWrapperFieldSetMapper.setTargetType(Product.class);
		productMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		productMapper.setLineTokenizer(productTokenizer);
		super.setLineMapper(productMapper);

	}
}
