package examen;

import java.util.Scanner;

public class Ej2 {
	
	static void rellenaEncuesta(String[][] encuesta) {
	    Scanner sc = new Scanner(System.in);
	    String codigo;
	    int i = 0;
	    int maxHabitantes = encuesta.length;
	    while (i < maxHabitantes) {
	    	System.out.print("Introduce código postal (o 'fin' para terminar): ");
	    	codigo = sc.nextLine();
	    	if(codigo.equals("fin")) {
	    		break;
	    	}
	    	encuesta[i][0] = codigo;
	    	System.out.print("Introduce edad: ");
	        encuesta[i][1] = sc.nextLine();
	        System.out.print("Introduce sexo (M/F): ");
	        String sexo = sc.nextLine();
	        if (sexo.length() > 0) {
	            encuesta[i][2] = sexo.substring(0, 1).toUpperCase();
	        } else {
	            encuesta[i][2] = "";
	        }
	        i++;
	    }

	}
	
	static void muestraResultados(String[][] encuesta) {
        System.out.println("--- Resultados de la encuesta ---");
        for (int i = 0; i < encuesta.length; i++) {
            if (encuesta[i][0] != null) {
                System.out.println("Código Postal: " + encuesta[i][0] + ", Edad: " + encuesta[i][1] + ", Sexo: " + encuesta[i][2]);
            }
        }
    }
	
	static int calculaMediaEdad(String[][] encuesta, char sexo, int codigoPostal) {
        int sumaEdades = 0;
        int contador = 0;
        String sexoS = String.valueOf(Character.toUpperCase(sexo));
        String cpS = String.valueOf(codigoPostal);
        for (int i = 0; i < encuesta.length; i++) {
            if (encuesta[i][0] != null) {
                String cpEncuesta = encuesta[i][0];
                String sexoEncuesta = encuesta[i][2];
                if (cpEncuesta.equals(cpS) && sexoEncuesta.equals(sexoS)) {
                    sumaEdades = sumaEdades + Integer.parseInt(encuesta[i][1]);
                    contador = contador + 1;
                }
            }
        }
        
        if (contador == 0) {
            return 0;
        }
        return sumaEdades / contador;
    }

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] encuesta = new String[500][3];
        rellenaEncuesta(encuesta);
        muestraResultados(encuesta);
        System.out.print("Introduce código postal para calcular media: ");
        int cp = Integer.parseInt(sc.nextLine()); 
        
        System.out.print("Introduce sexo (M/F): ");
        String sexoInput = sc.nextLine();
        char sexo = ' ';
        if (sexoInput.length() > 0) {
            sexo = sexoInput.charAt(0);
        }
        int media = calculaMediaEdad(encuesta, sexo, cp);
        System.out.println("La media de edad asociada al CP " + cp + " y sexo " + Character.toUpperCase(sexo) + " es: " + media);
        sc.close();
    }

}