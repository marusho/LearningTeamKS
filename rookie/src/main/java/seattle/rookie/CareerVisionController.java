package seattle.rookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import seattle.rookie.model.CareerVisionsForm;
import seattle.rookie.model.UserForm;

@Controller
@ComponentScan("repositories")
public class CareerVisionController {
	
	@Autowired
	CareerVisionService careerVisionService;

	// キャリアビジョン編集
	@RequestMapping(value = "/CareerVisionEdit/{userId}", method = RequestMethod.GET)
	public ModelAndView editCareerVisions(
			@ModelAttribute("formModel") UserForm data,
			@ModelAttribute("CVformModel") CareerVisionsForm CVForm,
			Model model,
			ModelAndView mav) {

			mav = careerVisionService.editCareerVisionsGet(data, CVForm, model, mav);
			return mav;

	}

	// キャリアビジョン編集保存処理
	@RequestMapping(value = "/CareerVisionsEdit", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView updateCareerVision(
			@ModelAttribute("formModel") UserForm data,
			@ModelAttribute("CVformModel") CareerVisionsForm CVForm,
			ModelAndView mav) {
		
			mav = careerVisionService.updateCareerVisionPost(data, CVForm, mav);
			return mav;
		}

	// キャリアビジョン参照
	@RequestMapping(value = "/CareerVisionShow/{userId}", method = RequestMethod.GET)
	public ModelAndView careerVisionInfo(
			@ModelAttribute("formModel") UserForm data,
			@ModelAttribute("CVformModel") CareerVisionsForm CVForm, Model model,
			ModelAndView mav) {

			mav = careerVisionService.careerVisionInfoGet(data, CVForm, model, mav);
			return mav;
	}
	
}
