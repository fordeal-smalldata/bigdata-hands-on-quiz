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

    static int maxEmployeeId = 9999;

    public static void sendRedPack(int currentEmployeeId, int price) {
        int recipientId = (currentEmployeeId + 1) % (maxEmployeeId + 1);
        System.out.println("员工 " + currentEmployeeId + "发利是给员工" + recipientId + " " + price + " 元");
        if (currentEmployeeId > 0) sendRedPack(currentEmployeeId - 1, price + 1);
    }

    public static void main(String[] args) {
        sendRedPack(maxEmployeeId, maxEmployeeId);
    }
    //员工 9999发利是给员工0 9999 元
    //员工 9998发利是给员工9999 10000 元
    //员工 9997发利是给员工9998 10001 元
    //员工 9996发利是给员工9997 10002 元
    //员工 9995发利是给员工9996 10003 元
    // .....
    //Exception in thread "main" java.lang.StackOverflowError
    //	at demo.AJavaClass.sendRedPack(AJavaClass.java:26)

}
