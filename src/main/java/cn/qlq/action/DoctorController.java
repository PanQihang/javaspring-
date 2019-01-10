package cn.qlq.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.qlq.bean.Doctor;
import cn.qlq.service.impl.UserServiceImpl;

@RestController
public class DoctorController {

	@Autowired
	private UserServiceImpl userServiceImpl;//依赖注入
	
	@RequestMapping(value="/doctorfind",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<Doctor> findDoctor()
	{
		List<Doctor> list = userServiceImpl.findalldoctor();
		return list;
	}
	
	@RequestMapping(value="/doctordelete",method=RequestMethod.POST)
	@ResponseBody
	public void deletedoctor(@RequestBody Doctor res)
	{
		System.out.println("===========================");
		System.out.println(res.getId());
		userServiceImpl.deleteDoctorS(res.getId());
	}
	
	@RequestMapping(value="/doctorupdate",method=RequestMethod.POST)
	@ResponseBody
	public void updatedoctor(@RequestBody Doctor res)
	{
		userServiceImpl.updateDoctorS(res);
	}
	
	@RequestMapping(value="/doctorinsert",method=RequestMethod.POST)
	@ResponseBody
	public void insertdoctor(@RequestBody Doctor res)
	{
		userServiceImpl.insertDoctorS(res);
	}
}
