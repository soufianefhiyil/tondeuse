package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Main.class.getResourceAsStream("/tondeuse.txt");
        if (inputStream == null) {
            System.err.println("Le fichier 'tondeuse.txt' n'a pas été trouvé dans les ressources.");
            return;
        }
        Scanner in = new Scanner(inputStream);

        // Lecture des dimensions de la pelouse maximale fixée dans la première ligne
        int largeur = in.nextInt();
        int hauteur = in.nextInt();

        // Lecture des tondeuses
        List<Tondeuse> tondeuses = new ArrayList<>();
        while (in.hasNextLine()) {
            int x = in.nextInt();
            int y = in.nextInt();
            char orientation = in.next().charAt(0);
            in.nextLine(); // Consommer le retour à la ligne

            // Récupérer les instructions de la tondeuse
            String instructions = in.nextLine();

            Tondeuse tondeuse = new Tondeuse(x, y, orientation);
            for (char instruction : instructions.toCharArray()) {
                switch (instruction) {
                    case 'A':
                        tondeuse.move();
                        break;
                    case 'D':
                        tondeuse.turnRight();
                        break;
                    case 'G':
                        tondeuse.turnLeft();
                        break;
                    default:
                        break;
                }

                // Vérifier si la tondeuse est toujours dans la pelouse
                if (!Tondeuse.isInLawnArea(tondeuse, largeur, hauteur)) {
                    break;
                }
            }

            tondeuses.add(tondeuse);
        }

        // Affichage de la position finale des tondeuses
        for (Tondeuse tondeuse : tondeuses) {
            System.out.println(tondeuse);
        }
    }


}
