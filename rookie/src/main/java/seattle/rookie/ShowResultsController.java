package seattle.rookie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		// 正規表現の試験
        // 検索する文字列を用意
        String str = "123";
        String str1 = ".";
        String str2 = "\\.";
        String str3 = "\\/";
        String str4 = "/";
        String str5 = "a\\\\/";

        // 正規表現のパターンを作成
        Pattern p = Pattern.compile("^[0-9\\\\\\*\\+\\.\\?\\^\\$\\-\\|\\/]+$");
        Matcher m = p.matcher(str);
        Matcher m1 = p.matcher(str1);
        Matcher m2 = p.matcher(str2);
        Matcher m3 = p.matcher(str3);
        Matcher m4 = p.matcher(str4);
        Matcher m5 = p.matcher(str5);

        System.out.println(m.find());
        System.out.println(m1.find());
        System.out.println(m2.find());
        System.out.println(m3.find());
        System.out.println(m4.find());
        System.out.println(m5.find());

		return mav;
	}
}
