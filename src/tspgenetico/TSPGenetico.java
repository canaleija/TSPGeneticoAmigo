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
import operadores.Muta;

/**
 *
 * @author DE LEON
 */
public class TSPGenetico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Individuo.ciudadInicial=2;
        double matriz[][] = Herramientas.abrirInstancia();
        Individuo.matrizDistancias = matriz;
        GeneticoV1 g1 = new GeneticoV1(15, 100000, 0.4,1000, 56,matriz);
        g1.evolucionar();
        System.out.println();
    }
    
}
