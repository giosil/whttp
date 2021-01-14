package org.dew.test;

import java.util.HashMap;
import java.util.Map;

import org.dew.http.WHttp;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestWHttp extends TestCase {
  
  public TestWHttp(String testName) {
    super(testName);
  }
  
  public static Test suite() {
    return new TestSuite(TestWHttp.class);
  }
  
  public 
  void testApp() 
    throws Exception 
  {
    String url = System.getProperty("test.url");
    if(url == null || url.length() == 0) {
      System.out.println("Set -Dtest.url");
      return;
    }
    if(url.equalsIgnoreCase("echo")) {
      url = "http://localhost:8080/echo/test";
    }
    
    String data = "{\"firstName\":\"Clark\",\"lastName\":\"Kent\"}";
    
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("folder", "heroes");
    
    WHttp whttp = new WHttp(url);
    whttp.setBasicAuthUsername("user");
    whttp.setBasicAuthPassword("pass");
    whttp.setTracerRequest(System.out);
    whttp.setTracerResponse(System.out);
    
    String response = whttp.post("contacts", parameters, data);
    
    int status = whttp.head();
    System.out.println("status=" + status);
    
    System.out.println("response=" + response);
  }
}
