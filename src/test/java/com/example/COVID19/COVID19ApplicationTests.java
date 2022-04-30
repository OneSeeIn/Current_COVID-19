package com.example.COVID19;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@SpringBootTest
class COVID19ApplicationTests {

	@Test
	void contextLoads() {
		String SeoulDate = LocalDate.now(ZoneId.of("Asia/Seoul")).toString().replaceAll("-","");
		System.out.println(SeoulDate);
	}

}
