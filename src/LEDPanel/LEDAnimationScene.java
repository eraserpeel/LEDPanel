package LEDPanel;

import java.util.ArrayList;
import processing.core.PApplet;


public class LEDAnimationScene {
	private int frameCount;
	private ArrayList<LEDAnimation> animationList;
	private PApplet p;
	
	LEDAnimationScene(PApplet p) {
		animationList = new ArrayList<LEDAnimation>();
		this.p = p;
	}
	
	void addAnimation(LEDAnimation animation) {
		animationList.add(animation);
	}
	
	void update() {
		frameCount++;
		for(LEDAnimation animation : animationList)
			animation.update();
	}
	
	ArrayList<LEDAnimation> getAnimations() {
		ArrayList<LEDAnimation> activeAnimations = new ArrayList<LEDAnimation>(); 
		for(LEDAnimation animation : animationList)
			if(frameCount >= animation.startFrame && frameCount <= animation.endFrame)
				activeAnimations.add(animation);
		return activeAnimations;
	}
}
