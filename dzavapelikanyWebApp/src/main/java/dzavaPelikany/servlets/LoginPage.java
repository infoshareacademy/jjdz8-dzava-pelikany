package dzavaPelikany.servlets;

import dzavaPelikany.domain.User;
import dzavaPelikany.freemarker.TemplateProvider;
import dzavaPelikany.service.UserService;
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

@WebServlet("/login")
public class LoginPage extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "login.ftlh");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();
        try {
            template.process(new HashMap<String, Object>(), printWriter);
        } catch (TemplateException e) {
            LOGGER.warn("Template not created");
        }

    }
}