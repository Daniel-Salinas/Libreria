/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_Datos;

/**
 *
 * @author Daniel Salinas
 * @param <T>
 */
public class doubleLinkList<T> {
//atributos
    
    nodeClassDL first;
    nodeClassDL last;  
//metodos
   /**
    * Este metodo coloca un nodo al inicio
    * @param data es de tipo generico y contine la informacion importante
    */ 
   public void insertFirst(T data){
       nodeClassDL nodo = new nodeClassDL(data);//creacion del nodo
       if(isEmpty()) { //si esta vacia
          this.first=nodo;
          this.last=nodo;
       
       } else {
           //nodo.next = first;
           nodo.setNext(first); //El apuntador "siguiente" de nuestro nodo, apunta al primer nodo de la lista
           //first.prev = nodo; 
           nodo.setPrev(first);//El apuntador "anterior" del primer nodo de la lista apunta al nuevo nodo
           first = nodo;
       }
   
   }
    public nodeClassDL searchNode(T data){
        nodeClassDL aux;
        if(isEmpty()){ //si esta vacia retorna un falso
            return null;
        } else { //si no esta vacia
            aux = first; //colocamos auxiliar al inicio de la lista
            while(aux.data != data && aux != last){ //mientras no encuentre el dato y no llegue al final de la lista
               // aux=aux.next;    
                aux.setNext(aux);   //recorre la lista
            } 
             if (aux == null){
                 return null;
             } else {
                 return aux;
             }
        } 
    }
   public boolean deleteNode (T data){
       nodeClassDL aux = searchNode(data);
       if (aux == null){
           System.out.println("no se encontro el nodo :(");
       } else {
           if(aux == first){
               deleteNodeFirst();
           } else if(aux == last ){
               deleteNodeLast();        
           } else {
               aux.getPrev().setNext(aux.getNext());
             //aux.prev.next = aux.next;
           
             //aux.next.prev = aux.prev;
               aux.getNext().setPrev(aux.getPrev());
           
           }
         
       }
       return true;
   }
   public void deleteNodeFirst(){
       //first = first.next; 
       first.setNext(first); //movemos el apuntador first al siguiente nodo y el previo a este lo ignoramos
       //first.prev = null;
       first.setPrev(null);
   
   }
   public void deleteNodeLast(){
       //last = last.prev; 
       last.setPrev(last);           //movemos el apuntador last al nodo anterior y el que seguia de este lo olvidamos
       //last.next = null;
       last.setNext(null);
   }
   public boolean isEmpty(){
       return first == null && last == null;
           
        }
   public void showList(){
        if(!isEmpty()){ // si la lista no esta vacia
            System.out.print(" <=>");
            nodeClassDL aux; //se usa variable auxiliar
            aux = first; //capturando el valor del primer nodo
            while (aux!= null){ //mientras la auxiliar no llegue al fin de la lista
                System.out.print("["+aux.data+"] <=>"); //se imprime el valor en la posicion actual
                //aux = aux.next; 
                aux.setNext(aux);  //se avanza a la siguiente posicion
            }
            System.out.print(""); //simbolo utilizado para representar el final de la lista
        } else { // si la lista esta vacia
             System.out.println("lamentablemente la lista esta vacia");
        }
        System.out.println("");// esto es para saltar un renglon y que el mensaje "build succesful" no aparezca amontonado con la lista
    }
   } 
