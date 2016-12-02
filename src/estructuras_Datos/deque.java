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
public class deque <T> {
  private nodeClassDL first;
    private nodeClassDL last;
    private int size;
    

    public deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }    
    
    public Object getfirst() {
        return first.getData();
    }    
    public Object getlast(){
        return last.getData();
    }  
    public int getsize(){
        return size;
    }
    public void setfirst(nodeClassDL first) {
        this.first = first;
    }
    public void setlast(nodeClassDL last) {
        this.last = last;
    }
    public void setsize(int size) {
        this.size = size;
    }
    public void insertfirst(T data){        
        nodeClassDL node = new nodeClassDL (data); 
        if (isempty()) { 
            this.first = node;
            this.last = node;
            ++size;
        } else { 
            node.setNext(first); 
            first.setPrev(node); 
            first = node; 
            ++size;
        } 
    }
    
    
    public void insertlast(T data){        
        nodeClassDL node = new nodeClassDL (data); 
        
        if (isempty()) { 
            this.first = node;
            this.last = node;
            ++size;
        } else {
            node.setPrev(last); 
            last.setNext(node); 
            last = node; 
            ++size;
        } 
    }
    /**
     * Método para mostrar la lista.
     */
    public void showlist () {
        if (!isempty()) { 
            nodeClassDL aux; 
            aux = first; 
            System.out.print("=>"); 
            while(aux != null){ 
                System.out.print("[" + aux.getData() + "]=>");
                   
                aux = aux.getNext();
                    
            } 
            System.out.println(); 
        } else { 
            System.out.println("la lista esta vacia"); 
        } 
    }    
    public void deletefirst(){        
        first = first.getNext();
        first.setPrev(null); 
        --size; 
    }    
    public void deletelast(){                
        last = last.getPrev();
            
        last.setNext(null);
        --size; 
    }    
      
    public boolean isempty(){
        return first == null && last == null && size == 0;
    }    
    public void elist(){
        first = null;
        last = null;
        size = 0;
    }  
}
