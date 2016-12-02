package estructuras_Datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Salinas
 */
public class binaryTree { //atributos
    nodeTree root;
    int height;
    int elements;
    
    //constructor
    public binaryTree(){
      this.root = null;  
      this.height = -1;
      this.elements = 0;
    }
    
    //metodos
    public boolean isEmpty(){
        return this.root == null && root.right == null;
    }
    
    public void insert(int data, nodeTree root) {
        nodeTree node = new nodeTree(data);
        if(isEmpty()){ //Si esta vacio
            this.root = node; // el primer elemento sera la raiz del arbol
            this.height ++;
       } else { //Si no esta vacio
            if(this.root.data <= node.data){ //si el nodo es mayor que la raiz
                if(root.left == null){ // si la izquierda de la raiz es nula
                    root.left = node; // se coloca ahi el nodo
                } else { // si la izquierda no esta vacia
                    insert(data, root.left); // buscara por la izquierda hasta encontrar un espacio
                }
            } else { // si el nodo no es mayor que la raiz
                if(root.right == null){ // si la derecha esta vacia
                    root.right = node;
                } else { // si tiene un elemento a la derecha
                    insert(data, root.right); //buscara por la derecha hasta encontrar espacio
                }
            }
        }
        this.elements ++;
    }
    public  nodeTree searchNode(int data, nodeTree root){
        if(!isEmpty()){ // si no esta vacio el arbol
            if(root.data == data){ //checa si la raiz actual es el dato que se esta buscando
                return root;  //entonces devuelve el dato
            } else { //si no es, entonces checa
                if(root.data >= data && root.right != null){ //si el dato es menor que la raiz
                   // root = root.right; 
                    searchNode(data, root.right); // entonces va a buscar por la derecha
                } else {
                    if(root.data <= data && root.left != null){ //si el dato es mayor que la raiz
                        //root = root.left;
                        searchNode(data, root.left); //busca entonces por la izquierda
                    }
                } 
            } 
        }
        return null;
    }
    public void deleteNode(int data){    
        if(searchNode(data, root) == null){ // si no se encontro el dato
            System.out.println("El nodo que busca no existe dentro del arbol");
        } else { //si se encontro el dato
            nodeTree aux = searchNode(data, root); //se crea un auxiliar 
            if(aux.right == null && aux.left == null){ //si no tiene "hijos"
                aux = null; //simplemente se borra
           } else { //si tiene "hijos"
                if(aux.right != null && aux.left != null){ //si tiene dos "hijos"
                    aux = aux.right; //el de la derecha se pasa al "centro"
                    aux.right = null; //se borra el nodo de la derecha
                } else { // si solo tiene un "hijo"
                    if(aux.right != null){ //si el "hijo" esta a la derecha
                        aux = aux.right; // el de la derecha se pasa al centro
                        aux.right = null;
                    } else { 
                        if(aux.left != null){ // si el "hijo" esta a la izquierda
                            aux = aux.left;
                            aux.left = null;
                        }
                    }
                }
            }
        }
        this.elements --; // el numero de elementos disminuye en 1
    }
    
    public nodeTree getRoot(){
        return this.root;
    }
    
    public void postOrder(nodeTree root) {  
  if(root !=  null) {  
   postOrder(root.left);  
   postOrder(root.right);  
   System.out.printf("%d ",root.data);  
  }  
 }
    
public void inOrder(nodeTree root) {  
  if(root !=  null) {  
   inOrder(root.left);  
   System.out.printf("%d ",root.data);  
   inOrder(root.right);  
  }  
 }

public void preorder(nodeTree root) {  
    if(root !=  null) {     
      System.out.printf("%d ",root.data);  
      preorder(root.left);  
      preorder(root.right);  
    }
}
    
}
