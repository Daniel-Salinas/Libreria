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
class Edge {
    int dest;
    double weight;
    
    Edge (int d, double w){
        this.dest=d;
        this.weight=w;
    }
    
    public String toString (){
        return this.dest +"("+this.weight+")";
    }
    
}
