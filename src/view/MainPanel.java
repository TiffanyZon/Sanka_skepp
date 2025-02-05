package view;

import javax.swing.*;

/**
 *  <p> I den här klassen skapar vi huvudpanel och uppdaterar LPanel
 </p>
 @author Tiffany Zon & Saranna Lundén
 */

public class MainPanel extends JPanel {
    private LPanel lPanel;
    private RPanel rPanel;

    /** <p> Konstruktorn skapar huvudpanelen.
     </p>
     @author Tiffany Zon & Saranna Lundén
     */

    public MainPanel(int width, int height, MainFrame mainFrame) {
        super(null);
        this.setSize(width, height);

        lPanel = new LPanel(width / 2, height/2, mainFrame);

        add(lPanel);

        rPanel = new RPanel(width / 2, height, mainFrame);
        add(rPanel);


    }

    /**
     *  <p> Gör ett kedjekall till RPanel som uppdaterar antal träffar, missar etc..
     </p>
     @author Tiffany Zon & Saranna Lundén
     */
    public void updateRpanel(String str, int newValue)
    {
        rPanel.updateLabel(str, newValue);
    }

    /**
     *  <p> Metoden hämtar högra panelen.
     </p>
     * @return rPanel : högra panelen
     */

    protected RPanel getRightPanel() {
        return rPanel;
    }

    /**
     *  <p> Gör ett kedjekall till RPanel som informerar användaren ifall ett
     *  skepp har sänkts, träffat samma ruta eller bara träffat ett skepp.
     </p>
     * @param choice  : val i case som används i switch case.
     * @param shipName : namn på skeppet, eller nada om inget skepp finns på rutan
     */
    public void updateMessage(int choice, String shipName) {
        rPanel.updateMessage(choice,shipName);
    }


}
