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

@WebServlet("/tenant-edit-details")
public class TenantEditServlet extends HttpServlet {

    TenantService tenantService = new TenantService();

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private HttpSession httpSession;

    HashMap<String,String> dataModel = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "tenant-edit-screen.ftlh");

        response.setContentType("text/html;charset=UTF-8");
        httpSession.setAttribute("msg"," ");
        PrintWriter printWriter = response.getWriter();
        try {
            template.process(populateDataModel(), printWriter);
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
        String path = getServletContext().getRealPath("/WEB-INF/resources/tenants.json");
        Tenant tenant = tenantService.findByLogin((String) httpSession.getAttribute("login"), path);
        httpSession.setAttribute("msg","Twoje dane zostały zmienione");
        httpSession.setAttribute("name",name);
        httpSession.setAttribute("surname",surname);
        httpSession.setAttribute("email",email);
        httpSession.setAttribute("password",password);

        tenant.setName(name);
        tenant.setSurname(surname);
        tenant.setPassword(password);
        tenant.setEmail(email);
        tenantService.deleteTenant(tenant,path);
        tenantService.saveTenant(tenant, path);
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();


        Template template = templateProvider.getTemplate(getServletContext(), "tenant-edit-screen.ftlh");
        try {
            template.process(populateDataModel(), printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    protected HashMap<String,String> populateDataModel(){

        dataModel.put("name",(String) httpSession.getAttribute("name"));
        dataModel.put("surname",(String) httpSession.getAttribute("surname"));
        dataModel.put("email",(String) httpSession.getAttribute("email"));
        dataModel.put("password",(String) httpSession.getAttribute("password"));
        dataModel.put("msg",(String) httpSession.getAttribute("msg"));
        return dataModel;


    }
}
