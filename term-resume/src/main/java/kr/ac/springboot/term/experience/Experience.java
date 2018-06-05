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
	
	public Experience(String exText) {
		this.exText = exText;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eno;
	
	private String exText;

	@JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    private Resume resume;
	
	public Long getEno() {
		return eno;
	}

	public void setEno(Long eno) {
		this.eno = eno;
	}

	public String getExText() {
		return exText;
	}

	public void setExText(String exText) {
		this.exText = exText;
	}

	@Override
	public String toString() {
		return "experience [eno=" + eno + ", exText=" + exText + "]";
	}
	
	
	

}
