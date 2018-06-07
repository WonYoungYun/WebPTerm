package kr.ac.springboot.term.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class QnAController {
	
	@Autowired
	private QnARepository repo;
	
	@GetMapping("/qna")
	public void qnAIndex(Model model) {
		model.addAttribute("result", repo.findAllByOrderByRegdateDesc());
	}
	
}
