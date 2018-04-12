package kernel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Schema;

import TypeBD.*;
import kernel.relation.Attribute;
import kernel.relation.Index;

public class StateFullFile {

	private File DB;
	private ParseurXML relation;

	/**
	 * Constructeur avec une relation remplie
	 * @param DB_XML
	 */
	public StateFullFile(String DB_XML) {
		DB = new File(DB_XML);
		this.relation = new ParseurXML(DB_XML);
	}
	
	/**
	 * Constructeur d'une stateFullFile
	 * @param DB_XML le nom du fichier contenant la DB
	 * @param relation le nom de la relation que nous recherchons
	 */
	public StateFullFile(String DB_XML, String relation) {
		DB = new File(DB_XML);
		this.relation = new ParseurXML(DB_XML);
		chargerSchema(relation);
	}

	
	/**
	 * Ajout un tuple a la fin du fichier de DB
	 * @param tuple un tuple sous forme de string
	 */
	public void insert(String tuple) throws IOException {

		FileWriter fi = new FileWriter(DB, true);
		fi.write(tuple);

		fi.close();
	}

	
	/**
	 * Update d'une valeur d'un tuple
	 * @param attributes l'attribut ou faire l'update
	 * @oldValeur l'ancienne valeur a modifier
	 * @newValeur la nouvelle valeur a ajouter
	 */
	public void update(Schema attributes, String oldValeur, String newValeur) {

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(DB));

			String line;
			StringBuffer inputBuffer = new StringBuffer();

			while ((line = br.readLine()) != null) {
				line = line.subSequence(1, line.length() - 1).toString();
				String[] tmp = line.split(";");

				System.out.println(tmp[0]);
				inputBuffer.append("/");
				if (tmp[(attributes).getIndice()].equalsIgnoreCase(oldValeur)) {
					tmp[attributes.getIndice()] = new String(newValeur);

					int i = 0;
					for (i = 0; i < tmp.length - 1; i++) {
						inputBuffer.append(tmp[i]);
						inputBuffer.append(";");
					}
					inputBuffer.append(tmp[i]);

				} else
					inputBuffer.append(line);

				inputBuffer.append("\\");
				inputBuffer.append('\n');
			}

			String inputStr = inputBuffer.toString();
			br.close();

