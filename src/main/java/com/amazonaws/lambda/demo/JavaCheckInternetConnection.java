package com.amazonaws.lambda.demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class JavaCheckInternetConnection implements RequestHandler<Object, String> {

	@Override
	public String handleRequest(Object input, Context context) {
		try {
			final URL url = new URL("http://www.google.com");
			final URLConnection conn = url.openConnection();
			conn.connect();
			conn.getInputStream().close();
			return "true";
		} catch (MalformedURLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "false";
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "false";
		}
	}
}
