package Cache;

import EvictionPolicy.IEvictionPolicy;
import Storage.IStorage;

public abstract class AbstractCache implements ICache {

    private int capacity;
    protected IStorage storage;
    private IEvictionPolicy evictionPolicy;

    public AbstractCache(int capacity, IEvictionPolicy evictionPolicy) {
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public boolean put(String key, String value) {
        this.evictionPolicy.setAccessed(key);
        return this.storage.put(key, value);
    }

    @Override
    public String get(String key) {
        this.evictionPolicy.setAccessed(key);
        return this.storage.get(key);
    }

    @Override
    public boolean clear(String key) {
        return this.evictionPolicy.evict(key) && this.storage.clear(key);
    }

}
