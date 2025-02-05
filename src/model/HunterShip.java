package model;


/**
 *  <p> Klassen används för att kunna skapa objekt av HunterShip. Klassen ärver instansvariablerna
 namn, length och Board från den abstrakta klassen Ship.
 </p>
 @author Tiffany Zon & Saranna Lundén
 */

public class HunterShip extends Ship {
    /**
     * <p>  Konstruktor som vi använder för att skapa en HunterShip.
     * </p>
     * @param name: namn på skeppet
     * @param length: längden på skeppet
     * @param board: pga två olika boards behöver skeppen känna till vilken board det rör sig om.
     */
    public HunterShip(String name, int length, Board board) {
        super("Hunter", 3, board);
    }
}
