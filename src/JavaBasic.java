
import java.util.stream.Stream;
public class JavaBasic {
    //method overloading
    public static int myPrint(int x,int y) {
        return x+y;
    }
    public static float myPrint(float x,float y) {
        return x+y;
    }
    //java recursion
    public static  int myRecursion(int x){
        if(x==10)return x;
        else{
            return x+myRecursion(x+1);
        }
    }
    public static int x = 10;
    public static void main(String[] args) {
        //data type
        float f = 1.2f;
        byte n = 100;
        short s  = 100;
        long myNum = 15000000000L;
        float f1 = 35e3f;
        double d1 = 12E4d;
        Stream.iterate(1, i -> i + 1)
                .limit(10)
                .forEach(System.out::println);
        System.out.println("hello"+f+n+s+myNum+f1+d1);

        //narrow data type casting
        double d2 = 9.01;
        int i2 = (int) d2;
        System.out.println(i2+d2);

        //arithmetic operators
        int i3 = 10,i4 = 3;
        i4 = i4<<3;
        System.out.println(i4);//print out 3

        //java strings
        String string = "hello";
        int l = string.length();
        String s1  = string+"world";//use + to combine string
        String s2  = string.concat("hello");//string.concat("")
        String s3  = "hello \"world\" \'hello\' \\hello";//hello "world" 'hello' \hello
        System.out.println(s3);

        //Math
        Math.max(1,2);
        Math.min(2,3);
        Math.sqrt(9);

        //array
        int[] num = {1,2,3};
        System.out.println(num.length);

        //for each
        for(int i:num){
            System.out.println(i);
        }

        //mulitdimensional array
        int[][] num1 ={{1,2},{3,4}};
        for(int[] i:num1){
            for(int j:i){
                System.out.println(j);
            }
        }

        myPrint(1,2);
        myPrint(1.1f,2.2f);

        //java scope In Java, variables are only accessible inside the region they are created.
        // This is called scope.

        //java recursion - a way to break complicate problems into simple items
        System.out.println(myRecursion(1));


    }
}