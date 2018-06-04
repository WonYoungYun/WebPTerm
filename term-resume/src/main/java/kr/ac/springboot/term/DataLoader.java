package kr.ac.springboot.term;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public void run(ApplicationArguments args) {
        IntStream.range(1, 10).forEach(i -> resumeRepository.save(new Resume("name"+i)));
        IntStream.range(1, 10).forEach(i -> experienceRepository.save(new Experience("Text"+i, resumeRepository.findById((long)i).orElse(null))));
    }

}