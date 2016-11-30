/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_Datos;
/**
 *
 * @author Daniel Salinas
 */
public class Stack <T> {
    //atributos
    private nodeClass top;
    private int size;
    
    //constructor
    
   public Stack() {
       this.top = null;
       this.size = 0;
    }
   
    public nodeClass getTop (){ //para mostrar el dato de hasta arriba de la pila
        return top;
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isEmpty(){
        return top == null;
    }
    public void push(T data){ //introduce un dato a la pila
        nodeClass node = new nodeClass(data);
        if (isEmpty()){ //Si la pila esta vacia
            top = node;
        } else { //Si no esta vacia
            node.setNext(top);
            top = node;
        }
        ++ size;
    }
    public void pop(){ //saca el dato de hasta arriba y lo borra
        if(!isEmpty()){
            top = top.getNext();
            -- size;
        } else {
            System.out.println("la pila esta vacia ...");
        }
    }
    public void empty(){ //borrar evidencias
        top = null;
        size = 0;
    }
    public void showStack(){
        if(!isEmpty()){
        nodeClass aux = top;
        do {
            System.out.println(aux.getData());
            System.out.println("|");
            System.out.println("V");
            aux = aux.getNext();
        }while (aux != null);
            System.out.println("");
      }
    }
}
