public class Dijkstra {

    //just for testing to see if solution works, remove later
    void testAlg(int solution[], int vert){
		System.out.println("Vertext       Distance");
		for (int i = 0; i < vert; i++){
			System.out.println(i + "             " + solution[i]);
        }
	}

    //finds the best path and checks if its already been done
	int bestDistance(int distance[], Boolean used[], int vert){
		int bestPath = Integer.MAX_VALUE;
        int bestIndex = -1;

		for (int i = 0; i < vert; i++){
			if (used[i] == false && distance[i] <= bestPath){
				bestPath = distance[i];
				bestIndex = i;
			}
        }
		return bestIndex;
	}

	void dijkstraAlg(int arr[][])
	{
		int distance[] = new int[arr.length];
		Boolean used[] = new Boolean[arr.length];

		for (int i = 0; i < arr.length; i++){
			distance[i] = Integer.MAX_VALUE;
			used[i] = false;
		}
		distance[0] = 0;

		for (int j = 0; j < arr.length - 1; j++){
			int best = bestDistance(distance, used, arr.length);
			used[best] = true;

			for (int k = 0; k < arr.length; k++){
				if (!used[k] && arr[best][k] != 0 && distance[best] != Integer.MAX_VALUE &&
                     distance[best] + arr[best][k] < distance[k]){
					distance[k] = distance[best] + arr[best][k];
                }
            }
		}
        //only use this line when directly testing this file to see the result
		//testAlg(distance, arr.length);
	}
}
