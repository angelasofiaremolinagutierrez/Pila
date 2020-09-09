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
        //todo
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public Object peek() {
        //todo GET TOP
        return null;
    }

    @Override
    public Object pop() {
        //todo
        return null;
    }

    @Override
    public boolean push(Object object) {
        StackNode node = new StackNode(object);
        if(!this.isEmpty()){
            this.top.above = node;
        }
        this.top = node;
        this.size += 1;
        return true;
    }

    @Override
    public int size() {
        //todo
        return 0;
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
}
