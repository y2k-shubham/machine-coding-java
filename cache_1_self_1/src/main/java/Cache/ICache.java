package Cache;

public interface ICache {

    public boolean put(String key, String value);

    public boolean get(String key);

    public boolean clear(String key);

}
