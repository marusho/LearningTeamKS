package seattle.rookie;
//test
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import seattle.rookie.model.FormMotivation;
import seattle.rookie.model.Motivation;
import seattle.rookie.repositories.MotivationRepository;

@RestController
public class AjaxMotivation {

	@Autowired
	MotivationRepository motivationrepo;

	// 編集保存処理
	@RequestMapping(value = "/editComment", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String editMotivation(@RequestBody FormMotivation formMotivation) {

		// Errorsクラスのリストを作成する
		ArrayList<AjaxErrors> errors = new ArrayList<AjaxErrors>();
		errors.add(new AjaxErrors("motivationId", formMotivation.getMotivationId().toString()));

		String x = "---";
		String a = "A";
		String b = "B";
		String c = "C";
		String d = "D";

		if (formMotivation.getComment().length() > 600) {
			errors.add(new AjaxErrors("comment", "コメント範囲を超過しました。600文字以下にしてください。"));
		}
		if (!formMotivation.getCompanyMotivation().equals(a) && !formMotivation.getCompanyMotivation().equals(b)
				&& !formMotivation.getCompanyMotivation().equals(c) && !formMotivation.getCompanyMotivation().equals(d)
				&& !formMotivation.getCompanyMotivation().equals(x)) {
			errors.add(new AjaxErrors("companyMotivation", "不正なデータが入力されました。"));
		}
		if (!formMotivation.getJobMotivation().equals(a) && !formMotivation.getJobMotivation().equals(b)
				&& !formMotivation.getJobMotivation().equals(c) && !formMotivation.getJobMotivation().equals(d)
				&& !formMotivation.getJobMotivation().equals(x)) {
			errors.add(new AjaxErrors("jobMotivation", "不正なデータが入力されました。"));
		}
		if (formMotivation.getRetireRisk() != true && formMotivation.getRetireRisk() != false) {
			errors.add(new AjaxErrors("retireRisk", "不正なデータが入力されました。"));
		}

		// エラーがなかったら保存
		if (errors.size() == 1) {
			Optional<Motivation> motivation = motivationrepo.findById(formMotivation.getMotivationId());
			Motivation motivation1 = motivation.get();
			motivation1.setComment(formMotivation.getComment());
			motivation1.setCompanyMotivation(formMotivation.getCompanyMotivation());
			motivation1.setJobMotivation(formMotivation.getJobMotivation());
			motivation1.setInterviewDate(formMotivation.getInterviewDate());
			motivation1.setRetireRisk(formMotivation.getRetireRisk());
			motivationrepo.saveAndFlush(motivation1);
		} else {
			Gson gson = new Gson();
			// AjaxErrorsクラスの配列を、JSON文字列に変換する
			String errorMessages = gson.toJson(errors);
			return errorMessages;
		}
		Gson g = new Gson();
		return g.toJson("success!");
	}
}