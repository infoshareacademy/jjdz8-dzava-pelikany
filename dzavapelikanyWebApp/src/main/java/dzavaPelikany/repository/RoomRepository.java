package dzavaPelikany.repository;

import dzavaPelikany.domain.Room;
import dzavaPelikany.domain.Rooms;
import dzavaPelikany.fileOperation.JsonReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoomRepository implements RoomRepositoryInterface{

    @Override
    public Optional<Room> findRoomByTenantLogin(String tenantLogin, String path) {
        Rooms rooms = JsonReader.create(new Rooms(), path);
        return Optional.ofNullable(rooms.getRoomsList()
                .stream()
                .filter(r->r.getTenantLogin().equals(tenantLogin))
                .findFirst()
                .orElse(null));
    }

    @Override
    public List<String> roomSearchByCity(String city, String path) {
        Rooms rooms = JsonReader.create(new Rooms(), path);
        return rooms.getRoomsList()
                .stream()
                .filter(r-> !r.isStatus() && r.getCity().equals(city))
                .map(r -> r.getCity() + " " + r.getStreetAndNumber() + " " +r.getArea() + " " +r.getPrice())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> roomSearchByCityAndPrice(String city, Double priceMin, Double priceMax, String path) {
        Rooms rooms = JsonReader.create(new Rooms(), path);
        return rooms.getRoomsList()
                .stream()
                .filter(r -> !r.isStatus() && r.getCity().equals(city) && r.getPrice()>=priceMin && r.getPrice() <= priceMax)
                .map(r -> r.getCity() + " " + r.getStreetAndNumber() + " " +r.getArea() + " " +r.getPrice())
                .collect(Collectors.toList());
    }


}

