package kr.ac.springboot.term.experience;


import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.ac.springboot.term.resume.Resume;

import javax.persistence.*;

@Entity
@Table(name = "tbl_experiences")
public class Experience {

    public Experience() {
    }

    public Experience(String experienceText, Resume resume) {
        this.experienceText = experienceText;
        this.resume = resume;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eno;

    private String experienceText;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Resume resume;

    public Long getEno() {
        return eno;
    }

    public void setEno(Long eno) {
        this.eno = eno;
    }

    public String getExperienceText() {
        return experienceText;
    }

    public void setExperienceText(String experienceText) {
        this.experienceText = experienceText;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "eno=" + eno +
                ", experienceText='" + experienceText + '\'' +
                '}';
    }
}
