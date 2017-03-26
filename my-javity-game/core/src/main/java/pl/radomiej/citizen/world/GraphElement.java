package pl.radomiej.citizen.world;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GraphElement {

	private String name = "";
	private final Vector2 position;
	private final Vector2 size;
	private Object userObject;

	public GraphElement(Vector2 position, Vector2 size) {
		this.position = position.cpy();
		this.size = size.cpy();
	}

	public Vector2 setPosition(Vector2 position) {
		return this.position.set(position);
	}

	public Vector2 getPosition() {
		return position.cpy();
	}

	public Vector2 getSize() {
		return size;
	}

	public Rectangle getBound() {
		return new Rectangle(getPosition().x - getSize().x / 2, getPosition().y - getSize().y / 2, getSize().x,
				getSize().y);
	}

	public Object getUserObject() {
		return userObject;
	}

	public void setUserObject(Object userObject) {
		this.userObject = userObject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
