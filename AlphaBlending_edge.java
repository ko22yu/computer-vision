
import java.awt.*;


public class AlphaBlending_edge {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input0, int input1_set_x, int input1_set_y) {  // I1をどこの位置に配置するか

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;

		int width  = (width1  > width2)  ? width1  : width2;
		int height = (height1 > height2) ? height1 : height2;

		int cx = width1 / 2;
		int cy = height1 / 2;

		MyImage output = new MyImage(width, height);

		double alpha;

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;

				if((input1_set_y < i && i < height1 + input1_set_y) && (input1_set_x < j && j < width1 + input1_set_x)) {  // I1の内部にあるなら
					int input1_j = j - input1_set_x, input1_i = i - input1_set_y;
					Color color0 = input0.getColor(input1_j, input1_i);
					if(color0.getRed() > 0) {  // 2値画像でその位置の画素値が黒以外なら

						Color color1 = input1.getColor(input1_j, input1_i);
						Color color2 = input2.getColor(j, i);

						// 円の中心(cx, cy)と(x, y)との距離lを計算
						double l = Math.sqrt((input1_j - cx)*(input1_j - cx) + (input1_i - cy)*(input1_i - cy));
						// 距離dを計算
						double d = (double)l / (double)(width1 / 2);
						// アルファブレンディングの値を決める
						alpha = d * d * d;

						// アルファブレンディング処理
						int alphablending_r = (int)(alpha * color1.getRed() + (1-alpha) * color2.getRed());
						int alphablending_g = (int)(alpha * color1.getGreen() + (1-alpha) * color2.getGreen());
						int alphablending_b = (int)(alpha * color1.getBlue() + (1-alpha) * color2.getBlue());
						Color alphablending_color = new Color(alphablending_r, alphablending_g, alphablending_b);
						output.setColor(j, i, alphablending_color);

						isProcessed = true;  // -> 6行下のif文は処理されない
					}

				}

				if(i < height2 && j < width2) {  // I2の内部にあるなら
					if(isProcessed == false) {  // I1の画素値が代入されていないなら -> 2値画像でその位置の画素数が黒 or I1の内部でない なら

						Color color2 = input2.getColor(j, i);
						output.setColor(j, i, color2);
					}
				}
			}
		}

		return output;

	}

}
