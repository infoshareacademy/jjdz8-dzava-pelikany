package dzavaPelikany.servlets;

import dzavaPelikany.domain.Room;
import dzavaPelikany.domain.Rooms;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;
import dzavaPelikany.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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


@WebServlet("/owner-edit-room")
public class OwnerEditRoomServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Room> rooms = JsonReader.create(new Rooms(), getServletContext().getRealPath(ROOMS_JSONWEB)).getRoomsList();
        Room editedRoom = rooms.stream().filter(room -> room.getId().toString().equals(request.getParameter("editRoomId"))).collect(Collectors.toCollection(ArrayList::new)).get(0);
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("editedRoom", editedRoom);


        Template template = templateProvider.getTemplate(getServletContext(), "owner-edit-room.ftlh");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Rooms rooms = JsonReader.create(new Rooms(), getServletContext().getRealPath(ROOMS_JSONWEB));
        Room editedRoom = rooms.getRoomsList().stream().filter(room -> room.getId().toString().equals(req.getParameter("id"))).collect(Collectors.toCollection(ArrayList::new)).get(0);
        editedRoom.setRoomLogin(req.getParameter("roomLogin"));
        editedRoom.setStreetAndNumber(req.getParameter("streetAndNumber"));
        editedRoom.setCity(req.getParameter("city"));
        editedRoom.setArea(Integer.parseInt(req.getParameter("area")));
        editedRoom.setPrice(Double.parseDouble(req.getParameter("price")));
        JsonSaver.makeJson(rooms, getServletContext().getRealPath(ROOMS_JSONWEB));


    }
}