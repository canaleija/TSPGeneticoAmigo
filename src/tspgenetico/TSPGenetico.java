/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tspgenetico;

import data.Herramientas;
import data.Individuo;
import data.Poblacion;
import operadores.Cruza;

/**
 *
 * @author DE LEON
 */
public class TSPGenetico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Cruza.cruzaAsexual(new Individuo(new int[]{1,0,2,3,4}),new Individuo(new int[]{1,4,2,3,0}));
        System.out.println();
    }
    
}
