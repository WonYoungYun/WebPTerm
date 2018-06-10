package kr.ac.springboot.term.qnA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna/")
public class QnAController {
	
	@Autowired
	private QnARepository repo;
	
	@GetMapping("/list")
	public void qnAIndex(Model model) {
		model.addAttribute("result", repo.findAllByOrderByRegdateDesc());
	}
	
    @GetMapping("/{qno}")
    public String view(@PathVariable("qno") long qno, Model model) {
        if (repo.findById(qno).isPresent()) {
            model.addAttribute("result", repo.findById(qno).get());
        } else {
            return "errors/404";
        }
        return "qna/item";
    }
    
    @GetMapping("/register")
    public void registerGET(@ModelAttribute("vo") QnA vo) {
    }

    @PostMapping("/register")
    public String registerPOST(@ModelAttribute("vo") QnA vo) {
        repo.save(vo);
        return "redirect:/qna/list";
    }
    
    
	
}
