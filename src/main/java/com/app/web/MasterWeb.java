package com.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.dto.MasterDto;
import com.app.service.api.MasterService;

@RestController
@RequestMapping("/master")
public class MasterWeb
{
	private MasterService masterService;

	@PostMapping("/save-master")
	public void addMaster(@RequestBody MasterDto masterDto)
	{
		masterService.addMaster(masterDto);
	}

	@DeleteMapping("/delete-master")
	public void deleteMaster(@RequestBody MasterDto masterDto)
	{
		masterService.deleteMaster(masterDto);
	}

	@GetMapping("/get-master-by-id/{id}")
	public MasterDto findMasterById(@PathVariable long id)
	{
		return masterService.findMasterById(id);
	}

	@GetMapping("/find-all-master")
	public List<MasterDto> findAllMasters()
	{
		return masterService.findAllMasters();
	}

	 @DeleteMapping("/delete-master/{id}")
    public void deleteMaster(@PathVariable long id) {
        masterService.deleteMasterById(id);
    }

	@GetMapping("/find-free-masters")
	public List<MasterDto> findAllFreeMasters()
	{
		return masterService.findFreeMasters();
	}

	@Autowired
	public void setMasterService(MasterService masterService)
	{
		this.masterService = masterService;
	}
}
