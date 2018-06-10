package kr.ac.springboot.term.qnAReply;

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

import kr.ac.springboot.term.qnA.QnA;

@Entity
@Table(name ="tb1_qnareplies")
public class QnAReply {
	
	public QnAReply() {
		
	}
	public QnAReply(String replyText, String replyer, QnA qna) {
		this.replyText = replyText;
		this.replyer = replyer;
		this.qna = qna;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rno;
	
	private String replyText;
	
	private String replyer;
	
	@CreationTimestamp
	private Timestamp regdate;
	
	@UpdateTimestamp
	private Timestamp updatedate;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private QnA qna;

	public Long getRno() {
		return rno;
	}
	public void setRno(Long rno) {
		this.rno = rno;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
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
	public QnA getQna() {
		return qna;
	}
	public void setQna(QnA qna) {
		this.qna = qna;
	}
	@Override
	public String toString() {
		return "QnAReply [rno=" + rno + ", replyText=" + replyText + ", replyer=" + replyer + ", regdate=" + regdate
				+ ", updatedate=" + updatedate + ", qna=" + qna + "]";
	}
	
	
}
