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
public class nodeClassDL <T> {
    T data;
    nodeClassDL next;
    nodeClassDL prev;
    public nodeClassDL (T data){
          this.data=data;
          this.next=null;
          this.prev=null;

    }  
    public void setData(T data){
        this.data = data;
    }
    public void setNext(nodeClassDL next){
        this.next=next;
    }
    public void setPrev(nodeClassDL prev){
        this.prev=prev;
    }
    public T getData(){
        return this.data;
    }
    public nodeClassDL getNext(){
        return this.next;
    } 
    public nodeClassDL getPrev(){
        return this.prev;
    }
}