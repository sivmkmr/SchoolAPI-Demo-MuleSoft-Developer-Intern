package com.school.schoolservice;

import com.school.apiresponse.ApiResponse;
import com.school.entitymodel.EntityModel;

public interface SchoolService {

	ApiResponse dummyApi();

	ApiResponse saveData(EntityModel entityModel);

	ApiResponse getAllData();

	ApiResponse getDatabyId(Integer id);

	ApiResponse updateDataByPut(EntityModel entityModel, Integer id);

	ApiResponse updateDataByPatch(EntityModel entityModel, Integer id);

	ApiResponse dataDeletebyId(Integer id);


}
