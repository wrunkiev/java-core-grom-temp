package lesson36.service;

import lesson36.model.Filter;
import lesson36.model.Hotel;
import lesson36.model.Room;
import lesson36.repository.RoomRepository;

import java.text.SimpleDateFormat;
import java.util.*;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();
    private HotelService hotelService = new HotelService();

    private static void validateDate(Date date)throws Exception{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);

        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(day > 31){
                    throw new Exception("Exception in method 'validateDate'. In this month: " + month + " can't be more than 31 days");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(day > 30){
                    throw new Exception("Exception in method 'validateDate'. In this month: " + month + " can't be more than 30 days");
                }
                break;
            case 2:
                if(day > 28){
                    throw new Exception("Exception in method 'validateDate'. In this month: " + month + " can't be more than 28 days");
                }
                break;
            default:
                throw new Exception("Exception in method 'validateDate'. In year can't be more than 12 months");
        }
    }

    private void validateNewRoom(Room room)throws Exception{
        for(Room r : getRooms()){
            if(r.equals(room)){
                throw new Exception("Exception in method 'validateNewRoom'. This room with ID: " + r.getId() + " is exist already");
            }
        }
    }

    private void validateRoom()throws Exception{
        for(String sR : roomRepository.readRoomsFromDb()){
            for (String sF : sR.split(",")){
                if(sF.trim().isEmpty())
                    throw new Exception("Exception in method 'validateRoom'. Data Base of Room is crashed");
            }
        }
    }

    public ArrayList<Room> getRooms()throws Exception{
        validateRoom();
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<String> roomFields = new ArrayList<>();
        Room room;

        for(String sR : roomRepository.readRoomsFromDb()){
            for (String sF : sR.split(",")){
                roomFields.add(sF.trim());
            }

            room = new Room(Long.parseLong(roomFields.get(0)),
                    Integer.parseInt(roomFields.get(1)),
                    Double.parseDouble(roomFields.get(2)),
                    Boolean.parseBoolean(roomFields.get(3)),
                    Boolean.parseBoolean(roomFields.get(4)),
                    new SimpleDateFormat("dd-MM-yyyy").parse(roomFields.get(5)),
                    getHotel(Long.parseLong(roomFields.get(6))));
            rooms.add(room);
            roomFields.clear();
        }
        return rooms;
    }

    private Hotel getHotel(long hotelId)throws Exception{
        ArrayList<Hotel> hotels = hotelService.getHotels();
        for(Hotel h : hotels){
            if(h.getId() == hotelId){
                return h;
            }
        }
        throw new Exception("Exception in method 'getHotel'. Hotel with ID: " + hotelId + " is not exist");
    }

    public Room addRoom(Room room)throws Exception{
        Date date = room.getDateAvailableFrom();
        validateDate(date);
        validateNewRoom(room);
        return roomRepository.addRoom(room);
    }

    public void deleteRoom(long roomId)throws Exception{
        ArrayList<Room> rooms = getRooms();

        int index = 0;
        boolean flag = false;
        for(Room r : rooms){
            if(r.getId() == roomId){
                flag = true;
                break;
            }
            index++;
        }

        if(!flag){
            throw new Exception("Exception in method 'deleteRoom'. Room with this ID: " + roomId + " is not exist");
        }
        roomRepository.deleteRoom(index);
    }

    public Set<Room> findRooms(Filter filter)throws Exception{
        Set<Room> result = new HashSet<>();

        for(Room r : getRooms()){
            if(h.getName().equals(name)){
                return h;
            }
        }

        throw new Exception("Exception in method 'findHotelByName'. Hotel with this name: " + name + " is not exist");
    }
}
