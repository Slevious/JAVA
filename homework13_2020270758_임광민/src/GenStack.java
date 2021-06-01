public class GenStack<T> {

    private Object[] stack;
    private int top;



    public GenStack(int size){
        stack = new Object[size];
        top = 0;
    }

    public void push(T item){
        stack[top++] = item;
    }

    public T pop() {
        return (T) stack[--top];
    }

    public boolean isEmpty(){
        return (top == 0);
    }

    public boolean isFull() {
        return (top == stack.length); //top과 전체 stack의 길이가 같을 때에 가득 찬 상태로 표현
    }

    public Object[] getStack() {
        return stack;
    }

    public int getTop() {
        return top;
    }

}
