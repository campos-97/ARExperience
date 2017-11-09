package com.vuforia.samples.SampleApplication.utils;

import android.util.Log;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Model extends  MeshObject{
	public List <Double> vertices = new ArrayList<Double>();
	public List <Double> normals = new ArrayList<Double>();
    public List<Double> texCoords = new ArrayList<Double>();
    public List<Short> indices = new ArrayList<Short>();

    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    private Buffer mIndBuff;

    private int indicesNumber = 0;
    private int verticesNumber = 0;

    public Model(){}
	public void load(){
        mVertBuff = fillBuffer(toDoubleArray(vertices));
        verticesNumber = toDoubleArray(vertices).length / 3;

        mTexCoordBuff = fillBuffer(toDoubleArray(texCoords));

        mNormBuff = fillBuffer(toDoubleArray(normals));

        mIndBuff = fillBuffer(toShortArray(indices));
        indicesNumber = toShortArray(indices).length;

        Log.d("Model",indices.toString());
        Log.d("Model",vertices.toString());
        Log.d("Model",normals.toString());
        Log.d("Model",texCoords.toString());
	}

    public float[] toFloatArray(List<Float> list){
        float[] floatArray = new float[list.size()];
        int i = 0;
        for (Float f : list) {
            floatArray[i++] = (f != null ? f : Float.NaN); // Or whatever default you want.
        }
        return floatArray;
    }

    public double[] toDoubleArray (List<Double> list){
        double [] doubleArray = new double[list.size()];
        int i = 0;
        for (Double f : list) {
            doubleArray[i++] = (f != null ? f : Double.NaN); // Or whatever default you want.
        }
        return doubleArray;
    }

    public short[] toShortArray (List<Short> list){
        short [] shortArray = new short[list.size()];
        int i = 0;
        for (Short f : list) {
            shortArray[i++] = (f != null ? f : Short.valueOf(f)); // Or whatever default you want.
        }
        return shortArray;
    }

    public int getNumObjectIndex()
    {
        return indicesNumber;
    }

    @Override
    public int getNumObjectVertex()
    {
        return verticesNumber;
    }


    @Override
    public Buffer getBuffer(BUFFER_TYPE bufferType)
    {
        Buffer result = null;
        switch (bufferType)
        {
            case BUFFER_TYPE_VERTEX:
                result = mVertBuff;
                break;
            case BUFFER_TYPE_TEXTURE_COORD:
                result = mTexCoordBuff;
                break;
            case BUFFER_TYPE_NORMALS:
                result = mNormBuff;
                break;
            case BUFFER_TYPE_INDICES:
                result = mIndBuff;
            default:
                break;

        }

        return result;
    }
}
