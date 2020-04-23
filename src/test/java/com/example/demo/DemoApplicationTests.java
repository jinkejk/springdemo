package com.example.demo;

import com.example.demo.bean.Person;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	Person person;

	@Test
	void contextLoads() {
		System.out.println(person);
	}

	@Test
	void logTest(){
		logger.trace("this is trace!");
		logger.error("this is logger error test!");
		logger.info("this is logger info test!");
		logger.warn("this is logger warn test!");
		Assert.assertSame("abc", "abc");
	}
}
