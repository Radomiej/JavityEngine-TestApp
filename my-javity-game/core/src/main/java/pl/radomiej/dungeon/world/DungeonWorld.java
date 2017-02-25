package pl.radomiej.dungeon.world;

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

import pl.radomiej.dungeon.world.ai.FlatTiledGraph;
import pl.radomiej.dungeon.world.ai.FlatTiledNode;
import pl.radomiej.dungeon.world.ai.TiledManhattanDistance;
import pl.radomiej.dungeon.world.ai.TiledSmoothableGraphPath;

public class DungeonWorld {

	public static DungeonWorld randomWorld() {
		return new DungeonWorldGenerator().generate();
	}

	private List<Room> rooms = new ArrayList<Room>();
	private List<RoomConnection> roomConnections = new ArrayList<RoomConnection>();
	private List<Unit> units = new ArrayList<Unit>();
	private List<Unit> enemies = new ArrayList<Unit>();

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

	public List<Vector2> getPath(Room start, Room end) {
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

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<RoomConnection> getRoomConnections() {
		return roomConnections;
	}

	public void setRoomConnections(List<RoomConnection> roomConnections) {
		this.roomConnections = roomConnections;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public Room getCurrentRoom(Unit unit) {
		Vector2 position = unit.getPosition().cpy();
		float minDistance = Float.MAX_VALUE;
		Room nearestRoom = null;
		
		for(Room room : rooms){
			float distance = position.dst(room.getPosition());
			if(distance < minDistance){
				minDistance = distance;
				nearestRoom = room;
			}
		}
		
		return nearestRoom;
	}

	public List<Unit> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<Unit> enemies) {
		this.enemies = enemies;
	}

}
