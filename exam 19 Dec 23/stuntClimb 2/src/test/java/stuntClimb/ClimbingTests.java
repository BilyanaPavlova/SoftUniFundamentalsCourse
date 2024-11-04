package stuntClimb;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ClimbingTests {

    Climbing climbing;


    RockClimber mockRockClimber;
    RockClimber mockRockClimber2;
    RockClimber mockRockClimber3;


    @BeforeEach
    public void setUp() {

        climbing = new Climbing("Musala", 2);
        mockRockClimber = new RockClimber("John", 10);

        mockRockClimber2 = new RockClimber("Bili", 20);

        mockRockClimber3 = new RockClimber("Ilian", 30);

    }

    @Test
    public void testSetEmptyNameThrows(){
        NullPointerException exception = assertThrows(NullPointerException.class, () ->{
            climbing = new Climbing("", 2);
        });
    }

    @Test
    public void testSetNullNameThrows(){
        NullPointerException exception = assertThrows(NullPointerException.class, () ->{
            climbing = new Climbing(null, 2);
        });
    }

    @Test
    public void testSetNegativeCapacityThrows(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->{
            climbing = new Climbing("Vihren", -1);
        });
    }


    @Test
    public void testCreationOfClimbing(){
        assertNotNull(climbing);
        assertEquals("Musala", climbing.getName());
        assertEquals(2, climbing.getCapacity());
    }

    @Test
    public void testGetCount() {
        assertEquals(0, climbing.getCount());
    }

    @Test
    public void testAddRockClimber(){
        climbing.addRockClimber(mockRockClimber);
        assertEquals(1, climbing.getCount());
    }

    @Test
    public void testAddRockClimberThrows(){
        climbing.addRockClimber(mockRockClimber);
        climbing.addRockClimber(mockRockClimber2);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            climbing.addRockClimber(mockRockClimber3);
        });

        assertEquals("No more places for this climb!", exception.getMessage());
    }

    @Test
    public void testFullCapacityThrows(){
        climbing.addRockClimber(mockRockClimber);
        climbing.addRockClimber(mockRockClimber2);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
        {climbing.addRockClimber(mockRockClimber3);
        });

        assertEquals("No more places for this climb!", exception.getMessage());

    }

    @Test
    public void testExistingClimberThrows(){
        climbing.addRockClimber(mockRockClimber);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->{
            climbing.addRockClimber(mockRockClimber);
        });

        assertEquals(String.format("The climber %s is already in the climb!", mockRockClimber.getName()), exception.getMessage());

    }

    @Test
    public void testRemoveRockClimber(){
        climbing.addRockClimber(mockRockClimber);
        climbing.removeRockClimber("John");
        assertEquals(0, climbing.getCount());

    }





}

