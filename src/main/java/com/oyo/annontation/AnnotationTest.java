package com.oyo.annontation;

@TestClass()
public class AnnotationTest {

    @TestMethod("1")
    public void test1() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        TestClass t = AnnotationTest.class.getAnnotation(TestClass.class);
        System.out.println(t.value());

        TestMethod testMethod = AnnotationTest.class.getDeclaredMethod("test1").getAnnotation(TestMethod.class);

        System.out.println(testMethod.value());
    }
}
