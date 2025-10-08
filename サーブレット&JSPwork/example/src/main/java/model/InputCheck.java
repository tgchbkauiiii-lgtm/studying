package model;

public class InputCheck {

	public double check(Object o) {
		double d;
		try {
			d = Double.parseDouble(o.toString());
		}catch(Exception e) {
			d=0.0;
		}
		return d;
	}
}
