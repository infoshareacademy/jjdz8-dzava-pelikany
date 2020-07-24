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


@WebServlet("/homepage-after-logout")
public class HomePageAfterLogOut extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageAfterLogOut.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "logout.ftlh");

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
        HttpSession session = req.getSession(false);
        if(session != null){
            session.invalidate();
        }
    }
}
