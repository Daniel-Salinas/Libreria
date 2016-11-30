/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_Datos;
import java.util.Scanner;

/**
 *
 * @author Daniel Salinas
 */
public class linealListClass <t>{
    private nodeClass first;
    private nodeClass last;
    private nodeClass move;
    private int elements;
    
    public linealListClass(){
        this.first = null;
        this.last = null;
    }
    
    //Metodos
    
    public void insert(t data){
        nodeClass <t> nodo = new nodeClass (data);
        if (isEmpty()){
            this.last = nodo;
            this.first= nodo;
        }else{
            this.last.next = nodo;
            last=nodo;
        }
        this.elements ++;
    }
    
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
        this.elements ++;
        
    }
   
    public int getElements(){
        return this.elements;
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
        this.elements ++;
        
    }
    
    public boolean delete (t data){
        if(!isEmpty()){
            setFirst();
            if (move.data.equals(data)){
                return deleteFirst();
            }else{
                while (!move.next.data.equals(data)){
                    if (move.next!=null){
                    keepMoving();
                    }else{
                        return false;
                    }
                }
                move.next=move.next.next;
                return true;
            }
        }else{
            return false;
        }
    }
    
    public void emptyList(){ //Elimina todos los elementos de la lista
        System.out.print("\033[31mAll the elements will disapear. Are you sure?(Y/N) ");
        Scanner e = new Scanner(System.in);
        String r = e.nextLine();
        if (r.equals("Y") || r.equals("y")){
            this.first=this.last=this.move=null;
            this.elements=0;
            System.out.println("\033[31mDone");
        }
    }
    
    public boolean deleteFirst(){
        if (!isEmpty()){
            this.first=this.first.next;
            return true;
        }else return false;
    }
    
     public boolean deleteLast(){
        if (!isEmpty()){
            setFirst();
            while(!this.move.next.equals(this.last)){
                keepMoving();
            }
            last = this.move;
            last.next = null;
            return true;
        }else return false;
    }
    
    public t fetch(t data){ //Busca un elemento en la lista y lo devuelve
        if(!isEmpty()){
            if (last.data.equals(data)){
                return (t) move.data;
            }else{
                setFirst();
                do{
                    if (!move.data.equals(data)){
                         keepMoving();
                    }else{
                        return (t) move.data;
                    } 
                }while(move != last);
            }
        }
        return null;
    }
    
    public void setFirst(){
        move = this.first;
    }
    
    public boolean isFirst(){
        return move == this.first;
    }
    
    public void setLast(){
        move = this.last;
    }
    
    public boolean isLast (){
        return move == this.last;
    }
    
     public void keepMoving(){
        move = move.next;
    }
     
     public t getMove(){
        return (t) this.move.getData();
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
    
    public boolean isEmpty(){ 
        return first == null; //si el valor de First es nulo entonces la lista esta vacia
    }
    
    @Override
    public String toString(){
        if (!isEmpty()){
            String s="";
            setFirst();
            while(move!=null){
                s += (t) getMove() + "->";
                
                keepMoving();
            }
            return s+="null";
        }
        else return "Lista vacía";
    }
    
}
