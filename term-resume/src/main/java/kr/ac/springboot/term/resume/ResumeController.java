package kr.ac.springboot.term.resume;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {
	
	@ExceptionHandler(Exception.class)
	public String resumeException(Exception e) {
		return "errors/500";
	}
	
    @GetMapping("/")
    public String resumeIndex(Model model) throws Exception{
        Resume resume = new Resume();
        resume.setName("윤원영");
        model.addAttribute("resume", resume);
        return "resume";
    }

}
