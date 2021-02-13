package Storage;

public interface IStorage {

    public boolean put(String key, String value);

    public String get(String key);

    public boolean clear(String key);

    public boolean isFull();

}
