package EvictionPolicy;

public interface IEvictionPolicy {

    public void setAccessed(String key);

    public String getKeyToEvict();

}
