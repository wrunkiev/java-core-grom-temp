package lesson15.homework2;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }
    // requestRooms
    public Room[] requestRooms(int price, int persons, String city, String hotel){
        int n = getCountRooms(price, persons, city, hotel) + 1;
        return fillRoomArrays(n, price, persons, city, hotel);
    }

    private int getCountRooms(int price, int persons, String city, String hotel){
        int s = 0;
        if(apis != null) {
            for (API api : apis) {
                if (api != null) {
                    s = api.findRooms(price, persons, city, hotel).length;
                    s += s;
                }
            }
        }
        return s;
    }

    private Room[] fillRoomArrays(int n, int price, int persons, String city, String hotel){
        Room[] tempRooms = new Room[n];
        int i = 0;
        if(apis != null) {
            for (API api : apis) {
                if (api != null) {
                    for (Room room : api.findRooms(price, persons, city, hotel)) {
                        tempRooms[i] = room;
                        i++;
                    }
                }
            }
        }
        return tempRooms;
    }

    // check
    public Room[] check(API api1, API api2){
        int n = getCountRooms(api1, api2);
        return fillRoomArray(n, api1,api2);
    }

    private int getCountRooms(API api1, API api2){
        int n = 0;
        if(api1 != null && api2 != null){
            if(api1.getAll().length >= api2.getAll().length){
                for (int i = 0; i < api1.getAll().length; i++) {
                    for (int k = 0; k < api2.getAll().length; k++) {
                        if(api1.getAll()[i] != null && api2.getAll()[k] != null) {
                            if (api1.getAll()[i].getPrice() == api2.getAll()[k].getPrice() &&
                                    api1.getAll()[i].getPersons() == api2.getAll()[k].getPersons() &&
                                    api1.getAll()[i].getHotelName() == api2.getAll()[k].getHotelName() &&
                                    api1.getAll()[i].getCityName() == api2.getAll()[k].getCityName()) {
                                n++;
                            }
                        }
                    }
                }
            }
            else {
                for (int i = 0; i < api2.getAll().length; i++) {
                    for (int k = 0; k < api1.getAll().length; k++) {
                        if(api1.getAll()[k] != null && api2.getAll()[i] != null) {
                            if (api1.getAll()[k].getPrice() == api2.getAll()[i].getPrice() &&
                                    api1.getAll()[k].getPersons() == api2.getAll()[i].getPersons() &&
                                    api1.getAll()[k].getHotelName() == api2.getAll()[i].getHotelName() &&
                                    api1.getAll()[k].getCityName() == api2.getAll()[i].getCityName()) {
                                n++;
                            }
                        }
                    }
                }
            }
        }
        return n;
    }

    private Room[] fillRoomArray(int n, API api1, API api2){
        Room[] resRooms = new Room[n];
        if(api1 != null && api2 != null) {
            if (api1.getAll().length >= api2.getAll().length) {
                for (int i = 0; i < api1.getAll().length; i++) {
                    for (int k = 0; k < api2.getAll().length; k++) {
                        if(api1.getAll()[i] != null && api2.getAll()[k] != null) {
                            if (api1.getAll()[i].getPrice() == api2.getAll()[k].getPrice() &&
                                    api1.getAll()[i].getPersons() == api2.getAll()[k].getPersons() &&
                                    api1.getAll()[i].getHotelName() == api2.getAll()[k].getHotelName() &&
                                    api1.getAll()[i].getCityName() == api2.getAll()[k].getCityName()) {
                                for(int m = 0; m < n; m++){
                                    resRooms[m] = api1.getAll()[i];
                                }
                            }
                        }
                    }

                }
            } else {
                for (int i = 0; i < api2.getAll().length; i++) {
                    for (int k = 0; k < api1.getAll().length; k++) {
                        if(api1.getAll()[k] != null && api2.getAll()[i] != null) {
                            if (api1.getAll()[k].getPrice() == api2.getAll()[i].getPrice() &&
                                    api1.getAll()[k].getPersons() == api2.getAll()[i].getPersons() &&
                                    api1.getAll()[k].getHotelName() == api2.getAll()[i].getHotelName() &&
                                    api1.getAll()[k].getCityName() == api2.getAll()[i].getCityName()) {
                                for(int m = 0; m < n; m++){
                                    resRooms[m] = api1.getAll()[i];
                                }
                            }
                        }
                    }

                }
            }
        }
        return resRooms;
    }

    //cheapestRoom
    public Room cheapestRoom(){
        Room resRoom = null;
        int minPrice;
        if(apis != null && apis[0].getAll()[0] != null){
            minPrice = apis[0].getAll()[0].getPrice();
            for (API api : apis){
                if(api != null){
                    for(int i = 0; i < api.getAll().length; i++){
                        if(api.getAll()[i] != null) {
                            if (api.getAll()[i].getPrice() < minPrice) {
                                minPrice = api.getAll()[i].getPrice();
                                resRoom = api.getAll()[i];
                            }
                        }
                    }
                }
            }
            return resRoom;
        }
        else {
            return null;
        }
    }
}
