<?php
/**
 * Created by PhpStorm.
 * User: coundoune
 * Date: 12/03/15
 * Time: 16:03
 */
require_once 'entete.php';
require_once 'lib/connectivite.php';
if(estconnecte())
{
    // On détruit les variables de notre session
    session_unset ();

// On détruit notre session
    session_destroy ();

// On redirige le visiteur vers la page d'accueil
    header ('location: connexion.php');
}
