/**
 * Created by Wo Chio Lao on 10/09/2016
 */
package com.recipe.rest.common.enums;

import lombok.Getter;

public enum StatusEnum {

    DELETED(0, "Deleted"),
    ACTIVE(1, "Active"),
    DEACTIVATED(2, "Deactivated");

    @Getter
    private int id;

    @Getter
    private final String name;

    StatusEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
