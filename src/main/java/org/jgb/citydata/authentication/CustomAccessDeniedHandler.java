package org.jgb.citydata.authentication;

import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jgb
 * @since 12/02/19 7:49
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(final HttpServletRequest request, final HttpServletResponse response, final AccessDeniedException ex) throws IOException {
        response.getOutputStream().print("{\"access\": \"denied\", \"message\": \"User don't have a correct role\"}");
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

}
