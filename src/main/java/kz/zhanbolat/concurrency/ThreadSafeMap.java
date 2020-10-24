package kz.zhanbolat.concurrency;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreadSafeMap implements ThreadMap {
    private Map<Integer, Integer> numbersMap;

    public ThreadSafeMap() {
        numbersMap = Collections.synchronizedMap(new HashMap<>());
    }

    public synchronized void put(Integer key, Integer value) {
        numbersMap.put(key, value);
    }

    public Collection<Integer> values() {
        return numbersMap.values();
    }
}
