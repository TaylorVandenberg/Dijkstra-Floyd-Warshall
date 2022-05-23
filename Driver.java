//Written by Taylor Vandenberg 013629720
//& Anthony Spencer

import java.util.Random;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		floyd fw = new floyd();
		Dijkstra d = new Dijkstra();
		int[][] matrix;
		long[][] results= new long[10][5];
		long startTime;
		long endTime;
		long executionTime;
		int count=0;
		for(int i =200;i<=2000;i+=200) {
			matrix = generateArray(i,5);
			results[count][0]=i;
			
			
			startTime = System.nanoTime();
			fw.floyds(matrix);
			endTime = System.nanoTime();
			executionTime = endTime - startTime;
			
			results[count][1]=executionTime;
			
			startTime = System.nanoTime();
			//change to distra
			d.dijkstraAlg(matrix);
			endTime = System.nanoTime();
			executionTime = endTime - startTime;
			
			results[count][2]=executionTime;
			
			//change to highly conected matrix
			matrix = generateArray(i,70);
			
			startTime = System.nanoTime();
			fw.floyds(matrix);
			endTime = System.nanoTime();
			executionTime = endTime - startTime;
			
			results[count][3]=executionTime;
			
			startTime = System.nanoTime();
			//change to distra
			d.dijkstraAlg(matrix);
			endTime = System.nanoTime();
			executionTime = endTime - startTime;
			
			results[count][4]=executionTime;
			
			System.out.println("done: "+count);
			count++;
			
			
		}
		for(int i = 0;i<results.length;i++) {
			System.out.println("For n = "+results[i][0]+" sparce: floyds = "+results[i][1] + " distra = "+results[i][2] +
					                      " dense: floyds = "+results[i][3] + " distra = "+results[i][4]);
		}
		
		


		
		
		
		System.out.println("done");
	}
	
	public static void printArr(int arr[][]){
		for(int i=0;i<arr .length;i++) {
			for(int j =0;j<arr.length;j++) {
				System.out.printf("    %,d    ",arr[i][j]);
			}
			System.out.println();
		}
	}
	public static int[][] generateArray(int n,int thresh){
		int result[][] = new int[n][n];
	    int min = 1;
	    int max = 100;
	    int rand;
		Random random = new Random();
		for(int i=0;i<result.length;i++) {
			for(int j =0;j<result.length;j++) {
				rand = random.nextInt(max - min) + min;
				if(rand < thresh) {
					rand = random.nextInt(max - min) + min;
					result[i][j]=rand;
				}else {
					result[i][j]=999999;
				}
			}
		}
		for(int i=0;i<result.length;i++) {
			result[i][i]=0;
		}
		return result;
	}
	public  static void formatArrayDijkstra(int arr[][]){
		for(int i=0;i<arr.length;i++) {
			for(int j =0;j<arr.length;j++) {
				if(arr[i][j]==999999) {
					arr[i][j]=0;
				}
			}
		}

	}

}
