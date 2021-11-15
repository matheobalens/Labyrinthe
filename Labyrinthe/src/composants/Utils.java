package composants;

import java.util.Date;
import java.util.Random;

/**
 * 
 * Classe contenant quelques fonctions utilitaires.
 * 
 */
public class Utils {
	
	private static Random generateur=new Random((new Date().getTime()));

	/**
	 * A Faire (30/04/21 AS,B Finalisée)
	 * 
	 * Méthode permettant de générer aléatoirement un nombre entier.
	 * 
	 * @param max Le nombre entier maximal pouvant être retourné.
	 * @return Un nombre entier compris entre 0 et max (inclus).
	 */
	
	public static int genererEntier(int max){
		Random generateur = new Random();
		int nb;
		nb = generateur.nextInt(max);
		return nb;
	}
	
	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de générer un tableau d'entiers dont la longueur longTab est donnée en paramètre.
	 * Le tableau généré doit contenir chaque entier compris entre 0 et longTab-1. La position de ces entiers
	 * dans le tableau doit être aléatoire.
	 * 
	 * @param longTab La longueur du tableau.
	 * @return Un tableau contenant les entiers 0,...,longTab-1 placés aléatoirement dans le tableau.
	 */
	public static int[] genereTabIntAleatoirement(int longTab){
		int tab[] = new int[longTab];
        int i = 0;
        boolean dansTableau;
        while(i != longTab) { //tant que i différent de longueur tab
            tab[i] = generateur.nextInt(longTab); //je génère un nb aléatoire
            dansTableau = false;
            for(int j=0; j<i; j++) {  //de j jusqu'à i (non inclus) for(int j=0; j!=i; j++)
                if(tab[j] == tab[i]) { //je vérifie si le nombre actuel est égal aux nombres précédents
                    dansTableau = true; //si c'est le cas, je passe à true donc je n'incrémente pas i, un nouveau nombre est alors généré
                }
            }
            if(!dansTableau) {
                i++;
            }
        }
        return tab;
    }
	
	
	
	/**
	 * Programme testant la méthode genereTabIntAleatoirement.
	 * @param args arguments du programme
	 */
	public static void main(String[] args) {
		// Un petit test ...
		int tab[]=genereTabIntAleatoirement(18);
		for (int i=0;i<tab.length;i++)
			System.out.print(tab[i]+" ");

	}

}