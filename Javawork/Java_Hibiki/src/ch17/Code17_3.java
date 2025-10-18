package ch17;

import java.io.FileWriter;
import java.io.IOException;

public class Code17_3 {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("_:;@data.txt");
			fw.write("hello!");
			fw.close();
		} catch (IOException e) {
			System.out.println("何らかの例外が発生しました");
			e.printStackTrace();
		}
	}

}
