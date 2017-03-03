/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadores;

import data.Individuo;
import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Muta {
    
    public static void mutaPosAleatorio(Individuo hijo) 
    {
        // Caso especial para individuos de tamaño 3 o menor
        if(hijo.getGenotipo().length<=3)
        {
            // No modifica al individuo
        }
        // Si el individuo es de tamaño mayor a 3
        else
        {
            // Intercambiamos aleatoriamente una posición entre la tercera y la última ciudad
            Random ran = new Random();
            int gen1 = -1;
            int gen2 = -1;
            int pos1 = ran.nextInt(hijo.getGenotipo().length);
            int pos2 = ran.nextInt(hijo.getGenotipo().length);
            // Calculamos posiciones hasta que ninguna sea la posición inicial
            while((pos1==0 || pos2==0) || (pos1==0 && pos2==0) || (pos1==pos2))
            {
                pos1 = ran.nextInt(hijo.getGenotipo().length);
                pos2 = ran.nextInt(hijo.getGenotipo().length);
            }
            // Intercambiamos los genes de las posiciones resultantes
            gen1 = hijo.getGenotipo()[pos1];
            gen2 = hijo.getGenotipo()[pos2];
            hijo.getGenotipo()[pos1] = gen2;
            hijo.getGenotipo()[pos2] = gen1;
            hijo.calcularFitness();
        }
    
    }
}
