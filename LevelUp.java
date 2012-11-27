public class LevelUp {

	public int toNextLevel(int[] expNeeded, int received) {
		for (int exp : expNeeded)
			if (received < exp)
				return exp - received;
		return 0;
	}

}
