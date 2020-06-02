package dzavaPelikany.servlets.registration;

import dzavaPelikany.domain.Owner;
import dzavaPelikany.domain.Tenant;
import dzavaPelikany.freemarker.TemplateProvider;
import dzavaPelikany.service.OwnerService;
import dzavaPelikany.service.TenantService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;

@WebServlet("/tenant-registration")
public class TenantRegistartionServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;


    TenantService tenantService = new TenantService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "tenant-registration.ftlh");

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
        Tenant tenant = new Tenant();
        tenant.setName(req.getParameter("name"));
        tenant.setSurname(req.getParameter("surname"));
        tenant.setEmail(req.getParameter("email"));
        tenant.setLogin(req.getParameter("login"));
        tenant.setId(UUID.randomUUID());

        tenantService.saveTenant(tenant);

        Template template = templateProvider.getTemplate(getServletContext(), "tenant-menu-screen.ftlh");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(new HashMap<String, Object>(), printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
