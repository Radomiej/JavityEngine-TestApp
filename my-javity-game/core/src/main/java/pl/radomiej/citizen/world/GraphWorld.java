package pl.radomiej.citizen.world;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ai.pfa.PathFinder;
import com.badlogic.gdx.ai.pfa.PathSmoother;
import com.badlogic.gdx.ai.pfa.indexed.IndexedAStarPathFinder;
import com.badlogic.gdx.ai.utils.Collision;
import com.badlogic.gdx.ai.utils.Ray;
import com.badlogic.gdx.ai.utils.RaycastCollisionDetector;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

import pl.radomiej.citizen.generator.CitizenWorldGenerator;
import pl.radomiej.citizen.world.ai.FlatTiledGraph;
import pl.radomiej.citizen.world.ai.FlatTiledNode;
import pl.radomiej.citizen.world.ai.TiledManhattanDistance;
import pl.radomiej.citizen.world.ai.TiledSmoothableGraphPath;

public class GraphWorld {

	public static GraphWorld randomWorld() {
		return new CitizenWorldGenerator().generate();
	}

	private List<GraphNode> rooms = new ArrayList<GraphNode>();
	private List<GraphNodeConnection> roomConnections = new ArrayList<GraphNodeConnection>();
	private List<MovableGraphElement> units = new ArrayList<MovableGraphElement>();
	private List<MovableGraphElement> enemies = new ArrayList<MovableGraphElement>();

	private FlatTiledGraph worldMap;
	private PathFinder<FlatTiledNode> pathFinder;
	private TiledSmoothableGraphPath<FlatTiledNode> path;
	private TiledManhattanDistance<FlatTiledNode> heuristic;

	public void generateAi() {
		worldMap = new FlatTiledGraph();
		worldMap.init(rooms, roomConnections);
		pathFinder = new IndexedAStarPathFinder<FlatTiledNode>(worldMap, true);
		path = new TiledSmoothableGraphPath<FlatTiledNode>();
		heuristic = new TiledManhattanDistance<FlatTiledNode>();
	}

	public List<Vector2> getPath(GraphNode start, GraphNode end) {
		System.out.println("Path start: " + start + " end: " + end);
		List<Vector2> results = new ArrayList<Vector2>();
		if (pathFinder.searchNodePath(start.getNode(), end.getNode(), heuristic, path)) {
			System.out.println("Path znaleziony! ");

			for (FlatTiledNode node : path) {
				Vector2 step = new Vector2(node.x, node.y);
				results.add(step);
				System.out.println("Add step: " + step);
			}
		}
		path.clear();
		return results;
	}

	public List<GraphNode> getNodes() {
		return rooms;
	}

	public void setRooms(List<GraphNode> rooms) {
		this.rooms = rooms;
	}

	public List<GraphNodeConnection> getRoomConnections() {
		return roomConnections;
	}

	public void setRoomConnections(List<GraphNodeConnection> roomConnections) {
		this.roomConnections = roomConnections;
	}

	public List<MovableGraphElement> getMovableElements() {
		return units;
	}

	public void setMovableElements(List<MovableGraphElement> units) {
		this.units = units;
	}

	public GraphNode getCurrentRoom(MovableGraphElement unit) {
		Vector2 position = unit.getPosition().cpy();
		float minDistance = Float.MAX_VALUE;
		GraphNode nearestRoom = null;
		
		for(GraphNode room : rooms){
			float distance = position.dst(room.getPosition());
			if(distance < minDistance){
				minDistance = distance;
				nearestRoom = room;
			}
		}
		
		return nearestRoom;
	}

	public List<MovableGraphElement> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<MovableGraphElement> enemies) {
		this.enemies = enemies;
	}

}
