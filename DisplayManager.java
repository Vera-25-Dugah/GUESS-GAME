public class DisplayManager {

    public void showWelcomeAndRules(){
        System.out.println("""
                WELCOME TO THE NUMBER GUESSING GAME
                
                RULES
                A. Choose a difficulty level(1 , 2 , 3)
                1->Easy → Range: 1–10 , Attempts: 5
                2->Medium → Range: 1–50 , Attempts: 3
                3->Hard → Range: 1–100 , Attempts: 2
                B. Enter only valid numbers within the given range
                C. You win by guessing correctly before attempts run out""");
    }

    public void showSelectDifficulty(){
        System.out.println("START GAME");
        System.out.println("CHOOSE DIFFICULTY LEVEL:");
        System.out.println("1 - Easy");
        System.out.println("2 - Medium");
        System.out.println("3 - Hard");
        System.out.print("Enter your choice: ");
    }

    public void showLevelConstraints(String difficulty, int minRange, int maxRange, int maxAttempts){
        System.out.println("LEVEL: " + difficulty);
        System.out.println("RANGE: " + minRange + "-" + maxRange);
        System.out.println("ATTEMPTS: " + maxAttempts);
    }

    public void showGameOver( int secretNumber){
        System.out.println("GAME OVER");
        System.out.println("You have no attempts left");
        System.out.println("The secret number was : " + secretNumber);
    }

}
