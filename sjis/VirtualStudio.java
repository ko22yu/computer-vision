
import java.awt.*;

/**
 * 画像処理の例：バーチャルスタジオ風の画像合成
 */
public class VirtualStudio {

	/**
	 * 画像処理の例：バーチャルスタジオ風の画像合成
	 */
	static MyImage execute(MyImage input1, MyImage input2, MyImage input0) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
	
		int width  = (width1  > width2)  ? width1  : width2;
		int height = (height1 > height2) ? height1 : height2;
	
		// 出力画像の確保
		MyImage output = new MyImage(width, height);

		// 各画素ごとに
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;
		
				// image0の画素値を参照
				if(i < height1 && j < width1) {

					// image0の画素値が黒でなければ
					Color color0 = input0.getColor(j, i);
					if(color0.getRed() > 0) {
				
						// 新しい画像にimage1の画素値を代入
						Color color1 = input1.getColor(j, i);
						output.setColor(j, i, color1);
				
						// trueであれば、input1の画素値を代入済みである
						isProcessed = true;
					}
					
				}

				// image2の画素値を参照
				if(i < height2 && j < width2) {
					if(isProcessed == false) {
						
						// 新しい画像にinput2の画素値を代入
						Color color2 = input2.getColor(j, i);
						output.setColor(j, i, color2);
					}
				}
			}
		}

		// 新しい画像データを返す
		return output;

	}

}