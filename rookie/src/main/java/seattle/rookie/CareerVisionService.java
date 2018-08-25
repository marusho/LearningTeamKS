package seattle.rookie;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import seattle.rookie.model.CareerVisions;
import seattle.rookie.model.CareerVisionsForm;
import seattle.rookie.model.ManagementVisions;
import seattle.rookie.model.MasterManagementVisions;
import seattle.rookie.model.MasterSectorVisions;
import seattle.rookie.model.MasterSpecialistVisions;
import seattle.rookie.model.MyData;
import seattle.rookie.model.SectorVisions;
import seattle.rookie.model.SpecialistVisions;
import seattle.rookie.model.UserForm;
import seattle.rookie.repositories.CareerVisionsRepository;
import seattle.rookie.repositories.ManagementVisionsRepository;
import seattle.rookie.repositories.MasterManagementVisionsRepository;
import seattle.rookie.repositories.MasterSectorVisionsRepository;
import seattle.rookie.repositories.MasterSpecialistVisionsRepository;
import seattle.rookie.repositories.MyDataRepository;
import seattle.rookie.repositories.SectorVisionsRepository;
import seattle.rookie.repositories.SpecialistVisionsRepository;


@Service
public class CareerVisionService {

		// repositoryクラスの@Autowired
		@Autowired
		MyDataRepository Myrepository;
		@Autowired
		CareerVisionsRepository CVrepository;
		@Autowired
		ManagementVisionsRepository MVrepository;
		@Autowired
		MasterManagementVisionsRepository MMVrepository;
		@Autowired
		SpecialistVisionsRepository SpVrepository;
		@Autowired
		MasterSpecialistVisionsRepository MSpVrepository;
		@Autowired
		SectorVisionsRepository SeVrepository;
		@Autowired
		MasterSectorVisionsRepository MSeVrepository;

