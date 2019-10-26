package com.spb.StrangersPlayBackend.model;

public enum Category {
    PILKA_NOZNA("Piłka nożna"),
    KRYKIET("Krykiet"),
    KOSZYKOWKA("Koszykówka"),
    HOKEJ("Hokej"),
    TENIS_ZIEMNY("Tenis ziemny"),
    SIATKOWKA("Siatkówka"),
    TENIS_STOLOWY("Tenis stołowy"),
    BASEBALL("Baseball"),
    RUGBY("Rugby"),
    GOLF("Golf"),
    BIEGANIE("Bieganie"),
    KOLARSTWO("Kolarstwo"),
    PILKA_RECZNA("Piłka ręczna");

    private final String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
