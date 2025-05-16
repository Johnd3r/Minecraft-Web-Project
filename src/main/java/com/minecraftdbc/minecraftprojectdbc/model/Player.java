package com.minecraftdbc.minecraftprojectdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column; // Agregado
import com.minecraftdbc.minecraftprojectdbc.model.enums.PlayerType;
import lombok.Data;

@Data
@Table("player")
public class Player {
    @Id
    private Long idPlayer;
    private String name;
    private String password;
    private String level;
    private float experience;

    @Column("playerType")
    private PlayerType playerType;
}