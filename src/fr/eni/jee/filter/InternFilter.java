package fr.eni.jee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.jee.bo.User;

public class InternFilter implements Filter {

	public void init( FilterConfig config ) throws ServletException {
    }

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        /* Get session */
        HttpSession session = request.getSession();

        /**
         * Check if the user is connected
         */
        if ( session.getAttribute( "sessionUser" ) == null ) {
            /* Redirect to restricted page */
            response.sendRedirect( request.getContextPath() + "/AccessRestricted" );
        } else {
        	User user = (User)session.getAttribute( "sessionUser" );
        	if(user.getProfile().getId() == 20){
        		chain.doFilter( request, response );
        	}
        	else{
        		/* Redirect to restricted page */
                response.sendRedirect( request.getContextPath() + "/AccessDenied" );
        	}
        }

	}
	
	public void destroy() {
    }

}
