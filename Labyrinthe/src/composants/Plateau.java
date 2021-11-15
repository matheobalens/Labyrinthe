package composants;

import java.util.Date;
import java.util.Random;

import grafix.interfaceGraphique.IG;



/**
 * Cette classe permet de gï¿½rer un plateau de jeu constituï¿½ d'une grille de piï¿½ces (grille de 7 lignes sur 7 colonnes).
 *
 */
public class Plateau {

	private Piece plateau[][]; // Création du plateau.

	/**
	 * A Faire (16/05/2021 M,AS,N,B Pas terminée)
	 * 
	 * Constructeur permettant de construire un plateau vide (sans pièces) et d'une taille de 7 lignes sur 7 colonnes.
	 */
	public Plateau() {
        plateau = new Piece[7][7];
    }
	
	/**
	 * A Faire (17/05/2021 B,AS,N,M Finalisée)
	 * 
	 * Méthode permettant de placer une pièce sur le plateau.
	 * 
	 * @param piece La pièce à placer.
	 * @param lignePlateau La ligne du plateau sur laquelle sera placée la pièce (un entier entre 0 et 6).
	 * @param colonnePlateau La colonne du plateau sur laquelle sera placée la pièce (une entier entre 0 et 6).
	 */
	public void positionnePiece(Piece piece,int lignePlateau,int colonnePlateau){
		this.plateau[lignePlateau][colonnePlateau] = piece;
	}

	/**
	 * A Faire (17/05/2021 B Finalisée)
	 * 
	 * Méthode retournant une pièce se trouvant sur le plateau à un emplacement spécifique.
	 * 
	 * @param lignePlateau La ligne du plateau  (un entier entre 0 et 6).
	 * @param colonnePlateau La colonne du plateau (un entier entre 0 et 6).
	 * @return La pièce se trouvant sur la ligne lignePlateau et la colonne colonnePlateau. S'il n'y a pas de pièce, null est retournée.
	 */
	public Piece getPiece(int lignePlateau,int colonnePlateau){
		if (lignePlateau<7 && colonnePlateau<7) {
		return this.plateau[lignePlateau][colonnePlateau];
		} else {
		return null;
		}
	}

	/**
	 * 
	 * A Faire (18/05/2021 B,AS,M,N Statut)
	 *  
	 * Méthode permettant de placer aléatoirment 49 pièces du jeu sur le plateau.
	 * L'orientation des pièces est aléatoire. Les pièces utilisées doivent être des nouvelles pièces générées à partir de la méthode Piece.nouvellesPieces.
	 * Parmi les 50 pièces du jeu, la pièce qui n'a pas été placée sur le plateau est retournée par la méthode.
	 * 
	 * @return La seule pièce qui n'a pas été placée sur le plateau
	 */
	public Piece placerPiecesAleatoirement(){
        Piece[] tabPieces = Piece.nouvellesPieces();
        int indicesPieces[] = Utils.genereTabIntAleatoirement(50);
        int cpt=0; //compteur des pièces
        for(int i=0; i<=6; i++) {
        	for(int j=0; j<=6; j++) {
        		this.plateau[i][j] = tabPieces[indicesPieces[cpt++]];
        		//IG.changerPiecePlateau(i, j, plateau[i][j].getModelePiece(), plateau[i][j].getOrientationPiece());
        		IG.changerPiecePlateau(i,j,tabPieces[indicesPieces[cpt]].getModelePiece(),tabPieces[indicesPieces[cpt]].getOrientationPiece());
        	}
          	}
        Random generateur=new Random((new Date().getTime()));
        for (int i = 0; i<=6; i++) {
        	for (int j = 0; j<=6; j++) {
        		plateau[i][j].setOrientation(generateur.nextInt(4));
        	}
            }
        
        return tabPieces[indicesPieces[cpt]];
    }

	/**
	 * 
	 * Méthode utilitaire permettant de tester si les positions passées en paramètre sont les positions de deux cases diffï¿½rentes et adjacentes d'une grille de 7 lignes sur 7 colonnes.
	 *  
	 * @param posLigCase1 Un entier quelconque.
	 * @param posColCase1 Un entier quelconque.
	 * @param posLigCase2 Un entier quelconque.
	 * @param posColCase2 Un entier quelconque.
	 * @return true si les les positions passï¿½es en paramï¿½tre sont les positions de deux cases diffï¿½rentes et adjacentes d'une grille de 7 lignes sur 7 colonnes, false sinon.
	 */
	private static boolean casesAdjacentes(int posLigCase1,int posColCase1,int posLigCase2,int posColCase2){
		if ((posLigCase1<0)||(posLigCase2<0)||(posLigCase1>6)||(posLigCase2>6)) return false;
		if ((posColCase1<0)||(posColCase2<0)||(posColCase1>6)||(posColCase2>6)) return false;
		int distLigne=posLigCase1-posLigCase2;
		if (distLigne<0) distLigne=-distLigne;
		int distColonne=posColCase1-posColCase2;
		if (distColonne<0) distColonne=-distColonne;
		if ((distLigne>1)||(distColonne>1)||((distColonne+distLigne)!=1))
			return false;
		return true;
	}

