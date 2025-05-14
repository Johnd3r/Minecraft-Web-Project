package com.minecraftdbc.minecraftprojectdbc.controller;

import com.minecraftdbc.minecraftprojectdbc.model.Player;
import com.minecraftdbc.minecraftprojectdbc.service.PlayerService;

/* import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; */

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // Página principal (login)
    @GetMapping("/")
    public String index() {
        return "index"; // index.html
    }

    // Procesar login
    @PostMapping("/login")
    @ResponseBody // Cambiamos para devolver JSON
    public ResponseEntity<Map<String, Object>> login(
            @RequestParam String username,
            @RequestParam String password) {

        Map<String, Object> response = new HashMap<>();
        Player player = playerService.login(username, password);

        if (player != null) {
            response.put("success", true);
            response.put("redirectUrl", "/players");
        } else {
            response.put("success", false);
            response.put("error", "Usuario o contraseña incorrectos");
        }

        return ResponseEntity.ok(response);
    }

    // Página de registro
    @GetMapping("/create")
    public String showCreateForm() {
        return "createPlayer"; // createPlayer.html
    }

    // Procesar registro
    @PostMapping("/createAccount")
    public String createAccount(Player player, Model model) {
        String error = playerService.registerPlayer(player);
        if (error != null) {
            model.addAttribute("error", error);
            return "createPlayer"; // Vuelve al formulario con el error
        }
        return "redirect:/"; // Éxito: redirige al login
    }

    // Lista de jugadores (ejemplo)
    @GetMapping("/players")
    public String showPlayers(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "players";
    }
}