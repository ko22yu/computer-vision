
import java.awt.*;


public class ColorChange {

	static MyImage execute(MyImage input, int pic_x, int pic_y) {
		int width, height, x, y;

		width = input.width;
		height = input.height;
		Color pic_color = input.getColor(pic_x, pic_y);

		MyImage output = new MyImage(width, height);


		for(y = 0; y < height; y++) {
			for(x = 0; x < width; x++) {

				Color color = input.getColor(x, y);
				if(pic_color.getRed() == color.getRed() && pic_color.getGreen() == color.getGreen() && pic_color.getBlue() == color.getBlue()){
					output.setColor(x, y, Color.BLACK);
				}
				else{
					output.setColor(x, y, color);
				}
			}
		}

		return output;

	}

}
