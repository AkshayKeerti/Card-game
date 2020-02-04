package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AgentTester {

    public static void main(String[] args) {

        int[][] history = new int[13][3];
        int cWins = 0;
        int hPoints = 0;
        List<Integer> hCard = new ArrayList<>(); //Human and stake card lists
        List<Integer> sCard = new ArrayList<>();

        // build a 'suit' of 13 cards
        List<Integer> possibleCards = new ArrayList<>();
        for (int i=0; i<13; i++) {
            possibleCards.add(i+1);
        }
        Collections.shuffle(possibleCards);

        /* The code below basically demonstrates the various variables taken for identification and the calculation of points and the winner
         of a particular round. It makes a copy of the chosen cards and also makes sure the entry is right. */
        System.out.print("Welcome to the game!");
        System.out.print(" Make sure you have a set of cards before you, before you start the game! The set of cards is very crucial \n " +
                "as the game requires input from the cards you pick out! \n");
        System.out.print("This is how the game works:- \n " +
                "1) You will have to split the deck of cards into 3 suites! The suite does not matter. Make sure that each suite has 13 cards 'A' standing for 1 and 'K' standing for 13. \n" +
                "2) Once you have split the cards make sure you have shuffled them properly and keep them in front of you. \n" +
                "3) At first you would be asked to pick out a stake card! This card represents the number of points given to the winner of this round. \n" +
                "4) The computer then randomly chooses a card and tell you what it has chosen. You will then be asked to enter your card. Make sure not to cheat :). \n" +
                "5) The 2 separate decks are intended for that purpose which is for stake an you card respectively. \n" +
                "6) The game runs for 13 rounds! Once a round is over make sure you keep the cards aside as you cannot use the same cards again. \n" +
                "7) In the end, the one with the most points wins the game and the points would be calculated automatically and shown to you. \n"+
                "8) If you have understood the rules then please proceed! \n \n \n ");


        for(int round = 0; round < 13; round++) {
            Scanner sInput = new Scanner(System.in);
            Scanner hInput = new Scanner(System.in);

            System.out.println("Enter the picked out stake card: ");
            int stakeCard = sInput.nextInt();

            if(stakeCard > 13){
                throw new RuntimeException("Invalid Entry! Make sure its between 1 and 13.");
            }

            else if(sCard.contains(stakeCard)){
                throw new RuntimeException("The card cannot be repeated!");
            }

            else{
                sCard.add(stakeCard);
            }

            int[][] roundHistory = Arrays.copyOf(history, round+1);

            int compCard = GameLogic.chooseCardP2(roundHistory, stakeCard);
            System.out.println("The computer has picked: " + compCard);

            System.out.println("Enter the card you picked up: ");
            int humanCard = hInput.nextInt();


            if(hCard.contains(humanCard)){
                throw new RuntimeException("The card cannot be repeated!");
            }

            else if(humanCard > 13){
                throw new RuntimeException("Invalid Entry! Make sure its between 1 and 13.");
            }

            else{
                hCard.add(humanCard);
            }

            history[round] = new int[]{stakeCard, humanCard, compCard};
            System.out.println(Arrays.toString(history[round]));

            if(humanCard > compCard) {
                System.out.println("This " + round + " goes to human" + "!" + stakeCard + " points is awarded to human");
                hPoints += stakeCard;
                System.out.println("Total points so far for the computer is: " + hPoints);
            }

            else if(compCard > humanCard) {
                System.out.println("This round (" + round + ") goes to computer" + "! " + stakeCard + " points is awarded to computer");
                cWins += stakeCard;
                System.out.println("Total points so far for the computer is: " + cWins);
            }

            else if(humanCard == compCard){
                System.out.println("ITS A DRAW! NO ONE WINS :(");
            }

            System.out.println("///////////////////////////////");
        }

        if(GameLogic.calcPlayer1Score(history) > cWins){
            int points = GameLogic.calcPlayer1Score(history);
            System.out.println("HUMAN HAS WON THE GAME! TOTAL POINTS WAS: " + points);
        }

        else if(GameLogic.calcPlayer1Score(history) < cWins){
            System.out.println("COMPUTER HAS WON THE GAME! TOTAL POINTS WAS: " + cWins);
        }

        else if(GameLogic.calcPlayer1Score(history) == cWins){
            System.out.println("ITS A TIE!!");
        }
    }
}

