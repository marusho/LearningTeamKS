package seattle.rookie;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import seattle.rookie.model.Department;
import seattle.rookie.model.MiddleDepartment;
import seattle.rookie.model.MiddleProject;
import seattle.rookie.model.MyData;
import seattle.rookie.model.Project;
import seattle.rookie.repositories.DepartmentRepository;
import seattle.rookie.repositories.MiddleDepartmentRepository;
import seattle.rookie.repositories.MiddleProjectRepository;
import seattle.rookie.repositories.MyDataRepository;
import seattle.rookie.repositories.ProjectRepository;

@Controller
public class InfoController {
	@Autowired
	DepartmentRepository orgrepo;
	@Autowired
	MiddleDepartmentRepository recordrepo;
	@Autowired
	MiddleProjectRepository middlerepo;
	@Autowired
	ProjectRepository projrepo;
	@Autowired
	MyDataRepository myrepo;
	@PersistenceContext
	EntityManager entityManager;

	/*	private Map<Integer, String> getSelectedItems() {
			// 中間テーブルから重複を取り除いたリストを作成
			Map<Integer, String> selectMap = new LinkedHashMap<Integer, String>();
			// 総数を取得
			long num = orgrepo.count();
			String list[] = new String[(int) num];
			// 組織名を取得しリストに格納
			for (int i = 1; i <= num; i++) {
				Department data = orgrepo.findByDepartmentId(i);
				String orgName = data.getDepartmentName();
				list[i - 1] = orgName;
			}
			// リストを元にマップに格納
			for (int i = 0; i < list.length; i++) {
				int j = i + 1;
				selectMap.put(j, list[i]);
			}
			return selectMap;
		}*/

	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public ModelAndView info(@PathVariable("id") int userId, Department orgDataForm, ModelAndView mav) {
		// 中間テーブルからデータを取得
		List<MiddleProject> middle = middlerepo.findByUserIdOrderByIdDesc(userId);
		List<String> projData = new ArrayList<String>();
		for (int num = 0; num < middle.size(); num++) {
			int i = middle.get(num).getProjectId();
			Project proj = projrepo.findByProjectId(i);
			if (!(proj.getProjectName().equals("無所属"))) {
				projData.add(proj.getProjectName());
			}
		}
		List<String> listProj = new ArrayList<String>(new LinkedHashSet<>(projData));
		List<MiddleDepartment> record = recordrepo.findByUserIdOrderByIdDesc(userId);
		List<String> orgData = new ArrayList<String>();
		for (int num = 0; num < record.size(); num++) {
			// レコードから部署idを取得
			int i = record.get(num).getDepartmentId();
			Department org = orgrepo.findByDepartmentId(i);
			// 組織名をリストに追加
			if (!(org.getDepartmentName().equals("無所属"))) {
				orgData.add(org.getDepartmentName());
			}
		}
		List<String> listRecord = new ArrayList<String>(new LinkedHashSet<>(orgData));
		String gender;
		MyData mydata = myrepo.findByUserId(userId);

		if (mydata.getDeleteFlag() != 0) {
			mav.setViewName("ErrorMsg");
			mav.addObject("msg", "500(Internal Server Error): データにアクセスできません。");
			return mav;
		}

		// データの中の性別を文字列に読み換える
		if (mydata.getGender() == 0) {
			gender = "男性";
		} else if (mydata.getGender() == 1) {
			gender = "女性";
		} else {
			gender = "";
		}
		mav.addObject("userName", mydata.getUserName());
		mav.addObject("enterDate", mydata.getEnterDate());
		mav.addObject("birthday", mydata.getBirthDate());
		mav.addObject("leaveDate", mydata.getLeaveDate());
		mav.addObject("gender", gender);
		mav.addObject("enteredate", mydata);
		mav.addObject("engineerLevel", mydata.getEngineerLevel());
		mav.addObject("imagePath", mydata.getImagePath() != null ? mydata.getImagePath(): "/img/no-image.png");

		mav.addObject("orgData", listRecord);
		mav.addObject("projData", listProj);

		mav.setViewName("info");
		return mav;
	}
}
