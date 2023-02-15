package Morpion;
import java.util.Objects;
import java.util.Scanner;
public class FctGame {
    public static char blank=' ';
    public static void toString(Game g) {
        assert g.TicTacToe != null;
        for (int i=0; i<3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(blank+g.TicTacToe[i][j]+blank);
                if (j!=2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i!=2) {
                System.out.println("―― ―― ――");
            }
        }
    }

    public static boolean jouerLettre(Game g, String pos, int Joueur) {
        String jeu=""+blank;
        if (Joueur==1) {
            jeu = "X";
        } else if (Joueur==2) {
            jeu = "O";
        }
        String lettres="ABC";
        String chiffres="123";

        if (pos.length()<2) {
            System.out.println("Veuillez entrer une cellule valide");
            return false;
        }

        if (!(Objects.equals(pos.charAt(0), lettres.charAt(0)) || Objects.equals(pos.charAt(0), lettres.charAt(1)) || Objects.equals(pos.charAt(0), lettres.charAt(2)))) {
            System.out.println("Veuillez entrer une cellule valide");
            return false;
        } else if (!(Objects.equals(pos.charAt(1), chiffres.charAt(0)) || Objects.equals(pos.charAt(1), chiffres.charAt(1)) || Objects.equals(pos.charAt(1), chiffres.charAt(2)))) {
            System.out.println("Veuillez entrer une cellule valide");
            return false;
        }

        if (Objects.equals(g.TicTacToe[lettres.indexOf(pos.charAt(0))][chiffres.indexOf(pos.charAt(1))], " ")) {
            g.TicTacToe[lettres.indexOf(pos.charAt(0))][chiffres.indexOf(pos.charAt(1))] = jeu;
            return true;
        } else {
            System.out.println("Quelqu'un à déjà joué ici !");
            return false;
        }
    }
    public static boolean isNul(Game g) {
        int count=0;
        for (int i=0; i<3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (!Objects.equals(g.TicTacToe[i][j], " ")) {
                    count++;
                }
            }
        }
        return count == 9;
    }

    public static boolean equals(String case1,String case2,String case3,String jeu) {
        return (Objects.equals(case1, case2) && Objects.equals(case2,case3) && Objects.equals(case3, jeu));
    }

    public static boolean isWin(Game g, int Joueur) {
        String jeu = ""+blank;
        if (Joueur==1) {
            jeu = "X";
        } else if (Joueur==2) {
            jeu = "O";
        }

        //Ligne
        for (int ligne=0;ligne<3; ++ligne) {
            if (equals(g.TicTacToe[ligne][0],g.TicTacToe[ligne][1],g.TicTacToe[ligne][2], jeu)) {
                return true;
            }
        }

        //Colonne
        for (int colonne=0;colonne<3; ++colonne) {
            if (equals(g.TicTacToe[0][colonne],g.TicTacToe[1][colonne],g.TicTacToe[2][colonne], jeu)) {
                return true;
            }
        }

        //Diagonale
        return equals(g.TicTacToe[0][0], g.TicTacToe[1][1], g.TicTacToe[2][2], jeu) || equals(g.TicTacToe[2][0], g.TicTacToe[1][1], g.TicTacToe[0][2], jeu);
    }
    public static void partie(Game g) {
        Scanner sc=new Scanner(System.in);
        int joueurTour=0;
        toString(g);
        while (true) {
            boolean joue=false;
            switch (joueurTour) {
                case 0, 2 -> {
                    joueurTour = 1;
                    System.out.println("A votre tour, " + g.Player1 + " : ");
                }
                case 1 -> {
                    joueurTour = 2;
                    System.out.println("A votre tour, " + g.Player2 + " : ");
                }
            }

            while (!joue) {
                joue=jouerLettre(g,sc.next(), joueurTour);
            }
            toString(g);
            if (isNul(g)) {
                System.out.println("Fin de la partie sur un nul.");
                break;
            } else if (isWin(g, 1)) {
                System.out.println("Victoire de "+g.Player1);
                break;
            } else if (isWin(g,2)) {
                System.out.println("Victoire de "+g.Player2);
                break;
            }
        }
    }
}
