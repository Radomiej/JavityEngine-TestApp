package com.mystudio.gamename.components.canvas;

import java.util.ArrayList;
import java.util.List;

import org.javity.engine.JCamera;
import org.javity.engine.JComponent;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import pl.silver.canvas.Color;
import pl.silver.canvas.LineDefinition;
import pl.silver.canvas.PointDefinition;
import pl.silver.canvas.PolygonDefinition;
import pl.silver.canvas.Position;
import pl.silver.canvas.ShapeHole;
import pl.silver.canvas.SilverCanvas;
import pl.silver.canvas.generic.GenericCanvas;
import pl.silver.canvas.PointDefinition.PointType;
import pl.silver.canvas.javity.JavityCanvasComponent;
import pl.silver.canvas.libgdx.triangulation.primitives.ComplexPolygon;

public class CollisionCanvasDrawer extends JComponent {
	private JavityCanvasComponent canvasComponents;
	private SilverCanvas canvas;
	private SpriteBatch spriteBatch;
	private Sprite sprite;
	
	private SmallRectangleCanvasDrawer other;
	private ComplexPolygon my;
	
	public CollisionCanvasDrawer(){
		
	}
	
	public CollisionCanvasDrawer(SmallRectangleCanvasDrawer collisionDrawer) {
		this.other = collisionDrawer;
	}

	@Override
	public void start() {
		long time = System.nanoTime();
		canvasComponents = getGameObject().getComponent(JavityCanvasComponent.class);
		canvas = canvasComponents.getCanvas();
		spriteBatch = new SpriteBatch();
		
		PointDefinition pointsDefinition = new PointDefinition(PointType.DOT, 1, 4, Color.CHARTREUSE, Color.GREEN);
		PolygonDefinition polygonDefinition = new PolygonDefinition(pointsDefinition, 2, 0, 0, Color.RED, Color.BLUE);
		
		List<Position> shapePositions = new ArrayList<Position>();
		shapePositions.add(new Position(128, 0));
		shapePositions.add(new Position(255, 128));
		shapePositions.add(new Position(128, 255));
		shapePositions.add(new Position(0, 128));
//		shapePositions.add(new Position(100, 0));
		
		ShapeHole hole1 = new ShapeHole();
		hole1.addVertexPosition(new Position(100, 100));
		hole1.addVertexPosition(new Position(100, 200));
		hole1.addVertexPosition(new Position(200, 200));
		hole1.addVertexPosition(new Position(200, 100));
		
		List<ShapeHole> shapeHoles = new ArrayList<ShapeHole>();
		shapeHoles.add(hole1);
		
		my = new ComplexPolygon(shapePositions, shapeHoles);
		canvas.drawShape(shapePositions, shapeHoles, polygonDefinition);
		time = System.nanoTime() - time;
		time /= 100000;
		
		System.out.println("time of execution: " + time);
		
		sprite = new Sprite(canvas.getTexture());
	}
	
	@Override
	public void update() {
		if(other == null) return;
		
		ComplexPolygon complexPolygonMy = my.copyComplexPolygon();		
		ComplexPolygon complexPolygonOther = other.my.copyComplexPolygon();
		
		complexPolygonOther.move(other.getTransform().getPosition());
		complexPolygonMy.move(getTransform().getPosition());
		complexPolygonMy.intersect(complexPolygonOther);
//		System.out.println("collision: " + complexPolygonMy.intersect(complexPolygonOther));
	}
	
	@Override
	public void preGuiRender() {
		Vector2 pos = getTransform().getPosition();
		sprite.setPosition(pos.x, pos.y);
		
		spriteBatch.setProjectionMatrix(JCamera.getMain().getNative().getCombined());
		spriteBatch.begin();
		sprite.draw(spriteBatch);
		spriteBatch.end();
	}
	
}
