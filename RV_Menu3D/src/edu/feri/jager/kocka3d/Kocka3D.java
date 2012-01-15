package edu.feri.jager.kocka3d;

import java.io.File;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.PerspectiveCamera;

public class Kocka3D implements ApplicationListener {

	private Mesh[] mesh = null;
	private PerspectiveCamera camera;
	private CameraPosition camPos;
	private MeshArray meshArray;
	private Music music;

	
	public void create() {
		if (mesh == null) {
			meshArray = new MeshArray(6);
			mesh = meshArray.getArray();

			camPos = new CameraPosition();
			
			music = Gdx.audio.newMusic(Gdx.files.internal("audio" + File.separator + "audio1.mp3"));
			music.setLooping(true);
			music.setVolume(new Float(0.5));
			music.play();
		}

		Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
	}

	
	public void render() {
		if (Gdx.input.isKeyPressed(Input.Keys.PLUS)) {
			camPos.moveForward();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.MINUS)) {
			camPos.moveBackward();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			camPos.moveLeft();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			camPos.moveRight();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			camPos.moveDown();
		} 
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			camPos.moveUp();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.X)) {
			if(music != null && !music.isPlaying()) {
				music.play();
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.C)) {
			if(music != null && music.isPlaying()) {
				music.pause();
			}
		}

		camPos.rotate();

		camera.position.set(camPos.getPosX(), camPos.getPosY(), camPos.getPosZ());
		camera.lookAt(0, 0, 0);	

		camera.update();
		camera.apply(Gdx.gl10);

		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		for (Mesh face : mesh) {
			face.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
		}
	}

	
	public void resize(int width, int height) {
		float aspectRatio = (float) width / (float) height;
		camera = new PerspectiveCamera(67, 2f * aspectRatio, 2f);
		camera.near = 0.1f;
		camera.position.set(camPos.getPosX(), camPos.getPosY(), camPos.getPosZ());
	}

	public void dispose() {
		music.dispose();
	}

	public void pause() {
		music.pause();
	}

	public void resume() {
		music.play();
	}
}