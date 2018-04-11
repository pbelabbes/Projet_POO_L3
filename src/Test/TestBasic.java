package Test;

import java.util.ArrayList;

import TypeBD.*;
import exceptions.different.DifferentTypeException;
import exceptions.notFound.TypeNotFoundException;
import kernel.DB;
import kernel.SGBD;
import kernel.relation.Attribute;
import kernel.relation.Field;
import kernel.relation.Relation;
import kernel.relation.Schema;
import kernel.relation.Tuple;
import kernel.relation.statefull.FullMemory;

public class TestBasic {

	public static void main(String[] args) {

		DB db = new DB("FACTORY");
		SGBD.addDB(db);

		//Charge la BD Factory
		DB db1 = SGBD.getDbByName("FACTORY");


		//Affiche les tables de la BD
		db.showTables();


		//Création d'une liste d'attributs

		ArrayList<Attribute> la = new ArrayList<Attribute>();
		try {
			la.add(new Attribute("Producteur", "IntegerBD"));
			la.add(new Attribute("Produit", "StringBD"));
			la.add(new Attribute("Quantité", "IntegerBD"));
			la.add(new Attribute("Prix", "DoubleBD"));

		} catch (TypeNotFoundException e) {e.printStackTrace();}


		//Creation de la clé primaire
		ArrayList<Attribute> pm = new ArrayList<Attribute>();

		pm.add(la.get(0));
		pm.add(la.get(1));

		//Création d'un schema
		Schema sc = new Schema("Production", la, pm );

		//Création de la relation
		db.addRelation(new FullMemory(sc));

		//Récupération d'une table par son nom
		Relation rel1 = db.getTableByName("Production");


		//Affichage de la rable
		rel1.displayTable();



		ArrayList<Field> ft1 = new ArrayList<Field>();
		ArrayList<Field> ft2 = new ArrayList<Field>();
		ArrayList<Field> ft3 = new ArrayList<Field>();
		ArrayList<Field> ft4 = new ArrayList<Field>();

		try {
			ft1.add(new Field ( rel1.getAttributeByName("Producteur"),new IntegerBD(1) ));
			//t1
			ft2.add(new Field ( rel1.getAttributeByName("Producteur"),new IntegerBD(2) )); //t2
			ft3.add(new Field ( rel1.getAttributeByName("Producteur"),new IntegerBD(3) )); //t3
			ft4.add(new Field ( rel1.getAttributeByName("Producteur"),new IntegerBD(3) )); //t4

			ft1.add(new Field ( rel1.getAttributeByName("Produit"),new StringBD("Epeautre") )); //t1
			ft2.add(new Field ( rel1.getAttributeByName("Produit"),new StringBD("Avoine") )); //t2
			ft3.add(new Field ( rel1.getAttributeByName("Produit"),new StringBD("Mais") )); //t3
			ft4.add(new Field ( rel1.getAttributeByName("Produit"),new StringBD("Epeautre") )); //t4

			ft1.add(new Field ( rel1.getAttributeByName("Quantite"),new IntegerBD(10) )); //t1
			ft2.add(new Field ( rel1.getAttributeByName("Quantite"),new IntegerBD(150) )); //t2
			ft3.add(new Field ( rel1.getAttributeByName("Quantite"),new IntegerBD(10) )); //t3
			ft4.add(new Field ( rel1.getAttributeByName("Quantite"),new IntegerBD(10) )); //t4

			ft1.add(new Field ( rel1.getAttributeByName("Prix"),new DoubleBD(3.56) )); //t1
			ft2.add(new Field ( rel1.getAttributeByName("Prix"),new DoubleBD(2.37) )); //t2
			ft3.add(new Field ( rel1.getAttributeByName("Prix"),new DoubleBD(9.12) )); //t3
			ft4.add(new Field ( rel1.getAttributeByName("Prix"),new DoubleBD(2.99) )); //t4
		} catch (DifferentTypeException e) {
			e.printStackTrace();
		}


		//Insertion de tuple dans la table
		rel1.addTuple(ft1);
		rel1.addTuple(ft2);
		rel1.addTuple(ft3);
		rel1.addTuple(ft4);


		//Afficher la table 
		rel1.displayTable();
		
		
		// Créer la requete : Select producteur, produit, quantité from PRODUCTION 
		/*	
		Request r1 = new Request("Projection",rel1).get("producteur","produit","quantite");


		// Ordonner la dernière requete par nom de produit

		Request r2 = new Request(r1).orderBy("produit","asc");


		// Créer la requete : Select * from PRODUCTION where produit = "Epeautre"

		Request r3 = new Request("Selection",rel1,"produit","=","Epeautre");

		// Créer la requete : Select * from PRODUCTEUR inner join PRODUCTION on PRODUCTION.producteur = PRODUCTEUR.id_producteur ; 

		Relation rel2 = db.getTableByName("Producteur");

		Request r4 = new Request("join","inner",rel2,rel1,"id_producteur","=","producteur");


		// Execution des requêtes

		Relation rel3 = r1.execute();
		Relation rel4 = r2.execute();
		Relation rel5 = r3.execute();
		Relation rel6 = r4.execute();




	}
}*/
	}
}
