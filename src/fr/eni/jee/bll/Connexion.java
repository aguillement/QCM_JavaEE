package fr.eni.jee.bll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.jee.bo.User;
import fr.eni.jee.form.ConnexionForm;


public class Connexion extends HttpServlet {
    public static final String USER         = "user";
    public static final String FORM         = "form";
    public static final String SESSION_USER = "sessionUtilisateur";
    public static final String VIEW              = "/WEB-INF/connexion.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        ConnexionForm form = new ConnexionForm();
        User user = form.connectUser( request );

        /* Get the current session with the previous request */
        HttpSession session = request.getSession();

        if ( form.getErrors().isEmpty() ) {
            session.setAttribute( SESSION_USER, user );
        } else {
            session.setAttribute( SESSION_USER, null );
        }

        request.setAttribute( FORM, form );
        request.setAttribute( USER, user );

        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }
}
