package kr.ac.springboot.term;

import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public void run(ApplicationArguments args) {
        IntStream.range(1, 100).forEach(i -> resumeRepository.save(new Resume("name"+i)));
    }

}