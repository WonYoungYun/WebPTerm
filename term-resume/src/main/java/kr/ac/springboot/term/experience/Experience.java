package kr.ac.springboot.term.experience;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.resume.Resume;

@Entity
@Table(name ="tb1_experience")
public class Experience {
	
	public Experience() {
		
	}
	
	public Experience(String role, String name, String date, String text, Resume resume) {
		this.role = role;
		this.name = name;
		this.date = date;
		this.text = text;
		this.resume = resume;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eno;
	
	private String role;
	private String name;
	private String date;
	private String text;

    @CreationTimestamp
    private Timestamp regdate;
    
    @UpdateTimestamp
    private Timestamp updatedate;
    
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

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
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
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + ", resume=" + resume + "]";
	}


    


	
	

	
	
	

}
