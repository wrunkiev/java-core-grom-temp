package lesson36.service;

import lesson36.model.Hotel;
import lesson36.repository.HotelRepository;
import java.util.ArrayList;

public class HotelService {
    private HotelRepository hotelRepository = new HotelRepository();

    public ArrayList<Hotel> getHotels()throws Exception{
        validateHotel();

        ArrayList<Hotel> hotels = new ArrayList<>();
        ArrayList<String> hotelFields = new ArrayList<>();
        Hotel hotel;

        for(String sH : hotelRepository.readHotelsFromDb()){
            for (String sF : sH.split(",")){
                hotelFields.add(sF.trim());
            }

            hotel = new Hotel(Long.parseLong(hotelFields.get(0)),
                                hotelFields.get(1),
                                hotelFields.get(2),
                                hotelFields.get(3),
                                hotelFields.get(4));
            hotels.add(hotel);
            hotelFields.clear();
        }
        return hotels;
    }

    private void validateHotel()throws Exception{
        for(String sH : hotelRepository.readHotelsFromDb()){
            for (String sF : sH.split(",")){
                if(sF.trim().isEmpty())
                    throw new Exception("Exception in method 'validateHotel'. Data Base of Hotel is crashed");
            }
        }
    }

    private void validateNewHotel(Hotel hotel)throws Exception{
        for(Hotel h : getHotels()){
            if(h.equals(hotel)){
                throw new Exception("Exception in method 'validateNewHotel'. This hotel with ID: " + h.getId() + " is exist already");
            }
        }
    }

    public Hotel addHotel(Hotel hotel)throws Exception{
        validateNewHotel(hotel);
        return hotelRepository.addHotel(hotel);
    }

    public void deleteHotel(long hotelId)throws Exception{
        ArrayList<Hotel> hotels = getHotels();

        int index = 0;
        boolean flag = false;
        for(Hotel h : hotels){
            if(h.getId() == hotelId){
                flag = true;
                break;
            }
            index++;
        }

        if(!flag){
            throw new Exception("Exception in method 'deleteHotel'. Hotel with this ID: " + hotelId + " is not exist");
        }
        hotelRepository.deleteHotel(index);
    }
}
