package dzavaPelikany.servlets;

import dzavaPelikany.domain.Room;
import dzavaPelikany.domain.Rooms;
import dzavaPelikany.domain.Tenant;
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
import java.util.HashMap;
import java.util.UUID;

import static dzavaPelikany.fileOperation.FilesNames.ROOMS_JSONWEB;


@WebServlet("/owner-add-room")
public class OwnerAddRoomServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RoomCreatorService roomCreatorService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "owner-add-room.ftlh");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();
        try {
            template.process(new HashMap<String, Object>(), printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Rooms rooms = JsonReader.create(new Rooms(), getServletContext().getRealPath(ROOMS_JSONWEB));
        Integer area = Integer.parseInt(req.getParameter("area"));
        Double price = Double.parseDouble(req.getParameter("price"));
        Room newRoom = roomCreatorService.createRoom(req.getParameter("roomLogin"), req.getParameter("streetAndNumber"), req.getParameter("city"), area, price);
        rooms.addRoom(newRoom);
        JsonSaver.makeJson(rooms, getServletContext().getRealPath(ROOMS_JSONWEB));

        Template template = templateProvider.getTemplate(getServletContext(), "owner-add-room.ftlh");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(new HashMap<String, Object>(), printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
