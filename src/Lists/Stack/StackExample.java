package Lists.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack stackList = new Stack();
        stackList.push("google");
        stackList.push("udemy");
        stackList.push("discord");

        System.out.println(stackList.pop());
        System.out.println(stackList.pop());
        System.out.println(stackList.pop());

        System.out.println(stackList.peek());
        System.out.println(stackList);

    }
}
