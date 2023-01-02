
import java.awt.Color;

public class MyImage {

	// ‰¡•ûŒü‚Æc•ûŒü‚Ì‰æ‘f”
	int width, height;
	
	// ‰æ‘f’l
	int pixelarray[];
	
	
	/**
	 * Constructor
	 */
	public MyImage(int w, int h) {
		width = w;   height = h;
		pixelarray = new int[w * h];
	}
	
	/**
	 * Constructor
	 */
	public MyImage(int w, int h, int array[]) {
		width = w;   height = h;
		pixelarray = array;
	}
	
	/**
	 * “Á’è‚Ì‰æ‘f’l‚ğƒZƒbƒg‚·‚é
	 */
	public void setColor(int j, int i, Color color) {
		int id = i * width + j;
		int value = color.getRGB();
		pixelarray[id] = value;
	}
	
	/**
	 * “Á’è‚Ì‚ª‘[’u‚ğƒQƒbƒg‚·‚é
	 */
	public Color getColor(int j, int i) {
		int id = i * width + j;
		Color color = new Color(pixelarray[id]);
		return color;
	}
	
}
