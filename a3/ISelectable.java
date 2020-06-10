package com.mycompany.a3;

import com.codename1.ui.geom.Point;
import com.codename1.ui.Graphics;

public interface ISelectable 
{
	public void setSelected(boolean yesNo);
	public boolean contains(Point pPtrRelPOrigin, Point pCmpRelPOrigin);
	public void draw(Graphics g, Point pCmpRelPOrigin);
	// pPtrRelPOrigin = pointer position relative to the parent origin
	// pCmpRelPOrigin = component position relative to the parent origin

}
