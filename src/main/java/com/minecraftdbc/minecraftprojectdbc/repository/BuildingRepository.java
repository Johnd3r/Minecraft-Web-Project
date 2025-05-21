package com.minecraftdbc.minecraftprojectdbc.repository;

import com.minecraftdbc.minecraftprojectdbc.model.Building;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BuildingRepository extends CrudRepository<Building, Long> {
    List<Building> findByIdPlayer(Long playerId);
}