	/**
	 * 
	 * A Faire (18/05/2021 B Finalisée)
	 * 
	 * Mï¿½thode permettant de tester si les positions passï¿½es en paramï¿½tre sont les positions de deux cases diffï¿½rentes et adjacentes 
	 * de la grille de jeu et qu'il est possible de passer d'une cas ï¿½  l'autre compte tenu des deux piï¿½ces posï¿½es sur les deux cases du plateau.
	 * 
	 * @param posLigCase1 Un entier quelconque.
	 * @param posColCase1 Un entier quelconque.
	 * @param posLigCase2 Un entier quelconque.
	 * @param posColCase2 Un entier quelconque.
	 * @return true si les positions passï¿½es en paramï¿½tre sont les positions de deux cases diffï¿½rentes et adjacentes de la grille de jeu et qu'il est possible de passer d'une cas ï¿½  l'autre compte tenu des deux piï¿½ces posï¿½es sur les deux cases du plateau, false sinon.
	 */
	private boolean passageEntreCases(int posLigCase1,int posColCase1,int posLigCase2,int posColCase2){
        
        // A Compléter
        Piece PieceCase1 = getPiece(posLigCase1, posColCase1);
        Piece PieceCase2 = getPiece(posLigCase2, posColCase2);

        if(posColCase1 != posColCase2 && posLigCase1 != posLigCase2 && casesAdjacentes(posLigCase1, posColCase1, posLigCase2, posColCase2)){
            if(posLigCase1 == posLigCase2){
                if(posColCase1 < posColCase2){
                    return (PieceCase1.getPointEntree(1) && PieceCase2.getPointEntree(3));
                }
                else return (PieceCase1.getPointEntree(3) && PieceCase2.getPointEntree(1));
            }
            else {
                if(posLigCase1 < posLigCase2){
                    return (PieceCase1.getPointEntree(2) && PieceCase2.getPointEntree(0));
                }
                else return (PieceCase1.getPointEntree(0) && PieceCase2.getPointEntree(2));
            }
        }
        else return false;
    }
	 

	/**
	 * 
	 * A Faire (B,AS,M,N 18/05/2021 Non Finalisée)
	 * 
	 * Mï¿½thode permettant de retourner un ï¿½ventuel chemin entre deux cases du plateau compte tenu des piï¿½ces posï¿½es sur le plateau.
	 * Dans le cas oï¿½ il n'y a pas de chemin entre les deux cases, la valeur null est retournï¿½e.
	 * Dans le cas oï¿½ il existe un chemin, un chemin possible est retournï¿½ sous forme d'un tableau d'entiers ï¿½ deux dimensions.
	 * La premiï¿½re dimension correspond aux cases du plateau ï¿½  emprunter pour aller de la case de dï¿½part ï¿½  la case d'arrivï¿½e.
	 * Dans ce tableau, chaque case est un tableau de deux entiers avec le premier entier qui correspond ï¿½  la ligne de la case et
	 * le second entier qui correspond ï¿½  la colonne de la case. La premiï¿½re case d'un chemin retournï¿½ correspond toujours 
	 * ï¿½  la case (posLigCaseDep,posColCaseDep) et la derniï¿½re case correspond toujours ï¿½  la case (posLigCaseArr,posColCaseArr).
	 *
	 * @param posLigCaseDep La ligne de la case de dï¿½part (un entier compris entre 0 et 6).
	 * @param posColCaseDep La colonne de la case de dï¿½part (un entier compris entre 0 et 6).
	 * @param posLigCaseArr La ligne de la case d'arrivï¿½e (un entier compris entre 0 et 6).
	 * @param posColCaseArr La colonne de la case d'arrivï¿½e (un entier compris entre 0 et 6).
	 * @return null si il n'existe pas de chemin entre les deux case, un chemin sinon.
	 */
	
	public int[][] calculChemin(int posLigDep, int posColDep, int posLigArr, int posColArr) {
        int mat[][] = new int[7][7];
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++)
                mat[i][j] = -1;
        mat[posLigDep][posColDep] = 0;
        boolean fin = false;
        int val = 0;
        while (!fin) {
            fin = true;
            for (int i = 0; i < 7; i++)
                for (int j = 0; j < 7; j++)
                    if (mat[i][j] == -1) {
                        if (passageEntreCases(i, j, i, j) && (mat[i][j] == val)) {
                            mat[i][j] = val + 1;
                            fin = false;
                        }
                        if (passageEntreCases(i, j, i + 1, j) && (mat[i + 1][j] == val)) {
                            mat[i][j] = val + 1;
                            fin = false;
                        }
                        if (passageEntreCases(i, j, i, j) && (mat[i][j] == val)) {
                            mat[i][j] = val + 1;
                            fin = false;
                        }
                        if (passageEntreCases(i, j, i, j + 1) && (mat[i][j + 1] == val)) {
                            mat[i][j] = val + 1;
                            fin = false;
                        }
                    }
            val++;
        }


