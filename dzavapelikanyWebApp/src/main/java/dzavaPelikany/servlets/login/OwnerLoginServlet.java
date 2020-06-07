package dzavaPelikany.servlets.login;

import dzavaPelikany.domain.Owner;
import dzavaPelikany.freemarker.TemplateProvider;
import dzavaPelikany.service.OwnerService;
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


@WebServlet("/owner-login")
public class OwnerLoginServlet extends HttpServlet {

    @Inject
    private OwnerService ownerService;
    @Inject
    private TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "owner-login.ftlh");

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
        PrintWriter printWriter = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String path = getServletContext().getRealPath("/WEB-INF/resources/owners.json");
        HashMap<String, String> dataModel = new HashMap<>();

        if (ownerService.findByLogin(login, path) == null || !ownerService.findByLogin(login, path).getPassword().equals(password)) {

            resp.setContentType("text/html;charset=UTF-8");

            dataModel.put("msg", "Niepoprawne dane logowania");


            Template template = templateProvider.getTemplate(getServletContext(), "owner-login.ftlh");

            try {
                template.process(dataModel, printWriter);
            } catch (TemplateException e) {
                e.printStackTrace();
            }

        } else {
            Owner owner = ownerService.findByLogin(login, path);

            HttpSession session = req.getSession();

            session.setAttribute("name", owner.getName());
            session.setAttribute("surname", owner.getSurname());
            session.setAttribute("email", owner.getEmail());
            session.setAttribute("login", owner.getLogin());
            session.setAttribute("password", owner.getPassword());

            session.setMaxInactiveInterval(30 * 60);

            resp.setContentType("text/html;charset=UTF-8");

            dataModel.put("name", owner.getName());


            Template template = templateProvider.getTemplate(getServletContext(), "owner-menu-screen.ftlh");

            try {
                template.process(dataModel, printWriter);
            } catch (TemplateException e) {
                e.printStackTrace();
            }

        }
    }
}