		// キャリアビジョン編集
		@RequestMapping(value = "/CareerVisionEdit/{userId}", method = RequestMethod.GET)
		public ModelAndView editCareerVisionsGet(
				@ModelAttribute("formModel") UserForm data,
				@ModelAttribute("CVformModel") CareerVisionsForm CVForm,
				Model model,
				ModelAndView mav) {

			mav.setViewName("CareerVisionEdit");
			mav.addObject("title", "edit MyCareerVision");

			// usersテーブルのidからデータを検索
			MyData mydata = Myrepository.findByUserIdAndDeleteFlag(data.getUserId(), data.getDeleteFlag());

			// ユーザー情報存在チェック
			if (mydata == null) {
				mav.setViewName("ErrorMsg");
				mav.addObject("msg", "500(Internal Server Error): データにアクセスできません。");
				return mav;
			}

			// Optionalでcareer_visionsテーブルからデータを抽出
			Optional<CareerVisions> dataOptional = CVrepository.findByUserIdOrderByVersionDesc((int) CVForm.getUserId(), CVForm.getVersion());

			if (!dataOptional.isPresent()) {
				// 情報をセット
				data.setUserName(mydata.getUserName());
				data.setEngineerLevel(mydata.getEngineerLevel());
				data.setUserId(mydata.getUserId());

				// ユーザー名とエンジニアレベルをusersテーブルより引っ張ってくる
				mav.addObject("userName", mydata.getUserName());
				mav.addObject("engineerLevel", mydata.getEngineerLevel());

				mav.addObject("userId", mydata.getUserId());
				mav.addObject("formModel", data);
				mav.addObject("CVformModel", CVForm);

				// MasterManagementの情報を取得
				List<MasterManagementVisions> MasterManagementVisions = MMVrepository.findAll();
				model.addAttribute("MasterManagementVisions", MasterManagementVisions);

				// MasterSpecialistの情報を取得
				List<MasterSpecialistVisions> MasterSpecialistVisions = MSpVrepository.findAll();
				model.addAttribute("MasterSpecialistVisions", MasterSpecialistVisions);

				// MasterSectorの情報を取得
				List<MasterSectorVisions> MasterSectorVisions = MSeVrepository.findAll();
				model.addAttribute("MasterSectorVisions", MasterSectorVisions);

				return mav;
			}

			// CareerVisions型に変換
			CareerVisions careerVisions = dataOptional.get();

			// 情報をセット
			data.setUserName(mydata.getUserName());
			data.setEngineerLevel(mydata.getEngineerLevel());
			data.setUserId(mydata.getUserId());
			CVForm.setFirstEssential(careerVisions.getFirstEssential());
			CVForm.setSecondEssential(careerVisions.getSecondEssential());
			CVForm.setThirdEssential(careerVisions.getThirdEssential());
			CVForm.setFreetext(careerVisions.getFreetext());
			CVForm.setOneyearVision(careerVisions.getOneyearVision());
			CVForm.setThreeyearsVision(careerVisions.getThreeyearsVision());
			CVForm.setFiveyearsVision(careerVisions.getFiveyearsVision());
			CVForm.setRegisteredBy(careerVisions.getRegisteredBy());
			CVForm.setRegisteredAt(careerVisions.getRegisteredAt());
			CVForm.setUpdatedBy(careerVisions.getUpdatedBy());
			CVForm.setUpdatedAt(careerVisions.getUpdatedAt());
			CVForm.setVersion(careerVisions.getVersion() + 1);

			// ユーザー名とエンジニアレベルをusersテーブルより引っ張ってくる
			mav.addObject("userName", mydata.getUserName());
			mav.addObject("engineerLevel", mydata.getEngineerLevel());

			// 大事にしたいことの表示
			mav.addObject("firstEssential", careerVisions.getFirstEssential());
			mav.addObject("secondEssential", careerVisions.getSecondEssential());
			mav.addObject("thirdEssential", careerVisions.getThirdEssential());

			// MasterManagementの情報を取得
			List<MasterManagementVisions> MasterManagementVisions = MMVrepository.findAll();
			model.addAttribute("MasterManagementVisions", MasterManagementVisions);

			// ManagementVisionsの情報を取得
			List<ManagementVisions> ManagementVisions = MVrepository.findByUserIdOrderByVersionDesc((int) mydata.getUserId(), CVForm.getVersion());
            if (ManagementVisions.size() > 0 && ManagementVisions.get(0).getVersion() == careerVisions.getVersion()) {
			model.addAttribute("ManagementVisions", ManagementVisions);
            }

			// MasterSpecialistの情報を取得
			List<MasterSpecialistVisions> MasterSpecialistVisions = MSpVrepository.findAll();
			model.addAttribute("MasterSpecialistVisions", MasterSpecialistVisions);

			// SpecialistVisionsの情報を取得
			List<SpecialistVisions> SpecialistVisions = SpVrepository.findByUserIdOrderByVersionDesc((int) mydata.getUserId(), CVForm.getVersion());
			if (SpecialistVisions.size() > 0 && SpecialistVisions.get(0).getVersion() == careerVisions.getVersion()) {
			model.addAttribute("SpecialistVisions", SpecialistVisions);
			}

			// MasterSectorの情報を取得
			List<MasterSectorVisions> MasterSectorVisions = MSeVrepository.findAll();
			model.addAttribute("MasterSectorVisions", MasterSectorVisions);

			// SectorVisionsの情報を取得
			List<SectorVisions> SectorVisions = SeVrepository.findByUserIdOrderByVersionDesc((int) mydata.getUserId(),CVForm.getVersion());
			if (SectorVisions.size() > 0 && SectorVisions.get(0).getVersion() == careerVisions.getVersion()) {
			model.addAttribute("SectorVisions", SectorVisions);
			}

			// やりたいこと（その他）の表示
			mav.addObject("freetext", careerVisions.getFreetext());

			// 将来ビジョン（1,3,5年後）の表示
			mav.addObject("oneyearVision", careerVisions.getOneyearVision());
			mav.addObject("threeyearsVision", careerVisions.getThreeyearsVision());
			mav.addObject("fiveyearsVision", careerVisions.getFiveyearsVision());

			mav.addObject("formModel", data);
			mav.addObject("CVformModel", CVForm);

			return mav;

		}

