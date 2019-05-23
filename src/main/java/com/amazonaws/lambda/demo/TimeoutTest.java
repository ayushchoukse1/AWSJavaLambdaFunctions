package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class TimeoutTest implements RequestHandler<Object, String> {

	@Override
	public String handleRequest(Object input, Context context) {
		context.getLogger().log("Input: " + input);
		System.out.println();
		int i = 10;
		int j = 0;

		try {
			System.out.println(i / j);
			System.out.println("test");
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

		// TODO: implement your handler
		return "test";
	}

}
