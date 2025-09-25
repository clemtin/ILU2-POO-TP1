package villagegaulois;

import java.util.Iterator;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	
	/* classe Marche avec constructeur  */
	
	private static class Marche {
		private Etal[] etals;

		public Marche(int NbEtals) {
			this.etals = new Etal[NbEtals];
			for (int i = 0; i < etals.length; i++) {
				etals[i] = new Etal();
			}	
		}
	
	
	/* premiere methode */
		
	private void utiliserEtal (int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
		etals[indiceEtal].occuperEtal(vendeur,produit,nbProduit);
	}
	
	
	private int trouverEtalLibre() {
		for (int i = 0; i < etals.length; i++) {
			if(!(etals[i].isEtalOccupe()))
				return i;
		}
		
		return -1;
	}
	
	private Etal[] trouverEtals(String produit) {
		int nbrEtals = 0;
		for (int i = 0; i < etals.length; i++) {
			if(etals[i].contientProduit(produit)) {
				nbrEtals ++;
			}
		}
		Etal[] etals1 = new Etal[nbrEtals];
		
		for (int i = 0, j = 0; i < etals1.length; i++) {
			if(etals[i].contientProduit(produit)) {
				etals1[j]=etals[i];
				j++;
			}
		}
		return etals1;
	}
	
	
	
	}
}