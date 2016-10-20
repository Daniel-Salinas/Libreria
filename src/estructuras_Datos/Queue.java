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
public class Queue <T> {
    //Atributos
    private nodeClass first;
    private nodeClass last;
    int size;
    
    //Constructor
    public Queue(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    public Queue(T data){
        insertLast(data);
    }
    // Metodos
    
    public void insertLast(T data){
        nodeClass node = new nodeClass(data);
        if(isEmpty()){
            this.first = node;
            this.last = node;
            ++this.size;
        } else {
            
            node.setNext(last);
            last = node;
        } 
        ++this.size;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void deleteFirst(){
        nodeClass temp;
        if(!isEmpty()){
            temp = last;
            while(temp.getNext() != first) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            first = temp;
            --this.size;
        }
    }
    
    public void setEmpty(){
        this.first = null;
        this.last = null;
        this.size=0;
    }
     public Object getFirst(){
        return first.getData();
    } 
    
    public int getSize() {
        return size;
    }
    
}
