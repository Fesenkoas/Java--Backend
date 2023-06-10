package telran.matrix.tools;

public class Matrix {
	public static int sum(int[][] matrix) {
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				res += matrix[i][j];
			}
		}
		return res;
	}

	public static int[][] transp(int[][] matrix) {
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			res=0;
			for (int j = 0; j < matrix[i].length; j++) {
				res++;
			}
		}
		int[][] arr = new int[res][];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new int[matrix.length];
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = matrix[j][i];
			}
		}
		return arr;
	}

	public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
		
		int len1 = matrix1.length;
		int len2 = matrix2[0].length;
		
		int[][] arr = new int[len1][len2];

		int res = 0;
		for(int x = 0;x < matrix1.length;x++) {
			for (int i = 0; i < matrix2[0].length; i++) {
				for (int j = 0; j < matrix2.length; j++) {
					res += matrix1[x][j] * matrix2[j][i];
				}
				arr[x][i] = res;
				res = 0;
			}
		}
		return arr;
	}
}
