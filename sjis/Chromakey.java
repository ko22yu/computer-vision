
import java.awt.*;


/**
 * 画像処理の例：クロマキー処理
 */
public class Chromakey {

	/**
	 * 画像処理の例：クロマキー処理
	 */
	static MyImage execute(MyImage input, KMeans kmeans, int id) {

		int width = input.width;
		int height = input.height;
		MyImage output = new MyImage(width, height);

		//各画素ごとに
		for(int i = 0, ii = 0; i < height; i++) {
			for(int j = 0; j < width; j++, ii++) {
				
				if(kmeans.idarray[ii] == id)
					output.setColor(j, i, Color.black);
				else 
					output.setColor(j, i, Color.white);
			}	
		}
	
		// 新しい画像データを返す
		return output;

	}
}
