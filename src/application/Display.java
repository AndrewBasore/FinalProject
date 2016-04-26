package application;

import javafx.scene.Parent;
/*
 * Display class holds information pertaining to making the display and
 * retrieving that display.
 */
public abstract class Display<E extends Parent> extends Stylable{
	abstract void makeDisplay() ;
	abstract E getDisplay();

}
