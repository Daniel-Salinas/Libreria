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
public class AVLTree {
    //Atributos
    private AVLNode root;
    
    //Constructor
    public AVLTree(){
        this.root = null;
    }
    
    //metodos
    public AVLNode fetch (int d, AVLNode r){
        if(root == null){ //si esta vacio
            return null;
        } else if(root.data == d){ //si el dato esta en la raiz
            return root;
        } else if(root.data < d){ //si el dato es mayor a la raiz
            return fetch(d,r.right);//lo buscamos por la derecha
        } else {
            return fetch(d,r.left); //si el dato es menor a la raiz, buscamos por la izquierda
            }
        }
    
    public int getBF(AVLNode node){
        if(node == null){
            return -1;
        } else {
            return node.bf;
        }
    }
    
    public int calcBF(AVLNode node){ //calcular factor de balance 
        return Math.max(getBF(node.left), getBF(node.right))+1;
        
    }
    
    public AVLNode rightRotation(AVLNode r){ //rotacion a la izquierda
        AVLNode aux = r.left; //se crea un auxiliar que apunte a la izquierda de la raiz
        r.left = aux.right;
        aux.right = r;
        r.bf = calcBF(r);
        aux.bf = calcBF(aux);
        return aux;
    }
    
    public AVLNode leftRotation(AVLNode r){ //rotacion a la derecha
        AVLNode aux = r.right; //auxiliar que apunte al derecho de la raiz
        r.right = aux.left; 
        aux.left = r;
        r.bf = calcBF(r);
        aux.bf = calcBF(aux);
        return aux;
    }
    
    public AVLNode dRightRotation(AVLNode r){ //rotacion doble a la izquierda
        AVLNode aux;
        r.left = rightRotation(r.left);
        aux = leftRotation(r);
        return aux;
    }
    
    public AVLNode dLeftRotation(AVLNode r){ //rotacion doble a la derecha
        AVLNode aux;
        r.left = leftRotation(r.right); 
        aux = rightRotation(r);
        return aux; 
    }
    
   public AVLNode insertAVL(AVLNode n, AVLNode sr){
       AVLNode newDAD = sr;
       if(n.data < sr.data){
           if(sr.left == null){
               sr.left = n;
           } else {
               sr.left=insertAVL(n,sr.left);
               if((getBF(sr.left) - getBF(sr.right)) == 2){
                    if(n.data < sr.left.data){
                        newDAD = leftRotation(sr);
                    } else {
                        newDAD = dLeftRotation(sr);
                    }
                }
            }        
       } else if(n.data > sr.data) {
           if(sr.right == null){
               sr.right = n;
           } else {
               sr.right = insertAVL(n,sr.right);
               if((getBF(sr.right) - getBF(sr.left)) == 2){
                   if(n.data > sr.right.data){
                       newDAD = rightRotation(sr);
                   } else {
                       newDAD = dRightRotation(sr);
                   }
               }
           }
       } else {
           System.out.println("El nodo esta duplicado");
       }
       //Actualizar el BF
       if(sr.left == null && sr.right != null){
           sr.bf = sr.right.bf +1;
       } else if(sr.right == null && sr.left != null){
            sr.bf = sr.left.bf +1;
       }
       return null;
   }
    
}
