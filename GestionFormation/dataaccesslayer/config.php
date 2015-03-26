<?php
/**
 * Created by PhpStorm.
 * User: coundoune
 * Date: 16/03/15
 * Time: 14:26
 */
function connexionbdd()
{
    $bdd = new PDO('mysql:host=localhost;dbname=Formation_poivey;charset=utf8', 'root', '');
    return $bdd;
}

function Login()
{
    $bdd=connexionbdd();
    if(isset($_POST['submit']))
    {
        if(isset($_POST['nom']) && isset($_POST['password']))
        {

            $login=$_POST['nom'];
            $pass=$_POST['password'];
            $sql="select * from salarie where nom_salarie=:login and password=:pass";
            $query = $bdd->prepare($sql);

            $query->bindParam(':login',$login);
            $query->bindParam(':pass',md5($pass));
            $query->execute();

            $result=$query->fetchAll();

            return $result;
        }
        else
            return 0;

    }
    else
        return false;
}


