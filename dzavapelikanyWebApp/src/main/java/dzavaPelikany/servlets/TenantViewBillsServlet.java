package dzavaPelikany.servlets;

import dzavaPelikany.domain.Bill;
import dzavaPelikany.dto.BillView;
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
import java.util.*;


@WebServlet("/tenant-view-bills")
public class TenantViewBillsServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private BillService billService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "tenant-view-bills.ftlh");

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
        HashMap<String, List<String>> data = new HashMap<>();
        String address = req.getParameter("address");

        List<BillView> result = billService.findByAddress(address);
        if (result.isEmpty()) data.put("msg", Arrays.asList("Nie znaleziono rachunku dla podanego adresu"));
        else {
            List<String> billList = new ArrayList<>();

            for (BillView bill : result) {

                String sb = "Adres : " + bill.getAddress() +
                        " Opis : " + bill.getDescription() +
                        " Termin Spłaty : " + bill.getDate() +
                        " Wysokość rachunku: " + bill.getAmount() + "zł ";
                billList.add(sb);
            }
            data.put("bill",billList);

        }
        Template template = templateProvider.getTemplate(getServletContext(), "tenant-view-bills.ftlh");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(data,  printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}
