package seattle.rookie;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import seattle.rookie.model.ProjectEntity;
import seattle.rookie.model.UserForm;
import seattle.rookie.repositories.DepartmentRepository;
import seattle.rookie.repositories.MiddleDepartmentRepository;
import seattle.rookie.repositories.MiddleProjectRepository;
import seattle.rookie.repositories.MyDataRepository;
import seattle.rookie.repositories.ProjectRepository;

@Controller
public class EditController {
	@Autowired
	MyDataRepository myDataRepository;
	@Autowired
	MiddleDepartmentRepository middleDepartmentRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	MiddleProjectRepository middleProjectRepository;
	@Autowired
	ProjectRepository projectRepository;
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * 編集画面
	 * @param userId
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("userId") int userId, ModelAndView mav) {
		mav.setViewName("edit");
		mav.addObject("title", "edit mydata.");
		UserForm data = new UserForm();
		// idからデータを検索
		Optional<MyData> dataOptional = myDataRepository.findById((long) userId);
		// MyData型に変換
		MyData mydata = dataOptional.get();

		if (mydata.getDeleteFlag() != 0) {
			mav.setViewName("ErrorMsg");
			mav.addObject("msg", "500(Internal Server Error): データにアクセスできません。");
			return mav;
		}
		// 情報をセット
		data.setUserId(mydata.getUserId());
		data.setEmail(mydata.getEmail());
		data.setUserName(mydata.getUserName());
		data.setBirthday(mydata.getBirthDate());
		data.setEngineerLevel(mydata.getEngineerLevel());

		String org[] = getDepartmentInfo(userId).clone();
		String proj[] = getProjectInfo(userId).clone();

		mav.addObject("first", org[0]);
		mav.addObject("second", org[1]);
		mav.addObject("third", org[2]);

		mav.addObject("pfirst", proj[0]);
		mav.addObject("psecond", proj[1]);
		mav.addObject("pthird", proj[2]);
		// mav.addObject("engineerlevel", data);

		mav.addObject("formModel", data);
		// プルダウンのための情報を渡す
		mav.addObject("selectItems", getSelectedItems());
		mav.addObject("selectProjects", getSelectedProjects());
		return mav;
	}
	/**
	 * 組織マスタ取得
	 * @return selectMap
	 */
	private Map<Integer, String> getSelectedItems() {
		// ハッシュマップでプルダウンに送るデータを作成
		Map<Integer, String> selectMap = new LinkedHashMap<Integer, String>();
		// 組織マスタの総数を確認
		long num = departmentRepository.count();
		String list[] = new String[(int) num];
		// 組織マスタのデータを取得
		for (int i = 0; i < num; i++) {
			Department data = departmentRepository.findByDepartmentId(1);
			String orgName = data.getDepartmentName();
			list[i] = orgName;
		}
		// マップに値を格納
		for (int i = 0; i < list.length; i++) {
			int j = i + 1;
			selectMap.put(j, list[i]);
		}
		int[] aa = {1,2,3,4};
		String[] s = {"sss","dd"};
		return selectMap;
	}

	/**
	 * 案件マスタ取得
	 * TODO 重複なくしたい
	 * @return selectMap
	 */
	private Map<Integer, String> getSelectedProjects() {
		Map<Integer, String> selectMap = new LinkedHashMap<Integer, String>();
		long num = projectRepository.count();
		String list[] = new String[(int) num];
		for (int i = 0; i < num; i++) {
			ProjectEntity data = projectRepository.findByProjectId(1);
			String projName = data.getProjectName();
			list[i] = projName;
		}
		for (int i = 0; i < list.length; i++) {
			int j = i + 1;
			selectMap.put(j, list[i]);
		}
		return selectMap;
	}

	/**
	 * 組織名リスト取得
	 * @param userId
	 * @return org 組織名リスト
	 */
	private String[] getDepartmentInfo(int userId) {
		// 組織中間テーブルからデータを取得
			List<MiddleDepartment> list = middleDepartmentRepository.findByUserIdOrderByIdDesc(userId);
			// 組織名のリスト
			List<String> orgList = new ArrayList<String>();
			// 組織名リストに名前を格納
			for (int i = 0; i < list.size(); i++) {
				int depId = list.get(i).getDepartmentId();
				orgList.add(departmentRepository.findByDepartmentId(depId).getDepartmentName());
			}
			// 格納した名前の重複を消す
			List<String> orgNewList = new ArrayList<String>(new LinkedHashSet<>(orgList));
			String org[] = new String[3];
			// 組織選択プルダウンにセットする情報を選択
			if (3 <= orgNewList.size()) {
				for (int j = 0; j < 3; j++) {
					org[j] = orgNewList.get(j);
				}
			} else if (2 == orgNewList.size()) {
				for (int j = 0; j < 2; j++) {
					org[j] = orgNewList.get(j);
				}
				org[2] = "無所属";
			} else if (1 == orgList.size()) {
				org[0] = orgNewList.get(0);
				org[1] = "無所属";
				org[2] = "無所属";
			} else {
				org[0] = "無所属";
				org[1] = "無所属";
				org[2] = "無所属";
			}
		return org;
	}

	/**
	 * 案件情報取得
	 * TODO 重複なくしたい
	 * @param userId
	 * @return
	 */
	private String[] getProjectInfo(int userId) {
		List<MiddleProject> projList = middleProjectRepository.findByUserIdOrderByIdDesc(userId);
		List<String> pjList = new ArrayList<String>();
		for (int i = 0; i < projList.size(); i++) {
			int projId = projList.get(i).getProjectId();
			pjList.add(projectRepository.findByProjectId(projId).getProjectName());
		}
		List<String> projNewList = new ArrayList<String>(new LinkedHashSet<>(pjList));
		String proj[] = new String[3];

		if (3 <= projNewList.size()) {
			for (int j = 0; j < 3; j++) {
				proj[j] = projNewList.get(j);
			}
		} else if (2 == projNewList.size()) {
			for (int j = 0; j < 2; j++) {
				proj[j] = projNewList.get(j);
			}
			proj[2] = "無所属";
		} else if (1 == projNewList.size()) {
			proj[0] = projNewList.get(0);
			proj[1] = "無所属";
			proj[2] = "無所属";
		} else {
			proj[0] = "無所属";
			proj[1] = "無所属";
			proj[2] = "無所属";
		}
		return proj;
	}
}
