package ch05;

public class ex5_4 {
	public static double calcTriangleArea(double bottom, double height) {
		return bottom * height / 2;
	}
	public static double calcCircleArea(double radius) {
		return radius * radius * Math.PI;
	}
	public static double calcTriangleArea(double side) {
		return (Math.sqrt(3) / 4) * side * side;
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("三角形の面積を計算します。底辺：");
		double bottom = new java.util.Scanner(System.in).nextDouble();
		System.out.println("高さ:");
		double height = new java.util.Scanner(System.in).nextDouble();
		System.out.println(calcTriangleArea(bottom, height));
		
		System.out.println("円の面積を計算します。半径:");
		double radius = new java.util.Scanner(System.in).nextDouble();
		System.out.println(calcCircleArea(radius));
		
		System.out.println("正三角形の面積を求めます。一辺の長さ：");
		double side = new java.util.Scanner(System.in).nextDouble();
		System.out.println(calcTriangleArea(side));
	}

}
//(2 * √3/2) * (2 * 1/2 * 2) * 1/2
//(高さ) * (底辺) * 1/2