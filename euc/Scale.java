
import java.awt.*;

/**
 * 画像を拡大縮小する
 */
public class Scale {
	static double SCALEX = 2.0, SCALEY = 3.0;
	
	
	/**
	 * 画像を拡大縮小する
	　*/
	static MyImage execute(MyImage input) {
		int width1, height1, width2, height2, i, j;
		

		// 元画像と新画像のサイズを定義する
		width1 = input.width;
		height1 = input.height;
		width2 = (int)(input.width * SCALEX);
		height2 = (int)(input.height * SCALEY);
		MyImage output = new MyImage(width2, height2);
	
		
		// 新しい画像の各画素ごとに
		for(i = 0; i < height2; i++) {
			for(j = 0; j < width2; j++) {
				double x1, y1, r, g, b;
				
				// 元画像の対応するx,y座標値を計算する
				x1 = calcX(j, i, width1, height1);
				y1 = calcY(j, i, width1, height1);

				// 元画像からRGB値を算出する
				calcRGB(input, output, x1, y1, j, i);

			}
		}

		// 新しい画像データを返す
		return output;

	}

	
	/**
	 * 元画像の対応するX座標値を算出する
	 */
	static double calcX(int x2, int y2, int width1, int height1) {
		double x = 0.0;

		// 逆変換なので、画像の倍率の逆数を求める
		x = x2 / SCALEX;

		// 元画像の範囲内に収まっているかどうか確認する
		if(x < 0.0 || x > (double)width1) {
			System.out.println("EXIT! x=" + x);
			System.exit(-1);
		}

		return x;
	}

	
	/**
	 * 元画像の対応するY座標値を算出する
	 */
	static double calcY(int x2, int y2, int width1, int height1) {
		double y = 0.0;

		// 逆変換なので、画像の倍率の逆数を求める
		y = y2 / SCALEY;

		// 元画像の範囲内に収まっているかどうか確認する
		if(y < 0.0 || y > (double)height1) {
			System.out.println("EXIT! y=" + y);
			System.exit(-1);
		}

		return y;
	}




	/**
	 * 元画像の位置(x1,y1)におけるRGB値を算出する
 	 * （このプログラムでは Nearest Neighbor を採用する）
	 */
	static void calcRGB(MyImage input, MyImage output, double x1, double y1, int x2, int y2) {

		// 参照すべき画素を特定する
		int xx = (int)(x1 + 0.5);
		if(xx < 0) xx = 0;
		if(xx >= input.width) xx = input.width - 1;
		int yy = (int)(y1 + 0.5);
		if(yy < 0) yy = 0;
		if(yy >= input.height) yy = input.height - 1;

		// RGB値を返す
		Color color = input.getColor(xx, yy);
		int value = color.getRGB();
		output.setColor(x2, y2, color);
	
	}


}
