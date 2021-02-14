package Cache;

import EvictionPolicy.EvictionPolicyFactory;
import EvictionPolicy.IEvictionPolicy;
import Storage.IStorage;
import Storage.StorageFactory;

public class CacheFactory {

    public static ICache create(int capacity, String storageType, String evictionPolicyType) {
        IEvictionPolicy evictionPolicy = EvictionPolicyFactory.create(evictionPolicyType);
        IStorage storage = StorageFactory.create(storageType, capacity);

        ICache cache = new Cache(storage, evictionPolicy);

        return cache;
    }

}
