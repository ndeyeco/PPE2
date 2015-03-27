<?php 
include "conn.php";
session_start();

$mail = $_SESSION['log'];

echo("Salut ".selectUser($mail)[0][0]);

// Vérifie que tous les champs sont remplis pour effectuer l'insertion.
if (!empty($_POST['nom']) && !empty($_POST['prenom']) && !empty($_POST['email']) && !empty($_POST['password'])){
	$nom = $_POST['nom'];
	$prenom = $_POST['prenom'];
	$mail = $_POST['email'];
	$pw = $_POST['password'];
	
	insertUser($nom,$prenom,$mail,$pw);
}
?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title> Insérer employé</title>
	</head>
	<body>
		<form action="ajoutEmploye.php" method="post">
			<input type="text" name="nom" placeholder="Saisir Nom"/><br/>
			<input type="text" name="prenom" placeholder="Saisir Prénom"/><br/>
			<input type="mail" name="email" placeholder="Saisir E-mail"/><br/>
			<input type="password" name="password" placeholder="Saisir Password"/><br/>
			<input type="submit"/>
		</form>
	</body>
</html>
