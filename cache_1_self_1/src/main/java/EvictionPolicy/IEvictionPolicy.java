package EvictionPolicy;

public interface IEvictionPolicy {

    public void setAccessed(String key);

    public String getKeyToEvict();

    public boolean evict(String key);

}
