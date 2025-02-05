package model;

import java.io.Serializable;


/**
 *  <p> Klassen används för att kunna skapa objekt av Player. Klassen implementerar Serializable och Comparabale för att vi ska kunna stoppa in uppgifterna i vår Objekt dokument (List.dat).
 </p>
 @author Tiffany Zon & Saranna Lundén
 */

public class Player implements Serializable, Comparable<Player> {

    private String name;
    private int playersScore = 0;

    /**
     * <p>  Konstruktor som vi använder för att skapa en Player.
     * </p>
     * @param name: namn på spelaren.
     * @param playersScore: antal skott under en spelomgång.
     *
     */
    public Player(String name, int playersScore) {
        this.name = name;
        this.playersScore = playersScore;
    }


    /**
     * <p>Tilldelar namnet på spelaren.
     * </p>
     *  @param name: namn på spelaren.
     */
    public void setName(String name) {
        this.name = name;
    }




    /**<p>
     * Här görs instansvariablerna name och playersScore om till strängar så att informationen kan skrivas ut till användaren.
     * </p>
     * @return String: Instansvariablerna som gjorts om till strängar.
     */

    @Override
    public String toString() {


        return "Name: " + name + " Score: " + playersScore;
    }



    /**<p>
     * compareTo metoden returnerar antingen -1, 0 eller 1 beroende på om den första spelarens score (playersScore) är större,
     * mindre än eller lika med spelaren i listan som den jämförs med.
     *  Denna metod används alltså för att sortera listan av spelare. Metoden collections (som vi har i klassen ScoreBoard) behöver denna metod
     *  för att kunna sortera spelarna i rätt ordning beroende på varje Spelares playersScore.
     *  En int returneras. Om int = -1 innebär det att nuvarande spelarens score är mindre än den player som vi skickat med som parameter,
     *  1 betyder att den är större och 0 betyder att båda är lika. Den färdiga listan är i TopPlayerScore.
     * </p>
     * @return int: det nummer som returneras.
     *  @param o: spelare från ArrayList TopPlayersScore som skickas med från ScoreManager klassen.
     */
    @Override
    public int compareTo(Player o) {

        if (playersScore < o.playersScore) {
            return -1;
        }
       else if (playersScore > o.playersScore){
            return 1;
        }
        else{
            return 0;
        }

    }


    /**<p>
     * Tilldelar Score till nuvarande spelaren i slutet av spelet.
     *
     * </p>
     * @param counterShotsTotal: totala antalet shots som nuvarande spelaren gjort.
     */

    public void setScore(int counterShotsTotal) {
        this.playersScore = counterShotsTotal;
    }


    /**
     * <p>
     *
     * Hämtar spelarens playersScore.
     * </p>
     * @return playersScore: totala antalets shots som nuvarande spelaren gjort när spelet är slut.
     */
    public int getPlayersScore()
    {
        return playersScore;
    }
}
