public class Main {
    // The main method
    public static void main (String[] args) {
        // Create the games controller
        GamesController myGamesController = new GamesController();

        // Setup the game
        Contestant[] myContestants = myGamesController.setup();

        // Start the game
        myGamesController.start(myContestants);
    }
}
