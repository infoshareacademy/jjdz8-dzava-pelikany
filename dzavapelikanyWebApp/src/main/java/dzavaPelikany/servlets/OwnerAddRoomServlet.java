package dzavaPelikany.servlets;

import dzavaPelikany.domain.Room;
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


@WebServlet("/owner-add-room")
public class OwnerAddRoomServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RoomCreatorService roomCreatorService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "owner-add-room-screen.ftlh");

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


        Byte area = Byte.parseByte(req.getParameter("area"));
        Room newRoom = roomCreatorService.createRoom(req.getParameter("roomLogin"), req.getParameter("streetAndNumber"), req.getParameter("city"), area);
        roomCreatorService.saveRoom(newRoom);

        Template template = templateProvider.getTemplate(getServletContext(), "owner-add-room-screen.ftlh");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(new HashMap<String, Object>(), printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
