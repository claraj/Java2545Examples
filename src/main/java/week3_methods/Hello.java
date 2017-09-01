package week3_methods;

/**
Static vs. instance  */

public class Hello {
    
    public static void main(String[] args) {
        sayHello();  // main is static, so can only call other static methods directly.
        //sayHi();   // This line doesn't work
        
        // How to call sayHi() ? We need to make a Hello object,
        // and then can call the sayHi method for this object.
        Hello hello = new Hello();
        hello.sayHi();
    }
    
    // A static method, that belongs to the Hello class
    public static void sayHello() {
        System.out.println("Hello from the hello class!");
    }
    
    // An instance method. Every Hello object has this method.
    // Hello objects are made from the Hello class.
    public void sayHi() {
        System.out.println("Hi from a Hello object!");
    }

}

