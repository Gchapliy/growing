package someTasks.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionDoings {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException {
        ClassForReflectionDoing classForReflectionDoing = ClassForReflectionDoing.builder()
                .field1("The best string!")
                .justInt(1)
                .doubleAlsoHere(2.2)
                .didYouForgetMe(100l)
                .build();

        ClassForReflectionDoing classForReflectionDoing1 = ClassForReflectionDoing.builder()
                .field1("The best string!")
                .justInt(2)
                .doubleAlsoHere(2.2)
                .didYouForgetMe(200l)
                .build();

        Field[] fields = classForReflectionDoing.getClass().getDeclaredFields();
        Field[] fields2 = classForReflectionDoing1.getClass().getDeclaredFields();

        Field field = fields[0];
        field.setAccessible(true);
        System.out.println("fieldName = " + field.getName());
        System.out.println(field.get(classForReflectionDoing));
    }
}
