package gameComponents;

/**
 * A class that represents a rectangle. Can be used to check collision with 
 * other rectangles as well as the bounds to draw something to the screen.
 * @author Daniel
 *
 */
public class CollisionRectangle implements CollisionObject {
	private Vector2 position;
	private int width;
	private int height;
	
	/**
	 * Constructor
	 * @param centerPosition center position of the rectangle
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 */
	public CollisionRectangle(Vector2 centerPosition, int width, int height) {
		this.position = centerPosition;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Constructor
	 * @param x x coordinate of the top left corner
	 * @param y y coordinate of the top right corner
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 */
	public CollisionRectangle(int x, int y, int width, int height) {
		position = new Vector2(x + width / 2, y + height / 2);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * @return x coordinate of the right side
	 */
	public double right() {
		return position.x + width / 2;
	}
	
	/**
	 * @return x coordinate of the left side
	 */
	public double left() {
		return position.x - width / 2;
	}
	
	/**
	 * @return y coordinate of the top
	 */
	public double top() {
		return position.y - height / 2;
	}
	
	/**
	 * @return y coordinate of the bottom
	 */
	public double bottom() {
		return position.y + height / 2;
	}
	
	/**
	 * @return width of rectangle
	 */
	public int width() {
		return width;
	}
	
	/**
	 * @return height of rectangle
	 */
	public int height() {
		return height;
	}

	/**
	 * @return center position of the rectangle
	 */
	public Vector2 getCenterPosition() {
		return (Vector2) position.clone();
	}

	/**
	 * @return position of the top left corner of the rectangle
	 */
	public Vector2 getCornerPosition() {
		return new Vector2(position.getX() - width / 2, position.getY() - height / 2);
	}


	/**
	 * Determines whether this collides with the other collision rectangle
	 * @param rectangle rectangle to be checked
	 * @return true if they collide, false otherwise
	 */
	public boolean collides(CollisionRectangle rectangle) {
		if(left() < rectangle.right() && right() > rectangle.left() && top() < rectangle.bottom() && bottom() > rectangle.top()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the depth of intersection between this rectangle and another one
	 * @param rectB rectangle to be checked
	 * @return The depth of their intersection
	 */
	public Vector2 getIntersectionDepth(CollisionRectangle rectB)
    {
        // Calculate half sizes.
        float halfWidthA = this.width() / 2.0f;
        float halfHeightA = this.height() / 2.0f;
        float halfWidthB = rectB.width() / 2.0f;
        float halfHeightB = rectB.height() / 2.0f;

        // Calculate centers.
        Vector2 centerA = new Vector2(this.left() + halfWidthA, this.top() + halfHeightA);
        Vector2 centerB = new Vector2(rectB.left() + halfWidthB, rectB.top() + halfHeightB);

        // Calculate current and minimum-non-intersecting distances between centers.
        float distanceX = (float) (centerA.x - centerB.x);
        float distanceY = (float) (centerA.y - centerB.y);
        float minDistanceX = halfWidthA + halfWidthB;
        float minDistanceY = halfHeightA + halfHeightB;

        // If we are not intersecting at all, return (0, 0).
        if (Math.abs(distanceX) >= minDistanceX || Math.abs(distanceY) >= minDistanceY)
            return new Vector2(0,0);

        // Calculate and return intersection depths.
        float depthX = distanceX > 0 ? minDistanceX - distanceX : -minDistanceX - distanceX;
        float depthY = distanceY > 0 ? minDistanceY - distanceY : -minDistanceY - distanceY;
        return new Vector2(depthX, depthY);
    }

	@Override
	public boolean collides(CollisionObject otherObject) {
		if(otherObject instanceof CollisionRectangle) return collides((CollisionRectangle)otherObject);
		return false;
	}

}
