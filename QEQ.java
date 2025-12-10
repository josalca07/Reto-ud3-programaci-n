package ud3.ejemplos;

import java.util.Random;
import java.util.Scanner;

public class QEQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] jugadores = {"Messi","Ronaldo","Lucas Boyé","Neymar","Lama","Uzuni"};

        String[][] caracteristicas = {
            {"GOAT","Enano"},
            {"Segundo","Portugués"},
            {"Ex del Granada","Delantero"},
            {"Llorón","Regateador"},
            {"Hijo de comentarista","Lateral"},
            {"Myrto...","Uzi"}
        };

        int elegido = (int)(Math.random() * jugadores.length);
        String jugadorSecreto = jugadores[elegido];

        System.out.println("Pregunta por una característica y te responderé sí o no.");

        String pregunta = "";
        while (!pregunta.equalsIgnoreCase("salir")) {
            System.out.print("Pregunta: ");
            pregunta = sc.nextLine();

            if (pregunta.equalsIgnoreCase("salir")) continue;

            boolean coincide = false;
            for (String c : caracteristicas[elegido]) {
                if (pregunta.equalsIgnoreCase(c)) {
                    coincide = true;
                    break;
                }
            }

            if (coincide) System.out.println("Sí");
            else System.out.println("No");
        }
            

            if (coincide) System.out.println("Sí");
            else System.out.println("No");
        }
    }

