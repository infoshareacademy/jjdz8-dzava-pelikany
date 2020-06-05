package dzavaPelikany.servlets;

import com.google.gson.Gson;
import dzavaPelikany.domain.Room;
import dzavaPelikany.domain.Rooms;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;
import dzavaPelikany.freemarker.TemplateProvider;
import dzavaPelikany.service.RoomRegistrationService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static dzavaPelikany.fileOperation.FilesNames.OWNERS_JSONWEB;
import static dzavaPelikany.fileOperation.FilesNames.ROOMS_JSONWEB;


@WebServlet("/owner-rooms")
public class OwnerDisplayRoomsServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "owner-display-rooms-screen.ftlh");


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();

        List<Room> rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB).getRoomsList();
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("rooms", rooms);

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Rooms rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB);
        Optional<Room> roomToRemove = Optional.empty();
        for (Room room : rooms.getRoomsList()) {
            if (room.getRoomLogin().equals(req.getParameter("roomid"))) {
                roomToRemove = Optional.of(room);
            }
        }
                rooms.getRoomsList().remove(roomToRemove.get());
                JsonSaver.makeJson(rooms, ROOMS_JSONWEB);
            }
        }

