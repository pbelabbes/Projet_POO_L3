package kernel;

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
	
	public ParseurXML(String f){
		this.f = f;
	}
	// Retourne le nom de la DB
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
		
	// retourne une String au format : "nomAttribut typeAttribut "
	public String getAttribut(Scanner sc) {
		String Attribut = sc.next() + " ";
		sc.next();
		Attribut += sc.next() + " ";
		return Attribut;
	}

	// retourne une String au format : "name\nRelation"
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
	

	// retourne un tableau de nom de relation"
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
	
	// retourne une String du format : "Nom\nRelations"
	public String getDB() {
		String DB = "";
		try {
			InputStream s = new FileInputStream(f);
			BufferedInputStream bs = new BufferedInputStream(s);
			Scanner sc = new Scanner(bs);
			sc.useLocale(Locale.ENGLISH).useDelimiter("\"");
			goTo_name(sc);
			DB = sc.next();
			String[] names = getNomRelations(sc);
			for(int i=0; i<names.length; i++) {
				DB += "\n" + getRelation(names[i]);
			}
			sc.close();
			s.close();
			bs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DB;
	}
	
	//place le Scanner devant le nom suivant si il n'y est pas déjà
	public void goTo_name(Scanner sc) {
		if(!sc.hasNext(".*name")) {
			while(!sc.next().contains("name=")) {
			}
		}
	}
	//place le Scanner devant le nom suivant si il n'y est pas déjà
		public void goTo_relationName(Scanner sc) {
			if(!sc.hasNext(".*\n.*\n.*Relation name")) {
				while(sc.hasNextLine() && !sc.next().contains("Relation name=")) {
				}
			}
		}

}
