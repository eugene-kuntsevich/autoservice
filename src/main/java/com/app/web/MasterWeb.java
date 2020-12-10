package com.app.web;

import com.app.model.entity.PersistableEntityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.model.entity.MasterEntity;
import com.app.service.MasterService;

import java.util.List;

@RestController
@RequestMapping("/master")
public class MasterWeb
{
	private MasterService masterService;

	/*@PostMapping("/add-master")
	public void addUser(@RequestBody MasterEntity userEntity)
	{
		masterService.addUser(userEntity);
           	}
*/


	@PostMapping("/save-master")
	public void saveMaster(@RequestBody MasterEntity userEntity)
	{
		masterService.saveMaster(userEntity);
	}
	@DeleteMapping("/delete-master")
	public void deleteMaster(@RequestBody MasterEntity userEntity)
	{
		masterService.deleteMaster(userEntity);
	}
	@GetMapping ("/getById-master/{id}")
	public MasterEntity getMasterById(@PathVariable long id)
	{
		return masterService.getMasterById(id);
	}
	@GetMapping ("/findAll-master")
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
