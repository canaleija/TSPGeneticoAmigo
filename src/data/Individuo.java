/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Random;

/**
 *
 * @author DE LEON
 */
public class Individuo {
    private int genotipo[];
    private double fitness;
    public static int ciudadInicial;
    public static double matrizDistancias[][];

    public Individuo(int numCiu) {
        this.genotipo = Herramientas.generarGenotipoAleatorio(numCiu, ciudadInicial);
        calcularFitness();
    }

    public Individuo(Individuo ind) {
        this.genotipo = ind.getGenotipo().clone();
        calcularFitness();
    }
    
    public Individuo(int[] genotipo) {
        this.genotipo = genotipo.clone();
        calcularFitness();
    }

    public double getFitness() {
                
        return fitness;
    }

    public int[] getGenotipo() {
        return genotipo;
    }
        
    public void calcularFitness(){
        if(matrizDistancias != null){
            double acumulador = matrizDistancias[this.genotipo[0]][this.genotipo[this.genotipo.length-1]];
            for(int i=0;i<this.genotipo.length-1;i++){
                acumulador += matrizDistancias[this.genotipo[i]][this.genotipo[i+1]];
            }
            this.fitness = acumulador;
        }
        else{
            this.fitness = -1;
        }
    }

    @Override
    public String toString() {
        String aux = "[";
        for (int x=0;x<this.genotipo.length-1;x++)
            aux+=genotipo[x]+",";
        
        aux+=genotipo[genotipo.length-1]+"]";
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
        
}
