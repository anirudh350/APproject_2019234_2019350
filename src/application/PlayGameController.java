package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Paint;

public class PlayGameController extends AnimationTimer{
		

	    @FXML
	    private Label scoreLabel;
	    
	    @FXML
	    private Group Label;
	    @FXML
	    private Group o1;
	    @FXML
	    private Group o4;
	    @FXML
	    private Group o2;
	    @FXML
	    private Group o3;
	   
	    @FXML
	    private Circle c;
	    
	    @FXML
	    private Circle c1;
	    
	    @FXML
	    private Circle c11;
	    
	    @FXML
	    private Circle c12;
	    
	    @FXML
	    private Group i1;


	    @FXML
	    private AnchorPane mainPane;
	    
	    @FXML
	    private Arc arc1;

	    @FXML
	    private Arc arc3;

	    @FXML
	    private Arc arc2;

	    @FXML
	    private Arc arc4;
	    
	    @FXML
	    private Rectangle r1;

	    @FXML
	    private Rectangle r2;

	    @FXML
	    private Rectangle r3;

	    @FXML
	    private Rectangle r4;
	    
	    @FXML
	    private Rectangle re1;

	    @FXML
	    private Rectangle re2;

	    @FXML
	    private Rectangle re3;

	    @FXML
	    private Rectangle re4;
	    
	    @FXML
	    private Rectangle rc1;

	    @FXML
	    private Rectangle rc2;

	    @FXML
	    private Rectangle rc3;

	    @FXML
	    private Rectangle rc4;
	    
	    @FXML
	    private ImageView i2;

	    @FXML
	    private ImageView i3;
	    
	    Group top;
	    private ArrayList<Group> obstacles;
	    private ArrayList<Double> obstacleHeight;
	    private ArrayList<Color> colors;
	    public AnimationTimer gameTimer;
	    private int score = 00 ;  
	    private Color purple;
	    private Color pink;
	    private Color yellow;
	    private Color blue;
	    Scene s;
	    private boolean c1Collided=false;
	    private boolean c11Collided=false;
	    private Random random;
	    private boolean running;
	    
	    private TranslateTransition t1;
	    private TranslateTransition t2;
	    
	    private RotateTransition p1;
	    private RotateTransition p2;
	    private RotateTransition p3;
	    private TranslateTransition transition;
	    
	    private PauseTransition p;
	    private Double d;
	    
	    private Timeline animation1;
	    private  Timeline animation2;
	    private  Timeline animation4;
	    private  Timeline animation3;
	    
	    
	    
	   
	public PlayGameController() 
    {
		
    }
   
    @FXML
    public void initialize() {
	       
    		colors=new ArrayList<Color>();
    		random = new Random();
    		purple = Color.rgb(188,29,219);
			pink=Color.rgb(255,48,207);
			blue=Color.rgb(38,250,255);
		    yellow=Color.rgb(244,208,28);
		    scoreLabel.setText("SCORE :- "+Integer.toString(score));
		    scoreLabel.setStyle("-fx-font-family:'Georgia';-fx-font-size:25px");
		    colors.add(purple);
		    colors.add(pink);
		    colors.add(yellow);
		    colors.add(blue);
		    createObstacleList();
		    rotateObstacles();
			createGameLoop();
			
    }
    
    

	public void createGameLoop()
    {	
		
    	this.start();
    }
	
	public void makeStarVisible()
	{
		if(o1.getBoundsInParent().getMinY()>1000)
		{
			i2.setVisible(true);
		}
		if(o3.getBoundsInParent().getMinY()>1000)
		{
			i3.setVisible(true);
		}
	}
	public void switchColor()
	{
		int x=random.nextInt(4);
		while(c.getFill().equals(colors.get(x)))
		{
			x=random.nextInt(4);
		}
		if(checkCollision(c12,c))
		{
			c.setFill(colors.get(x));
			c.setStroke(colors.get(x));
			i1.setVisible(false);
			i1.setLayoutY(i1.getLayoutY()-490);
			
			while(checkColorSwitcherColl())
			{	
				i1.setLayoutY(i1.getLayoutY()-200);
				
			}
			i1.setVisible(true);
			
		}
	}
	
