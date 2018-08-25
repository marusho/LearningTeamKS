package seattle.rookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import seattle.rookie.model.EvaluationCreateForm;
import seattle.rookie.util.UserNotFoundException;

@Controller
public class EvaluationController {

	@Autowired
	CreateEvaluationService createEvaluationService;

	/*
	 * 個人の評価を編集・登録するページを取得
	 */
	@RequestMapping(value = "/evaluation/{userId}", method = RequestMethod.GET)
	public ModelAndView evaluationEdit(@PathVariable int userId, ModelAndView mav) throws UserNotFoundException {

		mav = createEvaluationService.createEvaluationGet(mav, userId);
		return mav;

	}

	/*
	 * 入力した評価結果を保存
	 */
	@RequestMapping(value = "/evaluation", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView evaluationUpdate(@ModelAttribute("formModel") @Validated EvaluationCreateForm eform,
			BindingResult thisResult, ModelAndView mav) {
		mav = createEvaluationService.createEvaluationPost(eform, thisResult, mav);
		return mav;
	}

}
