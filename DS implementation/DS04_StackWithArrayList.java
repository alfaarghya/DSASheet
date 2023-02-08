import java.util.ArrayList;

class StackWithArrayList{
    ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public void push(int data){
        list.add(data);
    }

    public int pop(){
        int top = list.get(list.size()-1);
        list.remove(list.size()-1);
        return top;
    }

    public int peek(){
        return list.get(list.size()-1);
    }

    public void print(){
        while(!isEmpty()){
            System.out.println(peek());
            pop();
        }
    }

}

public class DS04_StackWithArrayList {
    public static void main(String[] args) {
        StackWithArrayList stk = new StackWithArrayList();
        stk.push(0);
        stk.push(1);
        stk.push(2);

        while(!stk.isEmpty()){
            System.out.println(stk.peek());
            stk.pop();
        }
        
        System.out.println("--------------------");
        stk.push(3);
        stk.push(4);
        stk.push(5);
        while(!stk.isEmpty()){
            System.out.println(stk.peek());
            stk.pop();
        }
    }
}