		// キャリアビジョン編集保存処理
		@RequestMapping(value = "/CareerVisionsEdit", method = RequestMethod.POST)
		@Transactional(readOnly = false)
		public ModelAndView updateCareerVisionPost(
				@ModelAttribute("formModel") UserForm data,
				@ModelAttribute("CVformModel") CareerVisionsForm CVForm,
				ModelAndView mav) {

				// DBから最新情報を取得
				Optional<CareerVisions> dataOptional = CVrepository.findByUserIdOrderByVersionDesc((int) CVForm.getUserId(),CVForm.getVersion());

				//  ①キャリアビジョン新規登録
				if (!dataOptional.isPresent()) {
					// キャリアビジョンのテーブルをインスタンス化
					CareerVisions careerVisions = new CareerVisions();

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

					MyData mydata = Myrepository.findByEmail(userName);
					String name = mydata.getUserName();

					// 登録・更新日時を自動取得
					Date today = new Date();
					String sqlDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(today);

					// テキスト型のデータを更新
					careerVisions.setUserId((int) CVForm.getUserId());
					careerVisions.setFirstEssential(CVForm.getFirstEssential());
					careerVisions.setSecondEssential(CVForm.getSecondEssential());
					careerVisions.setThirdEssential(CVForm.getThirdEssential());
					careerVisions.setFreetext(CVForm.getFreetext());
					careerVisions.setOneyearVision(CVForm.getOneyearVision());
					careerVisions.setThreeyearsVision(CVForm.getThreeyearsVision());
					careerVisions.setFiveyearsVision(CVForm.getFiveyearsVision());
					careerVisions.setRegisteredBy(name);
					careerVisions.setRegisteredAt(sqlDate);
					careerVisions.setVersion(CVForm.getVersion());

					CVrepository.save(careerVisions);

					// マネジメントビジョンテーブルをインスタンス化
					ManagementVisions managementVisions = new ManagementVisions();
					managementVisions.setUserId((int) CVForm.getUserId());

					List<Integer> managementIds = CVForm.getManagementIds();

					// リスト化した中身をループを回して表示
					for (int i = 0; i < managementIds.size(); i++) {
						// nullとしてリストに入っていた場合はcontinueで次のループへ移行
						if (managementIds.get(i) == null) {
							continue;
						} else {
							// nullではない場合はentityへsetする
							managementVisions.setManagementId(managementIds.get(i));
							managementVisions.setVersion(CVForm.getVersion());
							// entityへsetしたものを保存
							MVrepository.save(managementVisions);
						}
					}

					// スペシャリストビジョンテーブルをインスタンス化
					SpecialistVisions specialistVisions = new SpecialistVisions();
					specialistVisions.setUserId((int) CVForm.getUserId());

					List<Integer> specialistIds = CVForm.getSpecialistIds();

					// リスト化した中身をループを回して表示
					for (int i = 0; i < specialistIds.size(); i++) {
						// nullとしてリストに入っていた場合はcontinueで次のループへ移行
						if (specialistIds.get(i) == null) {
							continue;
						} else {
							// nullではない場合はentityへsetする
							specialistVisions.setSpecialistId(specialistIds.get(i));
							specialistVisions.setVersion(CVForm.getVersion());
							// entityへsetしたものを保存
							SpVrepository.save(specialistVisions);
						}
					}

					// セクタビジョンテーブルをインスタンス化
					SectorVisions sectorVisions = new SectorVisions();
					sectorVisions.setUserId((int) CVForm.getUserId());

					List<Integer> sectorIds = CVForm.getSectorIds();

					// リスト化した中身をループを回して表示
					for (int i = 0; i < sectorIds.size(); i++) {
						// nullとしてリストに入っていた場合はcontinueで次のループへ移行
						if (sectorIds.get(i) == null) {
							continue;
						} else {
							// nullではない場合はentityへsetする
							sectorVisions.setSectorId(sectorIds.get(i));
							sectorVisions.setVersion(CVForm.getVersion());
							// entityへsetしたものを保存
							SeVrepository.save(sectorVisions);
						}
					}

					return new ModelAndView("redirect:/CareerVisionShow/" + data.userId);

				}

				//  ②キャリアビジョンのアップデート

				// 楽観的排他ロック処理
				CareerVisions careerVisionsCheck = dataOptional.get();
				if (careerVisionsCheck.getVersion() == CVForm.getVersion()) {
					mav.setViewName("ErrorMsg");
					mav.addObject("msg", "500(Internal Server Error): データにアクセスできません。");
					return mav;
				}

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

				MyData mydata = Myrepository.findByEmail(userName);
				String name = mydata.getUserName();

				// 登録・更新日時を自動取得
				Date today = new Date();
				String sqlDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(today);

				// キャリアビジョンのテーブルをインスタンス化
				CareerVisions careerVisions = new CareerVisions();

				// テキスト型のデータを更新
				careerVisions.setUserId((int) CVForm.getUserId());
				careerVisions.setFirstEssential(CVForm.getFirstEssential());
				careerVisions.setSecondEssential(CVForm.getSecondEssential());
				careerVisions.setThirdEssential(CVForm.getThirdEssential());
				careerVisions.setFreetext(CVForm.getFreetext());
				careerVisions.setOneyearVision(CVForm.getOneyearVision());
				careerVisions.setThreeyearsVision(CVForm.getThreeyearsVision());
				careerVisions.setFiveyearsVision(CVForm.getFiveyearsVision());
				careerVisions.setRegisteredAt(CVForm.getRegisteredAt());
				careerVisions.setRegisteredBy(CVForm.getRegisteredBy());
				careerVisions.setUpdatedBy(name);
				careerVisions.setUpdatedAt(sqlDate);
				careerVisions.setVersion(CVForm.getVersion());

				CVrepository.save(careerVisions);

				// マネジメントビジョンテーブルをインスタンス化
				ManagementVisions managementVisions = new ManagementVisions();
				managementVisions.setUserId((int) CVForm.getUserId());

				List<Integer> managementIds = CVForm.getManagementIds();

				// リスト化した中身をループを回して表示
				for (int i = 0; i < managementIds.size(); i++) {
					// nullとしてリストに入っていた場合はcontinueで次のループへ移行
					if (managementIds.get(i) == null) {
						continue;
					} else {
						// nullではない場合はentityへsetする
						managementVisions.setManagementId(managementIds.get(i));
						managementVisions.setVersion(careerVisions.getVersion());
						// entityへsetしたものを保存
						MVrepository.save(managementVisions);
					}
				}

				// スペシャリストビジョンテーブルをインスタンス化
				SpecialistVisions specialistVisions = new SpecialistVisions();
				specialistVisions.setUserId((int) CVForm.getUserId());

				List<Integer> specialistIds = CVForm.getSpecialistIds();

				// リスト化した中身をループを回して表示
				for (int i = 0; i < specialistIds.size(); i++) {
					// nullとしてリストに入っていた場合はcontinueで次のループへ移行
					if (specialistIds.get(i) == null) {
						continue;
					} else {
						// nullではない場合はentityへsetする
						specialistVisions.setSpecialistId(specialistIds.get(i));
						specialistVisions.setVersion(careerVisions.getVersion());
						// entityへsetしたものを保存
						SpVrepository.save(specialistVisions);
					}
				}

				// セクタビジョンテーブルをインスタンス化
				SectorVisions sectorVisions = new SectorVisions();
				sectorVisions.setUserId((int) CVForm.getUserId());

				List<Integer> sectorIds = CVForm.getSectorIds();

				// リスト化した中身をループを回して表示
				for (int i = 0; i < sectorIds.size(); i++) {
					// nullとしてリストに入っていた場合はcontinueで次のループへ移行
					if (sectorIds.get(i) == null) {
						continue;
					} else {
						// nullではない場合はentityへsetする
						sectorVisions.setSectorId(sectorIds.get(i));
						sectorVisions.setVersion(careerVisions.getVersion());
						// entityへsetしたものを保存
						SeVrepository.save(sectorVisions);
					}
				}

				return new ModelAndView("redirect:/CareerVisionShow/" + data.userId);

			}

