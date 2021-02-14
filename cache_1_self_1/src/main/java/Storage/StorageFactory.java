package Storage;

public class StorageFactory {

    public static IStorage create(String storageType, int capacity) {
        IStorage storage;

        switch (storageType) {
            case "HashMapStorage":
                storage = new HashMapStorage(capacity);
                break;

            default:
                throw new IllegalArgumentException("Unknown storage type: " + storageType);
        }

        return storage;
    }

}
