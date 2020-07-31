package dzavaPelikany.servlets.registration;

import dzavaPelikany.domain.User;
import dzavaPelikany.freemarker.TemplateProvider;
import dzavaPelikany.service.UserService;
import dzavaPelikany.servlets.HomePageServlet;
import dzavaPelikany.servlets.HomepageAfterLogin;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/registration")
public class Registration extends HttpServlet {

        @Inject
        private TemplateProvider templateProvider;

        @Inject
        UserService userService;



    private static final Logger LOGGER = LoggerFactory.getLogger(Registration.class.getName());


        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Template template = this.templateProvider.getTemplate(getServletContext(), "registration.ftlh");

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
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);
        userService.save(user);

        LOGGER.info("user registered: " + user);

    }
}
