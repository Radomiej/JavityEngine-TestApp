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

public class SmallRectangleCanvasDrawer extends JComponent {
	private JavityCanvasComponent canvasComponents;
	private SilverCanvas canvas;
	private SpriteBatch spriteBatch;
	private Sprite sprite;
	
	public ComplexPolygon my;
	public SmallRectangleCanvasDrawer(){
		
	}
	
	@Override
	public void start() {
		long time = System.nanoTime();
		canvasComponents = getGameObject().getComponent(JavityCanvasComponent.class);
		canvas = canvasComponents.getCanvas();
		spriteBatch = new SpriteBatch();
		
		PointDefinition pointsDefinition = new PointDefinition(PointType.DOT, 1, 1, Color.CHARTREUSE, Color.GREEN);
		PolygonDefinition polygonDefinition = new PolygonDefinition(pointsDefinition, 2, 0, 0, Color.RED, Color.BLUE);
		
		List<Position> shapePositions = new ArrayList<Position>();
		shapePositions.add(new Position(32, 0));
		shapePositions.add(new Position(64, 32));
		shapePositions.add(new Position(32, 64));
		shapePositions.add(new Position(0, 32));
//		shapePositions.add(new Position(100, 0));
		
		ShapeHole hole1 = new ShapeHole();
		hole1.addVertexPosition(new Position(2, 2));
		hole1.addVertexPosition(new Position(2, 3));
		hole1.addVertexPosition(new Position(3, 3));
		hole1.addVertexPosition(new Position(3, 2));
		
		
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
	public void preGuiRender() {
		Vector2 pos = getTransform().getPosition();
		sprite.setPosition(pos.x, pos.y);
		
		spriteBatch.setProjectionMatrix(JCamera.getMain().getNative().getCombined());
		spriteBatch.begin();
		sprite.draw(spriteBatch);
		spriteBatch.end();
	}
	
}
