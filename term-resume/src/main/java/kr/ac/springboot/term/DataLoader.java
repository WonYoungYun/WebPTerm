package kr.ac.springboot.term;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ResumeRepository resumeRepo;
	

    @Override
    public void run(ApplicationArguments args) {
    	IntStream.range(1, 100).forEach(i -> resumeRepo.save(new Resume("name"+i)));
    }

}