package week4_data_structures;

import java.util.LinkedList;

/**
 * LinkedList as a Stack
 */
public class LinkedListStack {

    public static void main(String[] args) {

        LinkedList stack = new LinkedList();

        stack.push(4);
        stack.push(10);
        stack.push(106);

        //What's the top element?
        System.out.println("Top element=" + stack.peek());

        System.out.println(stack.pop()); //remove the top element
        System.out.println(stack.pop()); //remove the top element
        System.out.println(stack.pop()); //remove the top element

        System.out.println(stack.pop()); //what does this do?
    }

}
