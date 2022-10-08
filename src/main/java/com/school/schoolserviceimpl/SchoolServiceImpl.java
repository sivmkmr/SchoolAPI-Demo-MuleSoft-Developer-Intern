package com.school.schoolserviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.apiresponse.ApiResponse;
import com.school.entitymodel.EntityModel;
import com.school.globalconstant.GlobalConstant;
import com.school.schoolentity.SchoolEntity;
import com.school.schoolrepository.SchoolRepository;
import com.school.schoolservice.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;

//	Singleton design pattern
	SchoolEntity schoolEntity = SchoolEntity.getObjEntity();
//

//	Dummy API for Testing 

	@Override
	public ApiResponse dummyApi() {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage(GlobalConstant.dummyApiSuccess);
		return apiResponse;
	}

//	Data Insertion Block

	@Override
	public ApiResponse saveData(EntityModel entityModel) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();

		try {
			schoolEntity.setName(entityModel.getName());
			schoolEntity.setRollNo(entityModel.getRollNo());
			schoolEntity.setsClass(entityModel.getsClass());
			schoolEntity.setSubject(entityModel.getSubject());
			schoolRepository.save(schoolEntity);
			apiResponse.setMessage(GlobalConstant.dataSaveSuccess);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse.setMessage(GlobalConstant.dataSaveFail);
		}
		return apiResponse;
	}

//	Get All Data Block

	@Override
	public ApiResponse getAllData() {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		List<SchoolEntity> listDbData = schoolRepository.findAll();
		if (listDbData.isEmpty()) {
			apiResponse.setMessage(GlobalConstant.getAllDataFail);
		} else {
			apiResponse.setAllSchoolEntities(listDbData);
			apiResponse.setMessage(GlobalConstant.getAllDataSuccess);
		}
		return apiResponse;
	}

//	Get Data By Id Block

	@Override
	public ApiResponse getDatabyId(Integer id) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		Optional<SchoolEntity> dbData = schoolRepository.findById(id);
		if (dbData.isEmpty()) {
			apiResponse.setMessage(GlobalConstant.getByIdFail);
		} else {
			apiResponse.setSchoolEntity(dbData.get());
			apiResponse.setMessage(GlobalConstant.getByIdSuccess);
		}
		return apiResponse;
	}

//	Data Updation By Put Block

	@Override
	public ApiResponse updateDataByPut(EntityModel entityModel, Integer id) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		Optional<SchoolEntity> dbData = schoolRepository.findById(id);
		if (dbData.isEmpty()) {
			apiResponse.setMessage(GlobalConstant.updateDataFail);
		} else {
			schoolEntity = dbData.get();
			schoolEntity.setName(entityModel.getName());
//			schoolEntity.setRollNo(entityModel.getRollNo());
//			schoolEntity.setsClass(entityModel.getsClass());
//			schoolEntity.setSubject(entityModel.getSubject());
			schoolRepository.save(schoolEntity);
			apiResponse.setMessage(GlobalConstant.updateDataSuccess);
		}
		return apiResponse;
	}

//	Data Updation By Patch Block

	@Override
	public ApiResponse updateDataByPatch(EntityModel entityModel, Integer id) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		Optional<SchoolEntity> dbData = schoolRepository.findById(id);
		if (dbData.isEmpty()) {
			apiResponse.setMessage(GlobalConstant.updateDataFail);
		} else {
			schoolEntity = dbData.get();
			schoolEntity.setName(entityModel.getName());
//			schoolEntity.setRollNo(entityModel.getRollNo());
//			schoolEntity.setsClass(entityModel.getsClass());
//			schoolEntity.setSubject(entityModel.getSubject());
			schoolRepository.save(schoolEntity);
			apiResponse.setMessage(GlobalConstant.updateDataSuccess);
		}
		return apiResponse;
	}

//	Data Deletion Block

	@Override
	public ApiResponse dataDeletebyId(Integer id) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		Optional<SchoolEntity> dbData = schoolRepository.findById(id);
		if (dbData.isEmpty()) {
			apiResponse.setMessage(GlobalConstant.deleteByIdFail);
		} else {
			schoolRepository.deleteById(id);
			apiResponse.setMessage(GlobalConstant.deleteByIdSuccess);
		}
		return apiResponse;
	}

}
