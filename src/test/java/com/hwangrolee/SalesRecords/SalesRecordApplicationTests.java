package com.hwangrolee.SalesRecords;

import com.hwangrolee.SalesRecords.service.SalesRecordsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalesRecordApplicationTests {

	@Autowired
	private SalesRecordsService salesRecordsService;

	@Test
	public void addSalesRecords() {

	}

	@Test
	public void contextLoads() {

		salesRecordsService.listSalesRecords().getContent().forEach(salesRecords -> {
			System.out.println(salesRecords);
		});
	}
}
