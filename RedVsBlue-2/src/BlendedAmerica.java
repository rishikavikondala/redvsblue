import java.awt.Color;
import java.io.*;
import java.util.*;
 
public class BlendedAmerica{
	private Map<String, Storage> counter;
	private Storage storage;

	public BlendedAmerica(){ this.counter = new HashMap<String, Storage>(); }
	
	public void visualize(String file, int year) {
		try {
			Execute execute = new Execute();
			BufferedReader br = execute.importFile(file);
			execute.dimensions(br.readLine().trim().split("   "), br.readLine().trim().split("   "));
			int total = Integer.parseInt(br.readLine());
			int i = 0;
			StdDraw.enableDoubleBuffering();

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
				StdDraw.setPenColor(mixer(counter.get(current.toLowerCase()).getR(), counter.get(current.toLowerCase()).getD(), counter.get(current.toLowerCase()).getI()));
				StdDraw.filledPolygon(xVals, yVals);
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.polygon(xVals, yVals);
				i++;
			} while (i < total);

			StdDraw.disableDoubleBuffering();
			StdDraw.show();
			
			br.close();
		} 
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public Color mixer(int r, int d, int i) {
		double sums = r + d + i;
		return new Color((int) (double) (r / (sums) * 255), (int) (double) (i / (sums) * 255), (int) (double) (d / (sums) * 255));	
	}
	
	public static void main(String[] args) {
/*		BlendedAmerica blam = new BlendedAmerica();
		blam.visualize("WA", 2012); StdDraw.pause(2000);
		blam.visualize("USA", 2012); StdDraw.pause(2000);
		blam.visualize("USA-county", 2012); StdDraw.pause(2000);*/
	}
}