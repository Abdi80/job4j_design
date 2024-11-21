package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Apartment apartment = new Apartment(100, "Well House",
                new String[] {"Kitchen", "Living room", "Hall"}, new Contact("Ann", "+7 777"),
                false);
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(apartment));

        final String apartmentTwo =
                "{"
                    + "\"square\":150,"
                    + "\"houseName\":\"Good House\","
                    + "\"rooms\":[\"Hall\",\"Kitchen\",\"Laundry\",\"Living room\"],"
                    + "\"contact\":{\"name\":\"Mike\",\"phone\":\"+7 999\"},"
                    + "\"finished\":true"
                + "}";

        final Apartment apartmentMod = gson.fromJson(apartmentTwo, Apartment.class);
        System.out.println(apartmentMod);
    }
}
