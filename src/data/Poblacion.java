/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author DE LEON
 */
public class Poblacion {

    private Individuo mejor;
    private LinkedList<Individuo> habitantes;
    private int num_habitantes;


    public Poblacion(LinkedList<Individuo> habitantes) {
        this.habitantes = (LinkedList<Individuo>) habitantes.clone();
        this.num_habitantes = this.habitantes.size();
    }

    public Poblacion(Poblacion anterior) {
        this.num_habitantes = anterior.getNum_habitantes();
        this.habitantes = new LinkedList<>();
        // copiamos cada uno de los individuos 
        for (Individuo aux : anterior.getHabitantes()) {
            this.habitantes.add(new Individuo(aux));
        }
    }

//    private void generaPoblacionIncialAleatoria(int num_habitantes) {
//        this.habitantes = new LinkedList<>();
//        for (int x = 0; x < num_habitantes; x++) {
//            this.getHabitantes().add(new Individuo());
//        }
//    }

    /**
     * @return the mejor
     */
    public Individuo getMejor() {
        this.mejor = buscaAlMejor();
        return mejor;
    }

    /**
     * @return the habitantes
     */
    public LinkedList<Individuo> getHabitantes() {
        return habitantes;
    }

    /**
     * @return the num_habitantes
     */
    public int getNum_habitantes() {
        return num_habitantes;
    }

    private Individuo buscaAlMejor() {
        // garantizar que regresamos la referencia del mejor
        Individuo aux = this.habitantes.getFirst();
        for (int x = 1; x < num_habitantes; x++) {
            if (this.habitantes.get(x).getFitness() < aux.getFitness()) {
                aux = this.habitantes.get(x);
            }
        }
        return aux;
    }

    public Individuo obtenerAleatorio() {
        Random ran = new Random();
        return new Individuo(this.habitantes.get(ran.nextInt(num_habitantes)));
    }

    public void agregarHabitante(Individuo ind) {
        this.habitantes.add(new Individuo(ind));
        this.num_habitantes++;
    }
    
    

}
