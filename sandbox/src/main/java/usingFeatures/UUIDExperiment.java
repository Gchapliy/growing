package usingFeatures;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UUIDExperiment {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 10000000; i++) {
            set.add(UUID.randomUUID().toString());
        }

        System.out.println(set.size()); // all absolutely unic
    }
}
