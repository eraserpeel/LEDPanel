package LEDPanel;

import processing.core.PApplet;
import processing.core.PFont;
import pixelated.PixelatedText;

public class LEDTextObject extends LEDObject {
	PixelatedText pixelatedText; 
	
	LEDTextObject(PApplet parent, PixelatedText pixelatedText) {
		int [][] array = pixelatedText.getIntArray();
		for(int row = 0; row < array.length; row++)
			for(int col = 0; col < array[0].length; col++)
				if(array[row][col] != 0)
					onOffArray.add(new Vector(row, col));
	}
		
	
}
