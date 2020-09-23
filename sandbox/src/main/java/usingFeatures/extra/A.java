package usingFeatures.extra;

public class A{
    @Override
    protected void finalize() throws Throwable {

        System.out.println("i am in finalize");

    }
}
