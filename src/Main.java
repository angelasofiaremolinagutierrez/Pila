import co.edu.upb.stack.ListStack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese una expresión aritmetica (con los simbolos: + para suma, - para resta, * para multiplicación, / para división, ^ para potenciación):");
        String expOriginal = scan.nextLine();
        System.out.println("Aquí está su expresión convertida a una expresión polaca inversa o postfija:");
        String res = evaluarExpresionAritmetica(expOriginal);
        System.out.println(res);
    }

    public static String evaluarExpresionAritmetica(String expOriginal) {
        String expPolaca = "";
        ListStack prioridades = new ListStack();
        ListStack stackOp = new ListStack();
        for (int i = 0; i < expOriginal.length(); i++) {
            String caracter = Character.toString(expOriginal.charAt(i)); //1
            int prioridad = setPrioridad(caracter);

            if (prioridad != -1) { //3. si es un operador

                if (prioridad == 0){ //si es parentesis izquierdo
                    stackOp.push(caracter);
                    prioridades.push(prioridad);
                    continue;
                }

                if (stackOp.isEmpty()) { //3.1
                    stackOp.push(caracter);
                    prioridades.push(prioridad);
                } else { //3.2
                    int prioTop = (int) prioridades.peek();
                    if (prioridad > prioTop) {
                        stackOp.push(caracter);
                        prioridades.push(prioridad);
                        continue;
                    } else {
                        expPolaca += stackOp.pop();
                        prioridades.pop();
                        stackOp.push(caracter);
                        prioridades.push(prioridad);
                    }
                }
            } else if (caracter.equals(")")) { //4
                String topActual = String.valueOf(stackOp.peek());
                while (!topActual.equals("(")){//4.2 si es parentesis izquierdo
                    expPolaca += stackOp.pop(); //4.1
                    prioridades.pop();
                    if(stackOp.isEmpty()){
                        break;
                    }
                    topActual = String.valueOf(stackOp.peek());
                }
                if(!stackOp.isEmpty()){
                    stackOp.pop();
                    prioridades.pop();
                }
            } else {//si es un numero (operando)
                expPolaca += caracter; //2
            }
        }

        for (int i = 0; i < stackOp.size(); i++) {//5
            expPolaca += stackOp.pop();
        }

        return expPolaca;
    }
    public static int setPrioridad(String caracter){
        int prioridad = -1;
        if (caracter.equals("^")) {
            prioridad = 3;
        } else if (caracter.equals("*") || caracter.equals("/")) {
            prioridad = 2;
        } else if (caracter.equals("+") || caracter.equals("-")) {
            prioridad = 1;
        } else if(caracter.equals("(")){
            prioridad = 0;
        }
        return prioridad;
    }
}