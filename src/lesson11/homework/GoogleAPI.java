package lesson11.homework;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int n = getCountRooms(price,persons, city, hotel);
        return fillRoomArrays(n,price,persons, city, hotel);
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

    private int getCountRooms(int price, int persons, String city, String hotel){
        int k = 0;
        if(rooms != null) {
            for (Room room : rooms) {
                if(room != null) {
                    if (room.getPrice() == price &&
                            room.getPersons() == persons &&
                            room.getCityName() == city &&
                            room.getHotelName() == hotel) {
                        k++;
                    }
                }
            }
        }
        return k;
    }

    private Room[] fillRoomArrays(int n, int price, int persons, String city, String hotel){
        Room[] tempRooms = new Room[n];
        int i = 0;
        if(rooms != null) {
            for (Room room : rooms) {
                if(room != null) {
                    if (room.getPrice() == price &&
                            room.getPersons() == persons &&
                            room.getCityName() == city &&
                            room.getHotelName() == hotel) {
                        tempRooms[i] = room;
                        i++;
                    }
                }
            }
        }
        return tempRooms;
    }
}
