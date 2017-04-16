package pl.radomiej.citizen.components;

import org.javity.components.SpriteRenderer;
import org.javity.engine.JCamera;
import org.javity.engine.JComponent;
import org.javity.engine.JEngine;
import org.javity.engine.JGameObject;
import org.javity.engine.JInput;
import org.javity.ui.JXmlUi;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.google.common.eventbus.Subscribe;

import pl.radomiej.citizen.view.events.OpenBuildMenuEvent;
import pl.radomiej.citizen.world.GraphWorld;
import pl.radomiej.citizen.world.MovableGraphElement;
import pl.radomiej.citizen.world.events.ElementClickEvent;

public class BottomMenuController extends JComponent {

	private JXmlUi xmlUi;

	@Override
	public void awake() {
		JEngine.INSTANCE.getEventBus().register(this);
		xmlUi = getGameObject().getComponent(JXmlUi.class);

	}

	@Subscribe
	public void elementClickEventListener(ElementClickEvent elementClickEvent) {
//		System.out.println("elementClickEventListener");
		
		JGameObject gameFieldObject = (JGameObject) elementClickEvent.element.getUserObject();
		final GameField gameField = gameFieldObject.getComponent(GameField.class);
		
		
		Label labelPopulation = xmlUi.getActor("population");
		labelPopulation.setText(Integer.toString(gameField.getPopulation()));
		
		Label labelFieldName = xmlUi.getActor("fieldName");
		labelFieldName.setText(gameField.getName());
		
		Table table = xmlUi.getActor("elementOptions");
		table.clear();
		
		TextButton buttonBuild = new TextButton("Build", xmlUi.getSkin());
		buttonBuild.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				OpenBuildMenuEvent openBuildMenuEvent = new OpenBuildMenuEvent(gameField);
				JEngine.INSTANCE.getEventBus().post(openBuildMenuEvent);
			}
		});
		table.add(buttonBuild);
		
		TextButton buttonRecruite = new TextButton("Recruit", xmlUi.getSkin());
		table.add(buttonRecruite);
		
		TextButton buttonOrder = new TextButton("Order", xmlUi.getSkin());
		table.add(buttonOrder);
	}
}
