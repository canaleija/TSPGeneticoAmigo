/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tspgenetico;

import data.Herramientas;

/**
 *
 * @author DE LEON
 */
public class TSPGenetico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double matriz[][] = Herramientas.generarMatrizDistanciasAleatoria(3, 1000);
        Herramientas.guardarInstancia(matriz);
        //double matriz2[][] = Herramientas.abrirInstancia();
        System.out.println();
    }
    
}
