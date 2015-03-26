<?php
/**
 * Created by PhpStorm.
 * User: coundoune
 * Date: 09/02/15
 * Time: 17:31
 */
require_once 'entete.php';
require_once 'lib/connectivite.php';
premconnexion();
?>
<!DOCTYPE html>
<html>
<head>
    <title>Mes formations </title>
    <link rel="stylesheet" type="text/css" href="css/accueil.css">
    <meta charset="utf-8">
</head>
<body>
<div id="content">
    <form method="POST" action="connexion.php">
        <fieldset>
            <legend>Connexion</legend>
            </br>
            </br>
            <label>Nom </label>
            <input type="text" name="nom" placeholder="Entrer nom " required>
            </br>
            </br>
            <label>Mot de passe </label>
            <input type="password" name="password" placeholder="Entrer mot de passe" required>
            </br>
            </br>
            <input type="submit" name="submit" value="OK" />
        </fieldset>

    </form>
</div>

<div id="footer">
    <a href="mentionlegal.php">Mentions legals</a>
</div>
</body>
</html>