//import java.util.Scanner;
//
//public class GuessGame {
//    public static void main(String[] args) {
//
//        //WELCOME AND RULES
//        System.out.println("""
//                WELCOME TO THE NUMBER GUESSING GAME
//
//                RULES
//                1. Choose a difficulty level(1 , 2 , 3)
//                Easy(1) → Range: 1–10 , Attempts: 5
//                Medium(2) → Range: 1–50 , Attempts: 3
//                Hard(3) → Range: 1–100 , Attempts: 2
//                3. Enter only valid numbers within the given range
//                4. Invalid inputs may reduce attempts (Medium & Hard)
//                5. You win by guessing correctly before attempts run out""");
//
//        //VALIDATING DIFFICULTY INPUT AS A DIGIT
//        boolean validChoice = false;
//        Scanner input = new Scanner(System.in);
//        int level = -1;
//
//        while (!validChoice) {
//            System.out.println("CHOOSE DIFFICULTY LEVEL:");
//            System.out.println("1 - Easy");
//            System.out.println("2 - Medium");
//            System.out.println("3 - Hard");
//            System.out.print("Enter your choice: ");
//
//            level = input.hasNextInt() ? input.nextInt() : -1;
//
//            if (level < 1 || level > 3) {
//                System.out.println("Invalid input. Please enter 1, 2, or 3.");
//                input.next(); //DISCARDS LEFTOVER INPUT FROM SCANNER
//            } else {
//                validChoice = true;
//            }
//        }
//
//        //SET GAME PARAMETERS(ATTEMPTS, RANGE AND DIFFICULTY LEVEL)
//        int minRange = 0;
//        int maxRange = 0;
//        int maxAttempts = 0;
//        String difficulty = "";
//
//        switch (level) {
//            case 1:
//                difficulty = "Easy";
//                minRange = 1;
//                maxRange = 10;
//                maxAttempts = 6;
//                System.out.println("LEVEL: " + difficulty);
//                System.out.println("RANGE: " + minRange + "-" + maxRange);
//                System.out.println("ATTEMPTS: " + maxAttempts);
//                break;
//            case 2:
//                difficulty = "Medium";
//                minRange = 1;
//                maxRange = 50;
//                maxAttempts = 4;
//                System.out.println("LEVEL: " + difficulty);
//                System.out.println("RANGE: " + minRange + "-" + maxRange);
//                System.out.println("ATTEMPTS: " + maxAttempts);
//                break;
//            case 3:
//                difficulty = "Hard";
//                minRange = 1;
//                maxRange = 100;
//                maxAttempts = 3;
//                System.out.println("LEVEL: " + difficulty);
//                System.out.println("RANGE: " + minRange + "-" + maxRange);
//                System.out.println("ATTEMPTS: " + maxAttempts);
//                break;
//            default:
//                System.out.println("Invalid Difficulty Selected");
//        }
//
//        //STARTING GAME ENGINE
//        int attemptUsed = 0;
//        boolean won = false;
//
//        //SECRET NUMBER GENERATION
//        int secretNumber = (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
//
//        int guess = 0;
//        while (true) {
//            if (attemptUsed >= maxAttempts) {
//                int attemptsLeft = maxAttempts - attemptUsed;
//                System.out.println("GAME OVER");
//                System.out.println("You have" + attemptsLeft + " left");
//                System.out.println("The correct number was : " + secretNumber);
//                break;
//            }
//
//
//            boolean validGuess = false;
//            guess = 0;
//            while (!validGuess) {
//
//                System.out.println("START GAME");
//                System.out.println(" Please enter your guess number");
//
//                //VALIDATE GUESS AS A NUMBER
//
//                if (!input.hasNextInt()) {
//                    System.out.println("Invalid input please enter a number");
//                    input.next();
//
//                }
//
//                //VALIDATE GUESS AS IN RANGE
//                guess = input.nextInt();
//
//                if (guess < minRange || guess > maxRange) {
//                    System.out.println("Out of range. Please enter a number between " + minRange + "-" + maxRange);
//                    input.next();
//
//                }
//                validGuess = true;
//
//            }
//            attemptUsed = attemptUsed + 1;
//
//            //CHECK WIN || LOSE
//            if (guess == secretNumber) {
//                won = true;
//                System.out.println("CONGRATULATIONS!!!...you guessed correctly WINNER");
//            }
//            break;
//        }
//
//        //SWITCH CASE DECISION FOR GUESS WITH DIFFICULTY LEVEL
//        switch(level) {
//            case 1:
//            case 2:
//            case 3:
//                if (guess > secretNumber) {
//                System.out.println("TOO HIGH");
//            } else {
//                System.out.println("TOO LOW");
//            }
//                break;
//            default:
//                System.out.println ("INVALID GAME STATE");
//        }
//
//        System.out.println("PLAY AGAIN(y/n)");
//        String playAgain = input.next();
//        if (playAgain.toLowerCase() == "y"){
//
//        }
//
//
//
//    }
//}
