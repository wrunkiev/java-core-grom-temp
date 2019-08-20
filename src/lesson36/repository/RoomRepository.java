package lesson36.repository;

import lesson36.model.Hotel;
import lesson36.model.Room;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class RoomRepository {
    private static String path = "C:/Soft/Files/RoomDb.txt";

    /*private static void validateRoomDb()throws Exception{
        File file = new File(path);

        if(!file.exists())
            throw new Exception("Exception in method 'validateRoomDb'. Access denied to data base of room");

        if(!file.canRead())
            throw new Exception("Exception in method 'validateRoomDb'. Can't read from data base of room");

        if(!file.canWrite())
            throw new Exception("Exception in method 'validateRoomDb'. Can't write to data base of room");
    }

    private static ArrayList<String> readRoomsFromDb()throws Exception{
        validateRoomDb();
        ArrayList<String> res = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                res.add(line);
            }
        }catch (IOException e){
            System.err.println("Exception in method 'readRoomsFromDb'. Reading from file " + path + " failed");
        }
        return res;
    }

    private static void validateRoomInDb()throws Exception{
        for(String sR : readRoomsFromDb()){
            for (String sF : sR.split(",")){
                if(sF.trim().isEmpty())
                    throw new Exception("Exception in method 'validateRoomInDb'. Data Base of Room is crashed");
            }
        }
    }

    private static ArrayList<Room> getRoomAll()throws Exception{
        validateRoomInDb();
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<String> roomFields = new ArrayList<>();
        Room room;

        for(String sR : readRoomsFromDb()){
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

    *//*private static Hotel getHotel(long hotelId)throws Exception{
        ArrayList<Hotel> hotels = HotelRepository.getHotelAll();
        for(Hotel h : hotels){
            if(h.getId() == hotelId){
                return h;
            }
        }
        throw new Exception("Exception in method 'getHotel'. Hotel with ID: " + hotelId + " is not exist");
    }*//*

    private static void validateNewRoom(Room room)throws Exception{
        for(Room r : getRoomAll()){
            if(r.equals(room)){
                throw new Exception("Exception in method 'validateNewRoom'. This room with ID: " + r.getId() + " is exist already");
            }
        }
    }

    public static long genIdRoom()throws Exception{
        Random random = new Random();
        boolean flag;
        long id;

        do{
            flag = true;
            id = random.nextInt();
            for(Room r : getRoomAll()){
                if(r.getId() == id || id < 0){
                    flag = false;
                }
            }
        }while (!flag);
        return id;
    }

    public Room addRoom(Room room)throws Exception{
        validateNewRoom(room);

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))){
            if(getRoomAll().size() == 0)
                bufferedWriter.append(room.toString());
            else{
                bufferedWriter.append("\n");
                bufferedWriter.append(room.toString());
            }
        }catch (IOException e){
            System.err.println("Exception in method 'addRoom'. Can't write to file " + path);
        }
        return room;
    }


    public void deleteRoom(long roomId)throws Exception{
        ArrayList<Room> rooms = getRoomAll();

        int index = 0;
        boolean flag = false;
        for(Room r : rooms){
            if(r.getId() == roomId){
                flag = true;
                break;
            }
            index++;
        }

        if(flag){
            rooms.remove(index);
        }

        if(rooms.size() == getRoomAll().size())
            throw new Exception("Exception in method 'deleteRoom'. Room with this ID: " + roomId + " is not exist in DB");

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            index = 1;
            for(Room r : rooms){
                if(rooms.size() == index){
                    bufferedWriter.append(r.toString());
                }else {
                    bufferedWriter.append(r.toString());
                    bufferedWriter.append("\n");
                }
                index++;
            }
        }catch (IOException e){
            System.err.println("Exception in method 'deleteRoom'. Can't write to file " + path);
        }
    }*/
}
