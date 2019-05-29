package seattle.rookie.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import seattle.rookie.service.MasterMaintenanceService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MasterMaintenanceControllerTest {

	// モックサーバー（AutoConfigureMockMvcアノテーションでよしなにしてくれる）
	@Autowired
	private MockMvc mvc;

	@Autowired
	MasterMaintenanceService masterMaintenanceService;

	@Before
	public void before() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new MasterMaintenanceController()).build();
	}

	@Test
	public void testGetProjectList() {
		String customerName = "";
		String projectName = "";
		System.out.println(projectName);
		try {
			mvc.perform(get("/projectList"))
					.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
