
import java.awt.Color;

public class MyImage {

	// 横方向と縦方向の画素数
	int width, height;
	
	// 画素値
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
	 * 特定の画素値をセットする
	 */
	public void setColor(int j, int i, Color color) {
		int id = i * width + j;
		int value = color.getRGB();
		pixelarray[id] = value;
	}
	
	/**
	 * 特定のが措置をゲットする
	 */
	public Color getColor(int j, int i) {
		int id = i * width + j;
		Color color = new Color(pixelarray[id]);
		return color;
	}
	
}
