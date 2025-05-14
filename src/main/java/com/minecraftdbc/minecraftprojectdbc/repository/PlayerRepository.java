package com.minecraftdbc.minecraftprojectdbc.repository;

import com.minecraftdbc.minecraftprojectdbc.model.Player;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepository {
    private final JdbcTemplate jdbcTemplate;

    public PlayerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Guardar un jugador (registro)
    public void save(Player player) {
        String sql = "INSERT INTO player (name, level, experience, playerType, password) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                player.getName(),
                player.getLevel(),
                player.getExperience(),
                player.getPlayerType(),
                player.getPassword());
    }

    // Buscar por nombre (login)
    public Player findByName(String name) {
        try {
            String sql = "SELECT * FROM player WHERE name = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Player player = new Player();
                player.setId(rs.getInt("id"));
                player.setName(rs.getString("name"));
                player.setPassword(rs.getString("password"));
                return player;
            }, name);
        } catch (EmptyResultDataAccessException e) {
            return null; // Si no encuentra el jugador
        }
    }

    // Listar todos los jugadores (opcional)
    public List<Player> findAll() {
        String sql = "SELECT * FROM player";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Player player = new Player();
            player.setId(rs.getInt("id"));
            player.setName(rs.getString("name"));
            player.setPassword(rs.getString("password"));
            return player;
        });
    }
}