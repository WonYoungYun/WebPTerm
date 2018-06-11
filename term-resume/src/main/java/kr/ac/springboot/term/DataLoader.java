package kr.ac.springboot.term;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;
import kr.ac.springboot.term.qnA.QnA;
import kr.ac.springboot.term.qnA.QnARepository;
import kr.ac.springboot.term.qnAReply.QnAReply;
import kr.ac.springboot.term.qnAReply.QnAReplyRepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private ResumeRepository resumeRepo;

	@Autowired
	private ExperienceRepository experiRepo;
	
	@Autowired
	private QnARepository qnARepo;
	
	@Autowired
	private QnAReplyRepository qnAReplyRepo;
	
    @Override
    public void run(ApplicationArguments args) {
    	IntStream.range(1, 10).forEach(i -> resumeRepo.save(new Resume("name"+i)));
    	IntStream.range(1, 5).forEach(i -> qnARepo.save(new QnA("title"+i, "name0"+i, "text"+i)));
    	IntStream.range(1, 10).forEach(i -> experiRepo.save(new Experience("role"+i, "name"+i, ""+(i+2000), "text"+i, resumeRepo.findById((long)i).orElse(null))));
    	IntStream.range(1, 5).forEach(i -> qnAReplyRepo.save(new QnAReply("replyText"+i, "replyer"+i, qnARepo.findById((long)i+9).orElse(null))));
    	

    }

}