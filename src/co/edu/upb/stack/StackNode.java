package co.edu.upb.stack;

public class StackNode implements Comparable<StackNode>{

    private Object object;
    public StackNode below;

    public StackNode(){
        this.object = null;
        this.below = null;
    }

    public StackNode(Object object){
        this.object = object;
        this.below = null;
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
                ", below=" + below +
                '}';
    }

    @Override
    public int compareTo(StackNode n1) {
        return (this.getObject().toString()).compareTo(n1.getObject().toString());
    }
}
