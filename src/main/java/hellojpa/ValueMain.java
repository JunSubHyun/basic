package hellojpa;

public class ValueMain {

    public static void main(String[] args){

        int a = 10;
        int b = 10;
        

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        Address address1 = new Address("city","street","10000");
        Address address2 = new Address("city","street","10000");

        System.out.println("(address1==address2) = " + (address1==address2));
        //오버라이딩해서 equals 생성후 true, 그 전에는 false
        System.out.println("(address1 equals address2) = " + (address1.equals(address2)));
    }
}
