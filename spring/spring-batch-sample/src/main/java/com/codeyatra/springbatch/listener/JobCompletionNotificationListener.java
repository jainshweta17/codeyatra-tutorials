package com.codeyatra.springbatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * 
 * @author codeYatra
 *
 */

@Component("jobCompletionNotificationListener")
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static Logger logger = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	@Override
	public void beforeJob(JobExecution jobExecution) {
		logger.error("============before job================");
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		logger.error("============after job================");
	}

}
