
package Game.Allgemein;

import Exceptions.MatrixException;

public class Matrix {
	
	private String exceptionMessage= "The Matrix has no Field with this coordinates";
	private int width;
	private int height;
	private Object[][] matrix;
	public Matrix(int width, int height ) {
		this.height=height;
		this.width= width;
		matrix = new Object[width][height];
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	
	public Object getElementFromMarix(int width, int height) throws MatrixException {
		try {
			return matrix[width][height];
		}catch (Exception e) {
			// TODO: handle exception
			throw new MatrixException(exceptionMessage);
		}
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	public Object[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(Object[][] matrix) {
		this.matrix = matrix;
	}
	
	public void setElementToMatrix(int width, int height, Object elem) throws MatrixException {
		try {
			matrix[width][height]=elem;
		}catch (Exception e) {
			// TODO: handle exception
			throw new MatrixException(exceptionMessage);
		}
	}
	
	@Override
	public String toString() {
		String result="";
		for (int i=0; i< matrix.length;i++) {
			for(int j=0; j<matrix[i].length;j++) {
				result+= matrix[i][j].toString()+" / ";
			}
			result+="\n";
		}
		return result;
	}
	

}
