package edu.feri.jager.menu3d;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;

public class PiramideArray {
	private List<Mesh> vecMesh;
	private final Integer MESH_COUNT = new Integer(4);
	private float size;
//	private Texture[] texture;
	
	public PiramideArray(int size) {
		vecMesh = new ArrayList<Mesh>(MESH_COUNT);
		setSize(size);
		fillVector();
	}
	public Mesh[] getArray() {
		Mesh[] mesh = new Mesh[MESH_COUNT];
		vecMesh.toArray(mesh);

		return mesh;
	}
	private void fillVector() {
//		texture = new Texture[MESH_COUNT];
		for (int i = 0; i < MESH_COUNT; i++) {
			Mesh tempMesh = new Mesh(true, 3, 3, 
					new VertexAttribute(Usage.Position, 3, "a_position"),
					new VertexAttribute(Usage.ColorPacked, 4, "a_color")); 
//            new VertexAttribute(Usage.TextureCoordinates, 2, "a_texCoords"));


			tempMesh.setIndices(new short[] { 0, 1, 2 });    

//			FileHandle imageFileHandle = Gdx.files.internal("image/image" + i + ".jpg"); 
//	        texture[i] = new Texture(imageFileHandle);

			
			
			float x = (((float) Math.sqrt(3)) / 3) * size;
			float y = (((float) Math.sqrt(3)) / 6) * size;
			float v = (float) Math.sqrt(Math.pow(size, 2) - Math.pow(x, 2));

			switch (i) {
//			case 0:
//				//SPODNJA PLOSKEV
//				tempMesh.setVertices(new float[] { 
//						-size/2, 0, y, 0, 1,
//						size/2, 0, y, 1, 1,
//						0, 0, -x, 0.5f, 0}); 
//				break;
//			case 1:
//				//SPREDNJA PLOSKEV
//				tempMesh.setVertices(new float[] { 
//						-size/2, 0, y, 0, 1,
//						size/2, 0, y, 1, 1,
//						0, v, 0, 0.5f, 0}); 
//				break;
//			case 2:
//				//DESNA PLOSKEV
//				tempMesh.setVertices(new float[] { 
//						size/2, 0, 0, 1,
//						0, 0, -x, 1, 1,
//						0, v, 0, 0.5f, 0}); 
//				break;
//			case 3:
//				//LEVA PLOSKEV
//				tempMesh.setVertices(new float[] { 
//						0, 0, -x, 0, 0.5f,
//						-size/2, 0.5f, 0.5f,
//						0, v, 0, 0.5f, 0}); 
//				break;
//			default:
//				break;
			
//			switch (i) {
//			case 0:
//				//SPODNJA PLOSKEV
//				tempMesh.setVertices(new float[] { 
//						-size/2, 0, y, Color.toFloatBits(255, 0, 0, 255), 0, 1,
//						size/2, 0, y, Color.toFloatBits(0, 255, 0, 255), 1, 1,
//						0, 0, -x, Color.toFloatBits(0, 0, 255, 255), 0.5f, 0}); 
//				break;
//			case 1:
//				//SPREDNJA PLOSKEV
//				tempMesh.setVertices(new float[] { 
//						-size/2, 0, y, Color.toFloatBits(255, 0, 0, 255), 0, 1,
//						size/2, 0, y, Color.toFloatBits(0, 255, 0, 255), 1, 1,
//						0, v, 0, Color.toFloatBits(0, 0, 255, 255), 0.5f, 0}); 
//				break;
//			case 2:
//				//DESNA PLOSKEV
//				tempMesh.setVertices(new float[] { 
//						size/2, 0, y, Color.toFloatBits(0, 0, 255, 255), 0, 1,
//						0, 0, -x, Color.toFloatBits(255, 0, 0, 255), 1, 1,
//						0, v, 0, Color.toFloatBits(0, 255, 0, 255), 0.5f, 0}); 
//				break;
//			case 3:
//				//LEVA PLOSKEV
//				tempMesh.setVertices(new float[] { 
//						0, 0, -x, Color.toFloatBits(0, 255, 0, 255), 0, 1,
//						-size/2, 0, y, Color.toFloatBits(0, 0, 255, 255), 1, 1,
//						0, v, 0, Color.toFloatBits(255, 0, 0, 255), 0.5f, 0}); 
//				break;
//			default:
//				break;
				
				
			case 0:
				//SPODNJA PLOSKEV
				tempMesh.setVertices(new float[] { 
						-size/2, 0, y, Color.toFloatBits(255, 0, 0, 255),
						size/2, 0, y, Color.toFloatBits(0, 255, 0, 255),
						0, 0, -x, Color.toFloatBits(0, 0, 255, 255) }); 
				break;
			case 1:
				//SPREDNJA PLOSKEV
				tempMesh.setVertices(new float[] { 
						-size/2, 0, y, Color.toFloatBits(255, 0, 0, 255),
						size/2, 0, y, Color.toFloatBits(0, 255, 0, 255),
						0, v, 0, Color.toFloatBits(0, 0, 255, 255) }); 
				break;
			case 2:
				//DESNA PLOSKEV
				tempMesh.setVertices(new float[] { 
						size/2, 0, y, Color.toFloatBits(0, 0, 255, 255),
						0, 0, -x, Color.toFloatBits(255, 0, 0, 255),
						0, v, 0, Color.toFloatBits(0, 255, 0, 255)}); 
				break;
			case 3:
				//LEVA PLOSKEV
				tempMesh.setVertices(new float[] { 
						0, 0, -x, Color.toFloatBits(0, 255, 0, 255),
						-size/2, 0, y, Color.toFloatBits(0, 0, 255, 255),
						0, v, 0, Color.toFloatBits(255, 0, 0, 255) }); 
				break;
			default:
				break;
			
//			case 0:
//				//SPODNJA PLOSKEV
//				tempMesh.setVertices(new float[] { 
//						-size/2, -y, y, Color.toFloatBits(255, 0, 0, 255),
//						size/2, -y, y, Color.toFloatBits(0, 255, 0, 255),
//						0, -y, -x, Color.toFloatBits(0, 0, 255, 255) }); 
//				break;
//			case 1:
//				//SPREDNJA PLOSKEV
//				tempMesh.setVertices(new float[] { 
//						-size/2, -y, y, Color.toFloatBits(255, 0, 0, 255),
//						size/2, -y, y, Color.toFloatBits(0, 255, 0, 255),
//						0, v-y, 0, Color.toFloatBits(0, 0, 255, 255) }); 
//				break;
//			case 2:
//				//DESNA PLOSKEV
//				tempMesh.setVertices(new float[] { 
//						size/2, -y, y, Color.toFloatBits(0, 0, 255, 255),
//						0, -y, -x, Color.toFloatBits(255, 0, 0, 255),
//						0, v-y, 0, Color.toFloatBits(0, 255, 0, 255)}); 
//				break;
//			case 3:
//				//LEVA PLOSKEV
//				tempMesh.setVertices(new float[] { 
//						0, -y, -x, Color.toFloatBits(0, 255, 0, 255),
//						-size/2, -y, y, Color.toFloatBits(0, 0, 255, 255),
//						0, v-y, 0, Color.toFloatBits(255, 0, 0, 255) }); 
//				break;
//			default:
//				break;
			}
			vecMesh.add(tempMesh);
		}
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}
//	public Texture[] getTexture() {
//		return texture;
//	}
//	public void setTexture(Texture[] texture) {
//		this.texture = texture;
//	}
}
