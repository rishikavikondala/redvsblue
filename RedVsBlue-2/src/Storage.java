import java.awt.Color;
 
public class Storage {
	private int r, d, i;

	public Storage(String votes) { 
		String[] counts = votes.split(","); 
		this.r = Integer.parseInt(counts[0]);
		this.d = Integer.parseInt(counts[1]);
		this.i = Integer.parseInt(counts[2]);
	}
	public int getR() { return r; }
	public int getD() { return d; }
	public int getI() { return i; }
}