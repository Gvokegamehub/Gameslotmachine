import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to start the game?");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                //The game begins
                startGame();
            } else if (answer.equalsIgnoreCase("n")) {
                //stop the game
                System.out.println("See you later");
                break;
            } else {
                System.out.println("I don't understand the answer.");
            }
        }
    }

    public static void startGame() {
        int buget = 100;

        Scanner sc = new Scanner(System.in);
        Random generator = new Random();

        ArrayList<String> possibilities = new ArrayList<>(Arrays.asList("DIAMOND", "CHERRY", "BAR"));

        String result1;
        String result2;
        String result3;

        while (true) {
            System.out.println("Enter the stake. Your budget is " + buget);
            int stake = sc.nextInt();

            if (stake > buget) {
                System.out.println("You don't have that much money.");
            } else {
                System.out.println("I pull the lever.");
                result1 = possibilities.get(generator.nextInt(possibilities.size()));
                result2 = possibilities.get(generator.nextInt(possibilities.size()));
                result3 = possibilities.get(generator.nextInt(possibilities.size()));
                System.out.println("[" + result1 + "]" + "  " + "[" + result2 + "]" + "  " + "[" + result3 + "]");

                if (result1.equals(result2) && result2.equals(result3)) {
                    System.out.println("JACKPOT");
                    double jackpot = (90.0 / 100.0) * stake;
                    System.out.println("You won " + jackpot + " points");
                    buget += jackpot;
                } else if (result1.equals(result2) || result1.equals(result3) || result2.equals(result3)) {
                    System.out.println("SEMI-JACKPOT ");
                    double semijackpot = (30.0 / 100.0) * stake;
                    System.out.println("You won " + semijackpot + " points");
                    buget += semijackpot;
                } else {
                    System.out.println("You lost " + stake);
                    buget -= stake;
                }

                if (buget == 0) {
                    System.out.println("You lost the game!");
                    break;
                } else if (buget >= 200) {
                    System.out.println("You won the game!");
                    break;
                }
            }
        }
    }
}
