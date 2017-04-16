package pl.radomiej.citizen.components;

import org.javity.engine.JComponent;
import org.javity.engine.JEngine;
import org.javity.ui.JXmlUi;

import com.google.common.eventbus.Subscribe;

import pl.radomiej.citizen.view.events.OpenBuildMenuEvent;
import pl.radomiej.citizen.world.events.ElementClickEvent;

public class BuildingMenuController extends JComponent {

	private JXmlUi xmlUi;
	private GameField currentGameField;

	@Override
	public void start() {
		JEngine.INSTANCE.getEventBus().register(this);
		xmlUi = getGameObject().getComponent(JXmlUi.class);

		xmlUi.hide();

	}

	@Subscribe
	public void openBuildMenuEventListener(OpenBuildMenuEvent openBuildMenuEvent) {
		currentGameField = openBuildMenuEvent.gameField;
		xmlUi.show();
	}
}
