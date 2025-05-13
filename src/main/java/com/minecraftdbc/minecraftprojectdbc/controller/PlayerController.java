package com.minecraftdbc.minecraftprojectdbc.controller;

import com.minecraftdbc.minecraftprojectdbc.model.Player;
import com.minecraftdbc.minecraftprojectdbc.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public String showPlayers(Model model) {
        List<Player> players = playerService.getAllPlayers();
        model.addAttribute("players", players); // esto lo pasamos a Thymeleaf
        return "players"; // busca el archivo players.html en templates
    }
}