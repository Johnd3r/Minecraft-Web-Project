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
    @Column("id_player")
    private Long idPlayer;

    private String name;

    private String password;

    @Column("level")
    private String level = "0";

    private Float experience = 0f;

    @Column("playerType")
    private PlayerType playerType;
}
