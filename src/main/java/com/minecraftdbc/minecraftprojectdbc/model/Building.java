package com.minecraftdbc.minecraftprojectdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.minecraftdbc.minecraftprojectdbc.model.enums.BuildingType;
import lombok.Data;

@Data
@Table("building")
public class Building {
    @Id
    @Column("idBuilding")
    private Long id;
    
    @Column("buildingName")
    private String name;
    
    @Column("buildingType")
    private BuildingType type;
    
    private String coordinates;
    
    @Column("buildingStatus")
    private String status; // VARCHAR en BD
    
    @Column("id_player")
    private Long idPlayer;
}