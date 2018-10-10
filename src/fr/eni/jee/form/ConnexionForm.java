package fr.eni.jee.form;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.jee.bo.User;
import fr.eni.jee.dal.UserDAO;

public final class ConnexionForm {
    private static final String INPUT_MAIL  = "tmail";
    private static final String INPUT_PASS   = "tpassword";

    private String results;
    private Map<String, String> errors = new HashMap<String, String>();

    public String getResults() {
        return results;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public User connectUser( HttpServletRequest request ) {
    	/* Input value of the form */
        String mail = getInputValue( request, INPUT_MAIL );
        String password = getInputValue( request, INPUT_PASS );

        User user = new User();

        /* Check mail. */
        try {
        	validMail( mail );
        } catch ( Exception e ) {
        	setError( INPUT_MAIL, e.getMessage() );
        }
        user.setMail( mail );

        /* Check password */
        try {
        	validPassword( password, mail );
        } catch ( Exception e ) {
        	setError( INPUT_PASS, e.getMessage() );
        }
        user.setPassword( password );

        /* Init message returned */
        if ( errors.isEmpty() ) {
        	results = "Succès de la connexion.";            
        } else {
        	results = "Échec de la connexion.";
        }

        return user;
    }

    /**
     * Check the validity of the mail adress.
     */
    private void validMail( String mail ) throws Exception {
        if ( mail != null && !mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /**
     * Check the validity of the password.
     */
    private void validPassword( String password, String mail ) throws Exception {
        if ( password != null ) {        
        	        	
        	String pass = sha256(password);
        	User user = UserDAO.Search(mail, pass);        	
        	
        	if(user == null){
        		throw new Exception( "Mot de passe ou email incorrect" );
        	}        		
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    /**
     * Ad error message to the input.
     */
    private void setError( String input, String message ) {
    	errors.put( input, message );
    }

    /**
     * Get the value of an input
     */
    private static String getInputValue( HttpServletRequest request, String nomChamp ) {

        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
    public static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
           throw new RuntimeException(ex);
        }
    }
}
