package dzavaPelikany.servlets;

import dzavaPelikany.freemarker.TemplateProvider;
import dzavaPelikany.service.RoomService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/tenant-room")
public class TenantRoomServlet extends HttpServlet {

    @Inject
    private RoomService roomService;
    @Inject
    private HttpSession httpSession;
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tenantLogin = (String) httpSession.getAttribute("login");
        String path = getServletContext().getRealPath("WEB-INF/resources/rooms.json");

        HashMap<String,String> dataModel = new HashMap<>();

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();
        if (roomService.findRoomByTenantLogin(tenantLogin,path) == null) {
            String msg = "W tej chwili, nie wynajmujesz pokoju";
            dataModel.put("msg",msg);
        }
        else {
            dataModel.put("city",roomService.findRoomByTenantLogin(tenantLogin,path).getCity());
            dataModel.put("address",roomService.findRoomByTenantLogin(tenantLogin,path).getStreetAndNumber());
            dataModel.put("date",roomService.findRoomByTenantLogin(tenantLogin,path).getRegistrationTerm());
            dataModel.put("price",Double.toString(roomService.findRoomByTenantLogin(tenantLogin,path).getPrice()));
        }
        Template template = templateProvider.getTemplate(getServletContext(), "tenant-room.ftlh");

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
