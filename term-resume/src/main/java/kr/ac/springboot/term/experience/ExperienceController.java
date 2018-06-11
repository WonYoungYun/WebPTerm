package kr.ac.springboot.term.experience;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class ExperienceController {
	@Autowired
	private ExperienceRepository repo;
	
    @GetMapping("/experience")
    public void experienceIndex(Model model) {
    	model.addAttribute("result", repo.findAllByOrderByDateDesc());
    }
    
    @GetMapping("/{eno}")
    public String view(@PathVariable("eno") long eno, Model model) {
        if (repo.findById(eno).isPresent()) {
            model.addAttribute("result", repo.findById(eno).get());
        } else {
            return "errors/404";
        }
        return "item";
    }
    
    @GetMapping("/register")
    public void registerGET(@ModelAttribute("vo") Experience vo) {
    }

    @PostMapping("/register")
    public String registerPOST(@ModelAttribute("vo") Experience vo) {
        repo.save(vo);
        return "redirect:/experience";
    }
    
    @GetMapping("/{eno}/delete")
    public String delete(@PathVariable("eno") long eno) {
        if (repo.findById(eno).isPresent()) {
            repo.deleteById(eno);
        } else {
            return "errors/404";
        }
        return "redirect:/experience";
    }
    
    @GetMapping("/{eno}/edit")
    public String editGet(@PathVariable("eno") long eno, @ModelAttribute("vo") Experience vo, Model model) {
        if (repo.findById(eno).isPresent()) {
            model.addAttribute("vo", repo.findById(eno).get());
        } else {
            return "errors/404";
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String editPost(@ModelAttribute("vo") Experience vo) {
        Optional<Experience> experience = repo.findById(vo.getEno());
        if (experience.isPresent()) {
            experience.get().setText(vo.getText());
            experience.get().setName(vo.getName());
            experience.get().setRole(vo.getRole());
            experience.get().setDate(vo.getDate());
            repo.save(experience.get());
        } else {
            repo.save(vo);
        }
        return "redirect:/experience";
    }
    
}


