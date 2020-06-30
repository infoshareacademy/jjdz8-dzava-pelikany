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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/homepage-after-login")
public class HomepageAfterLogin extends HttpServlet {

        @Inject
        private TemplateProvider templateProvider;

    private static final Logger LOGGER = LoggerFactory.getLogger(HomepageAfterLogin.class.getName());

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            Template template = templateProvider.getTemplate(getServletContext(), "homepage-after-login.ftlh");

            response.setContentType("text/html;charset=UTF-8");

            PrintWriter printWriter = response.getWriter();
            try {
                template.process(new HashMap<String, Object>(), printWriter);
            } catch (TemplateException e) {
                LOGGER.warn("Template not created");
            }

        }


    }

