package com.sw.test.demo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sw.core.entity.Demo;
import com.sw.core.mapper.DemoMapper;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoCrudTest {

	@Autowired
	private DemoMapper demoMapper;
	
	@Test
	public void testAdd() {
		
		Demo demo = new Demo();
		//demo.setId(1);
		demo.setAge(18);
		demo.setCreateTime(new Date());
		demo.setName("张三");
		demo.setSex(1);
		
		int rs = demoMapper.insert(demo);
		assertEquals(1, rs);
	}
}
