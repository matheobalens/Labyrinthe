package tests;

import grafix.interfaceGraphique.IG;

public class MaDemoIG {

	public static void main(String[] args) {
		Object parametres[];
		parametres=IG.saisirParametres(); // On ouvre la fenêtre de paramètrage pour la saisie
		
		
		// Création de la fenêtre de jeu et affichage de la fenêtre 
		int nbJoueurs=((Integer)parametres[0]).intValue(); // Récupération du nombre de joueurs
		IG.creerFenetreJeu("Démo Team Foxers Librairie IG version 1.9", nbJoueurs); // On crée la fenêtre
		IG.rendreVisibleFenetreJeu();  // On rend visible la fenêtre de jeu
				
		
		// Changement des caractéristiques du premier joueur avec les paramètres saisis
		int numImageJoueur0=((Integer)parametres[3]).intValue(); //joueur 0*3+3=3
		String nomJoueur0=(String)parametres[1]; //joueur 0*3+1=1
		String categorieJoueur0=(String)parametres[2]; //joueur 0*3+2=2
		IG.changerNomJoueur(0, nomJoueur0+" ("+categorieJoueur0+")");
		IG.changerImageJoueur(0,numImageJoueur0);


		// Changement des caractéristiques du second joueur avec les paramètres saisis
		int numImageJoueur1=((Integer)parametres[6]).intValue(); //joueur 1*3+3=6
		String nomJoueur1=(String)parametres[4]; //joueur 1*3+1=4
		String categorieJoueur1=(String)parametres[5]; //joueur 1*3+2=5
		IG.changerNomJoueur(1, nomJoueur1+" ("+categorieJoueur1+")");
		IG.changerImageJoueur(1,numImageJoueur1);
				
		// Changement des caractéristiques du troisième joueur avec les paramètres saisis
		int numImageJoueur2=((Integer)parametres[9]).intValue(); //joueur 2*3+3=9
		String nomJoueur2=(String)parametres[7]; //joueur 2*3+1=7
		String categorieJoueur2=(String)parametres[8]; //joueur 2*3+2=8
		IG.changerNomJoueur(2, nomJoueur2+" ("+categorieJoueur2+")");
		IG.changerImageJoueur(2,numImageJoueur2);
				
		// Changement d'objets des joueurs
		for (int i=0;i<6;i++) {
			IG.changerObjetJoueur(0,i,i); //num joueur,num objet (entre 0 et 17),position
			IG.changerObjetJoueur(1,i+6,i);
			IG.changerObjetJoueur(2,i+12,i);
		}
		
		//Changer les pièces du plateau (6x6)
		for (int i=0; i<=6; i++) {
			for (int j=0; j<=6; j++) {
				IG.changerPiecePlateau(i, j, 2, 0); //ligne, colonne, modelePiece, orientationPiece (type)
			}
		}
				
		// Change la pièce hors du plateau
		IG.changerPieceHorsPlateau(1,0); //modelePiece, orientationPiece (type)
				
		// Place des objets sur le plateau
		int numObjet = 0;
			for (int i=0;i<=2;i++) {
				for (int j=0;j<=6;j++) {
					if (numObjet <=17) {
						IG.placerObjetPlateau(numObjet++,i,j); //numObjet, ligne, colonne
					}
				}
			}
					
			// Place les 2 joueurs sur le plateau
			IG.placerJoueurPrecis(0,3,0,1,0); //numJoueur, ligne, colonne, sousLigne, sousColonne
			IG.placerJoueurPrecis(1,3,6,1,2); //numJoueur, ligne, colonne, sousLigne, sousColonne
				
			// Affichage du message de bienvenue + mise à jour affichage + attente clic
			String message[]={
						"",
						"Bonjour !",
						"Cliquez pour continuer...",
						""
			};
			IG.afficherMessage(message); // On change de message de la fenêtre de jeu
			IG.miseAJourAffichage();
			IG.attendreClic();
			
			//Partie avec les 4 clics
			int compteurClics = 1;
			while (compteurClics<=4) {
			for (int i=0; i<=6; i++) {
				for (int j=0; j<=6; j++) {
					if (compteurClics==4) {
						IG.changerPiecePlateau(i, j, 2, 0); //ligne, colonne, modelePiece, orientationPiece (type)
						IG.changerPieceHorsPlateau(1,0); //modelePiece, orientationPiece (type)
					} else {
						IG.changerPiecePlateau(i, j, 2, compteurClics); //ligne, colonne, modelePiece, orientationPiece (type)
						IG.changerPieceHorsPlateau(1,compteurClics); //modelePiece, orientationPiece (type)
					}
				}
			}
			message[1]="Après le clic "+compteurClics;
			IG.afficherMessage(message);
			
			IG.placerJoueurPrecis(0,3,0,1,compteurClics); //numJoueur, ligne, colonne, sousLigne, sousColonne
			IG.placerJoueurPrecis(1,3,6,1,2-compteurClics);
			
			if (compteurClics<=3) { //Condition car le compteur ne fonctionne plus une fois que j'ai changé de case
			IG.placerBilleSurPlateau(3,0,1,compteurClics-1,0); //ligne, colonne, sousLigne, souscolonne, type
			IG.placerBilleSurPlateau(3,6,1,3-compteurClics,0);
			IG.jouerUnSon(3);
			} else if (compteurClics==4) {
				IG.placerBilleSurPlateau(3,1,1,0,0); 
				IG.placerBilleSurPlateau(3,5,1,2,0);
				IG.jouerUnSon(3);
			}
			
			IG.enleverObjetPlateau(0,compteurClics-1); //ligne, objet
			IG.changerObjetJoueurAvecTransparence(0,compteurClics-1,compteurClics-1); //numJoueur, numObjet, position
			
			IG.miseAJourAffichage();
			IG.attendreClic();
			compteurClics += 1;
			//System.out.println(compteurClics);
			}
		
		IG.afficherGagnant(0);
		IG.miseAJourAffichage();
		IG.jouerUnSon(9);
		
		int entree=IG.attendreChoixEntree();
		IG.selectionnerFleche(entree);
		IG.miseAJourAffichage();
		IG.pause(2000);
		IG.fermerFenetreJeu();
		System.exit(0);
	}
	
}