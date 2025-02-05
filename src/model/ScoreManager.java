package model;

import controller.Controller;

import javax.sound.midi.MidiFileFormat;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  <p> I den här klassen sparar nuvarande spelare i en ArrayList av spelare "topPlayerScore" om de kvalar in. Vi skriver även till och hämtar spelarobjekt från vår objektfil "list.dat".
 *  På detta sätt kan vi hålla koll på de 10 bästa spelarna.
 *  </p>
 </p>
 @author Tiffany Zon & Saranna Lundén
 */
public class ScoreManager {

    private String filename = "list.dat";
    private ArrayList<Player> topPlayersScore;
    private Controller controller;
    private Player player;


    /**
     * <p>  Konstruktor som vi använder för att skapa arrayLists. highScore kommer ha
     * objekt av player med vår nuvarande spelares information.
     * topPlayersScore lagrar all information från .dat filen samt lägger till nuvarande
     * spelare om spelaren är bättre än spelaren topPlayerScore(9);
     * För att kunna hämta spelarens score behöver vi ha tillgång till vår nuvarande controller.
     * Därför ingår den som en parameter.
     * </p>
     * @param controller: den specifika controllern vi använder för närvarande skickas med som parameter.
     */
    public ScoreManager(Controller controller) {

        topPlayersScore = new ArrayList<>(10);
        this.controller = controller;
    }


    /**
     * <p>
     *     Används för att vi ska jämföra nuvarande spelarens score med listan av spelare (som vi hämtat i List.dat och lagt i
     *     arrayList topPlayersScore)
     *     Om det finns färre än 10 spelare i listsan så läggs spelare in oavsett vad deras score är.
     *     Om det finns 10 spelare så jämför vi spelare med den sista spelaren i listan (dvs den som fått sämst score).
     *     Om nuvarande spelaren har bättre score så lägg nuvarande spelaren in i listan. Därefter sorteras den uppdaterade
     *     listan i ordning.
     *     Då returnerar denna metod true.
     *     Om spelaren har sämre resultat än den sista spelaren i listan så returneras false.
     * </p>
     * @return boolean
     */
    public boolean compareScore() {

        player = controller.getPlayer();
        if (topPlayersScore.isEmpty()  ||(topPlayersScore.size()<10) || ((player.getPlayersScore() < (topPlayersScore.get(topPlayersScore.size()-1).getPlayersScore())))){
                  String playersName = JOptionPane.showInputDialog(null, "Enter your name: ");
                  player.setName(playersName);
                  if (topPlayersScore.size() == 10) {
                      topPlayersScore.set(9, player);
                  }
                  else {
                      topPlayersScore.add(player);
                  }
                  Collections.sort(topPlayersScore);
                  return true;

              }
              else {
                  return false;
              }

            }


    /**
     * <p>
     *  Här görs topPlayersScore (en array bestående av alla bästa(top tio) spelare) om till en string array så att
     *  varje spelares namn och score blir en string.
     *
     * </p>
     * @return string []:  en array av strings bestående av varje spelares namn och score.
     */
    public String[] infoStringsAllScores () {
        String[] stringArrayAllScores = new String[topPlayersScore.size()];
        for (int i = 0; i < stringArrayAllScores.length; i++) {
            stringArrayAllScores[i] = topPlayersScore.get(i).toString();
        }
        return stringArrayAllScores;
    }


    /**
     * *<p>
     *     I denna metod skrivs alla players i vår arrayList TopPlaysScore över till vår objektfil List.dat.
     * </p>
     */
    public void writeToFileWithArg () {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
                for (int i = 0; i < topPlayersScore.size(); i++) {
                    oos.writeObject(topPlayersScore.get(i));
                    oos.flush();
                }
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    /**
     * <p>
     *     I denna metod läser vi in alla spelare som finns i vår List.dat fil och lägger det i arrayListan topPlayersScore.
     * </p>
     */
        public void readFileWithArg () {

            try {
                FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis);
                for(int i=0; i< 10; i++){
                    Player player1 = (Player) ois.readObject();
                    topPlayersScore.add(player1);
                }
                ois.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            Collections.sort(topPlayersScore);
        }
    }


