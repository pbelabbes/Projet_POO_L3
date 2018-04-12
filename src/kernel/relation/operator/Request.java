package kernel.relation.operator;

import java.util.ArrayList;

import TypeBD.IntegerBD;
import TypeBD.TypePrimitif;
import exceptions.different.DifferentAttributeException;
import exceptions.different.DifferentTypeException;
import exceptions.notFound.TypeNotFoundException;
import kernel.relation.Attribute;
import kernel.relation.Field;
import kernel.relation.Relation;
import kernel.relation.Schema;
import kernel.relation.Tuple;
import kernel.relation.stateless.Unary;

public class Request {

	/**
	 * Counter of request
	 */
	private static int CNT = 1;

	/**
	 * ID of the request
	 */
	private int id;
	
	/**
	 * operation ( "select","projection" etc. )
	 */
	private String op;

	/**
	 * Origin relation
	 */
	private Relation oldR;

	/**
	 * new relation's schema
	 */
	private Schema newSc;
	
	/**
	 * Argument of the operation 
	 */
	private ArrayList<Object> args;

	/**
	 * 
	 * @param op, type of operation
	 * @param r, Request based relation
	 */
	public Request(String op, Relation r) {
		this.args = new ArrayList<Object>();
		this.op = op;
		this.oldR = r;
		this.id = CNT++;
		this.newSc = null;

	}

	/**
	 * 
	 * @param params, names of attributes that we want keep in the projection
	 * @return 
	 */
	public Request get(String [] params) {

		this.args = new ArrayList<Object>();
		Attribute pm = new Attribute("id","IntegerBD");
		ArrayList<Attribute> as = new ArrayList<Attribute>();
		as.add(pm);
		for(String s : params) {
			as.add(new Attribute(oldR.getAttributeByName(s)));
		}

		this.newSc = new Schema(this.op + ":"+this.oldR.getName()+"-"+this.id, as, pm);

		return this;
	}

	/**
	 * 
	 * @param a, attribute that we will check
	 * @param operator, type of operation ( EQ,LT,LET,GT,GET,DIFF )
	 * @param o , operand
	 * @return
	 */
	public <T> Request where(Attribute a, Operator operator, T o ) {

		if(a != this.oldR.getAttributeByName(a.getName()))
			try {
				throw new DifferentAttributeException();
			} catch (DifferentAttributeException e) {
				e.printStackTrace();
			}
		
		this.args.add(a);
		this.args.add(operator);
		this.args.add(o);

		return this;
	}

	/**
	 * 
	 * @param nr, Origin table for the projection
	 * @return new Relation
	 */
	public Relation projection(Relation nr) {
		if(newSc == null) {
			newSc = new Schema(oldR.getSchema(),this);
		}
		nr = new Unary(newSc);
		for(Tuple t : oldR.getTuples()) {
			ArrayList<Field> lf = new ArrayList<Field>();
			try {
				lf.add(new Field(newSc.getAttributesByName("id"),new IntegerBD(nr.getCnt() )));
			} catch (DifferentTypeException e) {
				e.printStackTrace();
			}

			for(Attribute a : newSc.getAttributes()) {

				if(t.getFieldByAttribute(a) != null) {


					Field f = null;

					f = new Field(t.getFieldByAttribute(a),a);
					lf.add(f);
				}
			}

			nr.addTuple(lf);
		}
		
		return nr;
	}
	
	/**
	 * 
	 * @param nr, origin table for the selection
	 * @return
	 */
	private Relation selection(Relation nr) {
		nr = new Unary(newSc);
		
		for (Tuple t : oldR.getTuples()) {
			Field f = t.getFieldByAttribute((Attribute) args.get(0));
			
			switch ((Operator)this.args.get(1)) {
			case EQ:
				if(f.getValue().equals(this.args.get(2))) {
					nr.addTuple(t.getFields());
				}
				break;

			default:
				break;
			}
			
			
		
		}
		return nr;
	}
	
	/**
	 * Execution of the request
	 * @return the new relation
	 */
	public Relation execute() {
		Relation nr = null;
		switch (op) {
		case "projection":
			nr = this.projection(nr);
			break;

		case "select" :
			nr=this.projection(nr);
			nr=this.selection(nr);
		default:
			break;
		}
		System.out.println("nr : "+nr.getTuples());
		return nr;
	}

	/**
	 * 
	 * @return the ID of the request
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @return the origin relation of the request
	 */
	public Relation getRelation() {
		return this.oldR;
	}

	
}
