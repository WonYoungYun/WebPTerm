package kr.ac.springboot.term.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResumeController {

    // '/' ==> list
    // '/register' ==> create
    // '/{rno} ==> view
    // '/{rno}/update ==> update'
    // '/{rno}/delete ==> delete'
    @Autowired
    private ResumeRepository resumeRepository;

    @GetMapping("/")
    public String resumeIndex(Model model) {
        Resume resume = new Resume();
        resume.setName("윤원영");
        model.addAttribute("resume", resume);
        return "index";
    }


}
