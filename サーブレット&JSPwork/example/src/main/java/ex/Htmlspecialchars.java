package ex;

public class Htmlspecialchars {

	public String htmlspecialchars(String s) {
		return s.replaceAll("[<>(){}]", "").replaceAll("[\n]", "<br>");
	}
}
