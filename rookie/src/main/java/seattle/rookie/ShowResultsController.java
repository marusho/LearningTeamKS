package seattle.rookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowResultsController {
	@Autowired
	ShowResultService showResult;

	// 評価シートを表示するメソッド

	@RequestMapping("/evaluations")
	public ModelAndView showEvaluation(ModelAndView mav) {
		mav = showResult.showResult(mav);
		return mav;
	}
}