			FileOutputStream fileOut = new FileOutputStream(DB);
			fileOut.write(inputStr.getBytes());
			fileOut.close();
		} catch (IOException e) {
			System.out.println("ok");
			e.printStackTrace();
		}

	}

	
	/**
	 * Supprime les tuples contenant une certaine valeur
	 * @param attributes l'index de la attributesonne contenant la valeur
	 * @param valeur, la valeur a rechercher pour supprimer le tuple
	 */
	public void delete(Schema attributes, String valeur) {

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(DB));

			String line;
			StringBuffer inputBuffer = new StringBuffer();

			while ((line = br.readLine()) != null) {
				line = line.subSequence(1, line.length() - 1).toString();
				String[] tmp = line.split(";");

				System.out.println(tmp[0]);

				if (!tmp[attributes.Index.getIndice()].equalsIgnoreCase(valeur)) {
					inputBuffer.append("/");
					inputBuffer.append(line);
					inputBuffer.append("\\");
					inputBuffer.append('\n');
				}
			}

			String inputStr = inputBuffer.toString();
			br.close();

			FileOutputStream fileOut = new FileOutputStream(DB);
			fileOut.write(inputStr.getBytes());
			fileOut.close();
		} catch (IOException e) {
			System.out.println("ok");
			e.printStackTrace();
		}
	}

	/**
	 * Retourne la valeur a une certaine attributesonne et ligne
	 * @attributes l'index de la attribut
	 * @return la valeur
	 */
	public String getValues(Index index, Index indice) {
		System.out.println(" alors " + getTuple(Index.getIndice()));
		String tuple = getTuple(index.getIndice());
		String resultat = "";
		if (tuple != "") {
			String[] tableauattributes = tuple.split(";");
			
			resultat = tableauattributes[Index.getIndice()];
		}
		return resultat;
	}

	public String getTuple(int indice) {
		BufferedReader br;
		StringBuffer res = new StringBuffer("");
		try {
			br = new BufferedReader(new FileReader(DB));
			int ligneCursor = 1;
			String curseur;
			while (ligneCursor <= indice && (curseur = br.readLine()) != null) {

				if (ligneCursor == indice) {
					res.append(curseur);
				}
				ligneCursor++;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res.substring(1, res.length() - 1);
	}

	/**
	 * permet d'afficher la table
	 */
	public void afficheTable() {
		getMaxLigne();
		int ligne = Index.getIndice();
		int attributes = Index.getIndice();

		for (int i = 1; i < ligne; i++) {
			for (int j = 1; j < attributes; j++) {
				System.out.print(getValues(new Index(j), new Index(i)) + " ");
			}
			System.out.println();
		}
	}

	/**
	 * retourne l'index de la derniere ligne
	 */
	public Index getMaxLigne() {
		BufferedReader br;
		int nbLignes = 0;
		try {
			br = new BufferedReader(new FileReader(DB));
			while (br.readLine() != null)
				nbLignes++;
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Index(nbLignes);
	}

	/**
	 * cherche le type primitif correpsondant au string
	 * @param atr l'attribut en string
	 * @return le type primitif de l'attribut
	 */
	protected TypePrimitif recherche_type_primitif(String atr) {

		String attribut[] = atr.split(";");

		switch (attribut[0]) {
		case "BOOLEAN":
			return new BooleanBD();
		case "BYTE":
			return new ByteBD(0);
		case "CHAR":
			return new CharacterDB();
		case "DATE":
			return new DateDB();
		case "DOUBLE":
			return new DoubleDB();
		case "FLOAT":
			return new FloatDB();
		case "INT":
		case "INTEGER":
			return new IntegerDB();
		case "LONG":
			return new LongDB();
		case "SHORT":
			return new ShortDB();
		case "STRING":
			return new StringDB(Integer.parseInt(attribut[1]));
		default:
			return null;
		}
	}
	
	/**
	 * Retourne le string d'un attribut pour un XML
	 * @param atr l'attribut DB
	 * @return l'attribut en string
	 */
	protected String recherche_type(String atr) {
		return atr.replace("DB", "").toUpperCase();
	}

	/**
	 * Charge le schema en memoire pour pouvoir l'utiliser
	 * @param table le nom de la relation a stocké en memoire
	 */
	public void chargerSchema(String relation) {
		String tmp = relation.getRelation();
		String nom_attribut[] = tmp.split("\n");
		String attribut[] = nom_attribut[1].split(" ");
		List<Attribut> liste_attribut = new ArrayList<Attribut>();
		Attribut atr;
		int i = 0;

		while (i < attribut.length - 1) {
			atr = new Attribute(attribut[i], recherche_type_primitif(attribut[i + 1]));
			liste_attribut.add(atr);
			i += 2;
		}
		schema = new Schema(nom_attribut[0], liste_attribut, new Index(0));
	}

	/**
	 * enregistre dans un fichier le schema stocké
	 * @param nomDB le nom du fichier ou il faut stocké
	 * @param schem le schema a stocker
	 */
	public void sauvegarderSchema(String nomDB, Schema schem) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(nomDB));
			String line;
			StringBuffer bf = new StringBuffer();

			while ((line = br.readLine()) != null && !line.equalsIgnoreCase("</DB>")) {
				bf = bf.append(line);
				bf = bf.append("\n");
			}
			System.out.println("ok" + schem.getAttribut(0).getType().toString2() + " test");
			bf = bf.append("	<Relation name=\""+ schem.getNom() +"\" infile=\"False\" autokey=\"True\">" + "\n");
			
			int i = 0;
			while (i < schem.getDegre()) {
				bf = bf.append("		<Attribut name=\"" + schem.getAttribut(i).getNom() + "\" type=\"" + recherche_type(schem.getAttribut(i).getType().toString2()) + "\"/>\n");
				i++;
			}
			bf = bf.append("	</Relation>" + "\n" + "</DB>");
			
			FileOutputStream fileOut = new FileOutputStream(nomDB);
			fileOut.write(bf.toString().getBytes());
			fileOut.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
