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


@WebServlet("/homepage")
public class HomePageServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageServlet.class.getName());
    protected static final String TEXT_HTML_CHARSET_UTF_8 = "text/html;charset=UTF-8";

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "homepage.ftlh");

        response.setContentType(TEXT_HTML_CHARSET_UTF_8);

        PrintWriter printWriter = response.getWriter();
        try {
            template.process(new HashMap<String, Object>(), printWriter);
        } catch (TemplateException e) {
            LOGGER.warn("Template not created");
        }

    }


}
