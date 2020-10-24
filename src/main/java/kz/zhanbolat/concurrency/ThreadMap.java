package kz.zhanbolat.concurrency;

import java.util.*;

public class ThreadMap {
    private Map<Integer, Integer> numberMap;

    public ThreadMap() {
        numberMap = new HashMap<>();
    }

    public void put(Integer key, Integer value) {
        numberMap.put(key, value);
    }

    public Integer get(Integer key) {
        return numberMap.get(key);
    }

    public Set<Integer> keys() {
        return numberMap.keySet();
    }

    public Set<Map.Entry<Integer, Integer>> entrySet() {
        return numberMap.entrySet();
    }

    public Collection<Integer> values() {
        return numberMap.values();
    }
}
