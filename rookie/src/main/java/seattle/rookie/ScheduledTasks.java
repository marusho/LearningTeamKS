package seattle.rookie;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import seattle.rookie.model.Motivation;
import seattle.rookie.model.MyData;
import seattle.rookie.repositories.MotivationRepository;
import seattle.rookie.repositories.MyDataRepository;

@Component
public class ScheduledTasks {

	@Autowired
	MyDataRepository repository;

	@Autowired
	MotivationRepository motirepo;

	Calendar calendar = Calendar.getInstance();
	// SimpleDateFormatクラスを使用して、パターンを設定する
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	int lastDayOfMonth = calendar.getActualMaximum(Calendar.DATE);
	int day = calendar.get(Calendar.DATE);

	@Scheduled(cron = "0 0 23 * * *")
	public void insertCurrentMonth() {
		// 現在が月末日なら実行
		if (day == lastDayOfMonth) {
			// 日に01日を指定
			calendar.set(Calendar.DATE, 01);
			// 月に+1
			calendar.add(Calendar.MONTH, 1);
			// valueOfメソッドを使ってDate型に変換
			Date date = Date.valueOf(sdf.format(calendar.getTimeInMillis()));
			// usersテーブルのuser_idをinsert
			List<MyData> mydata = repository.findAll();
			// useridを取得
			for (int i = 0; i < mydata.size(); i++) {
				long userId = mydata.get(i).getUserId();
				Motivation motivation = new Motivation();

				// MyDataクラスををインスタンス化
				MyData md = new MyData();
				// userIdをset
				md.setUserId(userId);
				// MotivationクラスにMyDataにuserIdをsetしたものをset
				motivation.setMydata(md);
				motivation.setDate(date);
				// motivationにdateをsetしたものをsaveAndFlushでinsert
				motirepo.saveAndFlush(motivation);
			}
		}
	}
}