/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadores;

import data.Herramientas;
import data.Individuo;
import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Cruza {
    
    public static Individuo cruzaAsexual(Individuo padre,Individuo madre){
        int maskIndices[] = new int[padre.getGenotipo().length-1];
        // creo la mascara de índices 
        for(int ii=0;ii<maskIndices.length;ii++){
            maskIndices[ii] = -1;
        }
        for (int i=1; i<= maskIndices.length;i++){
            int ind = Herramientas.generarIndiceValido(maskIndices);
            maskIndices[ind]=i;
        }
        int geno1[] = new int[padre.getGenotipo().length];
        int geno2[] = new int[madre.getGenotipo().length];
        geno1[0] = padre.getGenotipo()[0];
        geno2[0] = madre.getGenotipo()[0];
        // construimos los nuevos genotipos
        for (int x=1;x<geno1.length;x++){
           geno1[maskIndices[x-1]]=padre.getGenotipo()[x];
           geno2[maskIndices[x-1]]=madre.getGenotipo()[x];
        }
       Individuo hijo1 =  new Individuo(geno1);
       Individuo hijo2 =  new Individuo(geno2);
         
       ArrayList<Individuo> lista = new ArrayList<>();
       lista.add(madre);
       lista.add(padre);
       lista.add(hijo1);
       lista.add(hijo2);
       return retornaMejor(lista);
    }

    private static Individuo retornaMejor(ArrayList<Individuo> lista) {
        Individuo mejor = lista.get(0);
        
        for (int x=1; x<lista.size();x++){
           if(lista.get(x).getFitness()<mejor.getFitness()){
            mejor =lista.get(x);
           }
        }
        return mejor;
    }
    
}
