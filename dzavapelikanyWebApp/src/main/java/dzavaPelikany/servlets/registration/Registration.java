package dzavaPelikany.servlets.registration;

import dzavaPelikany.freemarker.TemplateProvider;
import dzavaPelikany.servlets.HomePageServlet;
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
}
