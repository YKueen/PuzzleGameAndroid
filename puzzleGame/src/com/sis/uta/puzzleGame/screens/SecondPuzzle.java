package com.sis.uta.puzzleGame.screens;

import java.io.IOException;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.XmlReader;

public class SecondPuzzle implements Screen{
	
	private Game game;
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonBack, button1, button2, button3, button4, button5;
	private BitmapFont white, black;
	private Label heading;
	
	
	public SecondPuzzle(Game game) {
		this.game = game;
	}

	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
		stage=new Stage();
		Gdx.input.setInputProcessor(stage);
		
		CharSequence taskName = null;
		String value1 = null, value2 = null, value3 = null, value4 = null;
		//String[] results = null;
		int required;
		
		//parsing
		try {
		      XmlReader xmlReader = new XmlReader();
		      FileHandle file = Gdx.files.internal("data/x.xml");
		      XmlReader.Element root = xmlReader.parse(file);
		      XmlReader.Element taskElement = root.getChildByName("task");

		      taskName = root.getAttribute("name");
		      required = root.getInt("required", 1);
//		        XmlReader.Element resultsElement = root.getChildByName("results");
//		        final int resultCount = resultsElement.getChildCount();
//		        results = new String[resultCount];
//
//		        for (int j = 0; resultCount < j; ++j) {
//		          XmlReader.Element result = resultsElement.getChild(j);
//		          String value = result.getAttribute("value");
//		          results[j] = value;
//		        }
		        
		        XmlReader.Element resultsElement = root.getChildByName("result");
		        value1 = resultsElement.getAttribute("value1");
		        value2 = resultsElement.getAttribute("value2");
		        value3 = resultsElement.getAttribute("value3");
		        value4 = resultsElement.getAttribute("value4");		        
		        
		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		atlas=new TextureAtlas("ui/button.pack");
		skin=new Skin(atlas);
		
		table=new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		table.layout();
		table.left();
		
		white=new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		black=new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		
		TextButtonStyle textButtonStyle=new TextButtonStyle();
		textButtonStyle.up=skin.getDrawable("button.up");
		textButtonStyle.down=skin.getDrawable("button.down");
		textButtonStyle.pressedOffsetX=1;
		textButtonStyle.pressedOffsetY=-1;
		textButtonStyle.font=black;
		
		TextFieldStyle textFieldStyle= new TextFieldStyle();
		textFieldStyle.fontColor = Color.WHITE;
		textFieldStyle.focusedFontColor = Color.PINK;
		textFieldStyle.background = skin.getDrawable("button.up");
		textFieldStyle.font = black;
		
		buttonBack=new TextButton("Back", textButtonStyle);
		buttonBack.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				((Game)Gdx.app.getApplicationListener()).setScreen(new FirstSection(game));
			}
		});
		
		LabelStyle headingStyle=new LabelStyle(white, Color.WHITE);
		heading = new Label(taskName, headingStyle);
		heading.setFontScale(0.6f);
		heading.setWrap(true);
		heading.setColor(Color.WHITE);
		heading.setWidth(0);
		
		TextButton button1 = new TextButton("1", textButtonStyle);
		button1.left();
		button1.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//add checking
				((Game)Gdx.app.getApplicationListener()).setScreen(new FirstSection(game));
			}
		});  
		
		TextButton button2 = new TextButton("2", textButtonStyle);
		button2.left();
		button2.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//add checking
				((Game)Gdx.app.getApplicationListener()).setScreen(new FirstSection(game));
			}
		});  
		
		TextButton button3 = new TextButton("3", textButtonStyle);
		button3.left();
		button3.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//add checking
				((Game)Gdx.app.getApplicationListener()).setScreen(new FirstSection(game));
			}
		});  
		
		TextButton button4 = new TextButton("4", textButtonStyle);
		button4.left();
		button4.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//add checking
				((Game)Gdx.app.getApplicationListener()).setScreen(new FirstSection(game));
			}
		});  
		
		TextButton button5 = new TextButton("5", textButtonStyle);
		button5.left();
		button5.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//add checking
				((Game)Gdx.app.getApplicationListener()).setScreen(new FirstSection(game));
			}
		});  
		
		ButtonGroup answers = new ButtonGroup(button1, button2, button3, button4, button5);
		//answers.setChecked("1");
		answers.setMaxCheckCount(1);
				
		table.row().minWidth(Gdx.graphics.getWidth()).colspan(2);
		table.add(heading).colspan(2);
		
//		int resultCount = results.length;
//		for (int j = 0; resultCount > j; ++j) {
//			table.row();
//			String str = Integer.toString(results[j]);
//			table.add(str);
//		}
		//table.add(results[0]);
		
		table.row().minWidth(Gdx.graphics.getWidth()/3).minHeight(Gdx.graphics.getHeight()/9);
		table.add(button1);
		table.row().minWidth(Gdx.graphics.getWidth()/3).minHeight(Gdx.graphics.getHeight()/9);
		table.add(button2);
		table.row().minWidth(Gdx.graphics.getWidth()/3).minHeight(Gdx.graphics.getHeight()/9);
		table.add(button3);
		table.row().minWidth(Gdx.graphics.getWidth()/3).minHeight(Gdx.graphics.getHeight()/9);
		table.add(button4);
		table.row().minWidth(Gdx.graphics.getWidth()/3).minHeight(Gdx.graphics.getHeight()/9);
		table.add(button5);
		table.add(buttonBack);
		
		stage.addActor(table);
				
	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
