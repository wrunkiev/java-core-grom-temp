package lesson36.controller;

import lesson36.model.Room;
import lesson36.service.RoomService;

public class RoomController {
    private RoomService roomService = new RoomService();

    /*private void validateRoom(Room room)throws Exception{
        if(room == null)
            throw new Exception("Exception in method 'validateRoom'. Room can't be null");

        if(room.getNumberOfGuests() <= 0)
            throw new Exception("Exception in method 'validateRoom'. Number of Guests in room can't be empty");

        if(room.getPrice() <= 0)
            throw new Exception("Exception in method 'validateRoom'. Price of room can't be empty");

        if(room.isBreakfastIncluded() != true && room.isBreakfastIncluded() != false)
            throw new Exception("Exception in method 'validateRoom'. Field 'BreakfastIncluded' can't be empty or null");

        if(room.isPetsAllowed() != true && room.isPetsAllowed() != false)
            throw new Exception("Exception in method 'validateRoom'. Field 'PetsAllowed' can't be empty or null");

        if(room.getDateAvailableFrom() == null)
            throw new Exception("Exception in method 'validateRoom'. Field 'DateAvailableFrom' can't be empty or null");

        if(room.getHotel() == null)
            throw new Exception("Exception in method 'validateRoom'. ID Hotel in room can't be empty or null");
    }

    public Room addRoom(Room room)throws Exception{
        validateRoom(room);
        return roomService.addRoom(room);
    }

    public void deleteRoom(long roomId)throws Exception{
        roomService.deleteRoom(roomId);
    }*/
}
