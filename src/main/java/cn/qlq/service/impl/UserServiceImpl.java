package cn.qlq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qlq.bean.Doctor;
import cn.qlq.bean.Register;
import cn.qlq.bean.User;
import cn.qlq.bean.Usertype;
import cn.qlq.mapper.UserMapper;
import cn.qlq.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;//依赖注入
	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		List<User> list = userMapper.findAll();
		return list;
	}
	@Override
	public List<Usertype> findAllUsertype(){
		List<Usertype> list = userMapper.findAll1();
		return list;
	}
	@Override
	public List<Register> findAllregister(){
		List<Register> list = userMapper.findAllRegister();
		return list;
	}
	@Override
	public void insertRegisterS(Register res) {
		// TODO Auto-generated method stub
		userMapper.insertRegister(res);
	}
	
	@Override
	public void deleteRegisterS(int id)
	{
		userMapper.deleteRegister(id);
	}
	
	@Override
	public void updateRegisterS(Register res)
	{
		userMapper.updateRegister(res);
	}
	
	@Override
	public List<Doctor> finddoctor(String type)
	{
		List<Doctor> list = userMapper.findDoctor(type);
		return list;
	}
	
	@Override
	public List<Doctor> findalldoctor()
	{
		List<Doctor> list = userMapper.findallDoctor();
		return list;
	}
	
	@Override
	public void deleteDoctorS(int id)
	{
		userMapper.deleteDoctor(id);
	}
	
	@Override
	public void updateDoctorS(Doctor res)
	{
		userMapper.updateDoctor(res);
	}
	@Override
	public void insertDoctorS(Doctor res)
	{
		userMapper.insertDoctor(res);
	}
}
