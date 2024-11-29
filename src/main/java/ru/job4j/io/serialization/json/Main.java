package ru.job4j.io.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.io.serialization.xml.Car;
import ru.job4j.io.serialization.xml.Engine;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JSONObject jsonEngine = new JSONObject("{\"volume\":\"1.6\"}");

        List<String> list = new ArrayList<>();
        list.add("Fil");
        list.add("Karl");
        JSONArray jsonOwners = new JSONArray(list);

        final Car car = new Car(false, 1500.5, new Engine(1.6), new String[]{"Tod"});

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("newCar", car.isNewCar());
        jsonObject.put("price", 2000.0);
        jsonObject.put("engine", jsonEngine);
        jsonObject.put("owners", jsonOwners);

        System.out.println(jsonObject);

        System.out.println(new JSONObject(car));
    }
}
