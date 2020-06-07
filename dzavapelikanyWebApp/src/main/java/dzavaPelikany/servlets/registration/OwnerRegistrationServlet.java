package dzavaPelikany.servlets.registration;

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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;


@WebServlet("/owner-registration")
public class OwnerRegistrationServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;


    @Inject
    private OwnerService ownerService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "owner-registration.ftlh");

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
        Owner owner = new Owner();
        owner.setName(req.getParameter("name"));
        owner.setSurname(req.getParameter("surname"));
        owner.setPassword(req.getParameter("password"));
        owner.setEmail(req.getParameter("email"));
        owner.setLogin(req.getParameter("login"));
        owner.setId(UUID.randomUUID());
        String path = getServletContext().getRealPath("/WEB-INF/resources/owners.json");
        ownerService.saveOwner(owner, path);

        Template template = templateProvider.getTemplate(getServletContext(), "index.ftlh");
        HashMap<String,String> dataModel = new HashMap<>();
        dataModel.put("msg","Zarejestrowano nowego właściciela");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();


        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
