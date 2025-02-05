package model;

public abstract class Ship{

    private String name;
    private int length;
    private Board board;
    private int hits;

    /**
     * <p>  Konstruktor som vi använder för att skapa skepp.
     * </p>
     * @param name: namn på skeppet
     * @param length: längden på skeppet
     * @param board: pga två olika boards behöver skeppen känna till vilken board det rör sig om.
     */

    public Ship(String name, int length, Board board) {
        this.name = name;
        this.length = length;
        this.board = board;
    }

    /**
     * <p> Metod som kallas varje gång det specifika skeppet har träffats (antals hits). </p>
     */
    public void hit(){
        this.hits++;
    }


    /**
     * <p> Metod kollar om skeppet har sänkts genom att jämföra skeppets length med hur många gånger
     * den träffats (hits). </p>
     * @return boolean: returnerar true om skeppet har sänkts.
     */
    public boolean isSunk(){
        return hits == length;

    }

    /**
     * <p> Här hämtas namnet på skeppet. (eg. Battleship) </p>
     * @return String: returnerar namnet på skeppet.
     */
    public String getName() {
        return name;
    }

    /**
     * <p> Här hämtas en string med namnet på, samt längden på skeppet. </p>
     * @return String: returnerar en sträng.
     */
    public String toString() {
        return  name +", "+length+ " squares ";
    }
}


