package com.example;

import java.util.List;

public class LionAlex extends Lion  {

    private static final String sex = "Самец";

    public LionAlex(Feline feline) throws Exception {
        super(sex, feline);
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
