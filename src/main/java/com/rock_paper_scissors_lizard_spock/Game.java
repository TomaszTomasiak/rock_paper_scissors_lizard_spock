package com.rock_paper_scissors_lizard_spock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game extends Controller {

    public Game() {

        Controller controller = new Controller();
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        HashMap<String, Move> theMap = new HashMap<>();
        theMap.put("1", new Paper());
        theMap.put("2", new Scissors());
        theMap.put("3", new Rock());
        theMap.put("4", new Lizard());
        theMap.put("5", new Spock());

        ArrayList<Move> theList = new ArrayList<>();

        theList.add(new Paper());
        theList.add(new Scissors());

        theList.add(new Rock());

        theList.add(new Lizard());
        theList.add(new Spock());

        boolean end = false;

        System.out.println("Paper, Scissors, Rock, Lizard, Spock - Welcome to the game");
        controller.setPlayerName();

        while (!end) {

            controller.numberOfPlays();
            System.out.println("You choose name: " + controller.playerName);
            System.out.println("We play up to " + controller.howManyPlays + " wins");

            label:
            while (!end) {
                System.out.println("Select: 1 - paper; 2 - scissors; 3 - stone; 4 - lizard; 5 - spock or X - to close the game; N -to start new game");
                String playerChoice = input.nextLine().toUpperCase();
                Move playerMove = theMap.get(playerChoice);

                switch (playerChoice) {
                    case "X":
                        System.out.println("Do you realy want to exit the game? Press: Y - yes or N - no");
                        playerChoice = input.nextLine().toUpperCase();

                        if (playerChoice.equals("Y")) {
                            System.out.println("Application is closed");
                            end = true;
                        }

                        break;
                    case "N":
                        System.out.println("Do you realy want to terminate this game? Press: Y - yes or N - no");
                        playerChoice = input.nextLine().toUpperCase();

                        if (playerChoice.equals("Y")) {
                            controller.startFromTheBeginning();
                            break label;

                        }

                        break;
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":

                        System.out.println("Your choice: " + playerMove.name());

                        int computerChoice = random.nextInt(5);
                        Move computerMove = theList.get(computerChoice);
                        System.out.println("Computer choice: " + computerMove.name());

                        RoundResult roundResult = playerMove.winsWith(computerMove);

                        if (roundResult.isDraw()) {
                            controller.draw();

                        } else if (roundResult.isWin()) {
                            controller.playerWin();
                            if (controller.computerResult == controller.howManyPlays || controller.playerResult == controller.howManyPlays) {
                                controller.gameOver();
                                end = true;
                            }

                        } else {
                            controller.computerWin();
                            if (controller.computerResult == controller.howManyPlays || controller.playerResult == controller.howManyPlays) {
                                controller.gameOver();
                                end = true;

                            }
                        }
                        break;
                }
            }
        }
    }
}


