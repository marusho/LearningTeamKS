package seattle.rookie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seattle.rookie.model.ProjectDto;
import seattle.rookie.model.ProjectEntity;
import seattle.rookie.model.UsersEntity;
import seattle.rookie.repositories.ProjectRepository;
import seattle.rookie.repositories.UsersRepository;

@Service
public class MasterMaintenanceService {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	UsersRepository usersRepository;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProjectDto> getProjectList(String customerName, String projectName) {
		List<ProjectEntity> projectList = projectRepository.findAll();
//		List<ProjectEntity> projectList = projectRepository.findByCustomerNameAndProjectName(customerName, projectName);
		ProjectDto projectResult = new ProjectDto();
		List<ProjectDto> projectResultList = new ArrayList();

		if (projectList != null) {
			for (ProjectEntity project:projectList) {
				projectResult = new ProjectDto();
				projectResult.setProjectId(project.getProjectId());
				projectResult.setCustomerName(project.getCustomerName());
				projectResult.setProjectName(project.getProjectName());
				projectResult.setExpansionPossibilities(getExpansionPossibilities(project.getExpansionPossibilities()));
				projectResult.setIncreaseNumber(project.getIncreaseNumber());
				projectResult.setSalesRepresentativeName(getSalesRepresentativeName(project.getSalesRepresentative()));
				projectResult.setRegistered_at(project.getRegistered_at());
				projectResult.setRegistered_by(project.getRegistered_by());
				projectResult.setUpdated_at(project.getUpdated_at());
				projectResult.setUpdated_by(project.getUpdated_by());
				projectResult.setVersion(project.getVersion());

				projectResultList.add(projectResult);
			}
		}

		return projectResultList;

	}

	/**
	 * ユーザ名取得
	 * @param userId ユーザID
	 * @return ユーザ名
	 *
	 * */
	private String getSalesRepresentativeName(long userId) {

		if (userId < 0) {
			return "";
		}

		UsersEntity user = usersRepository.findByUserId(userId);

		if (user == null) {
			return "";
		}

		return user.getUserName();
	}

	/**
	 * 拡大可能性変換
	 * @param expansionPossibilities 拡大可能性値
	 * @return 拡大可能性文字列
	 *
	 * */
	private String getExpansionPossibilities(int expansionPossibilities) {

		String expansionPossibilitiesStr = "";
		switch (expansionPossibilities) {
		case 0:
			expansionPossibilitiesStr = "小";
		case 1:
			expansionPossibilitiesStr = "中";
		case 2:
			expansionPossibilitiesStr = "大";
		case 3:
			expansionPossibilitiesStr = "極大";
		}

		return expansionPossibilitiesStr;
	}

}