package Lists.Stack;

import Lists.model.StackNode;

import java.util.ArrayList;


public class Stack {
    private StackNode top;
    private StackNode bottom;
    private int length;

    public Stack() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    public void push(String newValue) {
        StackNode newNode = new StackNode(newValue);
        if (isEmpty()) {
            this.bottom = newNode;
            this.top = newNode;
        } else {
            StackNode holdingNode = this.top;
            this.top = newNode;
            this.top.setNext(holdingNode);
        }
        this.length++;
    }

    public StackNode pop(){
        if (isEmpty()) {
            return null;
        }
        StackNode holderNode = this.top;
        if (this.top == this.bottom){
            this.bottom = null;
        }
        this.top = this.top.getNext();
        this.length--;
        return holderNode;
    }

    public StackNode peek() {
       return this.top;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", length=" + length +
                '}';
    }
}




