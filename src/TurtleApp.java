import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**GUI-App zum Zeichnen einer Figur.
 * 
 * Die Figur kann ueber Befehle gesteuert werden, so dass verschiedene Muster 
 * gezeichnet werden koennen. Die Wegbeschreibung der Figur findet direkt waehrend des 
 * Starts der App in der Methode defineTurtleWay statt. 
 * 
 * Ueber die Tastate 'n' kann die Figur Schritt fuer Schritt weitergefuehrt werden.
 * 
 * @author joerg.berdux@hs-rm.de
 * @version 1.0
 */
public class TurtleApp extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	
	/**Figur, die gezeichnet wird
	 */
	protected Turtle myTurtle = null;
	
	public TurtleApp() {
		this.addKeyListener(this);
		myTurtle = new Turtle(); // erzeugt eine neue Figur
		this.setSize(600, 400);
		this.setVisible(true);
	}
	
	public void defineTurtleWay(){
		/* Setze den Weg der Figur 'myTurle' mit den Befehlen: 
		 * setStartpoint(x,y)
		 * rotate(a)
		 * go(x)
		 * jumpTo(x,y)
		 * setColor(c) mit den Farben Color.GREEN, Color.BLACK, Color.RED, Color.ORANGE
		 * 
		 * z.B. myTurtle.setStartpoint(100, 100);
		 */

		myTurtle.setStartpoint(100,100);
		myTurtle.rotate(270);
		myTurtle.go(20);
		myTurtle.rotate(90);
		myTurtle.go(20);
		myTurtle.rotate(90);
		myTurtle.go(20);
		myTurtle.rotate(90);
		myTurtle.go(20);
	}
	
	public static void main(String[] args) {
		TurtleApp app = new TurtleApp();
		app.defineTurtleWay();
		
	}
	
	/**Zeichnet die Figur inkl. des Weges bis zur aktuellen Position.
	 * 
	 * @param g Grafikkontext auf dem die Figur gezeichnet wird.
	 */
	public void paint(Graphics g){
		super.paint(g);
		g.drawString("My Turtle", 85, 30);
		myTurtle.paint(g); // zeichnet die Figur und den Weg bis zur aktuellen Position
	}
	
	/** (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent actEvent){
		
	}
	
	public void keyPressed(KeyEvent actEvent){
		
	}
	
	public void keyTyped(KeyEvent actEvent){
		char key = actEvent.getKeyChar();
		switch(key){
		case 'n':	
			myTurtle.nextStep();
			repaint();
			break;
		}
	}
	
}
