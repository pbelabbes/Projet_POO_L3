package kernel.relation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ParseurXML {
	// Nom du fichier à parser
	String f;
	
	/**
	 * Methode permettant d'initialiser le parseur
	 * @param f de type string
	 */
	public ParseurXML(String f){
		this.f = f;
	}
	
	/**
	 * Methode permettant de retourner le nom de la BD
	 * @return Nom : nom de la bd
	 */
	public String getNom() {
		String Nom = "";
		InputStream s;
		try {
			s = new FileInputStream(f);
			BufferedInputStream bs = new BufferedInputStream(s);
			Scanner sc = new Scanner(bs);
			sc.useLocale(Locale.ENGLISH).useDelimiter("\"");
			goTo_name(sc);
			Nom = sc.next();
			sc.close();
			s.close();
			bs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Nom;
	}
	
	/**
	 * Methode permettant de retourner une String au format : "nomAttribut typeAttribut "
	 * @param sc de type Scanner
	 * @return Attribut 
	 */
	public String getAttribut(Scanner sc) {
		String Attribut = sc.next() + " ";
		sc.next();
		Attribut += sc.next() + " ";
		return Attribut;
	}
	
	/**
	 * Methode permettant de retourner une String au format : "name\nRelation"
	 * @param name de type String
	 * @return Relation 
	 */
	public String getRelation(String name) {
		String Relation = name + " : ";
		InputStream s;
		try {
			s = new FileInputStream(f);
			BufferedInputStream bs = new BufferedInputStream(s);
			Scanner sc = new Scanner(bs);
			sc.useLocale(Locale.ENGLISH).useDelimiter("\"");
			while(!sc.next().contains(name)) {
			}
			goTo_name(sc);
			String tmp="";
			while (!tmp.contains("</Relation>")) {
				Relation += getAttribut(sc);
				tmp=sc.next();
			}
			sc.close();
			s.close();
			bs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Relation;
	}
	
	/**
	 * Methode permettant de retourner un tableau de nom de relation"
	 * @param sc de type Scanner
	 * @return Relation 
	 */
	public String[] getNomRelations(Scanner sc) {
		List<String> listeRelations = new ArrayList<String>();
		while(sc.hasNextLine()) {
			goTo_relationName(sc);
			if (sc.hasNextLine()) {listeRelations.add(sc.next());}
		}
		String[] Relations = new String[listeRelations.size()];
		for(int i=0; i<Relations.length; i++) {
			Relations[i]=listeRelations.get(i);
		}
		return Relations;
	}
	
	/**
	 * Methode permettant de retourner une String du format : "Nom\nRelations"
	 * @return Relation 
	 */
	public String getBD() {
		String BD = "";
		try {
			InputStream s = new FileInputStream(f);
			BufferedInputStream bs = new BufferedInputStream(s);
			Scanner sc = new Scanner(bs);
			sc.useLocale(Locale.ENGLISH).useDelimiter("\"");
			goTo_name(sc);
			BD = sc.next();
			String[] names = getNomRelations(sc);
			for(int i=0; i<names.length; i++) {
				BD += "\n" + getRelation(names[i]);
			}
			sc.close();
			s.close();
			bs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return BD;
	}
	
	/**
	 * Methode permettant de placer le Scanner devant le nom suivant si il n'y est pas 
	 * @param sc de type Scanner
	 */
	public void goTo_name(Scanner sc) {
		if(!sc.hasNext(".*name")) {
			while(!sc.next().contains("name=")) {
			}
		}
	}
	
	/**
	 * Methode permettant de placer le Scanner devant le nom suivant si il n'y est pas 
	 * @param sc de type Scanner
	 */
		public void goTo_relationName(Scanner sc) {
			if(!sc.hasNext(".*\n.*\n.*Relation name")) {
				while(sc.hasNextLine() && !sc.next().contains("Relation name=")) {
				}
			}
		}

}
