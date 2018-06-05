package kr.ac.springboot.term.experience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ExperienceController {

	@Autowired
	private ExperienceRepository repo;
	
    @GetMapping("/experience")
    public void experienceIndex(Model model) {
    	model.addAttribute("result", repo.findAll());
    }
    
}
