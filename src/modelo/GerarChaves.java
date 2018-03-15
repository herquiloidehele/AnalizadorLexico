/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Herquiloide Hele
 */
public class GerarChaves {

    public static int impar = -1;
    public static int par = 0;
    
    public static int getProximaChave(int valor){
        if(verficarPar(valor))
            return par+=2;
        else
            return impar+=2;
            
    }

    /**
     * metodo que verifica se a chave de uma determinda palavra e par ou nao
     * @param valor
     * @return 
     */
    public static boolean verficarPar(int valor){
        return (valor % 2) == 0;
    }
    
}
