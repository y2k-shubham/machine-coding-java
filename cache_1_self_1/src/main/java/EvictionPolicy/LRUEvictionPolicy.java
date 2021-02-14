package EvictionPolicy;

import java.util.*;

public class LRUEvictionPolicy implements IEvictionPolicy {

    private Map <String, Long> keyLastAccessedTsMap;
    private TreeMap <Long, Set <String> > lastAccessedTsKeysMap;

    public LRUEvictionPolicy() {
        this.keyLastAccessedTsMap = new HashMap<>();
        this.lastAccessedTsKeysMap = new TreeMap<>();
    }

    @Override
    public void setAccessed(String key) {
        if (this.keyLastAccessedTsMap.containsKey(key)) {
            this.lastAccessedTsKeysMap.get(this.keyLastAccessedTsMap.get(key)).remove(key);
        }

        Long accessTs = System.currentTimeMillis();
        this.keyLastAccessedTsMap.put(key, accessTs);

        Set <String> keySet = this.lastAccessedTsKeysMap.getOrDefault(accessTs, new HashSet<>());
        keySet.add(key);
        this.lastAccessedTsKeysMap.put(accessTs, keySet);
    }

    @Override
    public String getKeyToEvict() {
        Set <String> candidateKeys = this.lastAccessedTsKeysMap.firstEntry().getValue();
        String victimKey = candidateKeys.iterator().next();

        candidateKeys.remove(victimKey);
        this.keyLastAccessedTsMap.remove(victimKey);

        return victimKey;
    }
}