	public boolean checkColorSwitcherColl()
	{
		return (checkCollision(c12,arc1)||checkCollision(c12,arc2)||checkCollision(c12,arc3)||checkCollision(c12,arc4)||checkCollision(c12,r1)||checkCollision(c12,r2)||checkCollision(c12,r3)||checkCollision(c12,r4) || checkCollision(c12,re1)||checkCollision(c12,re2)||checkCollision(c12,re3)||checkCollision(c12,re4) || checkCollision(c12,rc1)||checkCollision(c12,rc2)||checkCollision(c12,rc3)||checkCollision(c12,rc4));  
	}
	public void setScore()
	{	
		
		if(!c1Collided)
		{	
			checkStarColl1();
			if(c1Collided)
			{

				score++;
				scoreLabel.setText("SCORE :- "+Integer.toString(score));
			}
		}
		else if(!c11Collided)
		{

			checkStarColl2();
			if(c11Collided)
			{

				score++;
				scoreLabel.setText("SCORE :-"+Integer.toString(score));
			}
		
		}
		
		
	}
	
	
	public void checkStarColl1()
	{
		if(checkCollision(c,c1))
		{
			c1Collided=true;
			c11Collided=false;
			i2.setVisible(false);
		}
	}
	

	public void checkStarColl2()
	{
		if(checkCollision(c,c11))
		{
			c1Collided=false;
			c11Collided=true;
			i3.setVisible(false);
		}
	}
    
	public void checkGameEnds() throws IOException
	{	
		
		if(endGame())
		{	
			gameOver();
			
		}
	}
	public void gameOver() 
	{
		try
		{	
			AnchorPane gameOver = (AnchorPane)FXMLLoader.load(getClass().getResource("GameOver.fxml"));
			
			Scene GameOverScene = new Scene (gameOver);
			Stage window = (Stage)(mainPane.getScene().getWindow());
			window.setScene(GameOverScene);
			window.show();
		}
		catch(NullPointerException | IOException Exception)
		{
		
		}
	}
	public boolean endGame()
	{	
		boolean b=false;
		if(c.getFill().equals(yellow))
		{
			if(checkCollision(c,arc2) || checkCollision(c,re2) || checkCollision(c,r2) || checkCollision(c,rc2)||checkCollision(c,arc3) || checkCollision(c,re3) || checkCollision(c,r3) || checkCollision(c,rc3)||checkCollision(c,arc4) || checkCollision(c,re4) || checkCollision(c,r4) || checkCollision(c,rc4))
			{
				b=true;
				return b;
				
			}
			
		}
		else if (c.getFill().equals(purple))
		{
			if(checkCollision(c,arc1) || checkCollision(c,re1) || checkCollision(c,r1) || checkCollision(c,rc1)||checkCollision(c,arc3) || checkCollision(c,re3) || checkCollision(c,r3) || checkCollision(c,rc3)||checkCollision(c,arc4) || checkCollision(c,re4) || checkCollision(c,r4) || checkCollision(c,rc4))
			{
				b=true;
				return b;
			}
			
		}
		else if (c.getFill().equals(pink))
		{
			if(checkCollision(c,arc2) || checkCollision(c,re2) || checkCollision(c,r2) || checkCollision(c,rc2)||checkCollision(c,arc1) || checkCollision(c,re1) || checkCollision(c,r1) || checkCollision(c,rc1)||checkCollision(c,arc4) || checkCollision(c,re4) || checkCollision(c,r4) || checkCollision(c,rc4))
			{
				b=true;
				return b;
			}
			
		}
		else if (c.getFill().equals(blue))
		{
			if(checkCollision(c,arc2) || checkCollision(c,re2) || checkCollision(c,r2) || checkCollision(c,rc2)||checkCollision(c,arc3) || checkCollision(c,re3) || checkCollision(c,r3) || checkCollision(c,rc3)||checkCollision(c,arc1) || checkCollision(c,re1) || checkCollision(c,r1) || checkCollision(c,rc1))
			{
				b=true;
				return b;
			}
			
		}
		
		return b;
	}
	public boolean checkCollision (Shape a , Shape b)
	
