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
 * @author Roberto Cruz Leija
 */
public class GeneticoV1 {
    
    private int tamano_poblacion;
    private int epocas;
    private double prob_muta;
    private int num_ciudades;
    private int ciudad_inicial;
    private Poblacion poblacion;

    public GeneticoV1(int tamano_poblacion, int epocas, double prob_muta, int num_ciudades, int ciudad_inicial) {
        this.tamano_poblacion = tamano_poblacion;
        this.epocas = epocas;
        this.prob_muta = prob_muta;
        this.num_ciudades = num_ciudades;
        this.ciudad_inicial = ciudad_inicial;
        // inicializamos la poblacion con el 
        // constructor que la genera de forma
        // aleatoria
        Individuo.matrizDistancias = Herramientas.generarMatrizDistanciasAleatoria(num_ciudades,100);
        Individuo.ciudadInicial = ciudad_inicial;
        Herramientas.guardarInstancia(Individuo.matrizDistancias);
        this.poblacion = new Poblacion(num_ciudades, tamano_poblacion);
    }
    
       public GeneticoV1(int tamano_poblacion, int epocas, double prob_muta, int num_ciudades, int ciudad_inicial,
               double[][]matrizDistancias) {
        this.tamano_poblacion = tamano_poblacion;
        this.epocas = epocas;
        this.prob_muta = prob_muta;
        this.num_ciudades = num_ciudades;
        this.ciudad_inicial = ciudad_inicial;
        // inicializamos la poblacion con el 
        // constructor que la genera de forma
        // aleatoria
        Individuo.matrizDistancias = matrizDistancias;
        Individuo.ciudadInicial = ciudad_inicial;
        this.poblacion = new Poblacion(num_ciudades, tamano_poblacion);
    }
     
    
    public void evolucionar (){
       // crear un proceso iterativo para simular las epocas
        for (int e=0; e < this.epocas;e++){
            // garantizar la creación de una nueva población
            Poblacion nuevaP = new Poblacion(); 
            // tenemos que iterar para construir la nueva generacion
            for(int i=0; i < this.tamano_poblacion;i++){
               // proceso de seleccion de padre y madre
               Individuo padre = this.poblacion.obtenerAleatorio();
               Individuo madre = this.poblacion.getMejor();
               // ejecutamos la cruza y obtenemos al hijo
               Individuo hijo = Cruza.cruzaAsexual(padre,madre);
               // dependiendo de una prob. muta se cambia el hijo
               if (Math.random()<=this.prob_muta){
               Muta.mutaPosAleatorio(hijo);
               
               }
// agrega el hijo a la nueva poblacion
               nuevaP.agregarHabitante(hijo);
            }
            // actualizamos la población 
            this.poblacion = new Poblacion(nuevaP);
            System.out.println(e+" - fitness de: "+this.poblacion.getMejor().getFitness());
        
        }
        System.out.println(this.poblacion.getMejor().toString());
    
    }
    
    
    
}
