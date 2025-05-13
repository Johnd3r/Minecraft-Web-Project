package com.minecraftdbc.minecraftprojectdbc.repository;

import com.minecraftdbc.minecraftprojectdbc.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public void save(Player player) {
        String sql = "INSERT INTO player (username, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, player.getName(), player.getPassword());
    }

    public Player findByUsername(String username) {
        String sql = "SELECT * FROM player WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, (rs, rowNum) -> {
            Player player = new Player();
            player.setId(rs.getInt("id"));
            player.setName(rs.getString("Name"));
            player.setPassword(rs.getString("password"));
            return player;
        });
    }
}

