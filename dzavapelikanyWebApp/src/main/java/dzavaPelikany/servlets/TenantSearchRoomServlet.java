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
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@WebServlet("/tenant-search-room")
public class TenantSearchRoomServlet extends HttpServlet {

    @Inject
    private RoomService roomService;
    
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "tenant-search-room.ftlh");

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

        double priceMin = Double.parseDouble(req.getParameter("price-min"));
        double priceMax = Double.parseDouble(req.getParameter("price-max"));
        String city = req.getParameter("city");
        List<String> availableRooms;
        String path = getServletContext().getRealPath("/WEB-INF/resources/rooms.json");
        HashMap<String,List<String>> dataModel = new HashMap<>();
        List<String> msg = Arrays.asList("Nie znalezinono wyniku o danych kryteriach");
        if (priceMin == 0 && priceMax == 0) availableRooms = roomService.roomSearchByCity(city,path);
        else if (priceMin > priceMax) availableRooms = roomService.roomSearchByCityAnPrice(city,priceMin,100000.0,path);
        else availableRooms=roomService.roomSearchByCityAnPrice(city,priceMin,priceMax,path);

        if (!availableRooms.isEmpty()) dataModel.put("room", availableRooms);
        else dataModel.put("msg",msg);
        Template template = templateProvider.getTemplate(getServletContext(), "tenant-search-room.ftlh");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }



    }
}
