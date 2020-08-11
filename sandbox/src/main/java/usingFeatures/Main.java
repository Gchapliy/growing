package usingFeatures;

import com.google.gson.Gson;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        /*Gson gson = new Gson();
        TestGson testGson = gson.fromJson("{\"a\":1,\"b\":null,\"c\":3,\"d\":null}", TestGson.class);
        System.out.println(testGson);
        System.out.println(UUID.randomUUID());

        System.out.println(gson.toJson(new ArrayList<>(Arrays.asList("1", "2"))));*/

        System.out.println(new Long(2).equals(new Long(2)));
        System.out.println(new Long(1).equals(new Long(2)));
    }
}
