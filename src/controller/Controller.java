package controller;

import model.ScoreManager;
import model.*;
import model.Torpedo;
import view.BoardButton;
import view.ButtonState;
import view.MainFrame;

import javax.swing.*;

import java.io.File;

/**
 *  <p> I den här klassen initierar vi spelet, användaren får välja bräda, kollar om en position är träffas och uppdaterar GUIt.
 *  För att kunna knyta ihop programmet så att allt samarbetar behöver vi Controller. Controllern är mellanhanden som
 *  ser både model samt view paketen. Controllern kontrollerar flödet av all data.
 *  </p>
 </p>
 @author Tiffany Zon & Saranna Lundén
 */
public class Controller {
    private MainFrame mainFrame;
    private Ship[][] shipGrid;
    private boolean shotsFiredGrid[][];
    private ScoreManager scoreHistory;
    private Player player;
    private int counterShotsTotal;
    private int counterMiss;
    private int counterDestroyed;
    private int counterHit;
    private Board board;

    /**
     *  <p> I den här konstruktorn kallar vi på metoden som initierar spelet.
     </p>
     */
    public Controller() {
     startGame();
    }

    /**
     *  <p> I den här metoden initieras spelet. Vi skapar en ny spelare,
     *  en ny scoreManager. Spelaren får välja om Board 1 eller Board 2
     *  ska spelas, och då skapas motsvarande board. Vi läser av filen
     *  där vi sparar objekt med tidigare spelare och visar dem i view i rightpanel.
     </p>
     */

    private void startGame() {
        player = new Player(null,0);
        scoreHistory = new ScoreManager(this);


        String[] possibilities = new String[]{"Board 1", "Board 2"};
        int response = JOptionPane.showOptionDialog(null, "Pick a board!", "Battleship", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, possibilities, possibilities[0]);
        this.mainFrame = new MainFrame(500, 500, this);
        counterShotsTotal = 0;
        counterHit = 0;
        counterMiss = 0;
        shotsFiredGrid = new boolean[10][10];
        if (response == 0) {
            board = new Board(response);
        }
        else if (response == 1)
        {
            board = new Board(response);
        }
        scoreHistory.readFileWithArg();
        mainFrame.populateRPanel(scoreHistory.infoStringsAllScores());
    }


    /**
     *  <p> I den här metoden tar vi emot den Boardbutton som spelaret tryckt på i view, och dess koordinator (i och j )
     *  Sedan kollar vi vår boolean grid ShortsFiredGrid för att se om boardbutton i fråga redan träffats.
     *  Om den ej har träffats så går vi vidare och kontrollerar om det finns ett skepp lagrat på Boardbutton.
     *  Vi kontrollerar även om hela skeppet träffats genom att kalla på metoden haveAllShipsSunk().
     *  Om ja, så kallas en metod i ScoreManager där vi kontrollerar om counterShotsTotal för nuvarande spelaren i fråga
     *  ska komma med på Top tio listan. Om ja, så får spelaren skriva in sitt namn.
     *
     * @param  i: ena koordinaten för Boardbutton.
     * @param  j: ena koordinaten för Boardbutton.
     * @param button: ena koordinaten för Boardbutton.

     </p>
     @author Tiffany Zon & Saranna Lundén
     */

    public void squareSelected(int i, int j, BoardButton button) { //eftersom det är pass-by-reference kommer allt vi gör med knappen i denna funktion kommer modifiera objetet vi har skickat in.

        if (shotsFiredGrid[i][j] )  {    //== true
            int choice = 1;
            String shipName = "nada";
            mainFrame.updateMessage(choice,shipName);
        } else {
            counterShotsTotal++;
            int newValue = counterShotsTotal;
            mainFrame.updateMainPanel("totalStrikes",newValue);
            shotsFiredGrid[i][j] =true;
            Ship ship = board.getPosition(i, j);

             if (ship == null) {
              counterMiss++;
                button.setHitState(ButtonState.hitWater);
                newValue = counterMiss;
                mainFrame.updateMainPanel("miss", newValue);
            } else {
                int choice = 2;
                String shipName = ship.getName();
                mainFrame.updateMessage(choice,shipName);
                ship.hit();
                counterHit++;
                newValue = counterHit;
                mainFrame.updateMainPanel("hit", newValue);

                button.setHitState(ButtonState.hit);
                if (ship.isSunk()) {
                    board.decreaseNbrOfShips();
                    choice = 3;
                    shipName = ship.getName();
                    mainFrame.updateMessage(choice,shipName);
                    counterDestroyed++;

                    newValue = counterDestroyed;
                    mainFrame.updateMainPanel("destroyed", newValue);

                   if(board.haveAllShipsSunk()){
                       choice = 4;
                       shipName = "nada";
                       mainFrame.updateMessage(choice,shipName);
                       player.setScore(counterShotsTotal);


                       if (scoreHistory.compareScore()){ 

                           scoreHistory.writeToFileWithArg();
                           mainFrame.populateRPanel(scoreHistory.infoStringsAllScores());
                       }
                       else{
                           JOptionPane.showMessageDialog(null,"Your score was too low.");
                       }

                       String[] poss2 = new String[]{"Yes", "No"};
                       int response = JOptionPane.showOptionDialog(null, "Do you want to play again?", "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, poss2, poss2[0]);
                       if (response == 0){
                           mainFrame.hideFrame();
                           startGame();
                       }
                       else {
                           mainFrame.closeFrame();
                       }





                    }

                }

            }
        }
    }

    /**
     * <p>
     * Hämtar player.
     * </p>
     * @return player: den nuvarande spelaren.
     */


    public Player getPlayer() {
        return player;
    }
}
