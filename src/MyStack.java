public class MyStack<T> {

    Object [] Stack;
    int StackSize;
    int top;

    public MyStack(int n) {
        StackSize = n;
        Stack = new Object [StackSize];
        top = 0;
    }

    public boolean isEmpty() {
        return(top == 0);
    }

    public boolean isFull() {
        return(top == StackSize);
    }

    /**public void push(String value) {
     if(isFull()) {
     System.out.println("Stack is full");
     return;
     } else {
     Stack[top++] = value;
     }
     }*/

    public void push(T value) {
        if(isFull()) {
            System.out.println("Stack is full");
            return;
        } else {
            Stack[top++] = value;
        }
    }

    /**public int pop() {
     if(isEmpty()) {
     System.out.println("Stack is empty");
     return -999;
     } else {
     return (int)Stack[--top];
     }
     }*/

    public T pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return (T)Stack[--top];
        }
    }

    public void showStack() {
        for (int i = 0; i < top; i++) {
            System.out.print(Stack[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int [] data= {3,5,4,1,7,2,9,8,6,0};


        MyStack stack = new MyStack(10);

        for (int i=0; i<data.length;i++) {
            stack.push(data[i]);
            stack.showStack();
        }

        for (int i=0; i<data.length;i++) {
            stack.pop();
            stack.showStack();
        }

    }

}


