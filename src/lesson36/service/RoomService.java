package lesson36.service;

import lesson36.model.Room;
import lesson36.repository.RoomRepository;
import java.util.Calendar;
import java.util.Date;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();

    /*private static void validateDate(Date date)throws Exception{
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

    public Room addRoom(Room room)throws Exception{
        Date date = room.getDateAvailableFrom();
        validateDate(date);
        return roomRepository.addRoom(room);
    }

    public void deleteRoom(long roomId)throws Exception{
        roomRepository.deleteRoom(roomId);
    }*/
}
