package com.vuforia.samples.SampleApplication.utils;

import javax.vecmath.Vector3f;
public class Face {
	public Vector3f vertex = new Vector3f();// Three indices, not vertices.
	public Vector3f normal = new Vector3f();
	public Face(Vector3f vertex, Vector3f normal){
		this.vertex = vertex;
		this.normal = normal;
	}
}
