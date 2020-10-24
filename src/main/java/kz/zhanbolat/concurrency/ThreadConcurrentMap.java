package kz.zhanbolat.concurrency;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ThreadConcurrentMap implements ThreadMap {
    private ConcurrentMap<Integer, Integer> numberMap;

    public ThreadConcurrentMap() {
        numberMap = new ConcurrentHashMap<>();
    }

    public void put(Integer key, Integer value) {
        numberMap.put(key, value);
    }

    public Collection<Integer> values() {
        return numberMap.values();
    }
}
