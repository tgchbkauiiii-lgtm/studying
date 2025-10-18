package ch13.ex13;

public class Wand {
	private String name;
	private double power;
	public void setName(String name) {
		if (name.length() < 3) {
			throw new IllegalArgumentException
			("杖の名前は3文字以上にしてください。");
		}
		this.name = name;
	}
	public void setPower(double power) {
		if (power < 0.5 || power >100) {
			throw new IllegalArgumentException
			("杖の回復力は0.5以上100以下にしてください。");
		}
		this.power = power;
	}
	public String getName() {
		return name;
	}
	public double getPower() {
		return power;
	}
}
