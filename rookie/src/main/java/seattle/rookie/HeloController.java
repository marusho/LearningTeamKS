package seattle.rookie;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import seattle.rookie.model.Department;
import seattle.rookie.model.MiddleDepartment;
import seattle.rookie.model.MiddleProject;
import seattle.rookie.model.Motivation;
import seattle.rookie.model.MyData;
import seattle.rookie.model.Project;
import seattle.rookie.model.UserCreateForm;
import seattle.rookie.model.UserForm;
import seattle.rookie.model.UserPass;
import seattle.rookie.repositories.DepartmentRepository;
import seattle.rookie.repositories.MiddleDepartmentRepository;
import seattle.rookie.repositories.MiddleProjectRepository;
import seattle.rookie.repositories.MotivationRepository;
import seattle.rookie.repositories.MyDataRepository;
import seattle.rookie.repositories.PremiseRepository;
import seattle.rookie.repositories.ProjectRepository;
import seattle.rookie.repositories.ResultRepository;

@Controller
@ComponentScan("repositories")
public class HeloController {

	@Autowired
	MyDataRepository repository;

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	DepartmentRepository orgrepo;

	@Autowired
	MiddleDepartmentRepository recordrepo;

	@Autowired
	MotivationRepository motirepo;

	@Autowired
	ResultRepository resultrepo;

	@Autowired
	PremiseRepository premiserepo;
	/*
	 * Cの付け足し
	 */
	@Autowired
	ProjectRepository projrepo;

	@Autowired
	MiddleProjectRepository middlerepo;

