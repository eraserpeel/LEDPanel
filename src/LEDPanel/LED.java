package LEDPanel;
import processing.core.*;


public class LED {
	float x, y;
	PImage on;
	PImage off;
	int width, height;
	
	LED(PApplet parent, PImage bulbOn, PImage bulbOff)	{
		this.on = bulbOn;
		this.off = bulbOff;
		width = bulbOn.width;
		height = bulbOn.height;
	}

	LED(LED led, int x, int y) {
		this.on = led.on;
		this.off = led.off;
		this.x = x;
		this.y = y;
	}
}



 
