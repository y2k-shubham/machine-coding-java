package EvictionPolicy;

public interface IEvictionPolicy {

    public String getKeyToEvict();

    public void setAccessed(String key);

}
