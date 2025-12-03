package examen;

import java.util.Scanner;

public class Ej1 {

    static class DNIInvalidoException extends Exception {

        public DNIInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    static String leerDNI() throws DNIInvalidoException {
        Scanner sc = new Scanner(System.in);
        String dni;
        System.out.print("Introduce el DNI (8 números y una letra): ");
        dni = sc.nextLine();

        if (dni.length() != 9) {
            throw new DNIInvalidoException("Formato de DNI inválido. Debe ser 8 números y una letra.");
        }

        String parteNumerica = dni.substring(0, 8);
        char letra = dni.charAt(8);

        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(parteNumerica.charAt(i))) {
                throw new DNIInvalidoException("Formato de DNI inválido. Debe ser 8 números y una letra.");
            }
        }

        if (!Character.isLetter(letra)) {
            throw new DNIInvalidoException("Formato de DNI inválido. Debe ser 8 números y una letra.");
        }
        
        return dni;
    }

    static String cambiarDigito(String dni, int posicion, char nuevoValor) throws DNIInvalidoException {
        if (posicion < 1 || posicion > 8) {
            throw new DNIInvalidoException("ERROR, el número tiene que ser entre el 1 y el 8.");
        }
        if (!Character.isDigit(nuevoValor)) {
            throw new DNIInvalidoException("El nuevo valor debe ser un número.");
        }
        char[] arrayDNI = dni.toCharArray();
        arrayDNI[8] = Character.toUpperCase(arrayDNI[8]);
        int indice = posicion;
        arrayDNI[indice] = nuevoValor;
        return new String(arrayDNI);
    }

    public static void main(String[] args) {
        String dniLeido = "";
        try {
            dniLeido = leerDNI();
            System.out.println("DNI válido: " + dniLeido);
            String dniModificado = cambiarDigito(dniLeido, 3, '9');
            System.out.println("DNI modificado: " + dniModificado);
        } catch (DNIInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}