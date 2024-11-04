package stuntClimb;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ClimbingTests {

    Climbing climbing;

    @Mock
    RockClimber mockRockClimber;
    RockClimber mockRockClimber2;
    RockClimber mockRockClimber3;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        climbing = new Climbing("Musala", 2);
        mockRockClimber = mock(RockClimber.class);
        when(mockRockClimber.getName()).thenReturn("John");
        mockRockClimber2 = mock(RockClimber.class);
        when(mockRockClimber2.getName()).thenReturn("Bili");
        mockRockClimber3 = mock(RockClimber.class);
        when(mockRockClimber3.getName()).thenReturn("Ilian");
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
