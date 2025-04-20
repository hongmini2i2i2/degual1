public class MyStack1<T> {

    MyArrayList2<T> stack;

    public MyStack1() {
        stack = new MyArrayList2<>();
    }

    public void push(T value) {
        stack.add(value);
    }

    public T pop() {
        return stack.remove(stack.size() -1);
    }

    public T peek() {
        return stack.get(stack.size() -1);
    }

    public void showStack() {
        stack.showList();
    }

    public static void main(String[] args) {
        int [] data= {3,5,4,1,7,2,9,8,6,0};


        MyStack1 stack = new MyStack1();

        for (int i=0; i<data.length;i++) {
            stack.push(data[i]);
            stack.showStack();
        }

        for (int i=0; i<data.length;i++) {
            stack.pop();
            stack.showStack();
        }

        MyStack1<String> stack2 = new MyStack1<>();

        stack2.push("AAA");
        stack2.push("AAA");
        stack2.showStack();

    }

}


