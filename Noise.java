import java.awt.*;

public class Noise{
	public static MyImage execute(MyImage input, double noiserate){
		boolean result;	// 結果格納フラグ

		// ノイズ画像の作成
		int x, y;
		int width, height;
		int r, g, b;
		double rate;

		// 画像サイズの取得
		width = input.width;
		height = input.height;

		MyImage output = new MyImage(width, height);
		output = input;

		// ノイズを加える
		for(y = 0; y < height; ++y){
			for(x = 0; x < width; ++x){
				// 乱数を発生
				rate = Math.random() * 100.0;

				// ノイズ色にするかを判定
				if (noiserate > rate) {
					// ノイズとして白色を設定
					r = 255;
					g = 255;
					b = 255;

					// r, g, bの色を合成
					Color color = new Color(r, g, b);

					// 合成した色を(x,y)に設定
					output.setColor(x, y, color);
				}
			}
		}

		System.out.println( "Noise.java 終了" );

		return output;
	}
}
