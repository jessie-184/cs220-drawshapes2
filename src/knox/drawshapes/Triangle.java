package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends AbstractShape
{
	public int bottomEdge;
	
	public Triangle(Color color, Point center, int bottomEdge) {
		super(new Point(center.x, center.y), color);
		this.bottomEdge = bottomEdge;
		boundingBox = new BoundingBox(center.x - bottomEdge/2, center.x + bottomEdge/2, center.y - bottomEdge/2, center.y + bottomEdge/2);		
	}
	
	public Triangle(Color color, int centerX, int centerY, int bottomEdge) {
		this(color, new Point (centerX, centerY), bottomEdge);
	}
	
	@Override
    public void draw(Graphics g) {
		int x = (int)getAnchorPoint().x;
		int y = (int)getAnchorPoint().y;
		int[] xPoints = {x - bottomEdge/2, x, x + bottomEdge/2};
		int[] yPoints = {y + bottomEdge/2, y - bottomEdge/2, y + bottomEdge/2};
        if (isSelected()){
            g.setColor(getColor().darker());
        } else {
            g.setColor(getColor());
        }
        g.fillPolygon(xPoints, yPoints, 3);
    }
	
	public String toString() {
        return String.format("TRIANGLE %d %d %d %s %s", 
                this.getAnchorPoint().x, 
                this.getAnchorPoint().y,
                this.bottomEdge,
                Util.colorToString(this.getColor()),
                this.isSelected());
    }
	
	@Override
	public void scale(double factor) {
		this.bottomEdge = (int)(factor * this.bottomEdge);
	}

}
