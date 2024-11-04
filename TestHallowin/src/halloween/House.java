package halloween;

import java.util.LinkedList;
import java.util.List;

public class House {


        List<Kid> data;
        int capacity;

        public House(int capacity) {
            this.data = new LinkedList<>();
            this.capacity = capacity;
        }

        public  void addKid(Kid kid) {
            if (this.data.size() < capacity ) {
                data.add(kid);
            }
        }

        public boolean removeKid(String name) {
            return data.removeIf(k -> k.getName().equals(name));
        }

        public Kid getKid(String street) {
            return data.stream().filter(k -> k.getStreet().equals(street))
                    .findFirst()
                    .orElse(null);
        }

        public int getAllKids() {
            return this.data.size();
        }

        public String getStatistics() {
            StringBuilder sb = new StringBuilder("Children who visited a house for candy:");
            sb.append(System.lineSeparator());
            this.data.forEach(k -> sb.append(k.getName()).append(" from ").append(k.getStreet()).append(" street").append(System.lineSeparator()));

            return sb.toString();
        }

    }



