package dzavaPelikany.oauth;


import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;
import com.google.api.client.http.GenericUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/google-login")
public class GoogleLoginServlet extends AbstractAuthorizationCodeServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleLoginServlet.class.getName());


    private OAuthManager oAuthManager;

    @Override
    protected AuthorizationCodeFlow initializeFlow() throws ServletException, IOException {
        return oAuthManager.buildFlow();
    }

    @Override
    protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
        GenericUrl url = new GenericUrl(req.getRequestURL().toString());
        url.setRawPath("/oauth2callback");
        return url.build();
    }

    @Override
    protected String getUserId(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        String randomUserId = UUID.randomUUID().toString();
        LOGGER.info("getUserId: " + randomUserId);
        return randomUserId;
    }
}
