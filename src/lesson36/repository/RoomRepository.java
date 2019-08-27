package lesson36.repository;

import lesson36.model.Room;
import java.io.*;
import java.util.ArrayList;

public class RoomRepository {
    private String path = "C:/Soft/Files/RoomDb.txt";

    private void validateRoomDb()throws Exception{
        File file = new File(path);

        if(!file.exists())
            throw new Exception("Exception in method 'validateRoomDb'. Access denied to data base of room");

        if(!file.canRead())
            throw new Exception("Exception in method 'validateRoomDb'. Can't read from data base of room");

        if(!file.canWrite())
            throw new Exception("Exception in method 'validateRoomDb'. Can't write to data base of room");
    }

    public ArrayList<String> readRoomsFromDb()throws Exception{
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

    public Room addRoom(Room room)throws Exception{
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))){
            if(readRoomsFromDb().size() == 0)
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

    public void deleteRoom(int roomId)throws Exception{
        ArrayList<String> rooms = readRoomsFromDb();

        rooms.remove(roomId);

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            int index = 1;
            for(String r : rooms){
                if(rooms.size() == index){
                    bufferedWriter.append(r);
                }else {
                    bufferedWriter.append(r);
                    bufferedWriter.append("\n");
                }
                index++;
            }
        }catch (IOException e){
            System.err.println("Exception in method 'deleteRoom'. Can't write to file " + path);
        }
    }
}
