package dzavaPelikany.repository;

import dzavaPelikany.domain.Room;
import dzavaPelikany.domain.Rooms;
import dzavaPelikany.fileOperation.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RoomRepository implements RoomRepositoryInterface{

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomRepository.class.getName());

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
        AtomicInteger i = new AtomicInteger(1);
        return rooms.getRoomsList()
                .stream()
                .filter(r-> !r.isStatus() && r.getCity().equals(city))
                .map(r -> i.getAndIncrement() + ". " + r.getStreetAndNumber() + " Powierzchnia: " +r.getArea() + "m²" + " Cena: " +r.getPrice() + "zł")
                .collect(Collectors.toList());
    }

    @Override
    public List<String> roomSearchByCityAndPrice(String city, Double priceMin, Double priceMax, String path) {
        Rooms rooms = JsonReader.create(new Rooms(), path);
        AtomicInteger i = new AtomicInteger(1);
        return rooms.getRoomsList()
                .stream()
                .filter(r -> !r.isStatus() && r.getCity().equals(city) && r.getPrice()>=priceMin && r.getPrice() <= priceMax)
                .map(r -> i.getAndIncrement() + ". " + r.getStreetAndNumber() +" Powierzchnia: " +r.getArea() + "m²" + " Cena: " +r.getPrice() +"zł")
                .collect(Collectors.toList());
    }


}

