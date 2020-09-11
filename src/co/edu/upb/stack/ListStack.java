package co.edu.upb.stack;

import java.util.Arrays;

public class ListStack implements StackInterface{

    StackNode top;
    int size = 0;

    public ListStack() {
        this.top = null;
    }

    public ListStack(Object o) {
        this.push(o);
    }

    @Override
    public void clear() {
        this.top = null;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public Object peek() {
        return top.getObject();
    }

    @Override
    public Object pop() {
        StackNode oldTop = this.top;
        if(size==1){
            this.top = null;
        }else {
            this.top = this.top.below;
        }
        this.size = this.size-1;
        return oldTop.getObject();
    }

    @Override
    public boolean push(Object object) {
        StackNode newHead = new StackNode(object);
        try {
            if(!isEmpty()){
                newHead.below = this.top;
            }
            this.top = newHead;
            this.size += 1;
            return true;
        }catch (Exception e){
            System.out.println("Error at attempting to push the object");
            return false;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean search(Object object) {
        StackNode node = top;
        for (int i = 0; i < this.size; i++) {
            if(node.getObject().equals(object)){
                return true;
            }
            node = node.below;
        }
        return false;
    }

    @Override
    public void sort() {
        Object[] array =  new Object[this.size];
        StackNode nodo = this.top;
        for (int i = 0; i <this.size ; i++) {
            array[i] = nodo.getObject();
            nodo = nodo.below;
        }
        Arrays.sort(array);

        ListStack pilaOrdenada = new ListStack();
        int cont =0;
        for (int i = array.length-1; i >= 0 ; i--) {
            pilaOrdenada.push(array[cont]);
            cont++;
        }

        this.top = pilaOrdenada.top;

    }

    @Override
    public void reverse() {
        ListStack temp = new ListStack();
        for (int i = 0; i <= this.size+1; i++) {
            temp.push(this.pop());
        }
        this.top = temp.top;
        this.size = temp.size;
    }

    @Override
    public String toString() {
        return "ListStack{" +
                top.toString() +
                ", size=" + size +
                '}';
    }
}