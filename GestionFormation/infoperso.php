
<?php
/**
 * Created by PhpStorm.
 * User: coundoune
 * Date: 09/02/15
 * Time: 17:43
 */
require_once 'entete.php';
if(estconnecte())
{
?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Mes formations </title>
    <link rel="stylesheet" type="text/css" href="css/accueil.css">
    <meta charset="utf-8">
</head>
<body>

<div id="content">


    <fieldset>
        <legend>Mes informations personnelles</legend>
       <table>
           <tr>
               <th>E-mail</th>
               <td> <?php echo $_SESSION['email']; ?></td>
           </tr>
           <tr>
               <th>Credit formation</th>
               <td> <?php echo $_SESSION['jours_consommes']; ?> </td>
           </tr>

           <tr>
               <th class="over"><a href="">Historique de mes formations</a> </th>
               <td></td>
           </tr>
           <tr>
               <th></th>
               <td></td>
           </tr>
       </table>

    </fieldset>



</div>

<div id="footer">
    <a href="mentionlegal.php">Mentions legals</a>
</div>
<?php
}
else
{
    header('location:connexion.php');
}
    ?>