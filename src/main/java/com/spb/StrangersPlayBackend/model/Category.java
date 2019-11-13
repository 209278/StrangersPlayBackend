package com.spb.StrangersPlayBackend.model;

public enum Category {
    PILKA_NOZNA("Piłka nożna","categoryImages/football.png"),
    KRYKIET("Krykiet", "categoryImages/other.png"),
    KOSZYKOWKA("Koszykówka", "categoryImages/basketball.png"),
    HOKEJ("Hokej", "categoryImages/other.png"),
    TENIS_ZIEMNY("Tenis ziemny", "categoryImages/tennis.png"),
    SIATKOWKA("Siatkówka", "categoryImages/volleyball.png"),
    TENIS_STOLOWY("Tenis stołowy", "categoryImages/pingpong.png"),
    BASEBALL("Baseball", "categoryImages/other.png"),
    RUGBY("Rugby", "categoryImages/rugby.png"),
    GOLF("Golf", "categoryImages/other.png"),
    BIEGANIE("Bieganie", "categoryImages/running.png"),
    KOLARSTWO("Kolarstwo", "categoryImages/cycling.png"),
    PILKA_RECZNA("Piłka ręczna", "categoryImages/other.png"),
    SILOWNIA("Siłownia", "categoryImages/gym.png");

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
