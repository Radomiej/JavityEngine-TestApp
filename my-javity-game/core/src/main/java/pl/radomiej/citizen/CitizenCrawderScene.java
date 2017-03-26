package pl.radomiej.citizen;
import org.javity.components.LineRenderer;
import org.javity.components.SpriteRenderer;
import org.javity.components.TextRenderer;
import org.javity.components.TouchableObject;
import org.javity.engine.JGameObject;
import org.javity.engine.Scene;
import org.javity.engine.SceneBulider;
import org.javity.engine.resources.SpritePivot;
import org.javity.ui.JXmlUi;
import org.jrenner.smartfont.SmartFontGenerator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.mystudio.gamename.components.BackComponent;
import com.mystudio.gamename.components.CameraControllerComponent;

import pl.radomiej.citizen.components.BottomMenuController;
import pl.radomiej.citizen.components.GameField;
import pl.radomiej.citizen.components.GraphController;
import pl.radomiej.citizen.components.MovableElementComponent;
import pl.radomiej.citizen.world.GraphNode;
import pl.radomiej.citizen.world.GraphNodeConnection;
import pl.radomiej.citizen.world.GraphWorld;
import pl.radomiej.citizen.world.MovableGraphElement;

public class CitizenCrawderScene implements SceneBulider {

	@Override
	public void buildScene(Scene scene) {
		GraphWorld dungeonWorld = GraphWorld.randomWorld();
		
		JGameObject back = scene.instantiateGameObject(new Vector2(0, 0));
		back.addComponent(new BackComponent());
		back.addComponent(new CameraControllerComponent());
		back.addComponent(new GraphController(dungeonWorld));
		back.addComponent(new TouchableObject(2048, 2048));
		
		
		
//		JGameObject windowUiGameObject = scene.instantiateGameObject(new Vector2(0, 0));
//		JXmlUi windowUiComponent = new JXmlUi("views/scene-chooser-view.xml");
//		windowUiGameObject.addComponent(windowUiComponent);		
		
		JGameObject bottomUiGameObject = scene.instantiateGameObject(new Vector2(0, 0));
		JXmlUi xmlUiComponent = new JXmlUi("views/bottom-view.xml");
		bottomUiGameObject.addComponent(xmlUiComponent);
		bottomUiGameObject.addComponent(new BottomMenuController());
		
		for(GraphNode room : dungeonWorld.getNodes()){
			JGameObject roomGameObject = scene.instantiateGameObject(room.getPosition());
			roomGameObject.addComponent(new TextRenderer("gdx-skins-master/lml/skin/Hack-Regular.ttf", room.getName(), 22));
			roomGameObject.addComponent(new GameField(room));
			roomGameObject.getTransform().setZ(1);
			
			JGameObject roomSprite = scene.instantiateGameObject(room.getPosition());
			roomSprite.addComponent(new SpriteRenderer("dungeon/circle-512.png"));
			roomSprite.getComponent(SpriteRenderer.class).setPivot(SpritePivot.CENTER);
			roomSprite.getTransform().setParent(roomGameObject);
			roomSprite.getTransform().setLocalScale(0.2f);
			roomSprite.getTransform().setZ(0);
			room.setUserObject(roomGameObject);
		}
		
		for(GraphNodeConnection roomConnection : dungeonWorld.getRoomConnections()){
			Vector2 middle = roomConnection.roomA.getPosition().cpy().add(roomConnection.roomB.getPosition()).scl(0.5f);
			JGameObject roomConnectionGameObject = scene.instantiateGameObject(new Vector2());
			LineRenderer lineRenderer = new LineRenderer(roomConnection.roomA.getPosition(), roomConnection.roomB.getPosition());
			lineRenderer.setWidth(10);
			lineRenderer.setColor(Color.BLACK);
			roomConnectionGameObject.addComponent(lineRenderer);
//			roomSprite.getTransform().setScale(0.2f);
			roomConnectionGameObject.getTransform().setZ(-22);
		}
		
		for(MovableGraphElement unit : dungeonWorld.getMovableElements()){
			JGameObject unitGameObject = scene.instantiateGameObject(unit.getPosition());
			unitGameObject.addComponent(new SpriteRenderer("dungeon/circle-512.png"));
			unitGameObject.getComponent(SpriteRenderer.class).setColor(Color.ORANGE);
			unitGameObject.getTransform().setScale(0.02f);
			unitGameObject.addComponent(new MovableElementComponent(unit));
		}
	}

}
