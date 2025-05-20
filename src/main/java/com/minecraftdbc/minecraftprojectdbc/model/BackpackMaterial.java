package com.minecraftdbc.minecraftprojectdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
@Table("backpack_material")

public class BackpackMaterial {
    @Id
    @Column("id_backpack_material")
    private Long idBackpackMaterial;

    @Column("idBackpack")
    private Long idBackpack;

    @Column("idMaterial")
    private Long idMaterial;

}
