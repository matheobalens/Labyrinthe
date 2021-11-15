package composants;

import grafix.interfaceGraphique.IG;

/**
 * 
 * Cette classe permet de reprÃ©senter chacun des objets du jeu.
 *
 */
public class Objet {

	private int numObjet; // Le numÃ©ro de l'objet (un entier entre 0 et 17).
	private int posLignePlateau; // La ligne du plateau sur laquelle est Ã©ventuellement posÃ© l'objet (un entier entre -1 et 6, -1:lorsqu'il n'est pas sur le plateau).
	private int posColonnePlateau; // La colonne du plateau sur laquelle est Ã©ventuellement posÃ© l'objet (un entier entre -1 et 6, -1:lorsqu'il n'est pas sur le plateau).
	private boolean surPlateau; // Indique si l'objet est sur le plateau ou non (true : sur le plateau, false : hors du plateau).

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Constructeur permettant de construire un objet qui est initialement hors du plateau.
	 * 
	 * @param numObjet Le numÃ©ro de l'objet.
	 */
	
	public Objet(int numObjet) {
		this.numObjet = numObjet;
	}

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * MÃ©thode permettant de gÃ©nÃ©rer un tableau contenant les 18 objets du jeu.
	 * Les objets seront postionnÃ©es alÃ©atoirement sur le plateau. Deux objets ne pourront pas Ãªtre sur une mÃªme case (mÃªme ligne et mÃªme colonne).
	 * 
	 * @return Un tableau de 18 objets initialisés pour une partie du jeu. Chaque objet a une position gÃ©nÃ©rÃ©e alÃ©atoirement. Les positions sont diffÃ©rentes pour deux objets distincts.
	 *
	 */
	public static Objet[] nouveauxObjets(){
        int compteur = 0; //création compteur
        Objet objets[] = new Objet[18]; //création du tableau
        int ligne = Utils.genererEntier(6); //On génère 6 entiers pour les lignes
        int colonne = Utils.genererEntier(6); //On génère 6 entiers pour les colonnes

        objets[compteur] = new Objet(compteur); //On créé un objet du numéro du compteur
        objets[compteur].posLignePlateau = ligne; //Cet objet prend une valeur aléatoire pour une ligne
        objets[compteur].posColonnePlateau = colonne; //Cet objet prend une valeur aléatoire pour une colonne
        objets[compteur].surPlateau = true; //L'objet du numéro du compteur est donc sur le plateau !
        compteur++; //On incrémente le compteur

        while(compteur<18){
            boolean verif = true; //On passe la vérif à true
            ligne = Utils.genererEntier(6); //On génère 6 entiers pour les lignes
            colonne = Utils.genererEntier(6); //On génère 6 entiers pour les colonnes
            for(int i=0; i<compteur; i++){ //De i jusqu'au compteur
                if(objets[i].posLignePlateau == ligne && objets[i].posColonnePlateau == colonne){ //si la position de la ligne = position de la colonne
                    verif = false; //On passe la vérif à false
                }
            }
            if(verif){ //Si la vérification est à true
                objets[compteur] = new Objet(compteur);
                objets[compteur].posLignePlateau = ligne;
                objets[compteur].posColonnePlateau = colonne;
                objets[compteur].surPlateau = true;
                compteur++;
            }
        }
        return objets;
    }

	/**
	 * 
	 * A Faire (13/05/2021 AS FinalisÃ©e)
	 * 
	 * MÃ©thode retournant le numÃ©ro de l'objet.
	 * 
	 * @return Le numÃ©ro de l'objet.
	 */
	
	public int getNumeroObjet() {
		return numObjet;
	}


	/**
	 * 
	 * A Faire (13/05/2021 AS FinalisÃ©e)
	 * 
	 * MÃ©thode retournant le numÃ©ro de la ligne sur laquelle se trouve l'objet.
	 * 
	 * @return Le numÃ©ro de la ligne sur laquelle se trouve l'objet.
	 */
	public int getPosLignePlateau() {
		return posLignePlateau; 
	}

	/**
	 * 
	 * A Faire (13/05/2021 AS FinalisÃ©e)
	 * 
	 * MÃ©thode retournant le numÃ©ro de la colonne sur laquelle se trouve l'objet.
	 * 
	 * @return Le numÃ©ro de la colonne sur laquelle se trouve l'objet.
	 */
	public int getPosColonnePlateau() {
		return posColonnePlateau; 
	}
	
	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * MÃ©thode permettant de positionner l'objet sur une ligne et une colonne donnée en paramètre.
	 * 
	 * @param lignePlateau Un entier compris entre 0 et 6.
	 * @param colonnePlateau Un entier compris entre 0 et 6.
	 */
	public void positionneObjet(int lignePlateau,int colonnePlateau){
		IG.placerObjetPlateau(numObjet, lignePlateau, colonnePlateau);
	}

	/**
	 * 
	 * A Faire (Quand AS,M, Statut)
	 * 
	 * MÃ©thode permettant d'enlever l'objet du plateau.
	 * 
	 */
	public void enleveDuPlateau(){
        this.posLignePlateau = -1;
        this.posColonnePlateau = -1;
        this.surPlateau = this.surPlateau();
    }
	
	/**
	 * 
	 * A Faire (13/05/2021 AS FinalisÃ©e)
	 * 
	 * Méthode indiquant si l'objet est sur le plateau ou non.
	 * 
	 * @return true si l'objet est sur le plateau, false sinon.
	 */
	public boolean surPlateau() {
		if ((posLignePlateau == -1) && (posColonnePlateau == -1)) {
			return false;
		}
		return true;
	}

	/**
	 * MÃ©thode permettant d'obtenir une reprÃ©sentation d'un objet sous forme de chaÃ®ne de caractÃ¨res.
	 */
	@Override
	public String toString() {
		return "Objet [numObjet=" + numObjet + ", posLignePlateau=" + posLignePlateau + ", posColonnePlateau="
				+ posColonnePlateau + ", surPlateau=" + surPlateau + "]";
	}

	/**
	 * 
	 * MÃ©thode permettant de copier l'objet.
	 * 
	 * @return Une copie de l'objet.
	 */
	public Objet copy(){
		Objet objet=new Objet(numObjet);
		objet.posLignePlateau=posLignePlateau;
		objet.posColonnePlateau=posColonnePlateau;
		objet.surPlateau=surPlateau;
		return objet;
	}

	/**
	 * Programme testant quelques mÃ©thodes de la classe Objet.
	 * @param args arguments du programme
	 */
	public static void main(String[] args) {
		// Un petit test ...
		System.out.println("*** GÃ©nÃ©ration et affichage des 18 objets ... ***");
		Objet objetsJeu[]=nouveauxObjets();
		for (int i=0;i<objetsJeu.length;i++)
			System.out.println(objetsJeu[i]);
		System.out.println("*** On enlÃ¨ve les 18 objets du plateau ... ***");
		for (int i=0;i<objetsJeu.length;i++)
			 objetsJeu[i].enleveDuPlateau();
		System.out.println("*** On affiche de nouveau les 18 objets ... ***");
		for (int i=0;i<objetsJeu.length;i++)
			System.out.println(objetsJeu[i]);
	}
	
}