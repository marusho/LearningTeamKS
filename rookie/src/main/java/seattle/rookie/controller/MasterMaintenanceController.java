package seattle.rookie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import seattle.rookie.model.ProjectDto;
import seattle.rookie.model.ProjectEntity;
import seattle.rookie.repositories.ProjectRepository;
import seattle.rookie.service.MasterMaintenanceService;

@Controller
@ComponentScan("repositories")
public class MasterMaintenanceController {

	@Autowired
	MasterMaintenanceService masterMaintenanceService;

	@Autowired
	ProjectRepository projectRepository;

	// キャリアビジョン編集
	@RequestMapping(value = "/projectList", method = RequestMethod.GET)
	public ModelAndView getProject(
			@RequestParam("customerName") String customerName,
			@RequestParam("projectName") String projectName,
			Model model,
			ModelAndView mav) {

		List<ProjectEntity> projectList = projectRepository.findAll();
		ProjectDto projectResult = new ProjectDto();
		List<ProjectDto> projectResultList = new ArrayList();

		if (projectList != null) {
			for (ProjectEntity project:projectList) {
				projectResult = new ProjectDto();
				projectResult.setProjectId(project.getProjectId());
				projectResult.setCustomerName("SBT");
				projectResult.setProjectName(project.getProjectName());
				projectResult.setExpansionPossibilities("小");
//				projectResult.setExpansionPossibilities(project.getExpansionPossibilities());
				projectResult.setIncreaseNumber(project.getIncreaseNumber());
				projectResult.setSalesRepresentativeName("小林大悟");
//				projectResult.setSalesRepresentativeName(project.getSalesRepresentative());
				projectResult.setRegistered_at(project.getRegistered_at());
				projectResult.setRegistered_by(project.getRegistered_by());
				projectResult.setUpdated_at(project.getUpdated_at());
				projectResult.setUpdated_by(project.getUpdated_by());
				projectResult.setVersion(project.getVersion());


				projectResultList.add(projectResult);
			}
		}

			mav.addObject("projectList", projectResultList);
			return mav;

	}

}