		// キャリアビジョン参照
		@RequestMapping(value = "/CareerVisionShow/{userId}", method = RequestMethod.GET)
		public ModelAndView careerVisionInfoGet(
				@ModelAttribute("formModel") UserForm data,
				@ModelAttribute("CVformModel") CareerVisionsForm CVForm, Model model,
				ModelAndView mav) {

			mav.setViewName("CareerVisionShow");
			mav.addObject("title", "show MyCareerVision");

			// usersテーブルのidからデータを検索
			MyData mydata = Myrepository.findByUserIdAndDeleteFlag(data.getUserId(), data.getDeleteFlag());

			// ユーザー情報存在チェック
			if (mydata == null) {
				mav.setViewName("ErrorMsg");
				mav.addObject("msg", "500(Internal Server Error): データにアクセスできません。");
				return mav;
			}

			// Optionalでcareer_visionsテーブルからデータを抽出
			Optional<CareerVisions> dataOptional = CVrepository.findByUserIdOrderByVersionDesc((int) CVForm.getUserId(),
					CVForm.getVersion());

			if (!dataOptional.isPresent()) {
				// 情報をセット
				data.setUserName(mydata.getUserName());
				data.setEngineerLevel(mydata.getEngineerLevel());
				data.setUserId(mydata.getUserId());

				// ユーザー名とエンジニアレベルをusersテーブルより引っ張ってくる
				mav.addObject("userName", mydata.getUserName());
				mav.addObject("engineerLevel", mydata.getEngineerLevel());

				mav.addObject("userId", mydata.getUserId());
				mav.addObject("formModel", data);
				mav.addObject("CVformModel", CVForm);

				// MasterManagementの情報を取得
				List<MasterManagementVisions> MasterManagementVisions = MMVrepository.findAll();
				model.addAttribute("MasterManagementVisions", MasterManagementVisions);

				// MasterSpecialistの情報を取得
				List<MasterSpecialistVisions> MasterSpecialistVisions = MSpVrepository.findAll();
				model.addAttribute("MasterSpecialistVisions", MasterSpecialistVisions);

				// MasterSectorの情報を取得
				List<MasterSectorVisions> MasterSectorVisions = MSeVrepository.findAll();
				model.addAttribute("MasterSectorVisions", MasterSectorVisions);

				return mav;
			}

			// CareerVisions型に変換
			CareerVisions careerVisions = dataOptional.get();
			// ユーザー名とエンジニアレベルをusersテーブルより引っ張ってくる
			mav.addObject("userName", mydata.getUserName());
			mav.addObject("engineerLevel", mydata.getEngineerLevel());

			// 大事にしたいことの表示
			mav.addObject("firstEssential", careerVisions.getFirstEssential());
			mav.addObject("secondEssential", careerVisions.getSecondEssential());
			mav.addObject("thirdEssential", careerVisions.getThirdEssential());

			// MasterManagementの情報を取得
			List<MasterManagementVisions> MasterManagementVisions = MMVrepository.findAll();
			model.addAttribute("MasterManagementVisions", MasterManagementVisions);

			// ManagementVisionsの情報を取得
			List<ManagementVisions> ManagementVisions = MVrepository.findByUserIdOrderByVersionDesc((int) mydata.getUserId(), CVForm.getVersion());
			if (ManagementVisions.size() > 0 && ManagementVisions.get(0).getVersion() == careerVisions.getVersion()) {
			model.addAttribute("ManagementVisions", ManagementVisions);
			}

			// MasterSpecialistの情報を取得
			List<MasterSpecialistVisions> MasterSpecialistVisions = MSpVrepository.findAll();
			model.addAttribute("MasterSpecialistVisions", MasterSpecialistVisions);

			// SpecialistVisionsの情報を取得
			List<SpecialistVisions> SpecialistVisions = SpVrepository.findByUserIdOrderByVersionDesc((int) mydata.getUserId(), CVForm.getVersion());
			if (SpecialistVisions.size() > 0 && SpecialistVisions.get(0).getVersion() == careerVisions.getVersion()) {
			model.addAttribute("SpecialistVisions", SpecialistVisions);
			}

			// MasterSpecialistの情報を取得
			List<MasterSectorVisions> MasterSectorVisions = MSeVrepository.findAll();
			model.addAttribute("MasterSectorVisions", MasterSectorVisions);

			// sectorVisionsの情報を取得
			List<SectorVisions> SectorVisions = SeVrepository.findByUserIdOrderByVersionDesc((int) mydata.getUserId(),CVForm.getVersion());
			if (SectorVisions.size() > 0 && SectorVisions.get(0).getVersion() == careerVisions.getVersion()) {
			model.addAttribute("SectorVisions", SectorVisions);
			}

			// やりたいこと（その他）の表示
			mav.addObject("freetext", careerVisions.getFreetext());

			// 将来ビジョン（1,3,5年後）の表示
			mav.addObject("oneyearVision", careerVisions.getOneyearVision());
			mav.addObject("threeyearsVision", careerVisions.getThreeyearsVision());
			mav.addObject("fiveyearsVision", careerVisions.getFiveyearsVision());

			return mav;
		}

}