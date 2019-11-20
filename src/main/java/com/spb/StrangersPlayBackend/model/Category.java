package com.spb.StrangersPlayBackend.model;

public enum Category {
    PILKA_NOZNA("Piłka nożna","football.png"),
    KRYKIET("Krykiet", "other.png"),
    KOSZYKOWKA("Koszykówka", "basketball.png"),
    HOKEJ("Hokej", "other.png"),
    TENIS_ZIEMNY("Tenis ziemny", "tennis.png"),
    SIATKOWKA("Siatkówka", "volleyball.png"),
    TENIS_STOLOWY("Tenis stołowy", "pingpong.png"),
    BASEBALL("Baseball", "other.png"),
    RUGBY("Rugby", "rugby.png"),
    GOLF("Golf", "other.png"),
    BIEGANIE("Bieganie", "running.png"),
    KOLARSTWO("Kolarstwo", "cycling.png"),
    PILKA_RECZNA("Piłka ręczna", "other.png"),
    SILOWNIA("Siłownia", "gym.png");

    private final String categoryName;
    private final String filename;

    Category(String categoryName, String filename) {
        this.categoryName = categoryName;
        this.filename = filename;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getFilename() {
        return filename;
    }
}
