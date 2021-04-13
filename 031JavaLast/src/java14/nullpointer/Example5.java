package java14.nullpointer;

public class Example5 {
	  public static void main(String[] args) {
	      String[][][] data = new String[1][1][];
	      data[0][0][0] = "jenny";
	  }
	}