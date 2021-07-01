package com.deepak.common.enums;

import java.util.Arrays;

public enum GroupSpecification {

    BRAND("brand"), COLOR("color"), CATEGORY("category");

    private String value;

    GroupSpecification(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static GroupSpecification getValue(String value) {
        return Arrays.stream(GroupSpecification.values())
                .filter(v -> v.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}
