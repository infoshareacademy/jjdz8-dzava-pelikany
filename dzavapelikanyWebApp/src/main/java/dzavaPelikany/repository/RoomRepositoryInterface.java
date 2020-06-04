package dzavaPelikany.repository;

import dzavaPelikany.domain.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface RoomRepositoryInterface {

    Optional<Room> findRoomByTenantLogin(String tenantLogin, String path);
    List<String> roomSearchByCity(String city, String path);
    List<String> roomSearchByCityAndPrice(String city, Double priceMin, Double priceMax, String path);
 }