	{
		Shape intersect = Shape.intersect(a,b);
		return intersect.getBoundsInLocal().getWidth() != -1 ;
	}
    public void moveElements(Node g)
    {   
    	
    	g.setLayoutY(g.getLayoutY()+1.5);
    	
    }
    public void moveAll()
    {
    	moveElements(o2);
		moveElements(o1);
		moveElements(o3);
		moveElements(o4);
		moveElements(i1);
	
    }
    
    public void relocateObstacles()
    {	
    	
    	Iterator itr = obstacles.iterator();
    	while(itr.hasNext())
    	{	
    		Group i=(Group) itr.next();
    		if(i.getBoundsInParent().getMinY() > 1000)
    		{	
    			i.setLayoutY(-1694);
    			
    			updateObstacleHeight();
    			Collections.shuffle(obstacles);
    			break;
    		}
    	}
    	
    	
    }
    
    
    public Double getTopObstacle()
    {
    	Double d = Collections.min(obstacleHeight);
    	
    	return d;
    }
    
    public void updateObstacleHeight()
    {
    	obstacleHeight.set(0,o1.getLayoutY());
    	obstacleHeight.set(1,o2.getLayoutY());
    	obstacleHeight.set(2,o3.getLayoutY());
    	obstacleHeight.set(3,o4.getLayoutY());
    }
    
    public void createObstacleList()
    {
    	obstacles=new ArrayList<Group>();
    	obstacles.add(o1);
    	obstacles.add(o2);
    	obstacles.add(o3);
    	obstacles.add(o4);
    	
    	obstacleHeight=new ArrayList<Double>();
    	obstacleHeight.add(o1.getLayoutY());
    	obstacleHeight.add(o2.getLayoutY());
    	obstacleHeight.add(o3.getLayoutY());
    	obstacleHeight.add(o4.getLayoutY());
    }
    
