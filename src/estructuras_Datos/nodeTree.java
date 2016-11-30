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
public class nodeTree {
    int data;
    nodeTree left;
    nodeTree right;
    
    public nodeTree(int data){
        this.data = data;
    }
    
    public nodeTree(int data, nodeTree left, nodeTree right){
        this.data = data;
        this.left = null;
        this.right = null;
    
    }
}
