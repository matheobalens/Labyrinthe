package tests;

import partie.ElementsPartie;
import composants.Plateau;
import composants.Piece;
import joueurs.Joueur;
import grafix.interfaceGraphique.IG;

public class TestElementsPartie {
	
	public static void main(String[] args) {
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		int  nbJoueurs=((Integer)parametresJeu[0]).intValue();
		IG.creerFenetreJeu("- TestElementsPartie",nbJoueurs);
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		ElementsPartie elementsPartie=new ElementsPartie(joueurs);
		IG.creerFenetreJeu("TestElements Team Foxers Librairie IG version 1.9", nbJoueurs); // On créé la fenêtre
		IG.rendreVisibleFenetreJeu();
		
		//Initialise les joueurs
		for(int i=0; i<nbJoueurs; i++) {
		IG.changerNomJoueur(joueurs[i].getNumJoueur(), joueurs[i].getNomJoueur()+" ("+joueurs[i].getCategorie()+")");
		IG.changerImageJoueur(joueurs[i].getNumJoueur(),joueurs[i].getNumeroImagePersonnage());
		IG.placerJoueurSurPlateau(i, joueurs[i].getPosLigne(), joueurs[i].getPosColonne());
		}
		
		// Affichage d'un message
        String message[]={
                "",
                "Cliquez pour continuer ...",
                ""
        };
        IG.afficherMessage(message); // On change de message de la fenêtre de jeu
        IG.miseAJourAffichage(); // On effectue le rafraichissement de la fenêtre de jeu
        IG.attendreClic();  // On attend un clic de souris

        message[0] = "";
        message[1] = "Choisissez une entrée...";
        message[2] = "(Une des flèches)";
        IG.afficherMessage(message);
        IG.miseAJourAffichage();

        for(int i=0; i<4; i++){
            int[] tab = joueurs[0].choisirOrientationEntree(null);
            elementsPartie.insertionPieceLibre(tab[1]);
            IG.miseAJourAffichage(); // On effectue le rafraichissement de la fenêtre de jeu
            IG.attendreClic();  // On attend un clic de souris
        }

        message[0]="";
        message[1]="C'est terminé !";
        message[2]="Cliquer pour quitter ...";
        IG.afficherMessage(message);
        IG.miseAJourAffichage();
        IG.attendreClic();
        IG.fermerFenetreJeu();
        System.exit(0);
    }		
}