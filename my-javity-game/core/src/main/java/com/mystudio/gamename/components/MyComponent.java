package com.mystudio.gamename.components;

import org.javity.engine.JComponent;
import org.javity.engine.JPhysic;

public class MyComponent extends JComponent{

	@Override
	public void start() {
		JPhysic.setDebugRender(true);
	}
}
