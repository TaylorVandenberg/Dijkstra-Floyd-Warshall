
public class floyd {
	void floyds(int mat[][]) {
		int[][] result= new int[mat.length][mat.length];
		
		for(int i = 0;i<mat.length;i++) {
			for(int j = 0; j<mat.length;j++) {
				result[i][j]=mat[i][j];
			}
		}//END: double for

		for(int k = 0; k<mat.length;k++) {
			for(int u=0;u<mat.length;u++) {
				for(int v=0;v<mat.length;v++) {
					result[u][v]=Math.min(result[u][v], result[u][k] +result[k][v]);
				}
			}
		}//END: triple for

		//print(result);
	}//end method
	void print(int res[][]) {
		for(int i = 0; i<res.length;i++) {
			for(int j=0;j<res.length;j++) {
				if(res[i][j]==999999) {
					System.out.print("999 ");
				}else if(res[i][j]<10) {
					System.out.print(""+res[i][j]+"     ");
				}else if(res[i][j]<100) {
					System.out.print(""+res[i][j]+"   ");
				}else {
					System.out.print(""+res[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	public static void printArr(int arr[][]){
		for(int i=0 ;i<arr .length; i++) {
			for(int j =0 ;j<arr.length; j++) {
				System.out.printf("    %,d    ",arr[i][j]);
			}
			System.out.println();
		}
	}
}//end class
