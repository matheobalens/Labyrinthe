package tests;

import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;

public class TestPlateau {
	
	public static void main(String[] args) {
		Object parametres[];
		parametres=IG.saisirParametres(); // On ouvre la fen�tre de param�trage pour la saisie
		
		// Cr�ation de la fen�tre de jeu et affichage de la fen�tre 
		int nbJoueurs=((Integer)parametres[0]).intValue(); // R�cup�ration du nombre de joueurs
		IG.creerFenetreJeu("TestPieces Team Foxers", nbJoueurs); // On cr�e la fen�tre
		IG.rendreVisibleFenetreJeu();  // On rend visible la fen�tre de jeu
		
		String message[]={
				"",
				"",
				"Cliquez pour continuer...",
				""
		};
		IG.afficherMessage(message); // On change de message de la fen�tre de jeu
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		
		Plateau plateau=new Plateau();
		Piece pieceHorsPlateau=plateau.placerPiecesAleatoirement();
		
		IG.attendreClic();
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		int[][] result = plateau.calculChemin(0,0,0,0);
		System.out.println(result.length);
        for (int i=0;i<result.length;i++) {
        	for (int j=0;j<result.length;j++) {
               System.out.print(result[i][j]+" ");
        	}
        }
	}

}