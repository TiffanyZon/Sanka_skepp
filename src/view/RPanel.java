package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;


/**
 *  <p> Klassen används för att visa användaren scorelista, träffar, misssar etc.. i GUIt.
 </p>
 @author Tiffany Zon & Saranna Lundén
 */

public class RPanel extends JPanel {


    private Controller controller;
    private JLabel info = new JLabel("Start shooting.");

    private JList <Object> rightPanelList;
    private JLabel hitLabel;
    private JLabel missLabel;
    private JLabel destroyedLabel;
    private JLabel totalStrikesLabel;
    private JLabel rightPanelListLabel;

    private JTextField hitField;
    private JTextField missField;
    private JTextField destroyedField;
    private JTextField totalStrikesField;

    private int width;
    private int height;

    private String hits;
    private String misses;
    private String destroyed;
    private String totalStrikes;
    private MainFrame mainFrame;
    private JLabel titleRightPanel;

    /**
     *  <p> Konstruktorn skapar den högra panelen.
     </p>
     * @param width : bredden på panelen
     * @param height : höjden på panelen
     * @param mainFrame : huvudfönstret panelen ligger på
     */

    public RPanel(int width, int height, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(width, 0);
        setUp();
    }
    /**
     *  <p> Fält som visar användaren antal träffar
     </p>
     */
    public void hitField() {

        hitLabel = new JLabel("Hits");
        hitLabel.setLocation(50, 50);
        hitLabel.setSize(100, 100);
        this.add(hitLabel);


        hits = "0";


        hitField = new JTextField("" + hits);
        hitField.setPreferredSize(new Dimension(50, 50));
        this.add(hitField);
        hitField.setText(String.valueOf(0));
    }

    /**
     *  <p> Fält som visar användaren antal missar
     </p>
     */
    public void missField() {
        missLabel = new JLabel("Miss");
        missLabel.setLocation(50, 100);
        missLabel.setSize(100, 100);
        this.add(missLabel);
        misses = "0";
        missField = new JTextField("" + misses);
        missField.setLocation(50, 80);
        missField.setPreferredSize(new Dimension(50, 50));
        this.add(missField);
    }
    /**
     *  <p> Fält som visar användaren antal förstörda skepp
     </p>
     */
    public void destroyField() {
        destroyedLabel = new JLabel("Destroyed");
        destroyedLabel.setLocation(50, 150);
        destroyedLabel.setSize(100, 100);
        this.add(destroyedLabel);
        destroyed = "0";
        destroyedField = new JTextField("" + hits);
        destroyedField.setLocation(10, 80);
        destroyedField.setPreferredSize(new Dimension(50, 50));
        // destroyedField.setBounds(50,100,50,30);
        this.add(destroyedField);

    }
    /**
     *  <p> Fält som visar användaren totalt antal skott
     </p>
     */

    public void totalStrikesField() {
        totalStrikesLabel = new JLabel("Total Strikes");
        totalStrikesLabel.setLocation(50, 200);
        totalStrikesLabel.setSize(100, 100);
        this.add(totalStrikesLabel);
        totalStrikes = "0";
        totalStrikesField = new JTextField("" + hits);
        totalStrikesField.setLocation(50, 80);
        totalStrikesField.setPreferredSize(new Dimension(50, 50));
        this.add(totalStrikesField);
    }
    /**
     *  <p> Skapar ett fönster för highscore listan.
     </p>
     */
    public void createRightPanelList()
    {
        rightPanelListLabel = new JLabel("HighScore list");
        rightPanelListLabel.setLocation(50,600);
        rightPanelListLabel.setSize(200,200);
        this.add(rightPanelListLabel);
        rightPanelList = new JList<>();
        rightPanelList.setLocation(50,500);
        rightPanelList.setSize(100,200);
        this.add(rightPanelList);
    }

    /**
     *  <p> Alla fält samlas i metoden som kallas i konstruktorn.
     </p>
     */

    private void setUp() {
        setLayout(new FlowLayout());
        hitField();
        missField();
        destroyField();
        totalStrikesField();
        createRightPanelList();

    }

    /**
     *  <p> uppdaterar fälten.
     </p>
     */
    public void updateLabel(String str, int newValue) {

        switch (str) {
            case "hit":
                hitField.setText(String.valueOf(newValue));
                break;
            case "miss":
                missField.setText(String.valueOf(newValue));
                break;
            case "destroyed":
                destroyedField.setText(String.valueOf(newValue));
                break;
            case "totalStrikes":
                totalStrikesField.setText(String.valueOf(newValue));
                break;
        }


    }

    /**
     *  <p> Informerar spelaren om de träffat eller sänkts ett skepp, samt om de redan träffat rutan tidigare.
     </p>
     * @param shipName : namn på skeppet, eller nada om inget skepp finns
     * @param choice : val i switch case.
     */

    public void updateMessage(int choice, String shipName) {
        switch (choice){
            case 1:
                JOptionPane.showMessageDialog(null,"You have already fired a shot at this square. Choose another one.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null,"You hit a " + shipName);
                break;
            case 3:
                JOptionPane.showMessageDialog(null,"You destroyed a " + shipName);
                break;
            case 4:
                JOptionPane.showMessageDialog(null,"Game finished!");
                break;
        }
    }

    /**
     *  <p> Uppdarerar highscore listan.
     </p>
     */

    public void populateList(String[] informationArray) {
        rightPanelList.setListData(informationArray);
    }

}


