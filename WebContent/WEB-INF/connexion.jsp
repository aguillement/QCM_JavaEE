<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
    </head>
    <body>
        <form method="post" action="connexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="mail">Adresse email <span class="required">*</span></label>
                <input type="email" id="mail" name="tmail" value=""/>
                <span class="error">${form.erreurs['tmail']}</span>
                <br />

                <label for="password">Mot de passe <span class="required">*</span></label>
                <input type="password" id="password" name="tpassword" value="" size="20" maxlength="20" />
                <span class="error">${form.erreurs['tpassword']}</span>
                <br />

                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
                
                <p class="${empty form.errors ? 'succes' : 'erreur'}">${form.results}</p>
            </fieldset>
        </form>
    </body>
</html>