	private String[] GENDER_LIST = {"男性","女性"};

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("formModel") UserCreateForm mydata, ModelAndView mav) {
		// ユーザー登録画面へ遷移
		mav.setViewName("create");
		// mav.addObject("formModel", mydata);
		// 男女選択のためのプルダウン情報
		Map<Integer, String> selectMap = new LinkedHashMap<Integer, String>();
		selectMap.put(0, "男性");
		selectMap.put(1, "女性");
		// 男女のハッシュマップ を渡す
		mav.addObject("gender", selectMap);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createConfirm(@ModelAttribute("formModel") @Validated UserCreateForm user, BindingResult result,
			ModelAndView mav) {
		ModelAndView res = null;
		// Emailの重複を防ぐためのチェック
		MyData userName = repository.findByEmail(user.getEmail());
		if (userName == null) {
			// 重複がなかった場合
			if (!result.hasErrors()) {
				// バリデーションエラーがない場合
				mav.setViewName("createconfirm");
				// userFormでは性別はStringなので別途で渡す
				mav.addObject("gender", user.getGender());
				// ユーザー情報を渡す
				mav.addObject("formModel", user);

				res = mav;
			} else {
				// エラーがある場合は新規作成画面へ
				Map<Integer, String> selectMap = new LinkedHashMap<Integer, String>();
				selectMap.put(0, "男性");
				selectMap.put(1, "女性");
				// 男女のハッシュマップ を渡す
				mav.addObject("gender", selectMap);
				mav.setViewName("create");
				res = mav;
			}

		} else {
			mav.setViewName("create");
			Map<Integer, String> selectMap = new LinkedHashMap<Integer, String>();
			selectMap.put(0, "男性");
			selectMap.put(1, "女性");
			// 男女のハッシュマップ を渡す
			mav.addObject("gender", selectMap);
			mav.addObject("emailDuplication", "this email is already used");
			res = mav;
		}

		return res;
	}

	@Autowired
	PasswordEncoder encoder;

	@Bean
	PasswordEncoder Encoder() {
		return new BCryptPasswordEncoder();
	}

	// ユーザー登録処理

	@RequestMapping(value = "/createform", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView form(

			@ModelAttribute("formModel") @Validated UserCreateForm userForm, BindingResult result, ModelAndView mov) {
		ModelAndView res = null;
		MyData mydata = new MyData();

		// 二度目のバリデーション（たぶんいらない）
		if (!result.hasErrors()) {
			if (!result.hasErrors()) {
				mydata.setUserName(userForm.getUserName());
				mydata.setEmail(userForm.getEmail());
				mydata.setEmployeeNumber(userForm.getEmployeeNumber());
				int gender;
				// 性別をintで保存
				if (userForm.getGender().equals("男性")) {
					gender = 0;
				} else {
					gender = 1;
				}
				mydata.setGender(gender);
				// パスワードを暗号化
				String encodedPassword = encoder.encode(userForm.getPassword());
				mydata.setPassword(encodedPassword);
				// データベースに保存
				repository.saveAndFlush(mydata);
				MiddleDepartment record = new MiddleDepartment();
				record.setUserId((int) mydata.getUserId());
				record.setDepartmentId(4);
				recordrepo.saveAndFlush(record);

				MiddleProject middleproject = new MiddleProject();
				middleproject.setUserId((int) mydata.getUserId());
				middleproject.setProjectId(4);
				middlerepo.saveAndFlush(middleproject);

				// motivationテーブルにdateを持たせてinsert
				Calendar calendar = Calendar.getInstance();
				// SimpleDateFormatクラスを使用して、パターンを設定する
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// 日に01日を指定
				calendar.set(Calendar.DATE, 01);
				// valueOfメソッドを使ってDate型に変換
				Date date = Date.valueOf(sdf.format(calendar.getTimeInMillis()));
				// useridを取得
				long userId = mydata.getUserId();
				// // userIdをset
				mydata.setUserId(userId);
				Motivation motivation = new Motivation();
				// MotivationクラスにMyDataにuserIdをsetしたものをset
				motivation.setMydata(mydata);
				motivation.setDate(date);
				motirepo.saveAndFlush(motivation);

				// 新規作成に遷移
				res = new ModelAndView("redirect:/create");
			}
		} else {
			// エラーがあった場合
			mov.setViewName("create");
			mov.addObject("msg", "sorry, error is occured");
			res = mov;
		}

		return res;
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView showPageAndName(Pageable pageable, @RequestParam("userName") String userName,
			@RequestParam("projectName") String projectName, @RequestParam("departmentName") String departmentName,
			@RequestParam("gender") String gender, ModelAndView mav) {
		// 比較値
		String women = "女性";
		String men = "男性";
		String empty = "";
		// 送信クエリの条件分岐
		mav.addObject("thisGender", gender);
		// mav.addObject("gender", selectMap);
		String projectNameKey = "%" + projectName + "%";
		String departmentNameKey = "%" + departmentName + "%";
		String userNameKey = "%" + userName + "%";
		// 女性
		if (gender.equals(women)) {
			Page<MyData> result = repository.findBySearchGender1(pageable, userNameKey, projectNameKey,
					departmentNameKey);
			mav.addObject("datalist", result);
			int listSize = result.getTotalPages();
			mav.addObject("listSize", listSize);
			mav.setViewName("show");
			// 男性
		} else if (gender.equals(men)) {
			Page<MyData> result = repository.findBySearchGender0(pageable, userNameKey, projectNameKey,
					departmentNameKey);
			mav.addObject("datalist", result);
			int listSize = result.getTotalPages();
			mav.addObject("listSize", listSize);
			mav.setViewName("show");
			// All
		} else if (gender.equals(empty)) {
			Page<MyData> result = repository.findBySearchGender0And1(pageable, userNameKey, projectNameKey,
					departmentNameKey);
			mav.addObject("datalist", result);
			int listSize = result.getTotalPages();
			mav.addObject("listSize", listSize);
			mav.setViewName("show");
		} else {
			mav.setViewName("show");
		}
		int page = 0;
		mav.addObject("departmentName", departmentName);
		mav.addObject("projectName", projectName);
		mav.addObject("page", page);
		mav.addObject("size", pageable.getPageSize());
		mav.addObject("userName", userName);
		mav.addObject("gender", gender);
		mav.addObject("genderList", GENDER_LIST);
		return mav;
	}

	// 編集画面

	// 修正

	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("userId") int userId, ModelAndView mav) {
		mav.setViewName("edit");
		mav.addObject("title", "edit mydata.");
		UserForm data = new UserForm();
		// idからデータを検索
		Optional<MyData> dataOptional = repository.findById((long) userId);
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
		data.setEngineerLevel(mydata.getEngineerLevel());

		// 組織中間テーブルからデータを取得
		List<MiddleDepartment> list = recordrepo.findByUserIdOrderByIdDesc(userId);
		// 組織名のリスト
		List<String> orgList = new ArrayList<String>();
		// 組織名リストに名前を格納
		for (int i = 0; i < list.size(); i++) {
			int depId = list.get(i).getDepartmentId();
			orgList.add(orgrepo.findByDepartmentId(depId).getDepartmentName());
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
		// プルダウンの初期値ための情報を渡す
		/*
		 * Cの付け足し
		 */
		// 組織中間テーブルからデータを取得
		List<MiddleProject> projList = middlerepo.findByUserIdOrderByIdDesc(userId);
		List<String> pjList = new ArrayList<String>();
		for (int i = 0; i < projList.size(); i++) {
			int projId = projList.get(i).getProjectId();
			pjList.add(projrepo.findByProjectId(projId).getProjectName());
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
		mav.addObject("imagePath", mydata.getImagePath());
		return mav;
	}

	// 編集確認画面
	@RequestMapping(value = "/editconfirm", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView editconfirm(@ModelAttribute("formModel") @Validated UserForm mydata, BindingResult result,
			ModelAndView mav) {
		// Emailの重複を確認
		MyData userName = repository.findByUserId(mydata.getUserId());
		if (!(userName.getEmail().equals(mydata.getEmail()))) {
			/*			// 重複がない場合
						if (userName == null) {
							if (!result.hasErrors()) {
								// バリデーションエラーがない場合
								mav.setViewName("editconfirm");
								mav.addObject("formModel", mydata);
							} else {
								// エラーがある場合
								mav.setViewName("edit");
							}
						} else {
							// 重複がある場合
							mav.setViewName("edit");
							mav.addObject("emailDuplication", "this email is already used");
						}*/
			// 重複がある場合
			mav.setViewName("edit");
			mav.addObject("emailDuplication", "this email is already used");
		} else {
			if (!result.hasErrors()) {
				// エラーがない場合
				mav.setViewName("editconfirm");
				mav.addObject("formModel", mydata);
			} else {
				// エラーがある場合
				mav.addObject("msg", "全て記入してください");
				mav.addObject("selectItems", getSelectedItems());
				mav.setViewName("edit");
				/*
				 * C付け足し
				 */
				mav.addObject("selectProjects", getSelectedProjects());
			}
		}
		return mav;
	}

	// 編集保存処理
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView update(@ModelAttribute("formModel") UserForm data, ModelAndView mav) {
		// idを元にデータベースから取得
		MyData mydata = repository.findByUserId(data.getUserId());
		// 名前、Emailを更新
		mydata.setUserName(data.getUserName());
		mydata.setEmail(data.getEmail());
		mydata.setEngineerLevel(data.getSelectedEngineerLevel());
		mydata.setImagePath(data.getImagePath());

		List<MiddleDepartment> datalist = recordrepo.findByUserId((int) data.getUserId());
		for (int num = 0; num < datalist.size(); num++) {
			datalist.get(num).setDeleteFlag(1);
			recordrepo.saveAndFlush(datalist.get(num));
		}

		/**
		 * 論理削除 /** 改修実験
		 */

		// deleteFlag = 1にする
		List<MiddleProject> middleProjects = middlerepo.findByUserId((int) data.getUserId());
		for (MiddleProject middleProject : middleProjects) {
			middleProject.setDeleteFlag(1);
			middlerepo.saveAndFlush(middleProject);
		}

		if (data.getSelectedProject1() != "") {
			Project project1 = projrepo.findByProjectName(data.getSelectedProject1());
			int projId1 = project1.getProjectId();
			MiddleProject mp1 = new MiddleProject();
			mp1.setProjectId(projId1);
			mp1.setUserId((int) data.getUserId());
			middlerepo.saveAndFlush(mp1);
		}

		// 一つ目の組織が選択されていた場合
		if (data.getSelectedItem1() != "") {
			Department orgData1 = orgrepo.findByDepartmentName(data.getSelectedItem1());
			int orgId1 = orgData1.getDepartmentId();
			MiddleDepartment record1 = new MiddleDepartment();
			record1.setDepartmentId(orgId1);
			record1.setUserId((int) data.getUserId());
			recordrepo.saveAndFlush(record1);
		}

		// 二つ目の組織が選択されていた場合
		if (data.getSelectedItem2() != "") {
			Department orgData2 = orgrepo.findByDepartmentName(data.getSelectedItem2());
			int orgId2 = orgData2.getDepartmentId();
			MiddleDepartment record2 = new MiddleDepartment();
			record2.setDepartmentId(orgId2);
			record2.setUserId((int) data.getUserId());
			recordrepo.saveAndFlush(record2);
		}

		// 三つ目の組織が選択されていた場合
		if (data.getSelectedItem3() != "") {
			Department orgData3 = orgrepo.findByDepartmentName(data.getSelectedItem3());
			int orgId3 = orgData3.getDepartmentId();
			MiddleDepartment record3 = new MiddleDepartment();
			record3.setDepartmentId(orgId3);
			record3.setUserId((int) data.getUserId());
			recordrepo.saveAndFlush(record3);
		}

		if (data.getSelectedProject1() != "") {
			Project project1 = projrepo.findByProjectName(data.getSelectedProject1());
			int projId1 = project1.getProjectId();
			MiddleProject mp1 = new MiddleProject();
			mp1.setProjectId(projId1);
			mp1.setUserId((int) data.getUserId());
			middlerepo.saveAndFlush(mp1);
		}
		if (data.getSelectedProject2() != "") {
			Project project2 = projrepo.findByProjectName(data.getSelectedProject2());
			int projId2 = project2.getProjectId();
			MiddleProject mp2 = new MiddleProject();
			mp2.setProjectId(projId2);
			mp2.setUserId((int) data.getUserId());

			middlerepo.saveAndFlush(mp2);
		}
		if (data.getSelectedProject3() != "") {
			Project project3 = projrepo.findByProjectName(data.getSelectedProject3());
			int projId3 = project3.getProjectId();
			MiddleProject mp3 = new MiddleProject();
			mp3.setProjectId(projId3);
			mp3.setUserId((int) data.getUserId());
			middlerepo.saveAndFlush(mp3);
		}

		repository.saveAndFlush(mydata);
		// 一覧画面へ遷移
		mav = new ModelAndView("redirect:/page?size=20&page=0&userName=&projectName=&departmentName=&gender=");
		return mav;
	}

	// ログイン画面表示
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView mav) {
		mav.setViewName("login");
		return mav;
	}

	// デリート画面表示
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute MyData mydata, @PathVariable long id, ModelAndView mav) {
		mav.setViewName("delete");
		// idからデータを取得
		MyData data = repository.findByUserId(id);

		if (data.getDeleteFlag() != 0) {
			mav.setViewName("ErrorMsg");
			mav.addObject("msg", "500(Internal Server Error): データにアクセスできません。");
			return mav;
		}
		mav.addObject("formModel", data);
		return mav;
	}

	// 削除処理

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView updateDelflg(@ModelAttribute MyData mydata) {
		long id = mydata.getUserId();
		resultrepo.deleteByUserId((int) id);
		premiserepo.deleteByUserId((int) id);
		MyData data = repository.findByUserId(id);
		// 論理削除
		data.setDeleteFlag(1);
		repository.save(data);
		ModelAndView mav = new ModelAndView();
		// 一覧に遷移
		mav = new ModelAndView("redirect:/page?size=20&page=0&userName=&projectName=&departmentName=&gender=");

		return mav;
	}

	// パスワード変更画面
	@RequestMapping(value = "/change", method = RequestMethod.GET)
	public ModelAndView changePassword(@ModelAttribute UserForm userForm, ModelAndView mav) {
		mav.setViewName("change");

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName;
		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		MyData data = repository.findByEmail(userName);
		mav.addObject("formModel", data);
		mav.addObject("email", data.getEmail());

		return mav;
	}

	// パスワード変更処理

	@RequestMapping(value = "/change", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView updatePassword(@ModelAttribute("formModel") @Validated UserPass userForm, BindingResult result,
			ModelAndView mav) {
		MyData mydata = new MyData();
		ModelAndView res = null;
		mydata = repository.findByUserId(userForm.getUserId());

		// 暗号化されたパスワードと入力されたパスワードの比較
		if (encoder.matches(userForm.getPassword(), mydata.getPassword())) {
			// エラーがない場合
			if (!result.hasErrors()) {
				// パスワードを暗号化

				String encodedPassword = encoder.encode(userForm.getNewPassword());

				// 新しいパスワードをセット
				mydata.setPassword(encodedPassword);
				repository.saveAndFlush(mydata);
				// 一覧に遷移
				res = new ModelAndView("redirect:/page?size=20&page=0&userName=&projectName=&departmentName=&gender=");
			} else {
				mav.setViewName("change");
				res = mav;
			}
		} else {
			// パスワードが正しくないとき
			mav.addObject("err", "Password is not correct");
		}
		mav.setViewName("change");
		res = mav;
		return res;
	}

	private Map<Integer, String> getSelectedItems() {
		// ハッシュマップでプルダウンに送るデータを作成
		Map<Integer, String> selectMap = new LinkedHashMap<Integer, String>();
		// 組織マスタの総数を確認
		long num = orgrepo.count();
		String list[] = new String[(int) num];
		// 組織マスタのデータを取得
		for (int i = 0; i < num; i++) {
			Department data = orgrepo.findByDepartmentId(4);
			String orgName = data.getDepartmentName();
			list[i] = orgName;
		}
		// マップに値を格納
		for (int i = 0; i < list.length; i++) {
			int j = i + 1;
			selectMap.put(j, list[i]);
		}
		return selectMap;
	}

	/*
	 * Cの付け足し
	 */
	private Map<Integer, String> getSelectedProjects() {
		Map<Integer, String> selectMap = new LinkedHashMap<Integer, String>();
		long num = projrepo.count();
		String list[] = new String[(int) num];
		for (int i = 0; i < num; i++) {
			Project data = projrepo.findByProjectId(4);
			String projName = data.getProjectName();
			list[i] = projName;
		}
		for (int i = 0; i < list.length; i++) {
			int j = i + 1;
			selectMap.put(j, list[i]);
		}
		return selectMap;
	}
}