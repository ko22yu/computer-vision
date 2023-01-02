import java.awt.*;


// コアの座標と色を格納するクラス
class CoreColor {
	public int x, y;
	public int r, g, b;
}


public class StainedGlass{
	public static MyImage execute(MyImage input, int corenum){
		boolean result;	// 結果格納フラグ

		// ステンドグラス画像の作成
		int x, y;
		int width, height;

		// 画像サイズの取得
		width = input.width;
		height= input.height;

		MyImage output = new MyImage(width, height);

		// コアを乱数で決める
		CoreColor core[] = new CoreColor[corenum];
		for(int i = 0; i < corenum; ++i){
			// 乱数を発生し、適当に座標を求める
			core[i] = new CoreColor();
			core[i].x = (int)(Math.random() * (double)width);
			core[i].y = (int)(Math.random() * (double)height);

			Color color = input.getColor(core[i].x, core[i].y);
			core[i].r = color.getRed();
			core[i].g = color.getGreen();
			core[i].b = color.getBlue();
		}


		// すべての画像の座標(x, y)から最も近いコアを求め、そのコアの色を(x, y)に置く
		for (y = 0; y < height; ++y){
			for (x = 0; x < width; ++x){
				int minl = 10000000;
				Color newcolor = new Color(0, 0, 0);

				// 一番近いコアを決める
				for (int i = 0; i < corenum; ++i){
					// 距離の2乗を計算
					int dx = core[i].x - x;
					int dy = core[i].y - y;
					int l  = dx * dx + dy * dy;

					if ( l < minl ) {
						minl = l;
						newcolor = new Color(core[i].r, core[i].g, core[i].b);
					}
				}
				output.setColor(x, y, newcolor);
			}
		}

		System.out.println( "StainedGlass.java 終了" );

		return output;
	}
}
