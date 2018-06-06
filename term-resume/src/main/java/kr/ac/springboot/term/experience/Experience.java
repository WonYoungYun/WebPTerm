package kr.ac.springboot.term.experience;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.resume.Resume;

@Entity
public class Experience {
	
	public Experience() {
		
	}
	
	public Experience(String role, String name, String date, String text) {
		this.role = role;
		this.name = name;
		this.date = date;
		this.text = text;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eno;
	
	private String role;
	private String name;
	private String date;
	private String text;


	@JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    private Resume resume;


	public Long getEno() {
		return eno;
	}

	public void setEno(Long eno) {
		this.eno = eno;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Experience [eno=" + eno + ", role=" + role + ", name=" + name + ", date=" + date + ", text=" + text
				+ ", resume=" + resume + "]";
	}
	

	
	
	

}
