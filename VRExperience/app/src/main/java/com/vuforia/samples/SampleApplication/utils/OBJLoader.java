package com.vuforia.samples.SampleApplication.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.vecmath.Vector3f;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OBJLoader {
	public static Model loadModel(InputStream is) throws FileNotFoundException, IOException{
		//BufferedReader reader = new BufferedReader(new FileReader(f));
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		Model m = new Model();
		String line;

        List<Double> texCoords = new ArrayList<Double>();
		List<Short> vtInd = new ArrayList<>();
		while ((line = reader.readLine()) != null){
			if (line.startsWith("v ")){
				String[] tokens = line.split("[ ]+");
				double x = Double.valueOf(tokens[1]);
				double y = Double.valueOf(tokens[2]);
				double z = Double.valueOf(tokens[3]);
				m.vertices.add(x);//new Vector3f(x,y,z));
				m.vertices.add(y);
				m.vertices.add(z);
			} else if (line.startsWith("vn ")){
				String[] tokens = line.split("[ ]+");
				double x = Double.valueOf(tokens[1]);
				double y = Double.valueOf(tokens[2]);
				double z = Double.valueOf(tokens[3]);
				m.normals.add(x);//new Vector3f(x,y,z));
				m.normals.add(y);
				m.normals.add(z);
			} else if (line.startsWith("vt ")){
				String[] tokens = line.split("[ ]+");
				double x = Double.valueOf(tokens[1]);
				double y = Double.valueOf(tokens[2]);
				double z = Double.valueOf(tokens[3]);
				texCoords.add(x);//new Vector3f(x,y,z));
				texCoords.add(y);
				texCoords.add(z);
			} else if (line.startsWith("f ")){
				String[] tokens = line.split("[ ]+");
				short x1 = (short)(Short.valueOf(tokens[1].split("/")[0])-1);
				short x2 = (short)(Short.valueOf(tokens[2].split("/")[0])-1);
				short x3 = (short)(Short.valueOf(tokens[3].split("/")[0])-1);

				String[] tokens1 = line.split("[ ]+");
				short y1 = (short)(Short.valueOf(tokens1[1].split("/")[1])-1);
				short y2 = (short)(Short.valueOf(tokens1[2].split("/")[1])-1);
				short y3 = (short)(Short.valueOf(tokens1[3].split("/")[1])-1);

				m.indices.add(x1);
				m.indices.add(x2);
				m.indices.add(x3);
				vtInd.add(y1);
				vtInd.add(y2);
				vtInd.add(y3);
			}
		}

		int i = 0;
		double[] vtVec = new double[vtInd.size()];
		for (short s : vtInd){
			vtVec[m.indices.get(i++)] = texCoords.get(s);
		}
		for (double d : vtVec){
			m.texCoords.add(d);
		}

		reader.close();
		return m;
	}
}
