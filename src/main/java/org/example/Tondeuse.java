package org.example;

public class Tondeuse {

    int x;
    int y;
    char orientation;

    public Tondeuse(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void move() {
        switch (orientation) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
            default:
                break;
        }
    }

    public void turnRight() {
        switch (orientation) {
            case 'N':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'N';
                break;
            default:
                break;
        }
    }

    public void turnLeft() {
        switch (orientation) {
            case 'N':
                orientation = 'W';
                break;
            case 'E':
                orientation = 'N';
                break;
            case 'S':
                orientation = 'E';
                break;
            case 'W':
                orientation = 'S';
                break;
            default:
                break;
        }
    }

    // Permets de retourner l’objet 'Tondeuse' sous forme de chaîne de caractères
    public String toString() {
        return x + " " + y + " " + orientation;
    }

    static boolean isInLawnArea(Tondeuse tondeuse, int largeur, int hauteur) {
        return tondeuse.x >= 0 && tondeuse.x <= largeur && tondeuse.y >= 0 && tondeuse.y <= hauteur;
    }
}
