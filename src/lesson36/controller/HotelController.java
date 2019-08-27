package lesson36.controller;

import lesson36.model.Hotel;
import lesson36.service.HotelService;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class HotelController {
    private HotelService hotelService = new HotelService();

    private void validateHotel(Hotel hotel)throws Exception{
        if(hotel == null)
            throw new Exception("Exception in method 'validateHotel'. Hotel can't be null");

        if(hotel.getName() == null || hotel.getName().isEmpty())
            throw new Exception("Exception in method 'validateHotel'. Name of hotel can't be empty or null");

        if(hotel.getCountry() == null || hotel.getCountry().isEmpty())
            throw new Exception("Exception in method 'validateHotel'. Country of hotel can't be empty or null");

        if(hotel.getCity() == null || hotel.getCity().isEmpty())
            throw new Exception("Exception in method 'validateHotel'. City of hotel can't be empty or null");

        if(hotel.getStreet() == null || hotel.getStreet().isEmpty())
            throw new Exception("Exception in method 'validateHotel'. Street of hotel can't be empty or null");
    }

    public long genIdHotel()throws Exception{
        Random random = new Random();
        boolean flag;
        long id;

        do{
            flag = true;
            id = random.nextInt();
            for(Hotel h : hotelService.getHotels()){
                if(h.getId() == id || id < 0){
                    flag = false;
                }
            }
        }while (!flag);
        return id;
    }

    // method adds hotel to base
    public Hotel addHotel(Hotel hotel)throws Exception{
        validateHotel(hotel);
        return hotelService.addHotel(hotel);
    }

    // method deletes hotel from base
    public void deleteHotel(long hotelId)throws Exception{
        hotelService.deleteHotel(hotelId);
    }

    // method finds hotels by name in to base
    public Set<Hotel> findHotelByName(String name)throws Exception{
        if(name == null || name.equals(""))
            throw new Exception("Exception in method 'findHotelByName'. Name of hotel can't be null or empty");

        return hotelService.findHotelByName(name);
    }

    // method finds hotels by city in to base
    public Set<Hotel> findHotelByCity(String city)throws Exception{
        if(city == null || city.equals(""))
            throw new Exception("Exception in method 'findHotelByCity'. Name of city of hotel can't be null or empty");

        return hotelService.findHotelByCity(city);
    }
}
