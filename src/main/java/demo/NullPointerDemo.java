package demo;

public class NullPointerDemo {
    public static String head_by_space(String str) {
        return str.split(" ")[0];
    }

    public static void main(String[] args) {
        //IDE会给一个Weak Warning
        //Passing 'null' argument to parameter annotated as @NotNull
        //但是在业务代码的海洋里遨游的您容易熟若无睹
        //编译器成功编译通过,也没有给出警告
        System.out.println(NullPointerDemo.head_by_space(null));
    }
}
