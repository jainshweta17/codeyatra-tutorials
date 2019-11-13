package com.codeyatra.springbatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @author codeYatra
 *
 */

@Component("stepCompletionNotificationListener")
public class StepCompletionNotificationListener implements StepExecutionListener {

	Logger logger = LoggerFactory.getLogger(StepCompletionNotificationListener.class);
	
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		logger.error("************agter step****************");
		logger.error("Step Status:: " + stepExecution.getStatus());
		return stepExecution.getExitStatus();
	}

	@Override
	public void beforeStep(StepExecution arg0) {
		logger.error("************before step****************");
	}

}
