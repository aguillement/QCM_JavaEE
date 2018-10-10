package fr.eni.jee.form;

import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import fr.eni.jee.bo.User;
import fr.eni.jee.dal.UserDAO;

public class AddCandidatForm {
	private static final String INPUT_FIRSTNAME = "tFirstname";
	private static final String INPUT_LASTNAME = "tLastname";
	private static final String INPUT_MAIL = "tMail";
	private int VALUE_PROFILE = 20;

	private String results;
	private Map<String, String> errors = new HashMap<String, String>();

	public String getResults() {
		return results;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setValueProfil(int valueProfil) {
		this.VALUE_PROFILE = valueProfil;
	}

	public User initUserForm(HttpServletRequest request) {
		/* Input value of the form */
		String firstname = getInputValue(request, INPUT_FIRSTNAME);
		String lastname = getInputValue(request, INPUT_LASTNAME);
		String mail = getInputValue(request, INPUT_MAIL);

		User candidat = new User();
		Boolean bValid = true;

		/* Check mail. */
		try {
			validMail(mail);
		} catch (Exception e) {
			setError(INPUT_MAIL, e.getMessage());
			bValid = false;
			results = "Veuillez vérifier votre adresse email.";
		}
		candidat.setMail(mail);

		/* Create password */
		String newPassword = generatePassword();
		candidat.setPassword(sha256(newPassword));

		/* Check firstname */
		if (bValid && (firstname == null || firstname == "")) {
			errors.put(INPUT_FIRSTNAME, "Veuillez saisir votre prénom.");
			results = "Veuillez saisir votre prénom.";
			bValid = false;
		}
		candidat.setFirstname(firstname);

		/* Check lastname */
		if (bValid && (lastname == null || lastname == "")) {
			errors.put(INPUT_LASTNAME, "Veuillez saisir votre nom.");
			results = "Veuillez saisir votre nom.";
			bValid = false;
		}
		candidat.setLastname(lastname);

		candidat.setIdProfile(VALUE_PROFILE);

		try {
			/* Check if the user is valid or not */
			if (bValid) {
				candidat = UserDAO.Insert(candidat);
				results = "Candidat créé.";
				// SEND MAIL WITH PASSWORD
			} else {
				candidat = null;
				results = "Candidat non créé.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			candidat = null;
			results = "Candidat non créé.";
		}

		return candidat;
	}

	/**
	 * Check mail
	 */
	private void validMail(String mail) throws Exception {
		if (mail != null && !mail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide.");
		}
	}

	/**
	 * Put the error message in the array errors
	 */
	private void setError(String input, String message) {
		errors.put(input, message);
	}

	/**
	 * Return null if the value is not defined
	 */
	private static String getInputValue(HttpServletRequest request, String inputName) {

		String value = request.getParameter(inputName);
		if (value == null || value.trim().length() == 0) {
			return null;
		} else {
			return value;
		}
	}

	public static String generatePassword() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 8) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public static String sha256(String base) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(base.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
