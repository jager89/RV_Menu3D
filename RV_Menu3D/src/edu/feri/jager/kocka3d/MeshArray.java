package edu.feri.jager.kocka3d;

import java.util.Vector;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;

public class MeshArray {
	private Vector<Mesh> vecMesh;

	public MeshArray(int size) {
		vecMesh = new Vector<Mesh>(size);
		fillVector();
	}
	public Mesh[] getArray() {
		Mesh[] temp = new Mesh[vecMesh.size()];
		for(int i = 0; i < vecMesh.size(); i++) {
			temp[i] = vecMesh.get(i);
		}
		return temp;
	}
	private void fillVector() {
		for (int i = 0; i < 6; i++) {
			Mesh tempMesh = new Mesh(true, 4, 4,
					new VertexAttribute(Usage.Position, 3, "a_position"),
					new VertexAttribute(Usage.ColorPacked, 4, "a_color"));

			tempMesh.setIndices(new short[] { 0, 1, 2, 3 });

			switch (i) {
			case 0:
				tempMesh.setVertices(new float[] {
						0.5f, 0.5f, 0.5f, Color.toFloatBits(255, 0, 0, 255),
						-0.5f, 0.5f, 0.5f, Color.toFloatBits(255, 0, 0, 255),
						0.5f, -0.5f, 0.5f, Color.toFloatBits(255, 0, 0, 255),
						-0.5f, -0.5f, 0.5f, Color.toFloatBits(255, 0, 0, 255) });
				break;
			case 1:
				tempMesh.setVertices(new float[] {
						0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 0, 255),
						-0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 0, 255),
						0.5f, -0.5f, -0.5f,  Color.toFloatBits(0, 255, 0, 255),
						-0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 255, 0, 255) });
				break;

			case 2:
				tempMesh.setVertices(new float[] {
						0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 0, 255, 255),
						-0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 0, 255, 255),
						0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 0, 255, 255),
						-0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 0, 255, 255) });
				break;

			case 3:
				tempMesh.setVertices(new float[] {
						0.5f, -0.5f, -0.5f, Color.toFloatBits(255, 0, 255, 255),
						-0.5f, -0.5f, -0.5f, Color.toFloatBits(255, 0, 255, 255),
						0.5f, -0.5f, 0.5f, Color.toFloatBits(255, 0, 255, 255),
						-0.5f, -0.5f, 0.5f,  Color.toFloatBits(255, 0, 255, 255) });
				break;

			case 4:
				tempMesh.setVertices(new float[] {
						0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 255, 255, 255),
						0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 255, 255, 255),
						0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 255, 255),
						0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 255, 255, 255) });
				break;
			case 5:
				tempMesh.setVertices(new float[] {
						-0.5f, 0.5f, 0.5f, Color.toFloatBits(255, 255, 0, 255),
						-0.5f, -0.5f, 0.5f, Color.toFloatBits(255, 255, 0, 255),
						-0.5f, 0.5f, -0.5f, Color.toFloatBits(255, 255, 0, 255),
						-0.5f, -0.5f, -0.5f, Color.toFloatBits(255, 255, 0, 255) });
				break;

			default:
				break;
			}
			vecMesh.add(tempMesh);
		}
	}


}
