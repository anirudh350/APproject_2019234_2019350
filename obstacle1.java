package application;

import javafx.scene.shape.Arc;
import javafx.scene.Group;

public class obstacle1 extends obstacle {
	
	public obstacle1(Arc a,Arc b,Arc c,Arc d)
	{
		super();
		this.getChildren().add(a);
		this.getChildren().add(b);
		this.getChildren().add(c);
		this.getChildren().add(d);
		this.orientation="circle";
	}
	
	
	
	
}
