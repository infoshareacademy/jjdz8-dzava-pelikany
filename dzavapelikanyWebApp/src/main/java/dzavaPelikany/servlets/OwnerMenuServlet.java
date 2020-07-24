package dzavaPelikany.servlets;

import dzavaPelikany.freemarker.TemplateProvider;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/owner-menu")
public class OwnerMenuServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private HttpSession httpSession;

    private static final Logger LOGGER = LoggerFactory.getLogger(OwnerMenuServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "owner-menu.ftlh");

        response.setContentType("text/html;charset=UTF-8");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", (String)httpSession.getAttribute("name"));

        PrintWriter printWriter = response.getWriter();
        try {
            template.process(dataModel,  printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
