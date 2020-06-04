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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/tenant-menu")
public class TenantMenuServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private HttpSession httpSession;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "tenant-menu-screen.ftlh");

        response.setContentType("text/html;charset=UTF-8");
        HashMap<String,String> dataModel = new HashMap<>();
        dataModel.put("name", (String)httpSession.getAttribute("name"));
        PrintWriter printWriter = response.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
