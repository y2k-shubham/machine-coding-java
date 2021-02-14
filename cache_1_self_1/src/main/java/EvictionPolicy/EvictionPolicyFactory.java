package EvictionPolicy;

public class EvictionPolicyFactory {

    public static IEvictionPolicy create(String policyType) {
        IEvictionPolicy policy;

        switch (policyType) {
            case "LRU":
                policy = new LRUEvictionPolicy();
                break;

            default:
                throw new IllegalArgumentException("Uknown eviction policy type: " + policyType);
        }

        return policy;
    }

}
