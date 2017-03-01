/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author DE LEON
 */
public class Herramientas {

    public static double[][] generarMatrizDistanciasAleatoria(int n, int distTope) {
        Random ran = new Random();

        double matriz[][] = new double[n][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (x == y) {
                    matriz[x][y] = 0;
                } else {// si no es igual
                    double dist = ran.nextInt(distTope) + ran.nextDouble();
                    matriz[x][y] = dist;
                    matriz[y][x] = dist;
                }
            }
        }
        return matriz;
    }

    public static void guardarInstancia(double[][] matriz) {
        //llamamos el metodo que permite cargar la ventana
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(file);
        //abrimos el archivo seleccionado
        File abre = file.getSelectedFile();

        String ruta = abre.getAbsolutePath();//"C:\\Users\\DE LEON\\Desktop\\" + nombre + ".txt";
        File archivo = new File(ruta+".txt");
        BufferedWriter bw = null;
        try {
            if (archivo.exists()) {
                JOptionPane.showMessageDialog(null, "Archivo ya Existente",
                        "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                for (int x = 0; x < matriz.length; x++) {
                    for (int y = 0; y < matriz.length; y++) {
                        if (y == matriz.length - 1) {
                            bw.append("" + matriz[x][y]);
                        } else {
                            bw.append("" + matriz[x][y] + ",");
                        }
                    }
                    bw.newLine();
                }
                bw.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double[][] abrirInstancia() {
        // generar la ventana de dialogo para abrir la instancias
        String texto, aux, nombre;
        LinkedList<String> lista = new LinkedList();
        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();            
            file.showOpenDialog(file);            
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();
            nombre = abre.getName();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                // calcular el numero de cidades
                int numCiu = lista.size();
                // instanciar la matriz
                double matriz[][] = new double[numCiu][numCiu];

                //leer los elementos y almacenarlos en la matriz
                ArrayList<String> lista2 = new ArrayList<>();
                String clase = "";
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    for (int x = 0; x < lista2.size(); x++) {
                        matriz[x][i] = Double.parseDouble(lista2.get(x));
                    }
                    lista2.clear();
                }
                //retornar la matriz
                return matriz;
            }
        } catch (Exception e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Archivo no encontrado",
                        "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public static int[] generarGenotipoAleatorio(int numCiu, int ciudadInicial){
        //declarar el arreglo
        int ruta[] = new int[numCiu];
        for(int i=0;i<numCiu;i++){
            ruta[i] = -1;
        }
        Random r = new Random();
        for(int c=0;c<numCiu;c++){
            //calcula el iindice de la ruta
            int ind = generarIndiceValido(ruta);                    
            ruta[ind] = c; 
        }
        //verificar que la ciudad inicial este al inicio
        if(ruta[0] != ciudadInicial){
            for(int x=1;x<numCiu;x++){
                if(ruta[x] == ciudadInicial){
                    //se realiza un intercambio
                    ruta[x] = ruta[0];
                    ruta[0] = ciudadInicial;
                    break;
                }
            }
        }
        
        return ruta;
    }

    public static int generarIndiceValido(int[] ruta) {
        Random r = new Random();
        int indice = r.nextInt(ruta.length);
        while(ruta[indice] != -1){
            indice = r.nextInt(ruta.length);
        }
        
        return indice;
    }
    
    
}
