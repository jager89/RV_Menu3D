package edu.feri.jager.menu3d;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.PerspectiveCamera;

public class Meni3D implements ApplicationListener {

	private Mesh[] mesh = null;
	private PerspectiveCamera camera;
	private CameraPositionMenu camPos;
	private PiramideArray piramideArray;
	private float prevPointX;
	private float prevPointY;
	private Input input;
	private boolean isRotating;
	private boolean isRotatingLeft;
	private boolean isRotatingRight;
	private boolean isClicked;
	private boolean isBack;
	private int countRotation;
	private ActivityClass activityClass;
	enum Stran {prva, druga, tretja};
	Stran currStran;
	
	public Meni3D(ActivityClass activityClass) {
		this.activityClass = activityClass;
	}

	public void create() {
		if (mesh == null) {
			piramideArray = new PiramideArray(1);
			mesh = piramideArray.getArray();
			camPos = new CameraPositionMenu();

			currStran = Stran.prva;
			setInput(Gdx.input);
			setClicked(false);
			setRotating(false);
			setRotatingLeft(false);
			setRotatingRight(false);
		}

		Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
	}

	public void render() {
		if(getInput().justTouched()) {
			if(isBack()) {
				setBack(false);
			}
		}
		
		if(getInput().isTouched()) {
			int deltaX = input.getDeltaX();
			int y = input.getY();
			int x = input.getX();

			System.out.println(getInput().getDeltaX());
			if(!isRotating()) {
				if(y > 570 && deltaX > 0) {
					camPos.rotateXAxis1(120);
					countRotation = 0;
					setRotating(true);
					setRotatingRight(true);
				} else if(y > 570 && deltaX < 0) {
					camPos.rotateXAxis1(-(120));
					countRotation = 0;
					setRotating(true);
					setRotatingLeft(true);
				}
				else if(!isBack() && !isClicked() && deltaX == 0 && y < 570 && y > 270 && x > 120 && x < 440){
					setClicked(true);
					System.out.println("CLICK!");
					setRotating(false);
					setRotatingLeft(false);
					setRotatingRight(false);

					switch (currStran) {
					case prva:
						activityClass.startKocka3DActivity();
						break;
					case druga:
						activityClass.start2Activity();
						break;
					case tretja:
						activityClass.start3Activity();
						break;

					default:
						break;
					}
				}		
			}
		}

		if(isRotating()) {
			if(isRotatingRight()) {
				countRotation++;
				if(countRotation < 48) {
					camPos.rotateXAxis(2.5f);
				}
				else {
					camPos.setPosX(camPos.getNewPosX());
					camPos.setPosZ(camPos.getNewPosZ());

					if(currStran == Stran.prva) {
						currStran = Stran.tretja;
					}
					else if(currStran == Stran.tretja) {
						currStran = Stran.druga;
					}
					else {
						currStran = Stran.prva;
					}
					
					setClicked(false);
					setRotating(false);
					setRotatingRight(false);
				}
			} else if(isRotatingLeft()) {
				countRotation++;
				if(countRotation < 48) {
					camPos.rotateXAxis(-(2.5f));
				}
				else {
					camPos.setPosX(camPos.getNewPosX());
					camPos.setPosZ(camPos.getNewPosZ());

					if(currStran == Stran.prva) {
						currStran = Stran.druga;
					}
					else if(currStran == Stran.druga) {
						currStran = Stran.tretja;
					}
					else {
						currStran = Stran.prva;
					}
					
					setClicked(false);
					setRotating(false);
					setRotatingLeft(false);
				}
			} 
			camera.position.set(camPos.getPosX(), camPos.getPosY(), camPos.getPosZ());
		}

		camera.lookAt(0, 0, 0);	
		camera.update();
		camera.apply(Gdx.gl10);

		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		for (Mesh face : mesh) {
			face.render(GL10.GL_TRIANGLE_STRIP, 0, 3);
		}
	}

	public void resize(int width, int height) {
		float aspectRatio = (float) width / (float) height;
		camera = new PerspectiveCamera(67, 2f * aspectRatio, 2f);
		camera.near = 0.1f;
		camera.position.set(camPos.getPosX(), camPos.getPosY(), camPos.getPosZ());
	}

	public void resume() {	
//		if (mesh == null) {
//			piramideArray = new PiramideArray(1);
//			mesh = piramideArray.getArray();
//		}
		setBack(true);
//		currStran = Stran.prva;
//		camPos = new CameraPositionMenu();

		setClicked(false);
		setRotating(false);
		setRotatingLeft(false);
		setRotatingRight(false);

		Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
	}
	public void dispose() {}

	public void pause() {}

	public float getPrevPointX() {
		return prevPointX;
	}

	public void setPrevPointX(float prevPointX) {
		this.prevPointX = prevPointX;
	}

	public float getPrevPointY() {
		return prevPointY;
	}

	public void setPrevPointY(float prevPointY) {
		this.prevPointY = prevPointY;
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public boolean isRotating() {
		return isRotating;
	}

	public void setRotating(boolean isRotating) {
		this.isRotating = isRotating;
	}

	public boolean isClicked() {
		return isClicked;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}

	public boolean isRotatingRight() {
		return isRotatingRight;
	}

	public void setRotatingRight(boolean isRotatingRight) {
		this.isRotatingRight = isRotatingRight;
	}

	public boolean isRotatingLeft() {
		return isRotatingLeft;
	}

	public void setRotatingLeft(boolean isRotatingLeft) {
		this.isRotatingLeft = isRotatingLeft;
	}

	public boolean isBack() {
		return isBack;
	}

	public void setBack(boolean isBack) {
		this.isBack = isBack;
	}
}