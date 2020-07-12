package dzavaPelikany.servlets;

import dzavaPelikany.domain.Room;
import dzavaPelikany.domain.Rooms;
import dzavaPelikany.domain.Tenant;
import dzavaPelikany.domain.Tenants;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;
import dzavaPelikany.freemarker.TemplateProvider;
import dzavaPelikany.service.RoomCreatorService;
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
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static dzavaPelikany.fileOperation.FilesNames.ROOMS_JSONWEB;
import static dzavaPelikany.fileOperation.FilesNames.TENANTS_JSONWEB;


@WebServlet("/owner-rent-room")
public class OwnerRentRoomServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Tenant> tenants = JsonReader.create(new Tenants(), getServletContext().getRealPath(TENANTS_JSONWEB)).getTenantsList();
        List<Room> rooms = JsonReader.create(new Rooms(), getServletContext().getRealPath(ROOMS_JSONWEB)).getRoomsList();
        Room rentedRoom = rooms.stream().filter(room -> room.getId().toString().equals(request.getParameter("rentRoomId"))).collect(Collectors.toCollection(ArrayList::new)).get(0);

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("rentedRoom", rentedRoom);
        dataModel.put("tenants", tenants);


        Template template = templateProvider.getTemplate(getServletContext(), "owner-rent-room.ftlh");

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
        editedRoom.setRegistrationTerm(req.getParameter("roomTerm"));
        editedRoom.setTenantLogin(req.getParameter("tenant"));
        editedRoom.setStatus(true);
        JsonSaver.makeJson(rooms, getServletContext().getRealPath(ROOMS_JSONWEB));


    }
}