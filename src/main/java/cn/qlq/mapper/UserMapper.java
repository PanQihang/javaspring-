package cn.qlq.mapper;

import java.util.List;

import cn.qlq.bean.Doctor;
import cn.qlq.bean.Register;
import cn.qlq.bean.User;
import cn.qlq.bean.Usertype;
 
public interface UserMapper {
	public List<User>findAll();                //查询所有账号信息
	public List<Usertype>findAll1();           //查询所有账号类型
	public List<Register>findAllRegister();    //查询所有挂号信息
	public void insertRegister(Register res);  //新增挂号信息
	public void deleteRegister(int id);        //删除挂号信息
	public void updateRegister(Register res);  //更新挂号信息
	public List<Doctor>findDoctor(String type);//查询某科室医生
	public List<Doctor>findallDoctor();        //查询所有医生信息
	public void deleteDoctor(int id);          //删除医生信息
	public void updateDoctor(Doctor res);      //更新医生信息
	public void insertDoctor(Doctor res);      //新增医生信息
}
