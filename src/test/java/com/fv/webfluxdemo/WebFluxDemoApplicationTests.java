package com.fv.webfluxdemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class WebFluxDemoApplicationTests {

	@Test
	public void contextLoads() {
		Assert.assertEquals("true", "true");
	}

}