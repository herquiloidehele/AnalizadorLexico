/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Testes;
/**
 * @author Claudio Sumburane
 * @author Herquiloide Hele
 * @author Jose Seie
 * 
 */
public class Teste {
    public static void main( String args[] ) {
        
        Long tempo_inicial, tempo_final, tempo_diferenca;
        String string = new String();
        StringBuilder stringBuilder = new StringBuilder();
        
//        tempo_inicial = System.currentTimeMillis();
//        
//        for (int i=0; i<100000; i++){
//            string +=i;
//        }
//        tempo_final = System.currentTimeMillis();
//        tempo_diferenca = tempo_final - tempo_inicial;
//        
//        
//        System.out.println((double)tempo_diferenca/1000);
//        
        tempo_inicial = System.currentTimeMillis();
//        
        for (int i=0; i<100000; i++){
            stringBuilder.append(i);
            System.err.println(i);
        }
        tempo_final = System.currentTimeMillis();
        tempo_diferenca = tempo_final - tempo_inicial;
        
        
        System.out.println((double)tempo_diferenca/1000);
   }
}
