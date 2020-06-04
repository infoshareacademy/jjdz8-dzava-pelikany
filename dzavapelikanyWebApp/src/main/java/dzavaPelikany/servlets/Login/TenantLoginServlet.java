package dzavaPelikany.servlets.Login;

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

    TenantService tenantService = new TenantService();
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

        if (tenantService.findByLogin(login, path) == null)
            printWriter.println("<a href=\"/tenant-login\">Uzytkownik o takim loginie nie istnieje</a>");
        else if (!tenantService.findByLogin(login, path).getPassword().equals(password))
            printWriter.println("<a href=\"/tenant-login\">Przykro nam, nie prawidłowe hasło, spróbuj ponownie</a>");
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
            HashMap<String,String> dataModel = new HashMap<>();
            dataModel.put("name", tenant.getName())      ;
            
            try {
                template.process(dataModel, printWriter);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }

    }
}

