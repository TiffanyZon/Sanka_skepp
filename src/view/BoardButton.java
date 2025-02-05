package view;

import javax.swing.*;
import java.awt.*;

/**
 * <p> Klassen används för att skapa en knapp samt ändra färg på knappen vid träff.
 </p>
 @author Tiffany Zon & Saranna Lundén
 */
public class BoardButton extends JButton {

    /**
     *  <p> I den här konstruktorn sätter vi utseende och storlek på en knapp.
     </p>
     * @param width: bredden på knapp.
     * @param height: höjden på knapp.
     */
    public BoardButton(int width, int height ){
        super();
        this.setEnabled(true);
        this.setSize(width, height);
        setHitState(ButtonState.water);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));


    }


    /**
     *  <p> I den metod bestäms knappens färg beroende på dess state. ButtonState skickas in som en parameter. .
     </p>
     * @param buttonState: knappens status (ett enum)
     */
    public void setHitState(ButtonState buttonState){

        switch (buttonState) {
            case hit:
                setBackground(Color.red);
                break;

            case hitWater:
                setBackground(Color.blue);
                break;

            case water:
                setBackground(Color.CYAN);
                break;


        }




    }


}
