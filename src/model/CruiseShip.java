package model;

/**
 *  <p> Klassen används för att kunna skapa objekt av CruiseShip. Klassen ärver instansvariablerna
 namn, length och Board från den abstrakta klassen Ship.
 </p>
 @author Tiffany Zon & Saranna Lundén
 */

public class CruiseShip extends Ship{

    /**
     * <p>  Konstruktor som vi använder för att skapa en CruiseShip.
     * </p>
     * @param name: namn på skeppet
     * @param length: längden på skeppet
     * @param board: pga två olika boards behöver skeppen känna till vilken board det rör sig om.
     */
    public CruiseShip(String name, int length, Board board) {
        super("CruiseShip", 4, board);
    }
}
