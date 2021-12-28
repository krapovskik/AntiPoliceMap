package com.example.antipolice.web;

import com.example.antipolice.service.MapCoordinatesService;
import com.example.antipolice.service.PoliceStateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/anti-police")
public class HomeController {

    private final MapCoordinatesService mapCoordinatesService;
    private final PoliceStateService policeStateService;

    public HomeController(MapCoordinatesService mapCoordinatesService, PoliceStateService policeStateService) {
        this.mapCoordinatesService = mapCoordinatesService;
        this.policeStateService = policeStateService;
    }


    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("coordinates",mapCoordinatesService.findAll());
        model.addAttribute("body","map_view");
        return "base";
    }
    @GetMapping("/new_location")
    public String getAddPage(Model model){
        model.addAttribute("policeStates", policeStateService.findAll());
        model.addAttribute("body","add_map");
        return "base";
    }

    @PostMapping("/new_location")
    public String submit(@RequestParam String cord,@RequestParam String state){
        mapCoordinatesService.save(cord,state);
        return "redirect:/anti-police";
    }
}
