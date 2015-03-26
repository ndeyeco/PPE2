<?php
/**
 * Created by PhpStorm.
 * User: coundoune
 * Date: 09/02/15
 * Time: 17:43
 */
include 'entete.php';

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
        <legend>Les formations disponibles</legend>
        <div id="form1">
            <form method="post" action="formationdispo.php" name="search" >

                <label>Recherche </label>

                <input type="text" name="cherche_formation" placeholder="chercher une formation " >

                <p>
                    <input type="submit" name="submit" value="OK" />
                </p>
            </form>
        </div>
        <div id="form2">
            <form method="post" action="formationdispo.php" >

                        <label>Formations </label>
                        <select name="formation" >
                            <?php
                                $formation=$bdd-> query('select * from formation');
                                while($formationdispo= $formation-> fetch())
                                {
                            ?>
                            <option>
                                <?php
                                    echo($formationdispo['nom_formation']);
                                ?>
                            </option>
                            <?php
                                }
                                $formation->closeCursor();
                            ?>
                        </select>

                    <p>
                        <input type="submit" name="submit1" value="OK" />
                    </p>

                <?php
                if(isset($_POST['submit']))
                {
                    $formationrecherche=$_POST['cherche_formation'];
                    if (isset($formationrecherche))
                    {
                        $cherche=$bdd-> query("select * from formation where nom_formation like '%".$formationrecherche."%'");
                        while($result=$cherche-> fetch())
                        {
                            echo($result['nom_formation']." ".$result['cout_formation']);
                            echo "<br />";
                        }
                    }
                }

                if( isset($_POST['submit1']))
                {
                    $formationselected=$_POST['formation'];

                    if (isset($formationselected))
                    {
                        //echo "select * from formation where nom_formation='".$formationselected."'----";
                       $detailformation=$bdd->query("select * from formation where nom_formation='".$formationselected."'");

                        while($liste=$detailformation-> fetch())
                        {
                            echo($liste['nom_formation']." ".$liste['cout_formation']);
                        }
                    }

                }
                ?>
            </form>
        </div>
    </fieldset>


</div>

<div id="footer">
    <a href="mentionlegal.php">Mentions legals</a>
</div>
