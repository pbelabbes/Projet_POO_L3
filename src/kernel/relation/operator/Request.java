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

	private static int CNT = 1;

	private int id;
	private String op;

	private Relation oldR;

	private Schema newSc;
	private ArrayList<Object> args;


	public Request(String op, Relation r) {
		this.args = new ArrayList<Object>();
		this.op = op;
		this.oldR = r;
		this.id = CNT++;
		this.newSc = null;

	}

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

	public int getId() {
		return this.id;
	}

	public Relation getRelation() {
		return this.oldR;
	}

	
}
