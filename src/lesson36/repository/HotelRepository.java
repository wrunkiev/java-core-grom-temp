package lesson36.repository;

import lesson36.model.Hotel;
import java.io.*;
import java.util.ArrayList;

public class HotelRepository {
    private String path = "C:/Soft/Files/HotelDb.txt";

    private void validateHotelDb()throws Exception{
        File file = new File(path);
        if(!file.exists())
            throw new Exception("Exception in method 'validateHotelDb'. Access denied to data base of hotel");

        if(!file.canRead())
            throw new Exception("Exception in method 'validateHotelDb'. Can't read from data base of hotel");

        if(!file.canWrite())
            throw new Exception("Exception in method 'validateHotelDb'. Can't write to data base of hotel");
    }

    public ArrayList<String> readHotelsFromDb()throws Exception{
        validateHotelDb();
        ArrayList<String> res = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                res.add(line);
            }
        }catch (IOException e){
            System.err.println("Exception in method 'readHotelsFromDb'. Reading from file " + path + " failed");
        }
        return res;
    }

    public Hotel addHotel(Hotel hotel)throws Exception{
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))){
            if(readHotelsFromDb().size() == 0)
                bufferedWriter.append(hotel.toString());
            else{
                bufferedWriter.append("\n");
                bufferedWriter.append(hotel.toString());
            }
        }catch (IOException e){
            System.err.println("Exception in method 'addHotel'. Can't write to file " + path);
        }
        return hotel;
    }

    public void deleteHotel(int hotelId)throws Exception{
        ArrayList<String> hotels = readHotelsFromDb();

        hotels.remove(hotelId);

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            int index = 1;
            for(String h : hotels){
                if(hotels.size() == index){
                    bufferedWriter.append(h);
                }else {
                    bufferedWriter.append(h);
                    bufferedWriter.append("\n");
                }
                index++;
            }
        }catch (IOException e){
            System.err.println("Exception in method 'deleteHotel'. Can't write to file " + path);
        }
    }
}
