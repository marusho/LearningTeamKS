package seattle.rookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import seattle.rookie.model.Evaluation;
import seattle.rookie.model.MultipledResult;
import seattle.rookie.model.MyData;
import seattle.rookie.model.Premise;
import seattle.rookie.model.Result;
import seattle.rookie.model.Team;
import seattle.rookie.repositories.EvaluationRepository;
import seattle.rookie.repositories.MyDataRepository;
import seattle.rookie.repositories.PremiseRepository;
import seattle.rookie.repositories.TeamRepository;

@Service
public class CsvService {
	
	@Autowired
	PremiseRepository premiseRepository;
	
	@Autowired
	EvaluationRepository evalrepo;
	
	@Autowired
	TeamRepository teamrepo;

	@Autowired
	MyDataRepository mydatarepo;
	
	
	public void outputCsv(HttpServletResponse response, List<Result> resultsList) {
		response.setContentType(MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE + ";charset=Shift_JIS");
		response.setHeader("Content-Disposition", "attachment; filename=\"evaluation_data.csv\"");
		
		// CSV形式で出力
		String header = "名前,チーム,シアトル会,勤怠,セキュリティ事故,お客様満足度,コミットメント,提案,社内コミュニケーション,人材育成,成果合計,ITスキル,業務理解,コミュニケーション力,リーダーシップ,課題解決力,専門力,現場営業力,能力合計, Thanks, Engine,All,Masterpiece,Stock,シアトルブランド,情意合計,合計,お客様満足度,コミットメント,提案,社内コミュニケーション,人材育成,成果合計,ITスキル,業務理解,コミュニケーション力,リーダーシップ,課題解決力,専門力,現場営業力,能力合計, Thanks, Engine,All,Masterpiece,Stock,シアトルブランド,情意合計,合計";
		try (PrintWriter pw = response.getWriter()) {
			pw.println(header);
			int index=0;
			for (Result result: resultsList) {
				// ユーザーIDを取得
				int thisUserId = result.getUserId();
				// 前提事項の取得
				List<Premise> premise = premiseRepository.findByUserIdAndYearAndTerm(thisUserId, result.getYear(), result.getTerm());

//				boolean型をString型に読み替える
				String attendance =premise.get(0).getAttend() ?"出席": "欠席";
				String attitude = premise.get(0).getAttitude() ? "良" : "悪";
				String securityAccident = premise.get(0).getSecurityAccident() ? "有": "無";
				
//				評価基準をDBから参照
				String engineerlevel = result.getEngineerLevel();
				Evaluation eval = evalrepo.findByEngineerLevel(engineerlevel);
//				チームの情報を取得
				Team team = teamrepo.findByTeamId(result.getTeamId());
//				ユーザーデータを取得
				MyData mydata = mydatarepo.findByUserId(thisUserId);
//				計算メソッドに値を渡す
				Multiple multiple = new Multiple();
				MultipledResult mr = multiple.multipleResult(result, index, eval, mydata, attendance, attitude,
						securityAccident, team);
//				ストリングビルダーでcsvに出力する文を生成
				StringBuilder str = new StringBuilder();
				str.append(mr.getUserName()).append(",").append(mr.getTeamName()).append(",").append(mr.getAttendstr())
						.append(",").append(mr.getAttitudestr()).append(",").append(mr.getSecurityAccidentstr()).append(",")
						.append(String.valueOf(mr.getSatisfyScoreBefore())).append(",")
						.append(String.valueOf(mr.getCommitmentScoreBefore())).append(",")
						.append(String.valueOf(mr.getProposalScoreBefore())).append(",")
						.append(String.valueOf(mr.getInternalCommunicationScoreBefore())).append(",")
						.append(String.valueOf(mr.getDevelopmentScoreBefore())).append(",")
						.append(String.valueOf(mr.getSumAchievementBefore())).append(",")
						.append(String.valueOf(mr.getItSkillsScoreBefore())).append(",")
						.append(String.valueOf(mr.getUnderstandScoreBefore())).append(",")
						.append(String.valueOf(mr.getLeadershipScoreBefore())).append(",")
						.append(String.valueOf(mr.getResolveScoreBefore())).append(",")
						.append(String.valueOf(mr.getCommunicationScoreBefore())).append(",")
						.append(String.valueOf(mr.getProfessionalScoreBefore())).append(",")
						.append(String.valueOf(mr.getFieldSalesScoreBefore())).append(",")
						.append(String.valueOf(mr.getSumAbilityBefore())).append(",")
						.append(String.valueOf(mr.getThanksScoreBefore())).append(",")
						.append(String.valueOf(mr.getEngineScoreBefore())).append(",")
						.append(String.valueOf(mr.getAllScoreBefore())).append(",")
						.append(String.valueOf(mr.getMasterpieceScoreBefore())).append(",")
						.append(String.valueOf(mr.getStockScoreBefore())).append(",")
						.append(String.valueOf(mr.getSeattleBrandScoreBefore())).append(",")
						.append(String.valueOf(mr.getSumPassionBefore())).append(",")
						.append(String.valueOf(mr.getTotalScoreBefore())).append(",").append(mr.getSatisfyScore())
						.append(",").append(mr.getCommitmentScore()).append(",").append(mr.getProposalScore())
						.append(",").append(mr.getInternalCommunicationScore()).append(",")
						.append(mr.getDevelopmentScore()).append(",").append(mr.getSumAchievement()).append(",")
						.append(mr.getItSkillsScore()).append(",").append(mr.getUnderstandScore()).append(",")
						.append(mr.getLeadershipScore()).append(",").append(mr.getResolveScore()).append(",")
						.append(mr.getCommunicationScore()).append(",").append(mr.getProfessionalScore()).append(",")
						.append(mr.getFieldSalesScore()).append(",").append(mr.getSumAbility()).append(",")
						.append(mr.getThanksScore()).append(",").append(mr.getEngineScore()).append(",")
						.append(mr.getAllScore()).append(",").append(mr.getMasterpieceScore()).append(",")
						.append(mr.getStockScore()).append(",").append(mr.getSeattleBrandScore()).append(",")
						.append(mr.getSumPassion()).append(",").append(mr.getTotalScore());
				// CSV形式で出力
				pw.println(str);
				index++;
			}
//			出力エラー
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
