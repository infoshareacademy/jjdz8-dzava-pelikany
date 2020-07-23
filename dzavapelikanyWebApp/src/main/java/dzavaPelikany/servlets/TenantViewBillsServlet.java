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
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;


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
        HashMap<String, String> data = new HashMap<>();
        String address = req.getParameter("address");

        List<Bill> result = billService.findByAddress(address);
        if (result.isEmpty()) data.put("msg","Nie znaleziono rachunku dla podanego adresu");
        else {
            StringBuilder sb = new StringBuilder();
            for (Bill bill :
                    result) {
                sb.append(bill.getAddress()).append(" ").append(bill.getDescription()).append(" ").append(bill.getAmount()).append(" ").append(bill.getDate()).append(" \n");
            }
            data.put("msg", sb.toString());
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
