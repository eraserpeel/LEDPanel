package LEDPanel;
import pixelated.*;
import processing.core.*;

public class Main extends PApplet
{
	LED led;
	LEDSurface ledSurface;
	LEDAnimationScene scene; 
	
	PImage busImage = loadImage("../images/bus.png");
	PImage on = loadImage("../images/on.png");
	PImage off = loadImage("../images/off.png");
	
	public void setup() {
	  size(600, 600);
      led = new LED(this, on, off);
      frameRate(25);
      ledSurface = new LEDSurface(this, led, new Vector(145, 45), 100, 15);
      createScrollingText("Hello", 0, 100, -0.2f);
      ledSurface.addAnimationScene(scene);
	}

	public void createScrollingText(String str, int startTime, int endTime, float velocity) {
		PFont testFont = createFont("Times New Roman", 140);
	    PixelatedText pixelatedText = new PixelatedText(this, testFont, color(200, 150, 0), str);				
	    pixelatedText.setResolution(10);
	    pixelatedText.setPixelationTolerance(0.5f);
	    LEDObject ledTextObject = new LEDTextObject(this, pixelatedText);
		LEDAnimation ledAnimation1 = new LEDAnimation(ledTextObject, new Vector(10, 16), new Vector(0.0, velocity), startTime, endTime);
		scene = new LEDAnimationScene(this);
		scene.addAnimation(ledAnimation1);
	}
	
	public void draw() {
		background(255);
		ledSurface.drawSurface();
	}

	public static void main(String _args[])	{
		PApplet.main(new String[] { LEDPanel.Main.class.getName() });
	}
}











