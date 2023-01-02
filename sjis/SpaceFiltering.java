
import java.awt.*;


/**
 * 空間フィルタリング
 */
public class SpaceFiltering {

	// 空間フィルタリングを適用する配列
	static double filter[] = {
		0.33333,0,0,0,0.33333,0,0,0,0.33333
	};


	/**
	 * 空間フィルタリングを用いた画像処理の例
	 */
	static MyImage execute(MyImage input) {
		int width = input.width;
		int height = input.height;
		int n;
		MyImage output = new MyImage(width, height);
		
		// 各画素ごとに
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				double valueR = 0.0, valueG = 0.0, valueB = 0.0;

				// 左上の画素値を加算
				if(i > 0 && j > 0) {
					Color color = input.getColor(j-1, i-1);
					valueR += (double)color.getRed()   * filter[0];
					valueG += (double)color.getGreen() * filter[0];
					valueB += (double)color.getBlue()  * filter[0];
				}

				// 上の画素値を加算
				if(i > 0) {
					Color color = input.getColor(j, i-1);
					valueR += (double)color.getRed()   * filter[1];
					valueG += (double)color.getGreen() * filter[1];
					valueB += (double)color.getBlue()  * filter[1];
				}

				// 右上の画素値を加算
				if(i > 0 && j < (width - 1)) {
					Color color = input.getColor(j+1, i-1);
					valueR += (double)color.getRed()   * filter[2];
					valueG += (double)color.getGreen() * filter[2];
					valueB += (double)color.getBlue()  * filter[2];
				}
			
				// 左の画素値を加算
				if(j > 0) {
					Color color = input.getColor(j-1, i);
					valueR += (double)color.getRed()   * filter[3];
					valueG += (double)color.getGreen() * filter[3];
					valueB += (double)color.getBlue()  * filter[3];
				}
				
				// 同一場所のの画素値を加算
				{
				Color color = input.getColor(j, i);
				valueR += (double)color.getRed()   * filter[4];
				valueG += (double)color.getGreen() * filter[4];
				valueB += (double)color.getBlue()  * filter[4];
				}
		
				// 右の画素値を加算
				if(j < (width - 1)) {
					Color color = input.getColor(j+1, i);
					valueR += (double)color.getRed()   * filter[5];
					valueG += (double)color.getGreen() * filter[5];
					valueB += (double)color.getBlue()  * filter[5];
				}

				// 左下の画素との比較
				if(i < (height - 1) && j > 0) {
					Color color = input.getColor(j-1, i+1);
					valueR += (double)color.getRed()   * filter[6];
					valueG += (double)color.getGreen() * filter[6];
					valueB += (double)color.getBlue()  * filter[6];
				}

				// 下の画素との比較
				if(i < (height - 1)) {
					Color color = input.getColor(j, i+1);
					valueR += (double)color.getRed()   * filter[7];
					valueG += (double)color.getGreen() * filter[7];
					valueB += (double)color.getBlue()  * filter[7];
				}

				// 右下の画素との比較
				if(i < (height - 1) && j < (width - 1)) {
					Color color = input.getColor(j+1, i+1);
					valueR += (double)color.getRed()   * filter[8];
					valueG += (double)color.getGreen() * filter[8];
					valueB += (double)color.getBlue()  * filter[8];
				}

				// valueR, valueG, valueB の値を0～255の範囲にする
				if(valueR < 0.0) valueR = 0.0;
				if(valueR > 255.0) valueR =255.0;
				if(valueG < 0.0) valueG = 0.0;
				if(valueG > 255.0) valueG =255.0;
				if(valueB < 0.0) valueB = 0.0;
				if(valueB > 255.0) valueB =255.0;

				// 出力画像に値を設定する
				Color color2 = new Color((int)valueR, (int)valueG, (int)valueB);
				output.setColor(j, i, color2);
			}
		}
		
		// 新しい画像データを返す
		return output;
	}


}