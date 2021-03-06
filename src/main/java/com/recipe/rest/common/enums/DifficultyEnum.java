/**
 * Created by Wo Chio Lao on 10/09/2016
 */
package com.recipe.rest.common.enums;

import lombok.Getter;

public enum DifficultyEnum {

    SUPER_EASY(1, "Super easy"),
    EASY(2, "Easy"),
    MEDIOCRE(3, "Mediocre"),
    HARD(4, "Hard"),
    SUPER_HARD(5, "Super hard");

    @Getter
    private int id;

    @Getter
    private final String name;

    DifficultyEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
