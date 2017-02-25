package pl.radomiej.dungeon;
import org.javity.components.LineRenderer;
import org.javity.components.SpriteRenderer;
import org.javity.components.TextRenderer;
import org.javity.engine.JGameObject;
import org.javity.engine.Scene;
import org.javity.engine.SceneBulider;
import org.javity.engine.resources.SpritePivot;
import org.jrenner.smartfont.SmartFontGenerator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.BackComponent;
import com.mystudio.gamename.components.CameraControllerComponent;

import pl.radomiej.dungeon.components.UnitComponent;
import pl.radomiej.dungeon.world.DungeonWorld;
import pl.radomiej.dungeon.world.Room;
import pl.radomiej.dungeon.world.RoomConnection;
import pl.radomiej.dungeon.world.Unit;

public class DungeonCrawderScene implements SceneBulider {

	@Override
	public void buildScene(Scene scene) {
		JGameObject back = scene.instantiateGameObject(new Vector2(0, 0));
		back.addComponent(new BackComponent());
		back.addComponent(new CameraControllerComponent());
		
		DungeonWorld dungeonWorld = DungeonWorld.randomWorld();
		for(Room room : dungeonWorld.getRooms()){
			JGameObject roomGameObject = scene.instantiateGameObject(room.getPosition());
			roomGameObject.addComponent(new TextRenderer("gdx-skins-master/lml/skin/Hack-Regular.ttf", room.getClass().getSimpleName(), 22));
			roomGameObject.getTransform().setZ(1);
			
			JGameObject roomSprite = scene.instantiateGameObject(room.getPosition());
			roomSprite.addComponent(new SpriteRenderer("dungeon/circle-512.png"));
			roomSprite.getComponent(SpriteRenderer.class).setPivot(SpritePivot.CENTER);
			roomSprite.getTransform().setScale(0.2f);
		}
		
		for(RoomConnection roomConnection : dungeonWorld.getRoomConnections()){
			Vector2 middle = roomConnection.roomA.getPosition().cpy().add(roomConnection.roomB.getPosition()).scl(0.5f);
			JGameObject roomConnectionGameObject = scene.instantiateGameObject(new Vector2());
			LineRenderer lineRenderer = new LineRenderer(roomConnection.roomA.getPosition(), roomConnection.roomB.getPosition());
			lineRenderer.setWidth(10);
			lineRenderer.setColor(Color.BLACK);
			roomConnectionGameObject.addComponent(lineRenderer);
//			roomSprite.getTransform().setScale(0.2f);
			roomConnectionGameObject.getTransform().setZ(-22);
		}
		
		for(Unit unit : dungeonWorld.getUnits()){
			JGameObject unitGameObject = scene.instantiateGameObject(unit.getPosition());
			unitGameObject.addComponent(new SpriteRenderer("dungeon/circle-512.png"));
			unitGameObject.getComponent(SpriteRenderer.class).setColor(Color.ORANGE);
			unitGameObject.getTransform().setScale(0.02f);
			unitGameObject.addComponent(new UnitComponent(unit));
		}
	}

}
