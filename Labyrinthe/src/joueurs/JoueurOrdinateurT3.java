package joueurs;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import composants.Utils;
import partie.ElementsPartie;
import partie.Partie;

/**
 * 
 * Cette classe permet de repr√©senter un joueur ordinateur de type T3.
 * 
 * @author Jean-Fran√ßois Condotta - 2021
 *
 */

public class JoueurOrdinateurT3 extends JoueurOrdinateur {

	/**
	 * Constructeur permettant de cr√©er un joueur.
	 * 
	 * @param numJoueur Le num√©ro du joueur.
	 * @param nomJoueur Le nom du joueur.
	 * @param numeroImagePersonnage Le num√©ro de l'image repr√©sentant le joueur.
	 * @param posLignePlateau La ligne du plateau sur laquelle est positionn√©e le joueur.
	 * @param posColonnePlateau La colonne du plateau sur laquelle est positionn√©e le joueur.

	 */
	public JoueurOrdinateurT3(int numJoueur,String nomJoueur, int numeroImagePersonnage,int posLignePlateau,int posColonnePlateau) {
				super(numJoueur,nomJoueur, numeroImagePersonnage,posLignePlateau,posColonnePlateau);
	}
	
	private int[][] avoirObjetDeuxCoup(ElementsPartie elementspartie, Partie partie){
		int[][] tabSolution = new int[100][2];
		tabSolution=null;
		int nbSolution = 0;
		int numJoueur=partie.getJoueurActuel(); //rÈcupÈration du numÈro du joueur actuel
		if(avoirObjetUnCoup(elementspartie,partie,numJoueur)!=null) { //Si on ne peut pas avoir l'objet en 1 coup
			for(int entree1=0; entree1<27; entree1++) { //Parcoure les entrÈes du premier tour
				for (int orien1 = 0; orien1<3; orien1++) { //On parcours les diffÈrentes orientations du coup 1
					ElementsPartie copyElementPartie = elementspartie.copy(); //Copie du plateau
					copyElementPartie.getPieceLibre().setOrientation(orien1); //DÈfinition de l'orientation de la piËce libre
					copyElementPartie.insertionPieceLibre(entree1); //Insertion de la piËce libre tour 1
					int colonne = copyElementPartie.getJoueurs()[numJoueur].getProchainObjet().getPosColonnePlateau(); //RÈcupËre ???
					for (int entree2=0; entree2<27; entree2++) { //Parcours les entrÈes au 2Ëme tour
						for(int orien2=0; orien2<3; orien2++) { //Parcours les orientations au 2Ëme tour
							copyElementPartie.insertionPieceLibre(entree2); //Insertion de la piËce libre tour 2
							if(copyElementPartie.getPlateau().calculChemin(copyElementPartie.getJoueurs()[numJoueur].getPosLigne(), copyElementPartie.getJoueurs()[numJoueur].getPosColonne(), PositionLigne, PositionColonne))
								tabSolution[nbSolution][0] = entree1;
								tabSolution[nbSolution][1] = orien1;
								nbSolution++;
						}
					}
				}
			}
		}
	}
	

	@Override
	public String getCategorie() {
		return "OrdiType3";
	}

	
	@Override
	public Joueur copy(Objet objets[]){
		Joueur nouveauJoueur=new JoueurOrdinateurT3(getNumJoueur(),getNomJoueur(), getNumeroImagePersonnage(),getPosLigne(),getPosColonne());
		nouveauJoueur.setObjetsJoueur(this.getObjetsJoueurGeneral(objets));
		while (nouveauJoueur.getNombreObjetsRecuperes()!=this.getNombreObjetsRecuperes())
			nouveauJoueur.recupererObjet();
		return nouveauJoueur;
	}

}
