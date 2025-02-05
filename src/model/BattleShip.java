package model;

/**
 *  <p> Klassen används för att kunna skapa objekt av Battleship. Klassen ärver instansvariablerna
 namn, length och Board från den abstrakta klassen Ship.
 </p>
 @author Tiffany Zon & Saranna Lundén
 */

public class BattleShip extends Ship {

    /**
     * <p>  Konstruktor som vi använder för att skapa en BattleShip.
     * </p>
     * @param name: namn på skeppet
     * @param length: längden på skeppet
     * @param board: pga två olika boards behöver skeppen känna till vilken board det rör sig om.
     */
    public BattleShip(String name, int length, Board board) {
        super("Battleship", 5, board);
    }
}
