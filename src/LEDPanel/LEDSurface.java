package LEDPanel;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PGraphics;

public class LEDSurface {
	private ArrayList<LEDAnimationScene> ledAnimationScenes; 
	private Vector location;
	private LED [][] leds;
	private Dimensions ledDim;
	private Dimensions ledGridDim;
	private Dimensions pixelGridDim;
	private PApplet parent; 
	private PGraphics ledSurface;
	
	public LEDSurface(PApplet parent, LED led, Vector location, int width, int height) { 
		this.parent = parent;
		this.location = location;
		ledAnimationScenes = new ArrayList<LEDAnimationScene>();
		
		initializeDim(led, width, height); 
		buildLEDArray(led);
		buildLEDBackgroundImage();
	}
	
	private void initializeDim(LED led, int width, int height) {
		ledDim = new Dimensions(led.width, led.height);
		pixelGridDim = new Dimensions(width * led.width, height * led.height);
		ledGridDim = new Dimensions(width, height);
	}
	
	private void buildLEDArray(LED led)	{
		int xLoc, yLoc; 
		leds = new LED[ledGridDim.width][ledGridDim.height];
		for(int row = 0; row < ledGridDim.height; row++)
			for(int col = 0; col < ledGridDim.width; col++)
				leds[col][row] = new LED(led, col * led.width, row * led.height);
	}
	
	private void buildLEDBackgroundImage() {
		ledSurface = parent.createGraphics(pixelGridDim.width, pixelGridDim.height, parent.JAVA2D);
		ledSurface.beginDraw();
		for(int row = 0; row < ledGridDim.height; row++)
			for(int col = 0; col < ledGridDim.width; col++)
				ledSurface.image(leds[col][row].off, leds[col][row].x, leds[col][row].y);
		ledSurface.endDraw();
	}
	
	void drawSurface() {
		drawBackground(); 
		drawScenes();
	}
	
	private void drawBackground() {
		parent.image(ledSurface, location.x, location.y);
	}
	
	private void drawScenes() {
		for(LEDAnimationScene animationScene : ledAnimationScenes) {
			animationScene.update();
			ArrayList<LEDAnimation> animations = animationScene.getAnimations();  
			for(LEDAnimation animation : animations)
				drawAnimation(animation);
		}
	}
	
	private void drawAnimation(LEDAnimation animation) {
		for(Vector ledVector : animation.ledObject.onOffArray) {
			int x = (int)ledVector.x;
			int y = (int)ledVector.y;
			if(onSurface(x, y)) {
				int ledOnX = (int)(leds[x][y].x + location.x);
				int ledOnY = (int)(leds[x][y].y + location.y);
				parent.image(leds[x][y].on, ledOnX, ledOnY);
			}
		}
	}
	
	private boolean onSurface(int x, int y) {
		if(x >= 0 && x < ledGridDim.width)
			if(y >= 0 && y < ledGridDim.height)
				return true;
		return false;
	}
	
	public void addAnimationScene(LEDAnimationScene scene) {
		ledAnimationScenes.add(scene);
	}
}
