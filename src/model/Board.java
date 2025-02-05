package model;

public class Board {

    private Ship [][] shipArray1;

    private int nbrOfShips;


    /**
     * <p>  Konstruktor som vi använder för att skapa en spelplan. Som parameter skickar vi med choice,
     * då spelaren kan välja mellan två spelplan, som vi hårdkodat i denna klass. I denna metod kommer
     * parametern choice avgöra om metoden Board1() eller metoden Board2() väljs.
     * </p>
     * @param choice: val av bräda.
     */
    public Board(int choice)
    {
        if (choice == 0){
            board1();
        }
        else {
            board2();
        }
    }

    /**
     * <p>  Metod som vi använder för att kontrollera om alla skepp på detta spelbräde har sänkts.
     * </p>
     * @return nbrOfShips: antal
     */


    public boolean haveAllShipsSunk()
    {
        return nbrOfShips == 0;
    }

    /**
     * <p>  Metod som returnerar ett skepp med position i,j.
     * </p>
     * @return shipArray1[i][j]
     */
    public Ship getPosition(int i, int j) {

        return shipArray1[i][j];
    }

    /**
     * <p>  Metod som vi använder för att skapa board2.
     * </p>
     */

    public void board2() {
        Torpedo torpedo = new Torpedo("Torpedo", 2, this);
         Submarine submarine = new Submarine("Submarine", 1, this);
         CruiseShip cruiseShip = new CruiseShip("CruiseShip",4,this);
         HunterShip hunterShip = new HunterShip("Hunter", 3, this);
         BattleShip battleShip = new BattleShip("Battleship", 5, this);
         this.nbrOfShips = 5;

        shipArray1 = new Ship[][]{
                {torpedo,null, null, null, battleShip, battleShip, battleShip, battleShip, battleShip, null},
                {torpedo, null, null, null, null, null, null, null, null, null},
                {null, null, hunterShip, null, null, null, null,null, null, null},
                {null, null, hunterShip, null, null, null, null, null, null, null},
                {null, null, hunterShip, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {cruiseShip, cruiseShip, cruiseShip, cruiseShip, null, null, null, null, submarine, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
        };
    }


    /**
     * <p>  Metod som vi använder för att skapa board1.
     * </p>
     */
    public void board1()
    {
         Torpedo torpedo = new Torpedo("Torpedo", 2, this);
         Submarine submarine = new Submarine("Submarine", 1, this);
         CruiseShip cruiseShip = new CruiseShip("CruiseShip",4,this);
         HunterShip hunterShip = new HunterShip("Hunter", 3, this);
         BattleShip battleShip = new BattleShip("Battleship", 5, this);
         this.nbrOfShips = 5;

        shipArray1 = new Ship[][]{
                {torpedo, torpedo, null, null, null, null, null, hunterShip, null, null},
                {null, null, null, null, null, null, null, hunterShip, null, null},
                {null, null, null, null, submarine, null, null,hunterShip, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, battleShip, null, null, null, null, null},
                {null, null, null, null, battleShip, null, null, null, null, null},
                {null, null, null, null, battleShip, null, null, null, null, null},
                {null, null, null, null, battleShip, null, null, null, null, null},
                {null, null, null, null, battleShip, null, null, null, null, null},
                {cruiseShip, cruiseShip, cruiseShip, cruiseShip, null, null, null, null, null, null},
        };


    }

    /**
     * <p>  Metod som vi använder för att minska antalet skepp. Denna metod kallas varje gång en spelare
     * har sänkt ett skepp på spelbrädet.
     * </p>
     */
    public void decreaseNbrOfShips() {
        nbrOfShips--;
    }
}
