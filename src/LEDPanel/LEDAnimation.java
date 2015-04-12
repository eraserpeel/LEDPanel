package LEDPanel;

public class LEDAnimation {
	Vector velocity; 
	LEDObject ledObject; 
	int startFrame, endFrame;
	
	public LEDAnimation(LEDObject ledObject, Vector startLocation, Vector velocity, int startFrame,	int endFrame) {
		this.startFrame = startFrame;
		this.endFrame = endFrame;
		this.velocity = velocity;
		this.ledObject = ledObject; 
		initialize(startLocation);
	}
	
	private void initialize(Vector startLocation) {
		for(Vector ledVector : ledObject.onOffArray)
			ledVector.add(startLocation);
	}
	
	public void update() {
		for(Vector ledVector : ledObject.onOffArray)
			ledVector.add(velocity);
	}
}
