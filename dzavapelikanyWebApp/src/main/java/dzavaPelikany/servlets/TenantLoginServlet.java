package dzavaPelikany.servlets.login;

import dzavaPelikany.domain.Tenant;
import dzavaPelikany.freemarker.TemplateProvider;
import dzavaPelikany.service.TenantService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/tenant-login")
public class TenantLoginServlet extends HttpServlet {

    @Inject
    private TenantService tenantService;
    @Inject
    private TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "tenant-login.ftlh");

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
        String path = getServletContext().getRealPath("/WEB-INF/resources/tenants.json");
        HashMap<String,String> dataModel = new HashMap<>();

        if (tenantService.findByLogin(login, path) == null || !tenantService.findByLogin(login, path).getPassword().equals(password))
        {

            resp.setContentType("text/html;charset=UTF-8");

            dataModel.put("msg","Niepoprawne dane logowania");

            Template template = templateProvider.getTemplate(getServletContext(), "tenant-login.ftlh");

            try {
                template.process(dataModel, printWriter);
            } catch (TemplateException e) {
                e.printStackTrace();
            }

        }
        else {
            Tenant tenant = tenantService.findByLogin(login, path);

            Template template = templateProvider.getTemplate(getServletContext(), "tenant-menu-screen.ftlh");
            HttpSession session = req.getSession();
            session.setAttribute("name",     tenant.getName());
            session.setAttribute("surname",  tenant.getSurname());
            session.setAttribute("email",    tenant.getEmail());
            session.setAttribute("login",    tenant.getLogin());
            session.setAttribute("password", tenant.getPassword());

            session.setMaxInactiveInterval(30*60);


            resp.setContentType("text/html;charset=UTF-8");
            dataModel.put("name", tenant.getName())      ;

            try {
                template.process(dataModel, printWriter);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }

    }
}