//jvm类加载顺序

//父类的静态变量(代码块)==>子类的静态变量(代码块)==>父类的非静态变量==>父类的构造器==>子类的非静态变量==>子类的构造器
//其中:   静态变量随着类的加载而加载,只加载一次
//非静态变量和构造器  可以多次加载
public class StaticInitialization {
    public static void main(String[] args) {    // 第三执行
        System.out.println("main()");   // 18
        cupboard.otherMethod(1);
    }
    static Table table = new Table();   // 第一执行
    static Cupboard cupboard = new Cupboard();  // 第二执行
}


class Bowl {
    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }
}

class Tableware {
    static Bowl bowl7 = new Bowl(7);    // 1            父类的静态变量
    static {
        System.out.println("Tableware静态代码块");   // 2        父类的静态变量
    }

    Tableware() {
        System.out.println("Tableware构造方法");    // 7、15     父类构造器
    }

    Bowl bowl6 = new Bowl(6);   // 6、14         父类的非静态变量
}

class Table extends Tableware {
    {
        System.out.println("Table非静态代码块_1");    // 8        子类的非静态变量
    }
    Bowl bowl5 = new Bowl(5);   // 9        子类的非静态变量
    {
        System.out.println("Table非静态代码块_2");    // 10       子类的非静态变量
    }
    static Bowl bowl1 = new Bowl(1);    // 3        子类的静态变量
    static {
        System.out.println("Table静态代码块");   // 4        子类的静态变量
    }

    Table() {
        System.out.println("Table构造方法");    // 11       子类构造器       完成Table类的加载
    }

    static Bowl bowl2 = new Bowl(2);    // 5        子类的静态变量
}

class Cupboard extends Tableware {
    Bowl bowl3 = new Bowl(3);   // 16       子类的非静态变量
    static Bowl bowl4 = new Bowl(4);    // 12        静态变量

    Cupboard() {
        System.out.println("Cupboard构造方法"); // 17       子类的构造器
    }

    void otherMethod(int marker) {
        System.out.println("otherMethod(" + marker + ")");  // 19
    }

    static Bowl bowl5 = new Bowl(5);    // 13   静态变量
}