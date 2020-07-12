package dzavaPelikany.service;

import dzavaPelikany.domain.Room;
import dzavaPelikany.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped

public class RoomService {


    private RoomRepository roomRepository = new RoomRepository();

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomService.class.getName());

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
