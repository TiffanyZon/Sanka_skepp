package view;

import controller.Controller;
import controller.Main;

import javax.swing.*;
import java.awt.event.WindowEvent;
/**
 *  <p> I den här klassen skapar vi huvudfönstret och uppdaterar RPanel, mainPanel och controllern.
 </p>
 @author Tiffany Zon & Saranna Lundén
 */

public class MainFrame extends JFrame {

    private MainPanel mainPanel;
    private Controller controller;

    /**
     *  <p> Konstruktorn används för att skapa huvudfönstret.
     </p>
     * @param controller : den specifika controllern vi använder för en spelomgång
     * @param height : höjden på huvudfönstret
     * @param width : bredden på huvudfönstret
     @author Tiffany Zon & Saranna
     */
    public MainFrame(int width, int height, Controller controller) {

        super("Battleship");
        this.controller = controller;
        this.setResizable(false);
        this.setSize(width,height);
        this.mainPanel = new MainPanel(width, height, this );
        this.setContentPane(mainPanel);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    /**
     *  <p> Metoden används för att uppdatera controllern om en knapp blivit nedtryckt.
     </p>
     * @param i : position
     * @param j : position
     * @param button : nedtryckt knapp
     @author Tiffany Zon & Saranna Lundén
     */

    public boolean boardButtonPressed(int i, int j, BoardButton button) {
        controller.squareSelected(i,j,button);
        return true;
    }

    /**
     *  <p> Gör ett kedjekall till mainPanel som upppdaterar RPanel.
     </p>
     * @param str : namn på ett case som används i switch case i RPanel
     * @param newValue : nya värdet som uppdateras på RPanel
     @author Tiffany Zon & Saranna Lundén
     */
    public void updateMainPanel(String str, int newValue)
    {
        mainPanel.updateRpanel(str, newValue);
    }

    /**
     *  <p> Metoden gör ett kedjekall till mainPanel som uppdaterar RPanel med information om rutans status.
     </p>
     * @param choice : namn på ett case som används i switch case i RPanel
     * @param shipName : namn på skeppet som finns på rutan, eller nada om inget skepp finns
     @author Tiffany Zon & Saranna Lundén
     */
    public void updateMessage(int choice, String shipName) {
        mainPanel.updateMessage(choice, shipName);
    }

    /**
     *  <p> Metoden gör ett kedjekall till mainPanel som uppdaterar RPanel med highscore listan.
     </p>
     * @param informationArray : array med players score och namn.
     @author Tiffany Zon & Saranna Lundén
     */
    public void populateRPanel(String[] informationArray) {
        mainPanel.getRightPanel().populateList(informationArray);
    }

    /**
     *  <p> Metod som gömmer huvudfönstret när ett nytt spel startar.
     </p>
     @author Tiffany Zon & Saranna Lundén
     */

    public void hideFrame() {
        setVisible(false);

    }

    /**
     *  <p>  Metoden stänger hela programmet när spelaren väljer att avsluta.
     </p>
     @author Tiffany Zon & Saranna Lundén
     */
    public void closeFrame() {
        System.exit(0);
    }
}

