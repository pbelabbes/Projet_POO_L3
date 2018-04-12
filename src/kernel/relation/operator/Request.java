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

	private Relation r;

	private Schema sc;
	private ArrayList<String> args;


	public Request(String op, Relation r) {
		this.op = op;
		this.r = r;
		this.id = CNT++;
		this.sc = null;

	}

	public Request get(String [] params) {
		Attribute pm = new Attribute("id","IntegerBD");
		ArrayList<Attribute> as = new ArrayList<Attribute>();
		as.add(pm);
		for(String s : params) {
			as.add(new Attribute(r.getAttributeByName(s)));
		}

		this.sc = new Schema(this.op + ":"+this.r.getName()+"-"+this.id, as, pm);

		return this;
	}

	public <T> Request when(Attribute a, Operator operator, T o ) {

		if(a != this.r.getAttributeByName(a.getName()))
			try {
				throw new DifferentAttributeException();
			} catch (DifferentAttributeException e) {
				e.printStackTrace();
			}

		switch (operator) {
		case EQ:
			for(Tuple t: r.getTuples()) {
				for(Field f : t.getFields()) {
					if(f.getType().equals(f.getValue(),o)) {
						//this.newTuples.add(t);
					}
				}
			}
			break;

		default:
			break;
		}




		//		if(o instanceof Attribute) {
		//			
		//			r.attributeExist((Attribute) o);
		//			switch (Operator) {
		//			case EQ:
		//				for(Tuple t: r.getTuples()) {
		//					for(Field f : t.getFields()) {
		//						if(f.getValue() == r.)
		//					}
		//				}
		//				break;
		//
		//			default:
		//				break;
		//			}
		//		}


		return this;
	}

	public Relation execute() {
		Relation nr = null;
		switch (op) {
		case "projection":
			nr = new Unary(sc);

			for(Tuple t : r.getTuples()) {
				ArrayList<Field> lf = new ArrayList<Field>();
				try {
					lf.add(new Field(sc.getAttributesByName("id"),new IntegerBD(nr.getCnt() )));
				} catch (DifferentTypeException e) {
					e.printStackTrace();
				}

				for(Attribute a : sc.getAttributes()) {

					if(t.getFieldByAttribute(a) != null) {


						Field f = null;

						f = new Field(t.getFieldByAttribute(a),a);
						lf.add(f);
					}
				}

				nr.addTuple(lf);
			}

			break;

		default:
			break;
		}
		System.out.println("nr : "+nr.getTuples());
		return nr;
	}
}
