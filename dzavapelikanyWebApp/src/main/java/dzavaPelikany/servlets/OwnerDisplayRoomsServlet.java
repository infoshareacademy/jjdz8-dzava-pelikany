package dzavaPelikany.servlets;

import dzavaPelikany.domain.Room;
import dzavaPelikany.domain.Rooms;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;
import dzavaPelikany.freemarker.TemplateProvider;
import dzavaPelikany.oauth.GoogleLogoutServlet;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

import static dzavaPelikany.fileOperation.FilesNames.ROOMS_JSONWEB;


@WebServlet("/owner-rooms")
public class OwnerDisplayRoomsServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(OwnerDisplayRoomsServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "owner-display-rooms.ftlh");


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();


        Optional<List<Room>> freeRooms = Optional.of(JsonReader.create(new Rooms(), getServletContext().getRealPath(ROOMS_JSONWEB)).getRoomsList().stream().filter(room -> !room.isStatus()).collect(Collectors.toCollection(ArrayList::new)));
        Optional<List<Room>> rentedRooms = Optional.of(JsonReader.create(new Rooms(), getServletContext().getRealPath(ROOMS_JSONWEB)).getRoomsList().stream().filter(Room::isStatus).collect(Collectors.toCollection(ArrayList::new)));
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("freerooms", freeRooms.get());
        dataModel.put("rentedrooms", rentedRooms.get());

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Rooms rooms = JsonReader.create(new Rooms(), getServletContext().getRealPath(ROOMS_JSONWEB));
        Optional<Room> roomToRemove = Optional.empty();
        for (Room room : rooms.getRoomsList()) {
            if (room.getRoomLogin().equals(req.getParameter("roomid"))) {
                roomToRemove = Optional.of(room);
            }
        }
        rooms.getRoomsList().remove(roomToRemove.get());
        JsonSaver.makeJson(rooms,getServletContext().getRealPath(ROOMS_JSONWEB));
        LOGGER.info("room deleted: " + roomToRemove);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Rooms rooms = JsonReader.create(new Rooms(), getServletContext().getRealPath(ROOMS_JSONWEB));
        Room editedRoom = rooms.getRoomsList().stream().filter(room -> room.getId().toString().equals(req.getParameter("rentRoomId"))).collect(Collectors.toCollection(ArrayList::new)).get(0);
        if(editedRoom.isStatus()){
            editedRoom.setStatus(false);
            editedRoom.setRegistrationTerm("brak");
            editedRoom.setTenantLogin("brak");
        }
        JsonSaver.makeJson(rooms, getServletContext().getRealPath(ROOMS_JSONWEB));
        LOGGER.info("room edited: " + editedRoom);
    }
}