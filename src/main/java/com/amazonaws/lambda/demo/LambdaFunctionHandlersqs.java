package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

public class LambdaFunctionHandlersqs implements RequestHandler<SQSEvent, Integer> {

	@Override
	public Integer handleRequest(SQSEvent event, Context context) {
		for (SQSMessage msg : event.getRecords()) {
			System.out.println(new String(msg.getBody()));
		}
		return event.getRecords().size();
	}
}
