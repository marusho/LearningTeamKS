package seattle.rookie;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import seattle.rookie.model.MotivDTO;
import seattle.rookie.model.Motivation;
import seattle.rookie.repositories.MiddleDepartmentRepository;
import seattle.rookie.repositories.MotivationRepository;
import seattle.rookie.repositories.MyDataRepository;

@Controller
public class ShowMotivationController {

	@Autowired
	MotivationRepository motivationrepo;

	@Autowired
	MiddleDepartmentRepository midrepo;

	@Autowired
	MyDataRepository mydatarepo;

	// プルダウン選択肢
	private Map<Integer, String> getCompanyMotivation() {
		Map<Integer, String> companyMap = new LinkedHashMap<Integer, String>();
		companyMap.put(1, "A");
		companyMap.put(2, "B");
		companyMap.put(3, "C");
		companyMap.put(4, "D");
		return companyMap;
	}

	private Map<Integer, String> getJobMotivation() {
		Map<Integer, String> jobMap = new LinkedHashMap<Integer, String>();
		jobMap.put(1, "A");
		jobMap.put(2, "B");
		jobMap.put(3, "C");
		jobMap.put(4, "D");
		return jobMap;
	}

	// モチベーション一括編集画面表示
	@RequestMapping(value = "/editmotivation", method = RequestMethod.GET)
	public ModelAndView showMotivation(ModelAndView mav) {
		mav.setViewName("motivation");

		Calendar thisMonth = Calendar.getInstance();
		Calendar oneMonthAgo = Calendar.getInstance();
		Calendar twoMonthAgo = Calendar.getInstance();
		Calendar threeMonthAgo = Calendar.getInstance();
		Calendar fourMonthAgo = Calendar.getInstance();
		Calendar fiveMonthAgo = Calendar.getInstance();
		Calendar sixMonthAgo = Calendar.getInstance();
		Calendar sevenMonthAgo = Calendar.getInstance();

		// 過去7ヶ月分をaddする
		oneMonthAgo.add(Calendar.MONTH, -1); // 先月
		twoMonthAgo.add(Calendar.MONTH, -2); // 2ヶ月前
		threeMonthAgo.add(Calendar.MONTH, -3); // 3ヶ月前
		fourMonthAgo.add(Calendar.MONTH, -4); // 4ヶ月前
		fiveMonthAgo.add(Calendar.MONTH, -5); // 5ヶ月前
		sixMonthAgo.add(Calendar.MONTH, -6); // 6ヶ月前
		sevenMonthAgo.add(Calendar.MONTH, -7); // 7ヶ月前

		// listにはMotivationテーブルの１レコード
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sarchDate = Date.valueOf(sdf.format(sevenMonthAgo.getTimeInMillis()));// 7ヶ月前
		// 今月と過去6ヵ月分のモチベーションのリストをlistに詰める（userid昇順、date降順）
		List<Motivation> list = motivationrepo.findByDateGreaterThanOrderByMydataUserIdAscDateDesc(sarchDate);
		
		// motivationDTOにはDTOずつのリスト、最後はmotivationDTOに入れてviewに渡す
		List<MotivDTO> motivationDTOList = new ArrayList<MotivDTO>();
		MotivDTO motivationDTO = new MotivDTO();
		// motivTBLの過去7ヵ月分のレコードまわす
		// もし一致しなければ外に出して新しくDTOを作る(新しいレコード)、一致すればセットする
		int i = 0;
		for (Motivation lis : list) {
			Calendar recodeDate = Calendar.getInstance();
			recodeDate.setTime(lis.getDate()); // motivationのリストのDateをカレンダー型に変換
			int recodeMonth = recodeDate.get(Calendar.MONTH) + 1; // recodeMonthはレコードごとのgetMonth()に当たる部分
			// MotivationのgetIdがdtoのuserIdと違う、かつdelflgがついてなかったら
			if (lis.getMydata().getUserId() != motivationDTO.getUserId() && lis.getMydata().getDeleteFlag()==0
					&& recodeMonth <= thisMonth.get(Calendar.MONTH) + 1) {
				// 1回目はすでに箱があるからそのまま入れて、それ以降はaddしてnewする
				if (i != 0) {
					motivationDTOList.add(motivationDTO);
					motivationDTO = new MotivDTO();
				}
				motivationDTO.setUserId(lis.getMydata().getUserId());
				motivationDTO.setUserName(lis.getMydata().getUserName());
			}
			i++;

//			Calendar recodeDate = Calendar.getInstance();
//			recodeDate.setTime(lis.getDate()); // motivationのリストのDateをカレンダー型に変換
//			int recodeMonth = recodeDate.get(Calendar.MONTH) + 1; // recodeMonthはレコードごとのgetMonth()に当たる部分

			// 当月
			if (recodeMonth == thisMonth.get(Calendar.MONTH) + 1) { // 現在の月と、motivationのリストにあるmonthが一緒ならここに入れる
				motivationDTO.setMonth1(recodeMonth);
				motivationDTO.setMotivationId1(lis.getId());
				motivationDTO.setRetireRisk1(lis.getRetireRisk());
				motivationDTO.setInterviewDate1(lis.getInterviewDate());
				motivationDTO.setJobMotivation1(lis.getJobMotivation());
				motivationDTO.setComment1(lis.getComment());
				motivationDTO.setCompanyMotivation1(lis.getCompanyMotivation());
				// 当月−１
			} else if (recodeMonth == oneMonthAgo.get(Calendar.MONTH) + 1) {
				motivationDTO.setMonth2(recodeMonth);
				motivationDTO.setMotivationId2(lis.getId());
				motivationDTO.setRetireRisk2(lis.getRetireRisk());
				motivationDTO.setInterviewDate2(lis.getInterviewDate());
				motivationDTO.setJobMotivation2(lis.getJobMotivation());
				motivationDTO.setComment2(lis.getComment());
				motivationDTO.setCompanyMotivation2(lis.getCompanyMotivation());
				// 当月−２
			} else if (recodeMonth == twoMonthAgo.get(Calendar.MONTH) + 1) {
				motivationDTO.setMonth3(recodeMonth);
				motivationDTO.setMotivationId3(lis.getId());
				motivationDTO.setRetireRisk3(lis.getRetireRisk());
				motivationDTO.setInterviewDate3(lis.getInterviewDate());
				motivationDTO.setJobMotivation3(lis.getJobMotivation());
				motivationDTO.setComment3(lis.getComment());
				motivationDTO.setCompanyMotivation3(lis.getCompanyMotivation());
				// 当月−３
			} else if (recodeMonth == threeMonthAgo.get(Calendar.MONTH) + 1) {
				motivationDTO.setMonth4(recodeMonth);
				motivationDTO.setMotivationId4(lis.getId());
				motivationDTO.setRetireRisk4(lis.getRetireRisk());
				motivationDTO.setInterviewDate4(lis.getInterviewDate());
				motivationDTO.setJobMotivation4(lis.getJobMotivation());
				motivationDTO.setComment4(lis.getComment());
				motivationDTO.setCompanyMotivation4(lis.getCompanyMotivation());
				// 当月−４
			} else if (recodeMonth == fourMonthAgo.get(Calendar.MONTH) + 1) {
				motivationDTO.setMonth5(recodeMonth);
				motivationDTO.setMotivationId5(lis.getId());
				motivationDTO.setRetireRisk5(lis.getRetireRisk());
				motivationDTO.setInterviewDate5(lis.getInterviewDate());
				motivationDTO.setJobMotivation5(lis.getJobMotivation());
				motivationDTO.setComment5(lis.getComment());
				motivationDTO.setCompanyMotivation5(lis.getCompanyMotivation());
				// 当月-5
			} else if (recodeMonth == fiveMonthAgo.get(Calendar.MONTH) + 1) {
				motivationDTO.setMonth6(recodeMonth);
				motivationDTO.setMotivationId6(lis.getId());
				motivationDTO.setRetireRisk6(lis.getRetireRisk());
				motivationDTO.setInterviewDate6(lis.getInterviewDate());
				motivationDTO.setJobMotivation6(lis.getJobMotivation());
				motivationDTO.setComment6(lis.getComment());
				motivationDTO.setCompanyMotivation6(lis.getCompanyMotivation());
				// 当月−６
			} else if (recodeMonth == sixMonthAgo.get(Calendar.MONTH) + 1) {
				motivationDTO.setMonth7(recodeMonth);
				motivationDTO.setMotivationId7(lis.getId());
				motivationDTO.setRetireRisk7(lis.getRetireRisk());
				motivationDTO.setInterviewDate7(lis.getInterviewDate());
				motivationDTO.setJobMotivation7(lis.getJobMotivation());
				motivationDTO.setComment7(lis.getComment());
				motivationDTO.setCompanyMotivation7(lis.getCompanyMotivation());
			} else {
				// スルーする
			}
		}
		// 最後の1人もadd
		motivationDTOList.add(motivationDTO);
		// DTOが入った変数motivationDTOListをformModelに入れてviewに返す
		mav.addObject("formModel", motivationDTOList);

		int Month1 = thisMonth.get(Calendar.MONTH) + 1;
		int Month2 = oneMonthAgo.get(Calendar.MONTH) + 1;
		int Month3 = twoMonthAgo.get(Calendar.MONTH) + 1;
		int Month4 = threeMonthAgo.get(Calendar.MONTH) + 1;
		int Month5 = fourMonthAgo.get(Calendar.MONTH) + 1;
		int Month6 = fiveMonthAgo.get(Calendar.MONTH) + 1;
		int Month7 = sixMonthAgo.get(Calendar.MONTH) + 1;

		// HTMLの上に年月を表示させる
		mav.addObject("yearMonth1", thisMonth.get(Calendar.YEAR) + "年" + Month1 + "月");
		mav.addObject("yearMonth2", oneMonthAgo.get(Calendar.YEAR) + "年" + Month2 + "月");
		mav.addObject("yearMonth3", twoMonthAgo.get(Calendar.YEAR) + "年" + Month3 + "月");
		mav.addObject("yearMonth4", threeMonthAgo.get(Calendar.YEAR) + "年" + Month4 + "月");
		mav.addObject("yearMonth5", fourMonthAgo.get(Calendar.YEAR) + "年" + Month5 + "月");
		mav.addObject("yearMonth6", fiveMonthAgo.get(Calendar.YEAR) + "年" + Month6 + "月");
		mav.addObject("yearMonth7", sixMonthAgo.get(Calendar.YEAR) + "年" + Month7 + "月");

		// プルダウンの選択肢
		mav.addObject("companyMotivation", getCompanyMotivation());
		mav.addObject("jobMotivation", getJobMotivation());

		return mav;
	}
}