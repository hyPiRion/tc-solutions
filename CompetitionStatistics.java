public class CompetitionStatistics {

	public int consecutiveGrowth(int[] ratingChanges) {
		int posC = 0, max = 0;
		for (int r : ratingChanges)
			if (r > 0)
				max = Math.max(++posC, max);
			else
				posC = 0;
		return max;
	}

}
