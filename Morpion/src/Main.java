import Morpion.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenue sur le jeu du morpion !");
        Scanner sc = new Scanner(System.in);
        String[] joueurs = new String[2];
        System.out.print("Veuillez entrer le nom du joueur 1  : ");
        joueurs[0]=sc.next();
        System.out.println("Bonjour "+joueurs[0]+", vous jouerez le symbole 'X'.");
        System.out.print("Veuillez entrer le nom du joueur 2  : ");
        joueurs[1]=sc.next();
        System.out.println("Bonjour "+joueurs[1]+", vous jouerez le symbole 'O'.");
        Game partie = new Game(joueurs[0], joueurs[1]);
        Morpion.FctGame.partie(partie);
    }
}