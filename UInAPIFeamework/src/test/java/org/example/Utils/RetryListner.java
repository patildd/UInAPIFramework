package org.example.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListner implements IRetryAnalyzer {
private static int retryCount=0;
//private static int max_count =3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        int max_count = Integer.parseInt(Hooks.properties.getProperty("testRetryCount"));
        if(retryCount <max_count)
        {
            retryCount++;
            return true;

        }
        return false;
    }
}
