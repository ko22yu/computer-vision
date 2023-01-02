import java.awt.Color;

public class Circle{
	public static MyImage execute(int rd, int r1, int g1, int b1, int r2, int g2, int b2){
		/*
		rd: 半径
		r1, g1, b1: 開始色
		r2, g2, b2: 終了色
		*/
		int width, height;	// 画像サイズ
		int cx, cy;	// 円の中心座標


		// 画像サイズを半径から計算
		width = rd * 2 + 1;
		height = rd * 2 + 1;

		// 円の中心座標を計算
		cx = rd;
		cy = rd;

		MyImage output = new MyImage(width, height);


		// グラデーション作成
		int    x, y;
		int    r, g, b;	// 計算したRGB
		double l;			// 距離
		double d;			// 距離

		for (y = 0; y < height; ++y){
			for (x = 0; x < width; ++x){
				// 円の中心(cx, cy)と(x, y)との距離lを計算
				l = Math.sqrt((x - cx)*(x - cx) + (y - cy)*(y - cy));
				// 距離dを計算
				d = Math.sqrt((double)l / (double)rd);

				// 色を計算
        if(d > 1){  // 円の外側
  				r = 0;
  				g = 0;
  				b = 0;
        }
        else{
          // 色を計算
  				r = (int)((double)(r2 - r1) * d + (double)r1);
  				g = (int)((double)(g2 - g1) * d + (double)g1);
  				b = (int)((double)(b2 - b1) * d + (double)b1);
        }

				// 色を0〜255の範囲に収める
				if (r < 0) r = 0;
				if (r > 255) r = 255;
				if (g < 0) g = 0;
				if (g > 255) g = 255;
				if (b < 0) b = 0;
				if (b > 255) b = 255;

				// r, g, bの色を合成
				Color color = new Color(r, g, b);

				// 合成した色を(x, y)に設定
				output.setColor(x, y, color);
			}
		}

		System.out.println("Circle.java 終了");

		return output;
	}
}
