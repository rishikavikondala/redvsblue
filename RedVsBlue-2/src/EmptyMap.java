import java.io.*;
 
public class EmptyMap {
	public EmptyMap() {}
	
	public void visualize(String file) {
		try {
			StdDraw.enableDoubleBuffering();
			Execute execute = new Execute();
			BufferedReader br = execute.importFile(file);
			execute.dimensions(br.readLine().trim().split("   "), br.readLine().trim().split("   "));
			int total = Integer.parseInt(br.readLine());
			int i = 0; 
			do {
				execute.tripleRead(br);
				double[] xVals = new double[Integer.parseInt(br.readLine().trim())];
				double[] yVals = new double[xVals.length];
				int j = 0;
				while(j < yVals.length) {
					execute.assignPoints(j, xVals, yVals, br.readLine().trim().split("   "));	
					j++;
				}
				StdDraw.polygon(xVals, yVals);
				execute.runEmptyMap(); i++;
			} while (i < total);
			StdDraw.show();
			br.close();
		} 
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public static void main(String[] args) {                
		/*EmptyMap em = new EmptyMap();
		em.visualize("WA"); StdDraw.pause(2000);
		em.visualize("USA"); StdDraw.pause(2000);
		em.visualize("USA-county"); StdDraw.pause(2000);*/
	}
}