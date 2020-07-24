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
import java.time.LocalDate;
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

        String address = req.getParameter("StreetAndNumber");
        String description = req.getParameter("Description");
        Double amount = Double.parseDouble(req.getParameter("Amount"));
        String date = req.getParameter("date");
        String[] dateArray = date.split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);
        LocalDate localDate = LocalDate.of(year,month,day);

        Bill bill = new Bill();

        bill.setDate(localDate);
        bill.setAddress(address);
        bill.setDescription(description);
        bill.setAmount(amount);
        bill.setActive(true);


        HashMap<String,String> data = new HashMap<>();
        data.put("msg", "Dodano nowy rachunek");

        billService.addBill(bill);

        Template template = templateProvider.getTemplate(getServletContext(), "owner-add-bill.ftlh");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(data, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
