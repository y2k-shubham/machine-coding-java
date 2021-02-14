package Storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage implements IStorage {

    private int capacity;
    private Map <String, String> hashMap;

    public HashMapStorage(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>(capacity);
    }

    @Override
    public boolean put(String key, String value) {
        return this.hashMap.put(key, value) != null;
    }

    @Override
    public String get(String key) {
        return this.hashMap.get(key);
    }

    @Override
    public boolean clear(String key) {
        return this.hashMap.remove(key) != null;
    }

    @Override
    public boolean isFull() {
        return this.hashMap.size() == this.capacity;
    }
}
