package application;

import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class ball extends Circle {
	
		private double position;
		private int speed=0;
		private Color color;
		
		public ball(double radius , Color color)
		{		
				super();
				this.setRadius(radius);
		    	this.setFill(color);
		    	this.color=color;
		}

		public double getPosition() {
			return position;
		}

		public void setPosition(double position) {
			this.position = position;
		}

		public int getSpeed() {
			return speed;
		}

		public void setSpeed(int speed) {
			this.speed = speed;
		}

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}
		
		
		
		
		
		
}
