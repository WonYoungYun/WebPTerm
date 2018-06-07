package kr.ac.springboot.term.qna;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class QnA {
	
	public QnA() {
		
	}
	
	public QnA(String title, String name, String text) {
		this.title = title;
		this.name = name;
		this.text = text;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qno;
	
	private String title;
	private String name;
	private String text;
	
	@CreationTimestamp
	private Timestamp regdate;

	public Long getQno() {
		return qno;
	}

	public void setQno(Long qno) {
		this.qno = qno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "QnA [qno=" + qno + ", title=" + title + ", name=" + name + ", text=" + text + ", regdate=" + regdate
				+ "]";
	}

	
	
	


}
