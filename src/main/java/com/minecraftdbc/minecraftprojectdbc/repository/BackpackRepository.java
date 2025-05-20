package com.minecraftdbc.minecraftprojectdbc.repository;

import com.minecraftdbc.minecraftprojectdbc.model.Backpack;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BackpackRepository extends CrudRepository<Backpack, Long> {
    List<Backpack> findByidPlayer(Long idPlayer); // Query derivada
}