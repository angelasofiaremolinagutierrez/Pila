package co.edu.upb.stack;

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
        this.top = this.top.below;
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
        //todo
        return false;
    }

    @Override
    public void sort() {
        //todo
    }

    @Override
    public void reverse() {
        //todo
    }

    @Override
    public String toString() {
        return "ListStack{" +
                top.toString() +
                ", size=" + size +
                '}';
    }
}