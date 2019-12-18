package com.epam.strings.text.entity.impl;

public class UnitLeaf extends MarkLeaf {

    private TypeUnitLeaf type;

    public UnitLeaf(TypeUnitLeaf type, String value) {
        super(value);
        this.type = type;
    }

    public TypeUnitLeaf getType() {
        return type;
    }

    public void setType(TypeUnitLeaf type) {
        this.type = type;
    }
}
