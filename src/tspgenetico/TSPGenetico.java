/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tspgenetico;

import data.Herramientas;
import data.Poblacion;

/**
 *
 * @author DE LEON
 */
public class TSPGenetico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneticoV1 gen = new GeneticoV1(5, 1, 0.4, 4,3,Herramientas.abrirInstancia());
        gen.evolucionar();
        System.out.println();
    }
    
}
