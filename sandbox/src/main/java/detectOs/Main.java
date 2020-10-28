package detectOs;

import org.apache.commons.lang.SystemUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(SystemUtils.IS_OS_WINDOWS);
        System.out.println(SystemUtils.IS_OS_LINUX);
        System.out.println(SystemUtils.IS_OS_UNIX);
    }
}