        int lig, col;

        int valArrivee = mat[posLigArr][posColArr];
        if (valArrivee == -1) return null;
        int resultat[][] = new int[valArrivee + 1][2];
        resultat[valArrivee][0] = posLigArr;
        resultat[valArrivee][1] = posColArr;
        for (int i = valArrivee - 1; i >= 0; i--) {
            lig = resultat[i + 1][0];
            col = resultat[i + 1][1];
            if (passageEntreCases(lig, col, lig - 1, col) && (mat[lig - 1][col] == i)) {
                resultat[i][0] = lig - 1;
                resultat[i][1] = col;
            } else if (passageEntreCases(lig, col, lig + 1, col) && (mat[lig + 1][col] == i)) {
                resultat[i][0] = lig + 1;
                resultat[i][1] = col;
            } else if (passageEntreCases(lig, col, lig, col - 1) && (mat[lig][col - 1] == i)) {
                resultat[i][0] = lig;
                resultat[i][1] = col - 1;
            } else if (passageEntreCases(lig, col, lig, col + 1) && (mat[lig][col + 1] == i)) {
                resultat[i][0] = lig;
                resultat[i][1] = col + 1;
            }

        }
        return resultat;
    }

	/**
	 * 
	 * Mï¿½thode permettant de calculer un chemin dï¿½taillï¿½ (chemin entre sous-cases) ï¿½  partir d'un chemin entre cases.
	 *  
	 * @param chemin Un tableau reprï¿½sentant un chemin de cases.
	 * @param numJoueur Le numï¿½ro du joueur pour lequel nous souaitons construire un chemin dï¿½taillï¿½.
	 * 
	 * @return Le chemin dï¿½taillï¿½ correspondant au chemin de positions de piï¿½ces donnï¿½es en paramï¿½tre et pour le numï¿½ro de joueur donnï¿½.
	 */
	public int[][] calculeCheminDetaille(int[][] chemin,int numJoueur){
		if (chemin.length==1)
			return new int[0][0];
		int[][] cheminDetaille=new int[chemin.length*5][4];
		int pos=0;
		int col,lig,colS,ligS;
		for (int i=0;i<chemin.length-1;i++){
			lig=chemin[i][0];
			col=chemin[i][1];
			ligS=chemin[i+1][0];
			colS=chemin[i+1][1];
			if (ligS<lig){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=0;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=2;
				cheminDetaille[pos++][3]=1;
			}
			else if (ligS>lig){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=2;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=0;
				cheminDetaille[pos++][3]=1;
			} else if (colS<col){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=0;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=2;
			} else if (colS>col){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=2;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=0;
			}
		}
		cheminDetaille[pos][0]=chemin[chemin.length-1][0];
		cheminDetaille[pos][1]=chemin[chemin.length-1][1];
		cheminDetaille[pos][2]=1;
		cheminDetaille[pos++][3]=1;

		int debut=0;
		if ((numJoueur==0)&&((cheminDetaille[pos-2][2]==0)||(cheminDetaille[pos-2][3]==2))) pos--;
		if ((numJoueur==1)&&((cheminDetaille[pos-2][2]==2)||(cheminDetaille[pos-2][3]==2))) pos--;
		if ((numJoueur==2)&&((cheminDetaille[pos-2][2]==2)||(cheminDetaille[pos-2][3]==0))) pos--;
		if ((numJoueur==0)&&((cheminDetaille[1][2]==0)||(cheminDetaille[0][3]==2))) debut++;
		if ((numJoueur==1)&&((cheminDetaille[1][2]==2)||(cheminDetaille[0][3]==2))) debut++;
		if ((numJoueur==2)&&((cheminDetaille[1][2]==2)||(cheminDetaille[0][3]==0))) debut++;

		int[][] resultat=new int[pos-debut][4];
		for (int i=debut;i<pos;i++)
			for (int j=0;j<4;j++)
				resultat[i-debut][j]=cheminDetaille[i][j];
		return resultat;	
	}

	/**
	 * 
	 * Mï¿½thode retournant une copie du plateau avec des copies de ses piï¿½ces.
	 * 
	 * @return Une copie du plateau avec une copie de toutes ses piï¿½ces.
	 */
	public Plateau copy(){
		Plateau plateau=new Plateau();
		for (int ligne=0;ligne<7;ligne++)
			for (int colonne=0;colonne<7;colonne++)
				plateau.positionnePiece((this.plateau[ligne][colonne]).copy(), ligne, colonne);
		return plateau;
	}

}