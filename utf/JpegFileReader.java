import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/**
 * JPEGファイルの読み込み
 */
public class JpegFileReader {

	/**
	 * JPEGファイルの読み込み
	 */
	public static MyImage read(String filename) {
		BufferedImage image = null;
		
		// ファイルを開く
		try {
			image = ImageIO.read(new File(filename));
		} catch(Exception exp) {
			exp.printStackTrace();
			return null;
		}
		
		// 読み込んだ画像の画素値を得る
		int width = image.getWidth();
		int height = image.getHeight();
		int[] rgb = new int[width * height];
		PixelGrabber grabber = new PixelGrabber(image, 0, 0, width, height, rgb, 0, width);
		try{
			grabber.grabPixels();
		} catch(InterruptedException e){
			e.printStackTrace();
			return null;
		}
		
		// MyImageクラスを確保して返す
		MyImage my = new MyImage(width, height, rgb);
		return my;
		
	}
	
}
