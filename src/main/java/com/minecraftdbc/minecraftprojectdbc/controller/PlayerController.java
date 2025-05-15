package com.minecraftdbc.minecraftprojectdbc.controller;

import com.minecraftdbc.minecraftprojectdbc.model.Player;
import com.minecraftdbc.minecraftprojectdbc.service.PlayerService;
import com.minecraftdbc.minecraftprojectdbc.repository.PlayerRepository;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerService playerService, PlayerRepository playerRepository) {
        this.playerService = playerService;
        this.playerRepository = playerRepository;
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
public String createAccount(
        @RequestParam String name,
        @RequestParam String password,
        @RequestParam String confirmPassword,
        @RequestParam String playerType,
        Model model,
        RedirectAttributes redirectAttributes) {

    // Validación básica
    if (!password.equals(confirmPassword)) {
        model.addAttribute("error", "Las contraseñas no coinciden");
        return "createPlayer";
    }

    // Verificar si el usuario ya existe
    if (playerRepository.existsByName(name)) {
        model.addAttribute("error", "El nombre de usuario ya existe");
        return "createPlayer";
    }

    // Crear y guardar el jugador
    Player player = new Player();
    player.setName(name);
    player.setPassword(password); // En producción: encriptar aquí
    player.setPlayerType(playerType);
    player.setLevel("0");
    player.setExperience(0);

    // ESTA ES LA LÍNEA FALTANTE QUE GUARDA EN LA BD
    playerRepository.save(player);

    // Mensaje de éxito
    redirectAttributes.addFlashAttribute("success", "¡Registro exitoso! Por favor inicia sesión.");
    return "redirect:/";
}
}