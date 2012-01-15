package edu.feri.jager.menu3d;

import com.badlogic.gdx.math.MathUtils;

public class CameraPositionMenu {
	public static final float ANGLE_DEG = new Float(1.2);

	private float posX, posY, posZ;
	private float step, newPosX, newPosZ;

	public CameraPositionMenu() {
		setPosX(new Float(0));
		setPosY(new Float(2));
		setPosZ(new Float(1));
		setNewPosX(getPosX());
		setNewPosZ(getPosZ());
		setStep(new Float(0.03));
	}

	public boolean isPosAxis() {
		if(getPosX() > 0 && getPosY() > 0 && getPosZ() > 0)
			return true;
		return false;
	}
	public boolean isNegAxis() {
		if(getPosX() < 0 && getPosY() < 0 && getPosZ() < 0)
			return true;
		return false;
	}
	
	public void moveDown() {
//		setPosY(getPosY() - getStep());
		
		rotateYAxis(4*ANGLE_DEG);
		
	}

	public void moveUp() {
//		setPosY(getPosY() + getStep());
		rotateYAxis(-(4*ANGLE_DEG));

	}
	
	public void moveLeft() {
//		rotateXAxis(4*ANGLE_DEG);
		rotateXAxis1(120);
		
		rotateXAxis(4*ANGLE_DEG);
		
	}

	public void moveRight() {
		rotateXAxis(-(4*ANGLE_DEG));
//		rotateXAxis(-120);
//		rotateXAxis(-(1));

	}

	public void moveBackward() {
		if(getPosX() < 0) {
			if(getPosZ() < 0) {
				setPosZ(getPosZ() - getStep());
			}
			else {
				setPosZ(getPosZ() + getStep());				
			}
			setPosX(getPosX() - getStep());
		}
		else {
			if(getPosZ() < 0) {
				setPosZ(getPosZ() - getStep());
			}
			else {
				setPosZ(getPosZ() + getStep());
			}
			setPosX(getPosX() + getStep());
		}
	}

	public void moveForward() {
		if(getPosX() > 0) {
			if(getPosZ() > 0) {
				setPosZ(getPosZ() - getStep());
			}
			else {
				setPosZ(getPosZ() + getStep());				
			}
			setPosX(getPosX() - getStep());
		}
		else {
			if(getPosZ() > 0) {
				setPosZ(getPosZ() - getStep());
			}
			else {
				setPosZ(getPosZ() + getStep());
			}
			setPosX(getPosX() + getStep());
		}
	}
	
	private void rotateYAxis(float angleDeg) {
		float cos = MathUtils.cosDeg(angleDeg);
		float sin = MathUtils.sinDeg(angleDeg);
		float x = getPosX();
		float y = getPosY();
		
		setPosX(cos*x - sin*y);
		setPosY(sin*x + cos*y);
	}
	
	public void rotateXAxis1(float angleDeg) {
		float cos = MathUtils.cosDeg(angleDeg);
		float sin = MathUtils.sinDeg(angleDeg);
		float x = getPosX();
		float z = getPosZ();
		
		setNewPosX(cos*x - sin*z);
		setNewPosZ(sin*x + cos*z);
		
		if(isNegAxis()) {
			setNewPosX(cos*x - sin*z);
			setNewPosZ(sin*x + cos*z);
		}
		if(isPosAxis()) {
			setNewPosX(cos*x - sin*z);
			setNewPosZ(sin*x + cos*z);	
		}
		System.out.println("originalX: " + getNewPosX() + ", originalZ: " + getNewPosZ());

	}

	public void rotateXAxis(float angleDeg) {
		float cos = MathUtils.cosDeg(angleDeg);
		float sin = MathUtils.sinDeg(angleDeg);
		float x = getPosX();
		float z = getPosZ();
		
		setPosX(cos*x - sin*z);
		setPosZ(sin*x + cos*z);
		
		if(isNegAxis()) {
			setPosX(cos*x - sin*z);
			setPosZ(sin*x + cos*z);
		}
		if(isPosAxis()) {
			setPosX(cos*x - sin*z);
			setPosZ(sin*x + cos*z);	
		}
	}

	public float getPosX() {
		return posX;
	}

	public float getPosY() {
		return posY;
	}

	public float getPosZ() {
		return posZ;
	}

	public float getStep() {
		return step;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public void setPosZ(float posZ) {
		this.posZ = posZ;
	}

	public void setStep(float step) {
		this.step = step;
	}

	public float getNewPosX() {
		return newPosX;
	}

	public void setNewPosX(float newPosX) {
		this.newPosX = newPosX;
	}

	public float getNewPosZ() {
		return newPosZ;
	}

	public void setNewPosZ(float newPosY) {
		this.newPosZ = newPosY;
	}
}