package fichier

import java.io.File
import java.nio.charset.Charset
import kotlin.io.path.fileVisitor

fun main() {
    // Tu peux tester tes fonctions en les appellants ici.
    lire()
    var args : Array<String> = arrayOf("pipo.txt", "message.txt")
    ecrire(args)

}

/**
 * (1 point) Affiche dans la console le contenu du fichier message.txt qui se trouve dans le projet de départ.
 */
fun lire() {
   var fichier : File = File("message.txt")
    var contenu : String = fichier.readText(Charsets.UTF_8)
    println(contenu)
}

/**
 * (1 point) S’il n’y a pas 2 éléments dans le paramètre args, affiche un message d'erreur, et retourne la valeur -1.
 * (1 point) Crée un fichier dans le répertoire du projet, dont le nom sera déterminé par le premier argument.
 *           Par exemple, si l’argument est « pipo.txt » l’application crée le fichier dans le dossier du projet avec le
 *           nom « pipo.txt ».
 * (1 point) Le fichier aura comme contenu le texte contenu dans le 2ème élément qui est dans le paramètre args.
 * Si tout s'est bien passé, on retourne la valeur 1.
 */
fun ecrire(args: Array<String>): Int {
    if (args.size !=2){
        println("Erreur")
        return -1
    }
    var fichier = File(args[0])
    var txt = File(args[1])
    fichier.createNewFile()
    var contenu = txt.readText()
    for (ligne in contenu) {
        fichier.writeText((fichier.readText(Charsets.UTF_8)+ligne).toString())
    }

    return 1
}


