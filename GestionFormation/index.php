<?php
/**
 * Created by PhpStorm.
 * User: coundoune
 * Date: 09/02/15
 * Time: 17:31
 */

require_once 'entete.php';


if(!estconnecte())
{

    header('location:connexion.php');
}
else

{
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
            <h1> Bienvenue <?php echo $_SESSION['nom'] ?> </h1>
    </div>

    <div id="footer">
        <a href="mentionlegal.php">Mentions legals</a>
    </div>
</body>
</html>
<?php
}
?>