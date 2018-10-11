<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un candidat</title>
</head>
<body>
	<form
		action="<%=request.getContextPath()%>/Connected/createUser"
		name="formAddUser" method="post">

		<div class="form-group">
			<label for="lastname">Nom :</label> <input class="form-control" type="text"
				name="tLastname" id="lastname" />
		</div>

		<div class="form-group">
			<label for="firstname">Prénom :</label> <input class="form-control"
				type="text" name="tFirstname" id="firstname" />
		</div>

		<div class="form-group">
			<label for="mail">Email :</label> <input class="form-control"
				type="mail" name="tMail" id="mail"/>
		</div>

		<button type="submit" class="col-sm-1 btn btn-default" name="bCancel"
			value="Annuler">
			<span class="glyphicon glyphicon-share-alt"></span>Annuler
		</button>
		<button type="submit"
			class="col-sm-1 col-sm-offset-10 btn btn-default" name="bSave"
			value="Enregistrer">
			<span class="glyphicon glyphicon-ok"></span>Enregistrer
		</button>
		<p class="${empty form.errors ? 'succes' : 'erreur'}">${message}</p>

	</form>
</body>
</html>