    public void rotateObstacles()
    {	
    	// Rotate o2
    	p1 = new RotateTransition();
    	p1.setNode(o2);
    	p1.setDuration(Duration.millis(6500));
		p1.setByAngle(360);
	    p1.setCycleCount(Timeline.INDEFINITE);
	    p1.play();
	    
	     animation1 = new Timeline(
	             new KeyFrame(Duration.ZERO, new KeyValue(arc3.startAngleProperty(), arc3.getStartAngle(), Interpolator.LINEAR)),
	             new KeyFrame(Duration.seconds(5), new KeyValue(arc3.startAngleProperty(), arc3.getStartAngle() - 360, Interpolator.LINEAR))
	         );
	         animation1.setCycleCount(Animation.INDEFINITE);
	         animation1.play();
	     animation2 = new Timeline(
		             new KeyFrame(Duration.ZERO, new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle(), Interpolator.LINEAR)),
		             new KeyFrame(Duration.seconds(5), new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle() - 360, Interpolator.LINEAR))
		         );
		         animation2.setCycleCount(Animation.INDEFINITE);
		         animation2.play();	    
		 animation3 = new Timeline(
			             new KeyFrame(Duration.ZERO, new KeyValue(arc1.startAngleProperty(), arc1.getStartAngle(), Interpolator.LINEAR)),
			             new KeyFrame(Duration.seconds(5), new KeyValue(arc1.startAngleProperty(), arc1.getStartAngle() - 360, Interpolator.LINEAR))
			         );
			         animation3.setCycleCount(Animation.INDEFINITE);
			         animation3.play();	         	
		 animation4 = new Timeline(
				             new KeyFrame(Duration.ZERO, new KeyValue(arc4.startAngleProperty(), arc4.getStartAngle(), Interpolator.LINEAR)),
				             new KeyFrame(Duration.seconds(5), new KeyValue(arc4.startAngleProperty(), arc4.getStartAngle() - 360, Interpolator.LINEAR))
				         );
				         animation4.setCycleCount(Animation.INDEFINITE);
				         animation4.play();

    	
		// Rotate o3
		

				 	    p3= new RotateTransition();
				     	p3.setNode(o3);
				     	p3.setDuration(Duration.millis(6500));
				 		p3.setByAngle(360);
				 	    p3.setCycleCount(Timeline.INDEFINITE);
				 	    p3.play();
				 	    
		// Rotate o4		         
		    
				 	    transition = new TranslateTransition();
						transition.setDuration(Duration.seconds(3.5));
						transition.setNode(o4);
						transition.setByX(-500);
						transition.setAutoReverse(true);
						transition.setCycleCount(Timeline.INDEFINITE);
						transition.play(); 
    }


	
    @FXML
	private void handleOnKeyPressed(KeyEvent event)
	{	
    	if(running)
			if(event.getCode().equals(KeyCode.ENTER))
			{
				t1 = new TranslateTransition();
				t1.setDuration(Duration.seconds(3));
				t1.setNode(c);
				t1.setByY(-1000);
				t1.play();
				
				
			
			}
	}

	@FXML
	private void handleOnKeyReleased(KeyEvent event)
	{	
		if(running)
			if(event.getCode().equals(KeyCode.ENTER))
			{
				t2 = new TranslateTransition();
				t2.setDuration(Duration.seconds(3));
				t2.setNode(c);
				t2.setByY(1000);
				t2.play();
			}
		if(!running)
		{
			
		}
				
		
	}
	
	
	@FXML
	public void pauseGame(ActionEvent event) throws IOException{
		// TODO Autogenerated
		
		AnchorPane play = (AnchorPane)FXMLLoader.load(getClass().getResource("PauseGameMenu.fxml"));
		Scene playGameScene = new Scene (play);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(playGameScene);
		window.show();
		
	 
		
	}
	
	@FXML
	public void pauseGameKey(KeyEvent event) throws IOException{
		// TODO Autogenerated
		if(event.getCode().equals(KeyCode.P))
		{	
			this.stop();
			
			p1.stop();
			
			p3.stop();
			animation1.stop();
			animation2.stop();
			animation3.stop();
			animation4.stop();
			transition.stop();
			Label.setVisible(true);
			t2 = new TranslateTransition();
			t2.setDuration(Duration.seconds(3));
			t2.setNode(c);
			t2.setByY(0.5);
			t2.play();
			
			
			
			
		}
		if(event.getCode().equals(KeyCode.C))
		{	
			this.start();
			p1.play();
			animation1.play();
			animation2.play();
			animation3.play();
			animation4.play();
			p3.play();
			transition.play();
			Label.setVisible(false);
			
			
			
			
			
		}
		if(event.getCode().equals(KeyCode.R))
		{
			AnchorPane restart = (AnchorPane)FXMLLoader.load(getClass().getResource("PlayGame.fxml"));
			Scene restartGameScene = new Scene (restart,630,1000);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(restartGameScene);
			window.show();
		}
	 
		
	}

	@Override
	public void handle(long now) {
		// TODO Auto-generated method stub
		
		if(c.getBoundsInParent().getMinY() < 400)
		{	
			relocateObstacles();
			moveAll();
			
		}
	try {
		
		checkGameEnds();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setScore();
	switchColor();
	makeStarVisible();
}
	
	 @Override
	    public void start() {
	         super.start();
	         running = true;
	    }

	    @Override
	    public void stop() {
	        super.stop();
	        running = false;
	    }

	    public boolean isRunning() {
	        return running;
	    }
	
}



