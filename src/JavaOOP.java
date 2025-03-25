import javax.xml.namespace.QName;
import java.util.Scanner;
/*
* object-oriented programming is about creating objects that contain both data and methods.
* OOP helps to keep the Java code DRY "Don't Repeat Yourself
* a class is a template for objects, and an object is an instance of a class.
* - java access modifier-public:can be access by anyone and anywhere.
* default: can only access in the same package
* private: can only access in the declared class
* protected: can access in the same package and subclass
* */
//inheritance
class FatherClass {
    protected String name;//use protect so that subclass  can access but other can not
}
class SonClass extends FatherClass {
    protected String name = "clc";

}
//polymorphism different classes extends the same father class and rewrite the function and attributes.
class DaughterClass extends FatherClass {
    protected String name = "daughter";
}
//inner class and class neat
class OuterClass {
  protected String outer = "outer";
  class InnerClass {
      public void Print() {
          //use inner class to visit outer class.
          System.out.println(outer);
      }
  }
  static class InnerClass2 {
      protected String inner2 = "inner2";
  }
}
//abstraction
abstract class Father {
    abstract void Print();
}
class Son extends Father {
    void Print() {
        System.out.println("son print");
    }
}


public class JavaOOP {
    int j1 = 5;
    final int j2 = 11;
    //private
    private String QName = "keke";

    public String getQName() {
        return QName;
    }

    public void setQName(String QName) {
        this.QName = QName;
    }

    public static void staticMethod() {
        System.out.println("Hello World");
    }
    public void print() {
        System.out.println("Hello World1");
    }
    //constructor-no return value and will be called when create object
    public JavaOOP(){
        j1 = 6;
    }
    public static void main(String[] args) {
        JavaOOP javaOOP = new JavaOOP();
        javaOOP.j1 = 3;
        JavaBasic javaBasic = new JavaBasic();
        staticMethod();//static method can be called diretly
        javaOOP.print();//non-static method can only be called by object
        System.out.print(javaOOP);
        System.out.println("enter your name");

        //scanner:
        Scanner scanner = new Scanner(System.in);
        javaOOP.setQName(scanner.next());
        System.out.println(javaOOP.getQName());

        //inheritance
        SonClass sonClass = new SonClass();
        System.out.println(sonClass.name);

        //inner class and neat class
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        //innerClass2 is static so it can use directly by OuterClass rather than new an object of OuterClass.
        OuterClass.InnerClass2 innerClass2 = new OuterClass.InnerClass2();
        System.out.println(outerClass.outer+" "+innerClass+" "+innerClass2.inner2);

        //abstraction
        Son son = new Son();//abstract class can not use new method
        son.Print();
    }
    /*
    *  we created a static method, which means that it can be accessed without
    * creating an object of the class, unlike public, which can only be accessed by objects:
     * */
}
