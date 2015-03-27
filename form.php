<?php
	include "conn.php";
	session_start();
	// Si les deux champs formulaires sont saisis ont attribu les valeurs dans des variables
	if(!empty($_POST['pw']) && !empty($_POST['login'])){
		$_SESSION['log'] = $_POST['login'];
		$_SESSION['pw'] = $_POST['pw'];
		
		$log = $_SESSION['log'];
		$pw = $_SESSION['pw'];
		
		// On récupère le mot de passe correspondant à l'adresse mail saisie
		$checkPw = verifMdp($log)[0][0];
		
		// Vérification du mot de passe saisi et crypté
		if ($checkPw != md5($pw)){
			echo("Le mot de passe est incorrect");
		}
		else{
			echo("connexion réussie");	
			header('Refresh:2; url=ajoutEmploye.php');
		}
	}
	
?>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title> Page Administrateur </title>
	</head>
	<body>
		<form action="form.php" method="post">
			<input type="mail" name="login"/><br/>
			<input type="password" name="pw"/><br/>
			<input type="submit"/>
		</form>
	</body>
</html>