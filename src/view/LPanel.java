package view;

import javax.swing.*;
import java.awt.*;
/**
 *  <p> Klassen används för att skapa spelplanen i GUIt.
 </p>
 @author Tiffany Zon & Saranna Lundén
 */

public class LPanel extends JPanel {


    private int width;
    private int height;
    private MainFrame mainFrame;

    /**
     *  <p> Konstruktorn skapar spelplanen i GUIt.
     </p>
     * @param height : höjden på spelplanen
     * @param width : bredden på spelplanen
     * @param mainFrame : spelbrädan placeras på mainFrame
     * @author Tiffany Zon & Saranna Lundén
     */
    public LPanel(int width, int height, MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.width = width;
        this.height= height;
        this.setSize(width,height);
        setLocation(0,0);
        this.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j= 0; j <10; j++){
               BoardButton button= new BoardButton(width/11, height/11);
                int finali = i;
                int finalj = j;
                button.addActionListener(l -> mainFrame.boardButtonPressed(finali, finalj, button));
                this.add(button);

            }

        }

        }


}









