package model;
/**
 *  <p> Klassen används för att kunna skapa objekt av Torpedo. Klassen ärver instansvariablerna
 namn, length och Board från den abstrakta klassen Ship.
 </p>
 @author Tiffany Zon & Saranna Lundén
 */

public class Torpedo extends Ship {

    /**
     * <p>  Konstruktor som vi använder för att skapa en Torpedo.
     * </p>
     * @param name: namn på skeppet
     * @param length: längden på skeppet
     * @param board: pga två olika boards behöver skeppen känna till vilken board det rör sig om.
     */
    public Torpedo(String name, int length, Board board) {
        super("Torpedo", 2, board);
    }
}




