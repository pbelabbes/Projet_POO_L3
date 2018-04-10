package Test;

import java.util.ArrayList;

import kernel.DB;
import kernel.SGBD;
import kernel.relation.Attribute;
import kernel.relation.Relation;
import kernel.relation.Schema;

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
		la.add(new Attribute("Producteur", "IntegerBD"));
		la.add(new Attribute("Produit", "StringBD"));
		la.add(new Attribute("Quantité", "IntegerBD"));
		la.add(new Attribute("Prix", "DoubleBD"));

		/**
		 * @todo
		 */
		//Création d'un schema
		
		//Création de la relation
		db.addRelation(new Relation());
		
		Relation rel1 = db.getTableByName("Production");

	
		
		
		
		
		
		// Créer la requete : Select producteur, produit, quantité from PRODUCTION 
		
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
}
}
}
