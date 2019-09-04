package demo;


import java.util.Arrays;
import java.util.List;

public class AJavaClass {
    public void aJavaMethod() {
        System.out.println("这是一个Java方法");
    }

    public List<Integer> getJavaList() {
        return Arrays.asList(1, 0, 2, 4);
    }

    public void printList(List<Integer> list) {
        System.out.println("数组中包含元素:");
        list.forEach(System.out::println);
    }
}
