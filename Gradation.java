import java.awt.*;

public class Gradation{
	public static MyImage execute(int width, int height, int r1, int g1, int b1, int r2, int g2, int b2){

		MyImage output = new MyImage(width, height);

		// グラデーション作成
		int    x, y;
		int    r, g, b;	// 計算した色
		double d;			// 距離

		for ( y = 0; y < height; ++ y ) {
			for ( x = 0; x < width; ++ x ) {
				// 距離dを計算
				d = (double)x / (double)(width - 1);

				// 色を計算
				r = (int)((double)(r2 - r1) * d + (double)r1);
				g = (int)((double)(g2 - g1) * d + (double)g1);
				b = (int)((double)(b2 - b1) * d + (double)b1);

				// r,g,bの色を合成
				Color color = new Color(r, g, b);

				// 合成した色を(x, y)に設定
				output.setColor(x, y, color);
			}
		}

		System.out.println("Gradation.java 終了");

		return output;
	}
}
