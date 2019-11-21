import java.awt.Color;
import java.io.*;
import java.util.*;
 
public class ElectoralMap {
	private Map<String, Storage> counter;
	private Storage storage;

	public ElectoralMap() { this.counter = new HashMap<String, Storage>(); }
	
	public Color majority(int r, int d, int i) {
		if (r > d == true && r > i == true) { return StdDraw.RED; }
		if (d > r == true && d > i == true) { return StdDraw.BLUE; } 
		if (i > r == true && i > d == true) { return StdDraw.GREEN; }
		return null;
	}

	public void visualize(String file, int year) {
		try {
			Execute execute = new Execute();
			BufferedReader br = execute.importFile(file);
			execute.dimensions(br.readLine().trim().split("   "), br.readLine().trim().split("   "));
			int total = Integer.parseInt(br.readLine());
			StdDraw.enableDoubleBuffering();
			int i = 0;
			do {
				br.readLine();
				String current = br.readLine().trim();
				current = execute.exceptions(current);

				BufferedReader BR = execute.secondFile(year, br.readLine());

				String thisLine = BR.readLine().trim();
				if(counter.containsKey(current.toLowerCase()) == false) {
					thisLine = execute.trimmer(BR, thisLine, current.toLowerCase(), true);
				}
				else {
					thisLine = execute.trimmer(BR, thisLine, current.toLowerCase(), true);
					BR.readLine();
					thisLine = execute.trimmer(BR, thisLine, current.toLowerCase(), false);
				}
				storage = new Storage(execute.getFinalVal(thisLine));
				counter.put(execute.getFinalKey(thisLine, thisLine.indexOf(",")), storage);

				BR.close();

				double[] xVals = new double[Integer.parseInt(br.readLine().trim())];
				double[] yVals = new double[xVals.length];
				int j = 0;
				while(j < yVals.length) {
					execute.assignPoints(j, xVals, yVals, br.readLine().trim().split("   "));	
					j++;
				}
				StdDraw.setPenColor(majority(counter.get(current.toLowerCase()).getR(), counter.get(current.toLowerCase()).getD(), counter.get(current.toLowerCase()).getI()));
				StdDraw.filledPolygon(xVals, yVals);
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.polygon(xVals, yVals);
				i++;
			} while(i < total);
			
			StdDraw.disableDoubleBuffering();
			StdDraw.show();
			br.close();
		} 
		catch(Exception e) { e.printStackTrace(); }
	}

	public static void main(String[] args) {
		/*ElectoralMap elm = new ElectoralMap();
		elm.visualize("WA", 2012); StdDraw.pause(2000);
		elm.visualize("USA", 2012); StdDraw.pause(2000);
		elm.visualize("USA-county", 2012); StdDraw.pause(2000);*/
	}
}