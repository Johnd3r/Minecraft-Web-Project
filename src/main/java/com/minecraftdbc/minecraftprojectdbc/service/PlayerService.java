package com.minecraftdbc.minecraftprojectdbc.service;

import com.minecraftdbc.minecraftprojectdbc.model.Player;
import com.minecraftdbc.minecraftprojectdbc.repository.PlayerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player login(String username, String password) {
        Player player = playerRepository.findByName(username);
        if (player != null && player.getPassword().equals(password)) {
            return player;
        }
        return null;
    }
    public List<Player> getAllPlayers() {
    return playerRepository.findAll();
}
}
