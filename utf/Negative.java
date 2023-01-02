
import java.awt.Color;

/**
 * 画像処理の例：濃淡を反転する
 */
public class Negative {

	/**
	 * 濃淡反転を実行する
	 */
	public static MyImage execute(MyImage input) {

		// 出力画像を確保する
		MyImage output = new MyImage(input.width, input.height);
	
		// 各画素について
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				
				// 入力画像の画素値をゲットする
				Color color1 = input.getColor(j, i);

				// 反転した画素値の計算
				int r = 255 - color1.getRed();
				int g = 255 - color1.getGreen();
				int b = 255 - color1.getBlue();
				Color color2 = new Color(r, g, b);

				// 出力画像の画素値をセットする
				output.setColor(j, i, color2);
			}
		}
		
		// 出力画像を返す
		return output;
	}

}

