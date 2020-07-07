package usingFeatures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestGson {
    @SerializedName("a")
    @Expose
    private Integer a;
    @SerializedName("b")
    @Expose
    private int b;
    @SerializedName("c")
    @Expose
    private Integer c;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "TestGson{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
