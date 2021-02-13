package Storage;

public interface IStorage {

    /**
     * Adds a key-value pair in storage
     * @param key
     * @param value
     * @return true if the key was already present in storage
     */
    public boolean put(String key, String value);

    public String get(String key);

    /**
     * Unsets the given key
     * @param key
     * @return true if key was present (and subsequently unset)
     */
    public boolean clear(String key);

    public boolean isFull();

}
