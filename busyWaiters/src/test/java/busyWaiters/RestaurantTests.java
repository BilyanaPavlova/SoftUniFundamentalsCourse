package busyWaiters;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Place the cursor on the method you want to import statically.
//        Press Option + Enter (⌥ + ⏎).
//Select "Add static import for 'methodName'" from the suggestion list.
//This will add the necessary static import at the top of your file.

//десен бутон върху името на класа - генерейт - тест - създава ми тест класа

// да се изнасят хардкоднатите стойности в константи
// да се инициализират каквито и колкото обекти ни трябват в бефор метода
// и да се декларират извън бифор метода, за да бъдат достъпни за всички методи
//
// в judje се предава зипнатия фолдър на тест клсовете

// изнасяне на интерфейс:
// слагаме един клас да имплементира интерфейс
// и създаваме с десен бутон интерфейса
// после отиваваме в класа - десен бутн ввърху метод - рефактор - pull members up
// и си избираме какво да се изнесе в интерфейса

// кога да се използва интерфайс - когато имаме зависими един от друг класове
// и искаме да ги разделим
// създаваме интерфейси и в тестовете подаваме интерфейс - защо?
// защото в тестовете искаме да подаваме мокове!! - мокове са обекти, които са имплементирани от интерфейси
// и са създадени от нас, за да тестваме нашия код
// т.е. можем да подадем на класовете каквото си поискаме като параметър,
// дори и мок, а не реален обект, от който да е зависим
// инжектираме каквото си поискаме депендънси

// когато инициализираме обектите в тест класа,
//можем да ги инициализираме с анонимен клас,
//който имплементира интерфейса, който ни трябва
//и ги имплементира със стойности, които ни трябват
//това е мокване на обекти
//т.е. когато имаш дипендънсита, можеш да си направиш интерфейси за тях
// и да ги имплементираш в анонимни инстанции в тест класа

// тъпото е, че трябва да се имплементират всички методи на интерфейса
// но затова можем да ползваме mockito
// mockito - библиотека, която ни позволява да създаваме мокове

// маейвън репото - взимаме си дпендънсито на мокито, което се поддържа от джейунит
// и си го добавяме в проекта в пома
// мокито ни позволява да си създадем инстанция от някакъв тип (нтерфейс или клас няма значение)
// и да му мокнем методите, които са ни необходими

//конструкторите няма какво да се тестват, освен ако нямат някаква логика
// винаги тестваме методи, които имат разклонения в логиката си
public class RestaurantTests {

    @Test
    public void testRestaurant() {
        Restaurant restaurant = new Restaurant("Food", 20);
        assertEquals("Food", restaurant.getName());
        assertEquals(20, restaurant.getCapacity());
        assertEquals(0, restaurant.getCount());
    }

    @Test
    public void testGetWiters() {
        Restaurant restaurant = new Restaurant("Food", 20);
        assertNotNull(restaurant.getWaiters());
    }

    @Test
    public void testSetNameNullThrows(){
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new Restaurant(null, 20));
        assertEquals("Invalid client!", exception.getMessage());
    }

    @Test
    public void testSetNameEmptyThrows(){
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new Restaurant("", 20));
        assertEquals("Invalid client!", exception.getMessage());
    }

    @Test
    public  void testSetCapacityThrows() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Restaurant("Food", -1));
        assertEquals("Invalid capacity!", exception.getMessage());
    }

    @Test
    public void testAddFullTimeWaiter() {
        Restaurant restaurant = new Restaurant("Food", 20);
        FullTimeWaiter waiter = new FullTimeWaiter("John", 1000);
        restaurant.addFullTimeWaiter(waiter);
        assertEquals(1, restaurant.getCount());
    }

    @Test
    public void testAddFullTimeWaiterThrows() {
        Restaurant restaurant = new Restaurant("Food", 20);
        FullTimeWaiter waiter = new FullTimeWaiter("John", 1000);
        restaurant.addFullTimeWaiter(waiter);
        assertThrows(IllegalArgumentException.class, () -> restaurant.addFullTimeWaiter(waiter));
    }

    @Test
    public void testAddFullTimeWaiterThrowsNoMorePlaces() {
        Restaurant restaurant = new Restaurant("Food", 1);
        FullTimeWaiter waiter = new FullTimeWaiter("John", 1000);
        restaurant.addFullTimeWaiter(waiter);
        FullTimeWaiter waiter2 = new FullTimeWaiter("Peter", 1000);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> restaurant.addFullTimeWaiter(waiter2));
        assertEquals("No more places!", exception.getMessage());
    }

    //how to check the message of the exception thrown
    @Test
    public void testAddFullTimeWaiterThrowsNoMorePlacesMessage() {
        Restaurant restaurant = new Restaurant("Food", 1);
        FullTimeWaiter waiter = new FullTimeWaiter("John", 1000);
        restaurant.addFullTimeWaiter(waiter);
        FullTimeWaiter waiter2 = new FullTimeWaiter("Peter", 1000);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> restaurant.addFullTimeWaiter(waiter2));
        assertEquals("No more places!", exception.getMessage());
    }


    //check if waiter does not exist and we try to add him
    @Test
    public void testAddFullTimeWaiterThrowsWaiterExist() {
        Restaurant restaurant = new Restaurant("Food", 20);
        FullTimeWaiter waiter = new FullTimeWaiter("John", 1000);
        restaurant.addFullTimeWaiter(waiter);
        FullTimeWaiter waiter2 = new FullTimeWaiter("John", 1000);
        assertThrows(IllegalArgumentException.class, () -> restaurant.addFullTimeWaiter(waiter2));
    }



    @Test
    public void testRemoveFullTimeWaiter() {
        Restaurant restaurant = new Restaurant("Food", 20);
        FullTimeWaiter waiter = new FullTimeWaiter("John", 1000);
        restaurant.addFullTimeWaiter(waiter);
        assertTrue(restaurant.removeFullTimeWaiter("John"));
    }

    @Test
    public void testRemoveFullTimeWaiterReturnsFalse() {
        Restaurant restaurant = new Restaurant("Food", 20);
        FullTimeWaiter waiter = new FullTimeWaiter("John", 1000);
        restaurant.addFullTimeWaiter(waiter);
        assertFalse(restaurant.removeFullTimeWaiter("Peter"));
    }

    //check setCapacity of waiters
    @Test
    public void testSetCapacity() {
        Restaurant restaurant = new Restaurant("Food", 1);
        FullTimeWaiter waiter = new FullTimeWaiter("John", 1000);
        restaurant.addFullTimeWaiter(waiter);
        FullTimeWaiter waiter2 = new FullTimeWaiter("Peter", 1000);
        assertThrows(IllegalArgumentException.class, () -> restaurant.addFullTimeWaiter(waiter2));
    }




}
