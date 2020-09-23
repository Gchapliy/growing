package usingFeatures;

import usingFeatures.extra.A;

public class FinalizeTest {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        a = null;
        System.gc();
    }
}
