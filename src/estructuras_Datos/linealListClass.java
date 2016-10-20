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
public class linealListClass <t>{
    private nodeClass first;
    private nodeClass last;
    
    //Metodos
    public void insertFirst(t n){
        nodeClass node = new nodeClass(n);
        if(isEmpty()){ //Si esta vacia
            first = node; //el primer nodo es tambien el ultimo
            last = node;
        } else {    //Si no esta vacia
            //node.next=first; 
            node.setNext(first);  //El nodo que recien agregamos se va a volver el nuevo primer nodo
            first=node; 
        
        }
        
    }
    public void insertLast(t n){
         //se crea un nuevo nodo
        if(isEmpty()){ // si esta vacia se ejecuta similar al insertFirst en este mismo caso
            insertFirst(n);
        } else {  //si no esta vacia
            nodeClass node = new nodeClass(n);
            //last.next = node;  
            last.setNext(node);  //el apuntador Last se mueve hacia el siguiente nodo
            last = node;   // de esta manera el nuevo nodo se volvera el ultimo de la lista
        }
        
    }
    public void DeleteFirst(){
        if(!isEmpty()){ //Si no esta vacia la lista
            first = first.next; //el segundo nodo se volvera el primero
        }
    }
    public void DeleteLast(){
        if(!isEmpty()){ //si la lista no esta vacia
            if (first == last){ //si la lista solo tiene un elemento
                DeleteFirst(); // se ejecuta el metodo DeleteFirst
            } else { //tenemos que determinar cual es el nodo antes del ultimo
                
                nodeClass current = first; //variable para determinar el nodo "actual"
                //while(current.next != last){ //mientras el nodo actual no sea el ultimo
                while(current.getNext() != last){
                    //current = current.next; 
                    current.setNext(current);    // se "avanza" una posicion en la lista
                } 
                last = current; //el penutlimo nodo se convierte en el ultimo
            }
        }
    }
    public void showList(){
        if(!isEmpty()){ // si la lista no esta vacia
            nodeClass aux; //se usa variable auxiliar
            aux = first; //capturando el valor del primer nodo
            while (aux!= null){ //mientras la auxiliar no llegue al fin de la lista
                //System.out.print("["+aux.data+"]"); 
                  System.out.print("["+aux.getData()+"]");  //se imprime el valor en la posicion actual
                //aux = aux.next; 
                 aux.setNext(aux);   //se avanza a la siguiente posicion
            
            }
            System.out.print(""); //simbolo utilizado para representar el final de la lista
        } else { // si la lista esta vacia
             System.out.println("lamentablemente la lista esta vacia");
        }
        System.out.println("");// esto es para saltar un renglon y que el mensaje "build succesful" no aparezca amontonado con la lista
    }
    
    private boolean isEmpty(){ 
        return first == null; //si el valor de First es nulo entonces la lista esta vacia
    }
    
}
