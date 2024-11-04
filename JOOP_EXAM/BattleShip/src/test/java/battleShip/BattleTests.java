package battleShip;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class BattleTests {

    //TODO implement tests
    Battle battle;
    Ship ship1;
    Ship ship2;
    Ship ship3;

    @BeforeEach
    public void setUp() {
        battle = new Battle("Black Sea", 2);
        ship1 = new Ship("Destroyer", "Warship", 100, 200, 50);
        ship2 = new Ship("Cruiser", "Warship", 150, 300, 70);
        ship3 = new Ship("Voyager", "PirateShip", 50, 100, 80);

    }

    @Test
    public void testGetShips() {

        battle.addShip(ship1);
        battle.addShip(ship2);

        List<Ship> ships = battle.getShips();

        assertEquals(2, ships.size());
        assertTrue(ships.contains(ship1));
        assertTrue(ships.contains(ship2));

        // Check if the list is unmodifiable
        assertThrows(UnsupportedOperationException.class, () -> {
            ships.add(new Ship("Submarine", "Warship", 80, 150, 40));
        });
    }

    @Test
    public void testAddNullShipThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            battle.addShip(null);
        });
        assertEquals("Ship can't be null", ex.getMessage());
    }

    @Test
    public void testAddShipsOverCapacityThrows(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            battle.addShip(ship1);
            battle.addShip(ship2);
            battle.addShip(ship3);
        });
        assertEquals("No more places!", ex.getMessage());
    }

    @Test
    public void testGetCount() {
        battle.addShip(ship1);
        battle.addShip(ship2);

        assertEquals(2, battle.getCount());
    }

    @Test
    public void testSetCapacity() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->  {
            Battle battle1 = new Battle("StarSeaBattle", -1);
        });

        assertEquals("Invalid capacity!", ex.getMessage());

    }

    @Test
    public void testRemoveShip() {
        battle.addShip(ship1);
        battle.addShip(ship2);

        assertTrue(battle.removeShip("Warship"));
        assertEquals(1, battle.getCount());
        assertFalse(battle.getShips().contains(ship1));

    }

    @Test
    public void testGetMostPowerfulShip() {

        battle.addShip(ship1);
        battle.addShip(ship3);

        String mostPowerfulShipName = battle.getMostPowerfulShip();
        assertNotNull(mostPowerfulShipName);
        assertEquals("Voyager", mostPowerfulShipName);

    }




    @Test
    public void testFindAllShipByAmmunitionMoreThan100() {

        battle.setCapacity(5);

        ship1 = new Ship("Destroyer", "Warship", 100, 200, 50);
        ship2 = new Ship("Cruiser", "Warship", 150, 300, 70);
        ship3 = new Ship("Voyager", "PirateShip", 50, 100, 80);


        battle.addShip(ship1); // ammunition = 200
        battle.addShip(ship2); // ammunition = 300
        battle.addShip(ship3); // ammunition = 100

        List<Ship> result = battle.findAllShipByAmmunitionMoreThan100();

        assertEquals(2, result.size());
        assertTrue(result.contains(ship1));
        assertTrue(result.contains(ship2));
        assertFalse(result.contains(ship3));
    }

    @Test
    public void testAddExistingShip() {
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> {
                    battle.addShip(ship1);
                    battle.addShip(ship1);
                });
        assertEquals("The ship Destroyer already exist!", String.format("The ship %s already exist!", ship1.getName()));
    }








}