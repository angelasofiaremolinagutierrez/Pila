import co.edu.upb.stack.ListStack;

public class Main {

    public static void main(String[] args) {
        ListStack pruebaPila = new ListStack();
        for (int i = 1; i <6 ; i++) {
            pruebaPila.push(i);
        }
        System.out.println("Antes:");
        System.out.println(pruebaPila.toString());
        System.out.println("Elemento eliminado: "+pruebaPila.pop());
        System.out.println("Elemento eliminado: "+pruebaPila.pop());
        System.out.println("Después:");
        System.out.println(pruebaPila.toString());
    }
}
