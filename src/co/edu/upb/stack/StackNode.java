package co.edu.upb.stack;

public class StackNode {

    private Object object;
    public StackNode above;

    public StackNode(){
        this.object = null;
        this.above = null;
    }

    public StackNode(Object object){
        this.object = object;
        this.above = null;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "{" +
                "object=" + object +
                ", next=" + above +
                '}';
    }

}
