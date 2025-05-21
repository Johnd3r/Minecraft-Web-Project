/* package com.minecraftdbc.minecraftprojectdbc.service;

import com.minecraftdbc.minecraftprojectdbc.model.Backpack;
import com.minecraftdbc.minecraftprojectdbc.repository.BackpackRepository;
import org.springframework.stereotype.Service;

@Service
public class BackpackService {
    private final BackpackRepository repository;

    public BackpackService(BackpackRepository repository) {
        this.repository = repository;
    }

    public Backpack getPlayerBackpack(Long playerId) {
        return repository.findByIdPlayer(playerId);
    }
} {
    
}
 */