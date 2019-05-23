package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class LambdaFunctionHandlersqsTest {

    private SQSEvent input;

    @Before
    public void createInput() throws IOException {
        input = TestUtils.parse("/kinesis-event.json", SQSEvent.class);
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testLambdaFunctionHandlersqs() {
        LambdaFunctionHandlersqs handler = new LambdaFunctionHandlersqs();
        Context ctx = createContext();

        Integer output = handler.handleRequest(input, ctx);

        // TODO: validate output here if needed.
        Assert.assertEquals(1, output.intValue());
    }
}
