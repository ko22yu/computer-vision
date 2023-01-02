
import java.awt.Color;

/**
 * ‰æ‘œˆ—‚Ì—áF”Z’W‚ğ”½“]‚·‚é
 */
public class Negative {

	/**
	 * ”Z’W”½“]‚ğÀs‚·‚é
	 */
	public static MyImage execute(MyImage input) {

		// o—Í‰æ‘œ‚ğŠm•Û‚·‚é
		MyImage output = new MyImage(input.width, input.height);
	
		// Še‰æ‘f‚É‚Â‚¢‚Ä
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				
				// “ü—Í‰æ‘œ‚Ì‰æ‘f’l‚ğƒQƒbƒg‚·‚é
				Color color1 = input.getColor(j, i);

				// ”½“]‚µ‚½‰æ‘f’l‚ÌŒvZ
				int r = 255 - color1.getRed();
				int g = 255 - color1.getGreen();
				int b = 255 - color1.getBlue();
				Color color2 = new Color(r, g, b);

				// o—Í‰æ‘œ‚Ì‰æ‘f’l‚ğƒZƒbƒg‚·‚é
				output.setColor(j, i, color2);
			}
		}
		
		// o—Í‰æ‘œ‚ğ•Ô‚·
		return output;
	}

}

