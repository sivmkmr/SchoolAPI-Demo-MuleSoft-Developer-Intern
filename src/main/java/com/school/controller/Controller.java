package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.apiresponse.ApiResponse;
import com.school.entitymodel.EntityModel;
import com.school.schoolservice.SchoolService;

@RestController
public class Controller {

	@Autowired
	private SchoolService schoolService;
	
//	Dummy API for Testing purpose
	
	@GetMapping("dummy-api")
	public ResponseEntity<ApiResponse> dummyApi() {
		ApiResponse response = schoolService.dummyApi();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	
//	Data Insertion Block
	
	@PostMapping("save-data")
	public ResponseEntity<ApiResponse> saveData(@RequestBody EntityModel entityModel) {
		ApiResponse response = schoolService.saveData(entityModel);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.CREATED);
	}
	
//	Get All Data Block
	
	@GetMapping("get-all-data")
	public ResponseEntity<ApiResponse> getAllData() {
		ApiResponse response = schoolService.getAllData();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	
//	Get Data By Id Block
	
	@GetMapping("/get-data-by-id/{id}")
	public ResponseEntity<ApiResponse> getDatabyId(@PathVariable("id") Integer id) {
		ApiResponse response = schoolService.getDatabyId(id);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
	}
	
//	Data Updation By Put Block
	
	@PutMapping("/update-data-by-put/{id}")
	public ResponseEntity<ApiResponse> updateDataByPut(@RequestBody EntityModel entityModel, @PathVariable("id") Integer id) {
		ApiResponse response = schoolService.updateDataByPut(entityModel,id);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
	}
	
//	Data Updation By Patch Block
	
	@PatchMapping("/update-data-by-patch/{id}")
	public ResponseEntity<ApiResponse> updateDataByPatch(@RequestBody EntityModel entityModel, @PathVariable("id") Integer id) {
		ApiResponse response = schoolService.updateDataByPatch(entityModel,id);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
	}
	
//	Data Deletion Block
	
	@DeleteMapping("/delete-data-by-id/{id}")
	public ResponseEntity<ApiResponse> dataDeletebyId(@PathVariable("id") Integer id) {
		ApiResponse response = schoolService.dataDeletebyId(id);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
	}
	
}
