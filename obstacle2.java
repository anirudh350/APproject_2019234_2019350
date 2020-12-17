package application;

import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;

public class obstacle2 extends obstacle {
	
	
	public obstacle2(Rectangle r1,Rectangle r2,Rectangle r3,Rectangle r4)
	{
		super();
		this.getChildren().add(r1);
		this.getChildren().add(r2);
		this.getChildren().add(r3);
		this.getChildren().add(r4);
		this.orientation="star";
	}
	
}
