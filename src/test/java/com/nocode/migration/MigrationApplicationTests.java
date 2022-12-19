package com.nocode.migration;

import com.nocode.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MigrationApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testAssign() {
		User user = new User();
		user.setId(new Long(1));
		user.setUserId(String.valueOf(11));
		user.setUserAge(new Integer(111));

		System.out.println(user.toString());
		System.out.println(user.hashCode());
	}

}
