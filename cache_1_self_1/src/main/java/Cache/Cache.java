package Cache;

import EvictionPolicy.IEvictionPolicy;
import Storage.IStorage;

public class Cache implements ICache {

    protected IStorage storage;
    private IEvictionPolicy evictionPolicy;

    public Cache(IStorage storage, IEvictionPolicy evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public boolean put(String key, String value) {
        if (this.storage.isFull()) {
            String keyToEvict = this.evictionPolicy.getKeyToEvict();
            this.evictionPolicy.evict(keyToEvict);
            this.storage.clear(keyToEvict);
        }

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
