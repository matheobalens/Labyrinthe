package composants;

/**
 * 
 * Cette classe permet de représenter les pièces du jeu de modèle 2.
 *
 */
public class PieceM2 extends Piece {

	/**
	 * A Faire (04/05/2021 AS,B Finalisée)
	 * 
	 * Constructeur permettant de construire une piÃ¨ce de modÃ¨le 2 et d'orientation 0.
	 */
	public PieceM2() {
		super(2,true,true,false,true); 
	}
	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de créer une copie de la pièce (un nouvelle objet Java).
	 * @return Une copie de la pièce.
	 */
	public Piece copy(){
		Piece piece = new PieceM2();
		piece.setOrientation(this.getOrientationPiece());
		return piece;
	}
}