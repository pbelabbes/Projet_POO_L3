package kernel.relation.operator;

import java.util.ArrayList;

import exceptions.notFound.TypeNotFoundException;
import kernel.relation.Attribute;
import kernel.relation.Relation;
import kernel.relation.Schema;

public abstract class Request {

	private static int CNT = 1;
	
	private int id;
	private String op;
	
	private Relation r;
	
	private Schema sc;
	
	private ArrayList<String> args;
	
	public Request(String op, Relation r) {
		this.op = op;
		this.r = r;
		this.id = CNT++;
		this.sc = null;
		
	}
	
	public void get(ArrayList<Attribute> params) {
		Attribute pm;
		pm = new Attribute("id","IntegerBD");
		
		params.add(0,pm);
		this.sc = new Schema(this.op + ":"+this.sc.getName()+"-"+this.id, params, pm);
	}
	
	public void when(ArrayList<String> p) {
		
	}
}
