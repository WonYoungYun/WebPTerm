package kr.ac.springboot.term;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;
import kr.ac.springboot.term.qna.QnA;
import kr.ac.springboot.term.qna.QnARepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ExperienceRepository experiRepo;
	
	@Autowired
	private QnARepository qnARepo;
	
    @Override
    public void run(ApplicationArguments args) {
    	IntStream.range(1, 10).forEach(i -> experiRepo.save(new Experience("role"+i, "name"+i, ""+(i+2000), "text"+i)));
    	IntStream.range(1, 5).forEach(i -> qnARepo.save(new QnA("title"+i, "name0"+i, "text"+i)));
    }

}