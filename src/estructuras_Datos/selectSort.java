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
public class selectSort {
    
    public static int Buscar(int x[], int val){ //Se inicializa el metodo
    boolean bandera = false; // la banderita booleana para saber si esta o no el valor
    for (int i=0; i < x.length; i++){
        if(val == x[i]){  //se busca en el arreglo y compara uno por uno
            System.out.println("El valor esta en la posicion "+ (i+1));
            bandera = true; // como si se encontro la bandera manda un true
        }
    
    }
    if(bandera == false){ //si no se encuentra entonces la bandera nunda pasa a ser True
        System.out.println("El valor que busca no se encuentra en el arreglo");
}
       return val; //return obligatorio
  }
}
