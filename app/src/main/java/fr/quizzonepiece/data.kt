package fr.quizzonepiece

import android.content.Intent

class Data {

    val question = arrayListOf( "Quel personnage n'est pas un grand un corsaire ?",
        "Qui est le premier membres des Mugiwara à être arrivé sur Sabondy après l'élipse des 2 ans ?",
        "Quel forme du Gear Fourth de Luffy existe ?")
    val answerPossible = arrayListOf(
        arrayListOf("Jimbe", "Boa Hancock", "Barbe Blanche", "Mihawk"),
        arrayListOf("Sanji", "Nami", "Chopper", "Zoro"),
        arrayListOf("Tiger Man", "Snake Man", "Monkey Man", "Lion Man")
    )
    val answer = arrayListOf("Barbe Blanche", "Zoro", "Snake Man")
}