package ch17;

import java.io.FileWriter;
import java.io.IOException;

public class Code17_10 {

	public static void main(String[] args) {
			try (FileWriter fw = new FileWriter("dat|a.txt");) {
				fw.write("hello!");
			} catch (IOException e) {
				System.err.println("何らかの例外が発生しました");
				System.err.println();
			}
	}

}
