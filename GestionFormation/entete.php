<?php
/**
 * Created by PhpStorm.
 * User: coundoune
 * Date: 18/02/15
 * Time: 14:15
 */
require_once 'lib/connectivite.php';
session_start();
?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Mes formations </title>
    <link rel="stylesheet" type="text/css" href="css/accueil.css">
    <meta charset="utf-8">
</head>
<body>
<div id="header">
    <img id="headerimg" src="image/header.png">
    <img id="logo" src="image/logo.png">

    <div id="menu">
        <ul>
            <li><a href="index.php">Accueil</a> </li>
            <li><a href="infoperso.php">Mes informations personnelles</a> </li>
            <li><a href="mesformations.php">Mes formations</a></li>
            <li><a href="formationdispo.php">Formations disponibles</a></li>
            <?php
                if(estconnecte())
                {
                    echo '<div id="logout"><a href="deconnexion.php">Déconnection</a></div>';
                }
            ?>
        </ul>
    </div>
</div>
</body>
</html>
