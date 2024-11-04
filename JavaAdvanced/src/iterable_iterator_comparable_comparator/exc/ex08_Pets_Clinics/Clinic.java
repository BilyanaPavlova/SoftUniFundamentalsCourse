package iterable_iterator_comparable_comparator.exc.ex08_Pets_Clinics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Clinic implements Iterable<Room> {
    private String name;
    private Room[] rooms;

    public Clinic(String name, int roomsCount) {
        // check if the rooms count is even
        if(roomsCount % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.name = name;
        this.rooms = new Room[roomsCount];
        for (int i = 0; i < roomsCount; i++) {
            this.rooms[i] = new Room();
        }
    }

    private class RoomIterator implements Iterator<Room> {
        int[] order;
        int index = 0;

        public RoomIterator() {
            int center = rooms.length / 2;
            order = new int[rooms.length];
            order[0] = center;
            for (int i = 1; i < rooms.length; i++) {
                if (i % 2 != 0) {
                    center -= i;
                } else {
                    center += i;
                }
                order[i] = center;
            }
        }

        @Override
        public boolean hasNext() {
            while (index < order.length) {
                if (!rooms[order[index]].isOccupied()) {
                    return true;
                }
                index++;
            }
            return false;
        }

        @Override
        public Room next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return rooms[order[index++]];
        }
    }
    // existing methods...

    // iterator for adding pet

    @Override
    public Iterator<Room> iterator() {
        return new RoomIterator();
    }

    public boolean addPet(Pet pet) {

        if (pet == null) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        Iterator<Room> roomIterator = this.iterator();
        if (roomIterator.hasNext()) {
            Room room = roomIterator.next();
            room.occupy(pet);
            return true;
        }
        return false;
    }

    // iterator for releasing pets
    public Iterator<Room> getReleaseIterator() {
        return new ReleaseIterator();
    }

        private class ReleaseIterator implements Iterator<Room> { // The ReleaseIterator class is a generic class
            int index = rooms.length / 2;
            boolean hasLooped = false;

            @Override
            public boolean hasNext() {
                return (index < rooms.length && rooms[index].isOccupied()) ||
                        (!hasLooped && index < rooms.length / 2 && rooms[index].isOccupied());
            }

            @Override
            public Room next() {
                // Check from the middle room to the end of the rooms array for an occupied room
                while (index < rooms.length) {
                    if (rooms[index].isOccupied()) {
                        return rooms[index++];
                    }
                    index++;
                }

                // If no occupied room is found, start from the beginning and check until the middle room for an occupied room
                if (!hasLooped) {
                    index = 0;
                    hasLooped = true;
                    while (index < rooms.length / 2) {
                        if (rooms[index].isOccupied()) {
                            return rooms[index++];
                        }
                        index++;
                    }
                }

                // If no occupied room is found, throw a NoSuchElementException
                throw new NoSuchElementException();
            }
        };



    public boolean releasePet() {
        Iterator<Room> roomIterator = this.getReleaseIterator();
        if (roomIterator.hasNext()) {
            Room room = roomIterator.next();
            room.release();  // Release the pet
            return true;
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (Room room : rooms) {
            if (room.isOccupied()) {
                System.out.println(room.getPet());
            } else {
                System.out.println("Room empty");
            }
        }
    }

    public void print(int roomNumber) {
        Room room = rooms[roomNumber - 1];
        if (room.isOccupied()) {
            System.out.println(room.getPet());
        } else {
            System.out.println("Room empty");
        }
    }
}


