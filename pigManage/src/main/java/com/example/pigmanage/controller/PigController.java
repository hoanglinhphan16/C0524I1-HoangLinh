package com.example.pigmanage.controller;

import com.example.pigmanage.model.Origin;
import com.example.pigmanage.model.Pig;
import com.example.pigmanage.service.OriginService;
import com.example.pigmanage.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/pigs")
public class PigController {

    @Autowired
    private PigService pigService;

    @Autowired
    private OriginService originService;

    @ModelAttribute("origins")
    public List<Origin> getOrigins() {
        return originService.findAll();
    }

    @GetMapping()
    public ModelAndView getPigs() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Pig> pigs = pigService.findAll();
        modelAndView.addObject("pigs", pigs);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPig(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Pig pig = pigService.findById(id);
        modelAndView.addObject("pig", pig);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editPig(@ModelAttribute("pig") Pig pig) {
        pigService.save(pig);
        return "redirect:/pigs";
    }

    @GetMapping("/search")
    public ModelAndView searchPig(@RequestParam(required = false) String status, @RequestParam(required = false) Long pigId, @RequestParam(required = false) Long originId) {
        ModelAndView modelAndView = new ModelAndView("list");
        if (status != null && status.isEmpty()) {
            status = null;
        }

        Origin origin = null;
        if (originId != null) {
            origin = originService.findById(originId);
        }
//        if (status.equals("Chưa bán")) {
//            modelAndView.addObject("pigs", pigService.findAllPigNotSell(pigId,origin));
//        } else if (status.equals("Đã bán")) {
//            System.out.println(pigService.findAllSoldPig(pigId,origin));
//            modelAndView.addObject("pigs", pigService.findAllSoldPig(pigId,origin));
//        }

        modelAndView.addObject("pigs", pigService.searchPig(pigId, origin, status));
        return modelAndView;
    }
}
