package dzavaPelikany.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")
public class GoogleLogoutServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleLogoutServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userEmail = (String) session.getAttribute("email");
        LOGGER.info("User " + userEmail + "log out successfully");
        session.invalidate();
        try {
            resp.sendRedirect("/homepage-after-logout");
        }catch (IOException e){
            LOGGER.error(e.getMessage());
        }

    }
}
