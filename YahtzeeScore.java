public class YahtzeeScore {

	public int maxPoints(int[] toss) {
		int max = -1;
		for (int i = 1; i < 7; i++){
			int c = 0;
			for (int t : toss)
				if (i == t)
					c+=i;
			if (max < c)
				max = c;
		}
		return max;
	}

}
