package ru.job4j.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {

        Map<Integer, String> previousMap = new HashMap<>(previous.size());
        Set<Integer> currentSet = new HashSet<>(current.size());
        int added = 0;
        int changed = 0;
        int deleted = 0;

        for (User user : previous) {
            previousMap.put(user.getId(), user.getName());
        }

        for (User user : current) {
            currentSet.add(user.getId());
        }

        for (User user : current) {
            if (!previousMap.containsKey(user.getId())) {
                ++added;
            }
            if (previousMap.containsKey(user.getId())
                    && !previousMap.get(user.getId()).equals(user.getName())) {
                ++changed;
            }
        }

        for (User user : previous) {
            if (!currentSet.contains(user.getId())) {
                ++deleted;
            }
        }

        return new Info(added, changed, deleted);
    }
}
