package com.app.web;

import java.util.List;

import com.app.model.dto.MasterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.entity.MasterEntity;
import com.app.service.api.MasterService;

@RestController
@RequestMapping("/master")
public class MasterWeb
{
	private MasterService masterService;

	@PostMapping("/save")
	public void addMaster(@RequestBody MasterDto masterDto)
	{
		masterService.addMaster(masterDto);
	}

	@DeleteMapping("/delete")
	public void deleteMaster(@RequestBody MasterDto masterDto)
	{
		masterService.deleteMaster(masterDto);
	}

	@GetMapping("/findById/{id}")
	public MasterEntity findMasterById(@PathVariable Long id)
	{
		return masterService.findMasterById(id);
	}

	@GetMapping("/findAll")
	public List<MasterEntity> findAllMasters()
	{
		return masterService.findAllMasters();
	}

	@Autowired
	public void setMasterService(MasterService masterService)
	{
		this.masterService = masterService;
	}
}
