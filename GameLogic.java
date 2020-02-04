package Game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameLogic {

    public static int chooseCardP2(int[][] gameHistory, int stakeCard) {

        List<Integer> myCards = new ArrayList<>();
        List<Integer> duplicateCards = new ArrayList<>();

        for (int i=1; i <= 13; i++) {

            boolean foundAlready = false;
            for (int[] round : gameHistory) {
                if(round.length < 3) {
                    throw new IllegalArgumentException("The array is incorrect!");
                }

                if (round[2] == i) {
                    foundAlready = true;
                    break;
                }
            }

            if (!foundAlready) {
                myCards.add(i);
            }
        }

        for (int i = 0; i < gameHistory.length; i++) {
            for (int j = 0; j < 3; j++) {
                if(duplicateCards.contains(gameHistory[i][1])) {
                    throw new IllegalArgumentException("The move cannot be played twice!");
                }

                else {
                    duplicateCards.add(gameHistory[i][j+1]);
                    break;
                }
            }
        }

        Random r = new Random();
        return myCards.get(r.nextInt(myCards.size()));
    }

    public static int calcPlayer1Score(int[][] gameHistory) {
        int totalScore = 0;
        List<Integer> duplicateCards = new ArrayList<>();

        for(int[]round : gameHistory) {
            if(round.length < 3) {
                throw new IllegalArgumentException("The array is incorrect!");
            }

            if(round[1] > round[2]) {
                totalScore += round[0];
            }
        }

        for (int i = 0; i < gameHistory.length; i++) {
            for (int j = 0; j < 3; j++) {
                if(duplicateCards.contains(gameHistory[i][1])) {
                    throw new IllegalArgumentException("The move cannot be played twice!");
                }

                else {
                    duplicateCards.add(gameHistory[i][j+1]);
                    break;
                }
            }
        }

        return totalScore;

    }

}
