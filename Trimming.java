import java.awt.*;


public class Trimming{

	static MyImage execute(MyImage input, int x_from, int x_to, int y_from, int y_to){
		int width, height, x, y;

		width = x_to - x_from;
		height = y_to - y_from;
		MyImage output = new MyImage(width, height);


		for(y = y_from; y < y_to; y++){
			for(x = x_from; x < x_to; x++){
				int r, g, b;
				Color color = input.getColor(x, y);
				r = color.getRed();
				g = color.getGreen();
				b = color.getBlue();

				output.setColor(x - x_from, y - y_from, new Color(r, g, b));
			}
		}

		return output;

	}

}
