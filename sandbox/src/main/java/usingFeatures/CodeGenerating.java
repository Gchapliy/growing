package usingFeatures;

import java.util.Base64;
import java.util.Random;
import java.util.UUID;

public class CodeGenerating {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "a");

        Random random = new Random();

        String init = uuid.concat(Long.toString(time)).concat("-");

        int length = init.length();
        for (int i = 0; i < 10; i++) {
            init = init.concat(Integer.toString(random.nextInt(length - 1)));
            if(i < 9)init = init.concat("-");
        }

        System.out.println(retrieveCode(init));

        String encoded = Base64.getEncoder().encodeToString(init.getBytes());
        String decoded = new String(Base64.getDecoder().decode(encoded));

        System.out.println(retrieveCode(decoded));
    }

    private static String retrieveCode(String decoded){
        String positions = decoded.substring(decoded.indexOf("-") + 1);
        int[] positionsNums = new int[10];

        int i = 0;
        for (String s : positions.split("-")){
            positionsNums[i] = Integer.parseInt(s);
            i++;
        }

        String code = "";
        for (int j = 0; j < positionsNums.length; j++) {
            code = code.concat(decoded.substring(positionsNums[j], positionsNums[j] + 1));
        }

        return code;
    }
}
