package seattle.rookie.service;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MasterMaintenanceServiceTest {

	/*
	 * @SpringBootTestを付けることでSpringのJava/XML Based Configurationなどの設定を読み込んでくれる
	 * */

	@Autowired
	MasterMaintenanceService masterMaintenanceService;

	@Test
	public void testGetProjectList() {
		System.out.println(masterMaintenanceService.getProjectList(StringUtils.EMPTY, StringUtils.EMPTY));
	}

}
