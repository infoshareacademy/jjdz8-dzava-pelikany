package dzavaPelikany.servlets;

import dzavaPelikany.domain.Tenant;
import dzavaPelikany.freemarker.TemplateProvider;
import dzavaPelikany.service.TenantService;
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


@WebServlet("/delete-tenant")
public class TenantDeleteServlet extends HttpServlet {

    @Inject
    private TenantService tenantService;

    @Inject
    private HttpSession httpSession;

    @Inject
    private TemplateProvider templateProvider;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Tenant tenant = tenantService.findByLogin((String)httpSession.getAttribute("login"),getServletContext().getRealPath("/WEB-INF/resources/tenants.json"));
        tenantService.deleteTenant(tenant,getServletContext().getRealPath("/WEB-INF/resources/tenants.json"));

        HashMap<String,String> dataModel = new HashMap<>();
        dataModel.put("msg","Usunięto użytkownika");

        Template template = templateProvider.getTemplate(getServletContext(), "index.ftlh");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
