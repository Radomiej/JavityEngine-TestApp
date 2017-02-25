package pl.radomiej.dungeon.world;

import com.badlogic.gdx.math.Vector2;

import pl.radomiej.dungeon.world.rooms.BanditRoom;
import pl.radomiej.dungeon.world.rooms.BarrackRoom;
import pl.radomiej.dungeon.world.rooms.MainRoom;
import pl.radomiej.dungeon.world.rooms.MinerRoom;
import pl.radomiej.dungeon.world.units.Imp;
import pl.radomiej.dungeon.world.units.Orc;

public class DungeonWorldGenerator {

	public DungeonWorld generate() {
		DungeonWorld world = new DungeonWorld();
		generateStartRooms(world);
		return world;
	}

	private void generateStartRooms(DungeonWorld world) {
		//Create rooms
		Room startRoom = new MainRoom(new Vector2(250, 250));
		world.getRooms().add(startRoom);
		
		Room minerRoom = new MinerRoom(new Vector2(500, 320));
		world.getRooms().add(minerRoom);
		
		Room barrackRoom = new BarrackRoom(new Vector2(200, 480));
		world.getRooms().add(barrackRoom);
		
		Room banditRoom = new BanditRoom(new Vector2(280, 780));
		world.getRooms().add(banditRoom);
		
		//Create connections
		RoomConnection roomConnection = new RoomConnection(startRoom, minerRoom); 
		world.getRoomConnections().add(roomConnection);
		
		RoomConnection roomConnection2 = new RoomConnection(startRoom, barrackRoom); 
		world.getRoomConnections().add(roomConnection2);
		
		RoomConnection roomConnection3 = new RoomConnection(barrackRoom, banditRoom); 
		world.getRoomConnections().add(roomConnection3);
		
		
		//Add player start unit
		Unit unit1 = new Imp(new Vector2(250, 250), world);
		world.getUnits().add(unit1);
		
		//Add some enemies
		Unit unitEnemy1 = new Orc(banditRoom.getPosition(), world);
		world.getEnemies().add(unitEnemy1);
		
		Unit unitEnemy2 = new Orc(banditRoom.getPosition(), world);
		world.getEnemies().add(unitEnemy2);
		
		//Prepare AI
		world.generateAi();		

		//Test commend
		unit1.goTo(minerRoom);
	}

}
