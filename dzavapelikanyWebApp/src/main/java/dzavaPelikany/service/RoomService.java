package dzavaPelikany.service;

import dzavaPelikany.domain.Room;
import dzavaPelikany.repository.RoomRepository;

import java.util.List;


public class RoomService {

    private RoomRepository roomRepository = new RoomRepository();

    public Room findRoomByTenantLogin(String tenantLogin, String path){
        return roomRepository.findRoomByTenantLogin(tenantLogin,path).orElse(null);
    }

    public List<String> roomSearchByCity(String city, String path){
        return roomRepository.roomSearchByCity(city, path);
    }

    public List<String> roomSearchByCityAnPrice(String city, Double priceMin, Double priceMax, String path){
        return  roomRepository.roomSearchByCityAndPrice(city,priceMin,priceMax,path);
    }

}
