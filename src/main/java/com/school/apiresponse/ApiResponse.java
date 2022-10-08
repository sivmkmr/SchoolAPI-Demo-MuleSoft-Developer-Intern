package com.school.apiresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.school.schoolentity.SchoolEntity;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

	private String message;
	private SchoolEntity schoolEntity;
	private List<SchoolEntity> allSchoolEntities;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SchoolEntity getSchoolEntity() {
		return schoolEntity;
	}

	public void setSchoolEntity(SchoolEntity schoolEntity) {
		this.schoolEntity = schoolEntity;
	}

	public List<SchoolEntity> getAllSchoolEntities() {
		return allSchoolEntities;
	}

	public void setAllSchoolEntities(List<SchoolEntity> allSchoolEntities) {
		this.allSchoolEntities = allSchoolEntities;
	}

}
