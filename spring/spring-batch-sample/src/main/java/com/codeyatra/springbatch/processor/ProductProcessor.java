package com.codeyatra.springbatch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.codeyatra.springbatch.dto.Product;

/**
 * 
 * @author codeYatra
 *
 */

@Component("productProcessor")
public class ProductProcessor implements ItemProcessor<Product, Product>{
	
	Logger logger = LoggerFactory.getLogger(ProductProcessor.class);

	@Override
	public Product process(Product product) throws Exception {
		logger.error("Processing : " + product);
		
		String productName = product.getProductName().toUpperCase();
        String productDescription =  product.getProductDescription();
        if(productDescription.isEmpty()) {
        	productDescription = "Dummy Description for: " + productName;
        }
        
        Product updatedProduct = new Product(productName, productDescription, product.getPrice());
        logger.info("Converting (" + product + ") into (" + updatedProduct + ")");

        return updatedProduct;
	}

}
