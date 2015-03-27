<?php 
function connect()
{
	$user = 'root';
	$pass = '';
	$hote = 'localhost';
	$port = '8080';
	$base = 'test';
	$dsn = "mysql:$hote;port=$port;dbname=$base";
	
	try{
		$dbh = new PDO($dsn, $user, $pass);
	}
	catch (PDOException $e){
		die("Erreur ! :" . $e->getMessage());
	}
	return $dbh;
}

// Fonction pour récupérer le mot de passe de l'user dans la BDD
function verifMdp($mail){
	$dbh = connect();
	$sql = "SELECT password_utilisateur FROM utilisateurs WHERE mail_utilisateur = :mail;";
	$val = $dbh->prepare($sql);
	$val->BindValue(':mail',$mail);
	$val->execute();
	
	if($val){
		return $val->fetchAll();
	}
	else{
		return false;
	}	
}

// Fonction pour récupérer le prénom de l'user dans la BDD
function selectUser($mail){
	$dbh = connect();
	$sql = "SELECT prenom_utilisateur FROM utilisateurs WHERE mail_utilisateur = :mail;";
	$val = $dbh->prepare($sql);
	$val->BindValue(':mail',$mail);
	$val->execute();
	
	if($val){
		return $val->fetchAll();
	}
	else{
		return false;
	}
}

// Fonction pour insérer un employé dans la BDD
function insertUser($nom,$prenom,$mail,$pw){
	$dbh = connect();
	$sql = "INSERT INTO utilisateurs(nom_utilisateur,prenom_utilisateur,mail_utilisateur,password_utilisateur) VALUE (:nom,:prenom,:mail,:pw);";
	$val = $dbh->prepare($sql);
	$val->BindValue(':nom',$nom);
	$val->BindValue(':prenom',$prenom);
	$val->BindValue(':mail',$mail);
	$val->BindValue(':pw',md5($pw));
	$val->execute();
}