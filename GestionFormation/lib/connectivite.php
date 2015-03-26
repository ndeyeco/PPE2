<?php
/**
 * Created by PhpStorm.
 * User: coundoune
 * Date: 16/03/15
 * Time: 15:38
 */
require_once 'dataaccesslayer/config.php';

function premconnexion()
{
     $login=Login();
     if(count($login)==1)
     {

         $_SESSION['nom']=$_POST['nom'];

         header('location:index.php');

    }

}

function estconnecte()
{
            if(isset($_SESSION['nom']))
            {
                return true;
            }
}