package com.minecraftdbc.minecraftprojectdbc.service;

import com.minecraftdbc.minecraftprojectdbc.model.Player;
import com.minecraftdbc.minecraftprojectdbc.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Registrar un jugador
    public String registerPlayer(Player player) {
        if (playerRepository.findByName(player.getName()) != null) {
            return "El nombre de usuario ya existe"; // Mensaje de error
        }
        player.setLevel("0");
        player.setExperience(0);
        playerRepository.save(player);
        return null; // Retorna null si no hay error
    }

    // Login (retorna null si falla)
    public Player login(String name, String password) {
        Player player = playerRepository.findByName(name);
        if (player != null && player.getPassword().equals(password)) {
            return player;
        }
        return null;
    }

    public Object getAllPlayers() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllPlayers'");
    }

}