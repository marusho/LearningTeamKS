package seattle.rookie;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;

import seattle.rookie.model.EvaluationCreateForm;
import seattle.rookie.model.MyData;
import seattle.rookie.model.Premise;
import seattle.rookie.model.Result;
import seattle.rookie.model.Team;
import seattle.rookie.repositories.MyDataRepository;
import seattle.rookie.repositories.PremiseRepository;
import seattle.rookie.repositories.ResultRepository;
import seattle.rookie.repositories.TeamRepository;

@Service
public class CreateEvaluationService {

	@Autowired
	ResultRepository resultrepo;

	@Autowired
	PremiseRepository premiserepo;

	@Autowired
	TeamRepository teamrepo;

	@Autowired
	MyDataRepository mydatarepo;

	public ModelAndView createEvaluationGet(ModelAndView mav, int userId) {
		mav.setViewName("evaluationForm");
		try {
			// UserIdからデータを検索し、最新の個人のデータを取得
			Result result = resultrepo.findLatestData((int) userId, true);
			// String engineerLevel="";
			if (result == null) {
				result = resultrepo.findLatestData((int) userId, false);
			}
			if (result == null) {
				result = new Result();
				// エンジニアレベルを取得
				// engineerLevel = result.getEngineerLevel();
			}

			// チーム名のみをリストで取得
			List<String> teamNames = teamrepo.getTeamNameList();

			// UserIdでユーザーを特定
			MyData mydata = mydatarepo.findByUserId((int) userId);
			// ユーザー名を取得
			String userName = mydata.getUserName();
			// 社員番号を取得
			int employeeNumber = mydata.getEmployeeNumber();
			// Profileを表示
			mav.addObject("userId", userId);
			mav.addObject("employeeNumber", employeeNumber);
			mav.addObject("name", userName);
			mav.addObject("engineerLevel", result.getEngineerLevel());

			/*
			 * 過去の評価データが無い場合⇒新規登録
			 */

			mav.addObject("formModel", result);
			// プルダウンのための情報を渡す
			mav.addObject("teamList", teamNames);
			mav.addObject("selectScores", getSelectedScores());
			return mav;
		} catch (Exception e) {
			mav.setViewName("ErrorMsg");
			mav.addObject("msg", "ユーザーが見つかりません");
			return mav;
		}
	}

	private Map<Integer, Float> getSelectedScores() {
		// プルダウンに格納する数値データを作成
		Map<Integer, Float> selectMap = new LinkedHashMap<Integer, Float>();
		selectMap.put(1, (float) 0.0);
		selectMap.put(2, (float) 1.0);
		selectMap.put(3, (float) 3.0);
		selectMap.put(4, (float) 5.0);
		return selectMap;
	}

