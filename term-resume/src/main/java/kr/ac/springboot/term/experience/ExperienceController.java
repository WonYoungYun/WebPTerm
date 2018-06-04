package kr.ac.springboot.term.experience;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/experiences/")
public class ExperienceController {

    @Autowired
    private ExperienceRepository experienceRepository;

    @GetMapping("/")
    public void ExperienceList(Model model) {
        model.addAttribute("result", experienceRepository.findAll());
    }

    @GetMapping("/register")
    public void registerGET(@ModelAttribute("vo") Experience vo){
    }

    @PostMapping("/register")
    public String registerPoset(@ModelAttribute("vo") Experience vo){
        experienceRepository.save(vo);
        return "redirect:/experiences/";
    }

    @GetMapping("/{eno}")
    public String view(@PathVariable("eno") long eno, Model model) {
        if (experienceRepository.findById(eno).isPresent()) {
            model.addAttribute("result", experienceRepository.findById(eno).get());
        } else {
            return "errors/404";
        }
        return "experiences/items";
    }

    @GetMapping("/delete/{eno}")
    public String delete(@PathVariable("eno") long eno) {
        if (experienceRepository.findById(eno).isPresent()) {
            experienceRepository.deleteById(eno);
        } else {
            return "errors/404";
        }
        return "redirect:/experiences/";
    }

    @GetMapping("/edit/{eno}")
    public String editGet(@PathVariable("eno") long eno, @ModelAttribute("vo") Experience vo, Model model) {
        if (experienceRepository.findById(eno).isPresent()) {
            model.addAttribute("vo", experienceRepository.findById(eno).get());
        } else {
            return "errors/404";
        }
        return "experiences/edit";
    }

    @PostMapping("/edit")
    public String editPost(@ModelAttribute("vo") Experience vo) {
        Optional<Experience> webBoard = experienceRepository.findById(vo.getEno());
        if (webBoard.isPresent()) {
            webBoard.get().setExperienceText(vo.getExperienceText());
            experienceRepository.save(webBoard.get());
        } else {
            experienceRepository.save(vo);
        }
        return "redirect:/experiences/";
    }
}
