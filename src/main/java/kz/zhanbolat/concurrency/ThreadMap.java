package kz.zhanbolat.concurrency;

import java.util.Collection;

public interface ThreadMap {
    void put(Integer key, Integer value);
    Collection<Integer> values();
}
