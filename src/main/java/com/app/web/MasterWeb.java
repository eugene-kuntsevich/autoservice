package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.entity.MasterEntity;
import com.app.service.MasterService;

@RestController
@RequestMapping("/master")
public class MasterWeb
{
	private MasterService masterService;

	@PostMapping("/add-master")
	public void addUser(@RequestBody MasterEntity userEntity)
	{
		masterService.addUser(userEntity);
	}

	@Autowired
	public void setMasterService(MasterService masterService)
	{
		this.masterService = masterService;
	}
}
