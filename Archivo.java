

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {

    private File fichero;
    public Archivo(){

    }
    public Archivo(File fichero) {
        this.fichero = fichero;
    }
     public float comparar(File fichero2){
        String linea_ar1 = null;String linea_ar2 = null;
        FileReader far1 = null;FileReader far2 = null;
        BufferedReader b1 = null;BufferedReader b2 = null;
        int contador = 0; int coincidencias = 0;
        //StringBuilder aux1 = new StringBuilder();StringBuilder aux2 = new StringBuilder();
        try {
            far1 = new FileReader(this.fichero);
            b1 = new BufferedReader(far1);
            far2 = new FileReader(fichero2);
            b2 = new BufferedReader(far2);
            try{         
                int a = 0; 
                while ((linea_ar1 = b1.readLine()) != null && (linea_ar2 = b2.readLine()) != null) {
                    if (a!=0){
                        //aux1.append(linea_ar1);
                        //aux2.append(linea_ar2);
                        int minimo = minimo(linea_ar1.length(),linea_ar2.length ());
                        System.out.println(minimo);       
                        System.out.println(linea_ar1+"\n"+linea_ar2+"\n\n");
                        for (int n = 0; n < minimo ; n++) { 
                            if(linea_ar1.charAt(n) == linea_ar2.charAt(n)){
                                coincidencias++;
                            }
                            contador++;
                        }                 
                    }
                    a++;
                }
            } catch (IOException ex) {
                System.out.println("Something bad has happended");
            }
        }   catch (FileNotFoundException ex) {
            System.out.println("Something bad has happended");
        }
        return ((float)coincidencias/(float)contador)*100;
    }
    public int minimo(int a, int b){
        return a<b?a:b;
    }
    public static void main(String[] args) {
        File texto  = new File("AY274119.txt");
        Archivo text = new Archivo(texto);
        File texto1 = new File("AY278488.2.txt");
        System.out.println(text.comparar(texto1)+"%");
    }
}
