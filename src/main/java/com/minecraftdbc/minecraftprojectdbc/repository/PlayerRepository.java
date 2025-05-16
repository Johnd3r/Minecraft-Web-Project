package com.minecraftdbc.minecraftprojectdbc.repository;

import com.minecraftdbc.minecraftprojectdbc.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    Player findByName(String name);
    boolean existsByName(String name);
}