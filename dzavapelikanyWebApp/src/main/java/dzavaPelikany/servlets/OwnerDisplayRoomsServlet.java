package dzavaPelikany.servlets;

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
import java.util.HashMap;
import java.util.Map;


@WebServlet("/owner-rooms")
public class OwnerDisplayRoomsServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "owner-display-rooms-screen.ftlh");

        response.setContentType("text/html;charset=UTF-8");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("ownerName", "Pawel");

        PrintWriter printWriter = response.getWriter();
        try {
            template.process(dataModel,  printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
