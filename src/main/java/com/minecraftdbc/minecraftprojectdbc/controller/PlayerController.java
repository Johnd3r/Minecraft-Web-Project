package com.minecraftdbc.minecraftprojectdbc.controller;

import com.minecraftdbc.minecraftprojectdbc.model.Player;
import com.minecraftdbc.minecraftprojectdbc.repository.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.minecraftdbc.minecraftprojectdbc.model.enums.PlayerType;

@Controller
public class PlayerController {
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        Player player = playerRepository.findByName(username);
        if (player != null && player.getPassword().equals(password)) {
            return "redirect:/players";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "index";
        }
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "createPlayer";
    }

    @PostMapping("/createAccount")
    public String createAccount(
            @RequestParam String name,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            @RequestParam PlayerType playerType,
            Model model) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden");
            return "createPlayer";
        }

        if (playerRepository.existsByName(name)) {
            model.addAttribute("error", "El nombre ya existe");
            return "createPlayer";
        }

        Player player = new Player();
        player.setName(name);
        player.setPassword(password);
        player.setPlayerType(playerType);
        player.setLevel("0");
        player.setExperience(0.0f);

        playerRepository.save(player);

        return "redirect:/?success";
    }
}