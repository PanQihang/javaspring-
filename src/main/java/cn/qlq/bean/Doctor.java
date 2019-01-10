package cn.qlq.bean;

public class Doctor {
	private int id;
	private String doctor;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getType() {
		return type;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doctor=" + doctor + ", type=" + type + "]";
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
