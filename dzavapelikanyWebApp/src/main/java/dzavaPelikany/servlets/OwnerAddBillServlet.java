package dzavaPelikany.servlets;

import dzavaPelikany.domain.Bill;
import dzavaPelikany.freemarker.TemplateProvider;
import dzavaPelikany.service.BillService;
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


@WebServlet("/owner-add-bill")
public class OwnerAddBillServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private BillService billService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "owner-add-bill.ftlh");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(new HashMap<String, Object>(), printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String address = req.getParameter("StreetAndNUmber");
        String description = req.getParameter("Description");
        Double amount = Double.parseDouble(req.getParameter("Amount"));
        String link = req.getParameter("CopyLink");

        Bill bill = new Bill();

        bill.setStreetNameAndNumber(address);
        bill.setDescription(description);
        bill.setAmount(amount);
        bill.setLinkToCopy(link);

        billService.addBill(bill);
    }
}
