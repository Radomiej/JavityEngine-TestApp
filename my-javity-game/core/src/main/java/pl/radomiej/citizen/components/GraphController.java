package pl.radomiej.citizen.components;

import org.javity.components.SpriteRenderer;
import org.javity.engine.JCamera;
import org.javity.engine.JComponent;
import org.javity.engine.JEngine;
import org.javity.engine.JGUI;
import org.javity.engine.JGameObject;
import org.javity.engine.JInput;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import pl.radomiej.citizen.world.GraphNode;
import pl.radomiej.citizen.world.GraphWorld;
import pl.radomiej.citizen.world.MovableGraphElement;
import pl.radomiej.citizen.world.events.ElementClickEvent;

public class GraphController extends JComponent {
	private GraphWorld graphWorld;
	private final Rectangle intersectorRectangle = new Rectangle();
	
	public GraphController(GraphWorld dungeonWorld) {
		this.graphWorld = dungeonWorld;
	}
	

	public Vector2 draggedDelta = new Vector2();
	
	@Override
	public void update() {
		if(!JInput.isJustPressed()) return;
		if(JGUI.INSTANCE.isStageHandleInput()) return;
		
		Vector2 screenMousePosition = JInput.getMousePosition();
		Vector2 worldMousePosition = JCamera.getMain().screenToWorldPoint(screenMousePosition);
		
//		worldMousePosition.y = worldMousePosition.y + JCamera.getMain().getNative().getViewport().y / 2;
		
		Rectangle mouseRectangle = new Rectangle(worldMousePosition.x, worldMousePosition.y, 1, 1);
		
		int clickedCount = 0;
		for(MovableGraphElement element : graphWorld.getMovableElements()){
			Rectangle bounds = element.getBound();
			if(Intersector.intersectRectangles(mouseRectangle, bounds, intersectorRectangle)){
				ElementClickEvent elementClickEvent = new ElementClickEvent(element, clickedCount);
				JEngine.INSTANCE.getEventBus().post(elementClickEvent);
				clickedCount++;
			}
		}
		
		for(GraphNode node : graphWorld.getNodes()){
			Rectangle bounds = node.getBound();
			if(Intersector.intersectRectangles(mouseRectangle, bounds, intersectorRectangle)){
				ElementClickEvent elementClickEvent = new ElementClickEvent(node, clickedCount);
				JEngine.INSTANCE.getEventBus().post(elementClickEvent);
				clickedCount++;
			}
		}
	}
	
	@Override
	public void onMouseClicked() {
		System.out.println("onMouseClicked");
	}
	
	@Override
	public void onMouseDragged(Vector2 draggedDelta) {
		System.out.println("onMouseDragged: " + draggedDelta);
	}
}
