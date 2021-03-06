package com.geoquiz.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class MultMenu implements Screen {

    private GeoQuiz game;
    private Stage stage;
    private TextButton back;
    private TextButton create;
    private Array<Texture> rooms;
    private List<InetAddress> addressList;
    private Label.LabelStyle style;
    private Label gameRoomsName;
    private int updateRate;
    private boolean wait;

    MultMenu(final GeoQuiz game) {
        // Gdx.files.local("stats.txt").delete();
        this.game = game;
        stage = new Stage(new ScreenViewport());
        rooms = new Array<Texture>();
        addressList = new ArrayList<InetAddress>();

        style = new Label.LabelStyle();
        style.font = game.font;

        back = new TextButton("Back", game.buttonStyles.shortButtonStyle);
        back.setWidth(450);
        back.setHeight(250);
        back.getLabel().setFontScale(2f, 2f);
        back.setPosition(Gdx.graphics.getWidth() / 2 - 500, Gdx.graphics.getHeight() - 400);

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
            }
        });

        create = new TextButton("Create", game.buttonStyles.shortButtonStyle);
        create.setWidth(450);
        create.setHeight(250);
        create.getLabel().setFontScale(2f, 2f);
        create.setPosition(Gdx.graphics.getWidth() / 2 + 70, Gdx.graphics.getHeight() - 400);
        create.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                try {
                    game.createServer();
                    game.setScreen(new WaitRoom(game, true));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        gameRoomsName = new Label("Game rooms", style);
        gameRoomsName.setPosition((int) (Gdx.graphics.getWidth() / 2 - 250), (int) (Gdx.graphics.getHeight() - 100));
        gameRoomsName.setFontScale(3.f, 3.f);
        loadRooms();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    public void loadRooms() {
        addressList.clear();
        rooms.clear();
        stage.clear();
        updateRate = 0;

        addressList = game.client.client.discoverHosts(54777, 100);
        if (!addressList.isEmpty()) {
            for (int i = 0; i < addressList.size(); i++) {
                Texture texture = new Texture(Gdx.files.internal("longunpressed.png"));
                rooms.add(texture);
                final Label ip = new Label(addressList.get(i).toString().replace("/", ""), style);
                ip.setFontScale(2.f, 2.f);
                ip.setPosition(150, Gdx.graphics.getHeight() - 570 - i * 300);
                stage.addActor(ip);

                TextButton join = new TextButton("join", game.buttonStyles.shortButtonStyle);
                join.setWidth(150);
                join.setHeight(100);
                join.getLabel().setFontScale(1f, 1f);
                join.setPosition(750, Gdx.graphics.getHeight() - 600 - i * 300);
                join.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        try {
                            game.client.connect(ip.toString());
                            game.client.sendRequest();
                            wait = true;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

                stage.addActor(join);
            }
        }
        stage.addActor(back);
        stage.addActor(create);
        stage.addActor(gameRoomsName);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (updateRate > 100)
            loadRooms();
        updateRate++;

        if (wait){
            if(game.client.connected){
                game.client.connected = false;
                game.client.connect();
                game.setScreen(new WaitRoom(game, false));
            }
        }

        game.batch.begin();
        if (!addressList.isEmpty()) {
            for (int i = 0; i < addressList.size(); i++) {
                game.batch.draw(rooms.get(i), 100, Gdx.graphics.getHeight() - 700 - i * 300,
                        Gdx.graphics.getWidth() - 200, 300);
            }
        }
        game.batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
