package seattle.rookie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import seattle.rookie.service.MasterMaintenanceService;

@Controller
@ComponentScan("repositories")
public class MasterMaintenanceController {

	@Autowired
	MasterMaintenanceService masterMaintenanceService;

	@RequestMapping(value = "/projectList", method = RequestMethod.GET)
	public ModelAndView getProject(
			@RequestParam("customerName") String customerName,
			@RequestParam("projectName") String projectName,
			Model model,
			ModelAndView mav) {

		mav.addObject("projectList", masterMaintenanceService.getProjectList(customerName, projectName));
		return mav;

	}
}
