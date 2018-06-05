package kr.ac.springboot.term;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ResumeRepository resumeRepo;
	
	@Autowired
	private ExperienceRepository experiRepo;
    @Override
    public void run(ApplicationArguments args) {
    	IntStream.range(1, 10).forEach(i -> resumeRepo.save(new Resume("name"+i)));
    	IntStream.range(1, 10).forEach(i -> experiRepo.save(new Experience("text"+i)));
    }

}