package hsf302.f25.s3.pehsf302662323ce190589.controller;

import hsf302.f25.s3.pehsf302662323ce190589.entity.Computer;
import hsf302.f25.s3.pehsf302662323ce190589.entity.Manufacturer;
import hsf302.f25.s3.pehsf302662323ce190589.entity.User;
import hsf302.f25.s3.pehsf302662323ce190589.repository.ComputerRepository;
import hsf302.f25.s3.pehsf302662323ce190589.repository.ManufacturerRepository;
import hsf302.f25.s3.pehsf302662323ce190589.service.ComputerService;
import hsf302.f25.s3.pehsf302662323ce190589.service.ManufacturerService;
import hsf302.f25.s3.pehsf302662323ce190589.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Year;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/computers")
public class ComputerController {

    private final ComputerService computerService;
    private final ManufacturerService manufacturerService;

    @GetMapping
    public String getAllProducts(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return  "redirect:/login";
        }
        model.addAttribute("computers", computerService.findAll());
        return "computers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return  "redirect:/login";
        }
        computerService.deleteById(id);
        return "redirect:/computers";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return  "redirect:/login";
        }
        model.addAttribute("computers", computerService.findById(id));
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("formMode", "update");
        return "computer-form";
    }

    @GetMapping("/create")
    public String create(Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return  "redirect:/login";
        }
        model.addAttribute("computers", new Computer());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("formMode", "create");
        return "computer-form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("computers") Computer computer,
                       BindingResult bindingResult, Model model, @RequestParam("mode") String formMode) {
        if(computer.getProductionYear() !=null){
            int currentYear = Year.now().getValue();
            if(computer.getProductionYear() > currentYear){
                bindingResult.rejectValue("productionYear", "error.computer", "Production year cannot be in the future.");
            }
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("manufacturers", manufacturerService.findAll());
            model.addAttribute("formMode", formMode);
            return "computer-form";
        }
        computerService.save(computer);
        return "redirect:/computers";
    }
}