package seattle.rookie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import seattle.rookie.model.Evaluation;
import seattle.rookie.model.MultipledResult;
import seattle.rookie.model.MyData;
import seattle.rookie.model.Premise;
import seattle.rookie.model.Result;
import seattle.rookie.model.Team;
import seattle.rookie.repositories.EvaluationRepository;
import seattle.rookie.repositories.MyDataRepository;
import seattle.rookie.repositories.PremiseRepository;
import seattle.rookie.repositories.ResultRepository;
import seattle.rookie.repositories.TeamRepository;

@Service
public class ShowResultService {

	@Autowired
	EvaluationRepository evaluationRepository;
	@Autowired
	ResultRepository resultRepository;
	@Autowired
	TeamRepository teamRepository;
	@Autowired
	PremiseRepository premiseRepository;
	@Autowired
	EvaluationRepository evalrepo;
	@Autowired
	MyDataRepository myrepo;
	@Autowired
	TeamRepository teamrepo;

	public ModelAndView showResult(ModelAndView mav) {
		// htmlを出力
		mav.setViewName("ev");
		// 年度を降順で持ってくる
		Calendar calendar = Calendar.getInstance();
		int yearLatest = calendar.get(Calendar.YEAR);
		int yearSecondLatest = calendar.get(Calendar.YEAR) - 1;
		List<Integer> years = resultRepository.findYear();
		if (2 < years.size()) {
			yearLatest = years.get(0);
			yearSecondLatest = years.get(1);
		} else if (1 < years.size()) {
			yearSecondLatest = years.get(0) - 1;
		}
		// 評価結果の配列を宣言
		List<Result> resultsListNew1 = resultRepository.findByYearAndTerm(yearLatest, true);
		List<Result> resultsListNew2 = new ArrayList<Result>();
		List<Result> resultsListNew3 = new ArrayList<Result>();
		// htmlに渡す年度を宣言
		String termLatest;
		String termSecondLatest;
		String termThirdLatest;
		String yearString = String.valueOf(yearLatest);
		String yearSecondString = String.valueOf(yearSecondLatest);
		// 最新データが上期の場合
		if (resultsListNew1.isEmpty()) {
			// 三期分のデータを取ってくる
			resultsListNew1 = resultRepository.findByYearAndTerm(yearLatest, false);
			resultsListNew2 = resultRepository.findByYearAndTerm(yearSecondLatest, true);
			resultsListNew3 = resultRepository.findByYearAndTerm(yearSecondLatest, false);
			// タブ名に出力する名前をセット
			termLatest = yearString + "上期";
			termSecondLatest = yearSecondString + "下期";
			termThirdLatest = yearSecondString + "上期";
			mav.addObject("year1", yearString);
			mav.addObject("year2", yearSecondString);
			mav.addObject("year3", yearSecondString);
			mav.addObject("term1", 0);
			mav.addObject("term2", 1);
			mav.addObject("term3", 0);
			// 最新データが下期の場合
		} else {
			// 二期分のデータをとってくる
			resultsListNew2 = resultRepository.findByYearAndTerm(yearLatest, false);
			resultsListNew3 = resultRepository.findByYearAndTerm(yearSecondLatest, true);
			// タブに出力する名前をセット
			termLatest = yearString + "下期";
			termSecondLatest = yearString + "上期";
			termThirdLatest = yearSecondString + "下期";
			mav.addObject("year1", yearString);
			mav.addObject("year2", yearString);
			mav.addObject("year3", yearSecondString);
			mav.addObject("term1", 1);
			mav.addObject("term2", 0);
			mav.addObject("term3", 1);
		}
		// オブジェクトの配列を作りhtmlに出力

		mav.addObject("multipledResultsNew1", makeList(resultsListNew1));
		mav.addObject("multipledResultsNew2", makeList(resultsListNew2));
		mav.addObject("multipledResultsNew3", makeList(resultsListNew3));
		mav.addObject("termLatest", termLatest);
		mav.addObject("termSecondLatest", termSecondLatest);
		mav.addObject("termThirdLatest", termThirdLatest);

		return mav;
	}

	// 結果出力のためのオブジェクトのリストを作成するメソッド
	List<MultipledResult> makeList(List<Result> list) {
		List<MultipledResult> mr = new ArrayList<MultipledResult>();
		// 各データに応じて前提事項を作成
		for (int i = 0; i < list.size(); i++) {
			// ユーザーIDを結果から参照
			int thisUserId = list.get(i).getUserId();
			// 前提事項をIDから参照
			List<Premise> premise = premiseRepository.findByUserIdAndYearAndTerm(thisUserId, list.get(i).getYear(),
					list.get(i).getTerm());
			boolean attend = premise.get(0).getAttend();
			boolean attitude = premise.get(0).getAttitude();
			boolean securityAccident = premise.get(0).getSecurityAccident();
			// boolean型からString型に読み替える

			// エンジニアレベルに基づいた評価方法を算出
			String engineerlevel = list.get(i).getEngineerLevel();
			Evaluation eval = evalrepo.findByEngineerLevel(engineerlevel);
			Team team = teamrepo.findByTeamId(list.get(i).getTeamId());
			MyData mydata = myrepo.findByUserId(thisUserId);
			Multiple multiple = new Multiple();
			// 計算メソッドに値をわたしリストに格納
			mr.add(multiple.multipleResult(list.get(i), i, eval, mydata, attend, attitude, securityAccident, team));

		}
		return mr;
	}
}
