package cn.qlq.service;

import java.util.List;

import cn.qlq.bean.Doctor;
import cn.qlq.bean.Register;
import cn.qlq.bean.User;
import cn.qlq.bean.Usertype;

public interface UserService {
      public List<User> findAllUser();
      public List<Usertype> findAllUsertype();
      public List<Register> findAllregister();
      public void insertRegisterS(Register res);
      public void deleteRegisterS(int id);
      public void updateRegisterS(Register res);
      public List<Doctor> finddoctor(String type);
      public List<Doctor>findalldoctor();
      public void deleteDoctorS(int id);
      public void updateDoctorS(Doctor res);
      public void insertDoctorS(Doctor res);
}
