package com.minecraftdbc.minecraftprojectdbc.repository;

import com.minecraftdbc.minecraftprojectdbc.model.BackpackMaterial;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BackpackMaterialRepository extends CrudRepository<BackpackMaterial, Long> {
    List<BackpackMaterial> findByIdBackpack(Long backpackId);
    List<BackpackMaterial> findByIdMaterial(Long materialId);
}