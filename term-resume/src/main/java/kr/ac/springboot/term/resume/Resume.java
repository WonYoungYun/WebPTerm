package kr.ac.springboot.term.resume;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.ac.springboot.term.experience.Experience;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_resumes")
public class Resume {

    public Resume(){

    }

    public Resume(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rno;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", fetch = FetchType.LAZY)
    private List<Experience> replie;

    public Long getRno() {
        return rno;
    }

    public void setRno(Long rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
