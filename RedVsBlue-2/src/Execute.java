import java.io.*;
import java.util.*;
 
public class Execute {
	public Execute() {}
	
	public static BufferedReader importFile(String file) throws FileNotFoundException {
		return new BufferedReader(new FileReader(new File("./input/" + file + ".txt")));
	}
	
	public static BufferedReader secondFile(int year, String file) throws FileNotFoundException {
		return new BufferedReader(new FileReader(new File("./input/" + file + year + ".txt")));
	}
	
	public void dimensions(String[] minVals, String[] maxVals) {
		double scaleVal = (Double.parseDouble(maxVals[0]) - Double.parseDouble(minVals[0])) / (Double.parseDouble(maxVals[1]) - Double.parseDouble(minVals[1]));
		StdDraw.setCanvasSize((int) (scaleVal * 500), 500);

		StdDraw.setXscale(Double.parseDouble(minVals[0]) - 0.25, Double.parseDouble(maxVals[0]) + 0.25);
		StdDraw.setYscale(Double.parseDouble(minVals[1]) - 0.25, Double.parseDouble(maxVals[1]) + 0.25);
	}
	
	public void tripleRead(BufferedReader br) throws IOException {
		br.readLine(); br.readLine(); br.readLine();
	}
	
	public void assignPoints(int j, double[] xVals, double[] yVals, String[] thisPoint) {
		xVals[j] = Double.parseDouble(thisPoint[0]);
		yVals[j] = Double.parseDouble(thisPoint[1]);
	}
	
	public String getFinalKey(String thisLine, int index) {
		String toRet = thisLine.substring(0, index);
		return toRet.toLowerCase();
	}
	
	public String getFinalVal(String thisLine) {
		return thisLine.substring(thisLine.indexOf(",") + 1);
	}
	
	public String trimmer(BufferedReader BR, String thisLineImport, String current, boolean iff) throws IOException {
		String thisLine = thisLineImport;
		if(!iff) {
			String thisLineSubstring = thisLine.substring(0, thisLine.indexOf(",")).toLowerCase();
			while (thisLineSubstring.equals(current.toLowerCase()) == false) {
				thisLine = BR.readLine().trim();
			}
			return thisLine;
		}
		do {
			thisLine = BR.readLine().trim();
		} while (thisLine.substring(0, thisLine.indexOf(",")).toLowerCase().equals(current) == false);
		return thisLine;
	}
	
	public static String exceptions(String current) {
		if (current.contains(" Parish") || current.contains(" city")) {
			if(current.contains(" city")) {
				current = current.replace(" city", "");
				return current;
			}
			else if(current.contains(" Parish")) {
				current = current.replace(" Parish", "");
				return current;
			}
		}
		return current;
	}
	
	public void runEmptyMap() {
		StdDraw.setPenColor(StdDraw.BLACK);              
		StdDraw.enableDoubleBuffering();
		StdDraw.show();
	}
}