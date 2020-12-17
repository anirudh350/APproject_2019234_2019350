package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.Node;

abstract class obstacle extends Group {
	
		
		protected double position;
		protected String orientation;
		
		public obstacle()
		{
			position=this.getLayoutY();
		}
		
		public Double getPosition()
		{
			return this.position;
		}
		
		public void setPosition(Double d) 
		{
			this.setLayoutY(d);
		}
		public String getOrientation()
		{
			return this.orientation;
		}
		
		public void setOrientation(String s)
		{
			this.orientation=s;
		}
		
}