	public ModelAndView createEvaluationPost(@Validated EvaluationCreateForm eform, BindingResult thisResult,
			ModelAndView mav) {
		if (thisResult.hasErrors()) {

			mav = createEvaluationGet(mav, eform.getUserId());
			mav.addObject("errorStr", thisResult.getFieldError());
			return mav;
		} else {
			// チーム名を取得
			Team team = teamrepo.findByTeam(eform.getTeamName());

			// 登録・更新日時を自動取得
			Date today = new Date();
			String sqlDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(today);

			/*
			 * 編集者・更新者を自動登録する処理
			 */
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userName;
			if (principal instanceof UserDetails) {
				userName = ((UserDetails) principal).getUsername();
			} else {
				userName = principal.toString();
			}
			MyData thisMydata = mydatarepo.findByEmail(userName);
			String name = thisMydata.getUserName();

			/*
			 * 年度・期が一致するデータは1ユーザー1つに絞るための処理
			 */

			boolean b;
			if (eform.getTermName().equals("上期")) {
				b = false;
			} else {
				b = true;
			}

			// Result・Premiseをクエリ文で取得
			Result result = resultrepo.findPerson(eform.getUserId(), eform.getYear(), b);
			Premise premise = premiserepo.findPerson(eform.getUserId(), eform.getYear(), b);

			// MyDataからも同一ユーザーのデータを取得
			MyData mydata = mydatarepo.findByUserId(eform.getUserId());
			if (result == null) {
				result = new Result();
				premise = new Premise();
				// 登録者、登録日をセット
				result.setRegisteredAt(sqlDate);
				result.setRegisteredBy(name);
				premise.setRegisteredAt(sqlDate);
				premise.setRegisteredBy(name);
			} else {
				int version = result.getVersion();
				version++;
				result.setVersion(version);
				premise.setVersion(version);

			}

			/*
			 * ログイン情報から、登録・編集者名を取得し自動で記録
			 */

			/**
			 * 評価素点+前提事項をまとめたモデル(EvaluationCreateForm)からデータを取得し、 ResultとPremiseのそれぞれに保存
			 */
			result.setUserId(eform.getUserId());
			result.setTeamId(team.getTeamId());
			result.setEngineerLevel(eform.getEngineerLevel());
			result.setYear(eform.getYear());
			result.setTerm(eform.checkTermName(eform.getTermName()));
			result.setSatisfyScore(eform.getSatisfyScore());
			result.setCommitmentScore(eform.getCommitmentScore());
			result.setProposalScore(eform.getProposalScore());
			result.setInternalCommunicationScore(eform.getInternalCommunicationScore());
			result.setDevelopmentScore(eform.getDevelopmentScore());
			result.setItSkillsScore(eform.getItSkillsScore());
			result.setUnderstandScore(eform.getUnderstandScore());
			result.setLeadershipScore(eform.getLeadershipScore());
			result.setResolveScore(eform.getResolveScore());
			result.setCommunicationScore(eform.getCommunicationScore());
			result.setProfessionalScore(eform.getProfessionalScore());
			result.setFieldSalesScore(eform.getFieldSalesScore());
			result.setThanksScore(eform.getThanksScore());
			result.setEngineScore(eform.getEngineScore());
			result.setAllScore(eform.getAllScore());
			result.setMasterpieceScore(eform.getMasterpieceScore());
			result.setStockScore(eform.getStockScore());
			result.setSeattleBrandScore(eform.getSeattleBrandScore());
			result.setRemark(eform.getRemark());
			result.setTotalScore(eform.getTotalScore());
			result.setUpdatedBy(name);
			result.setUpdatedAt(sqlDate);
			// 合計値を計算
			float score = eform.getSatisfyScore() + eform.getCommitmentScore() + eform.getProposalScore()
					+ eform.getInternalCommunicationScore() + eform.getDevelopmentScore() + eform.getItSkillsScore()
					+ eform.getUnderstandScore() + eform.getLeadershipScore() + eform.getResolveScore()
					+ eform.getCommunicationScore() + eform.getProfessionalScore() + eform.getFieldSalesScore()
					+ eform.getThanksScore() + eform.getEngineScore() + eform.getAllScore()
					+ eform.getMasterpieceScore() + eform.getStockScore() + eform.getSeattleBrandScore();

			result.setTotalScore(score);

			// MyDataに情報をセット
			mydata.setEngineerLevel(eform.getEngineerLevel());

			// Premiseに情報をセット
			premise.setUserId(eform.getUserId());
			premise.setYear(eform.getYear());
			premise.setTerm(eform.checkTermName(eform.getTermName()));
			premise.setAttend(eform.checkAttend(eform.getAttendString()));
			premise.setAttitude(eform.checkAttitude(eform.getAttitudeString()));
			premise.setSecurityAccident(eform.checkSecurityAccident(eform.getSecurityAccidentString()));
			premise.setUpdatedBy(name);
			premise.setUpdatedAt(sqlDate);

			// Result,Premise,MyDataにデータを保存
			resultrepo.saveAndFlush(result);
			premiserepo.saveAndFlush(premise);
			mydatarepo.saveAndFlush(mydata);

			// 登録後、評価一覧のページに遷移
			mav = new ModelAndView("redirect:/evaluations");
			return mav;
		}
	}
}
