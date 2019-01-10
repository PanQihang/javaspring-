package cn.qlq.bean;

import java.util.Date;

public class Register {
	private int id;
	private String name;
	private String sex;
	private Date birthdate;
	private String type;
	private String doctor;
	private int fee;
	private Date time;
	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", sex=" + sex + ", birthdate=" + birthdate + ", type=" + type
				+ ", doctor=" + doctor + ", fee=" + fee + ", time=" + time + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
