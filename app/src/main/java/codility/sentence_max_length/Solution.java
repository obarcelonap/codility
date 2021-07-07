package codility.sentence_max_length;

class Solution {

	public int solution(String S) {
		if (S == null || S.trim().equals("")) {
			return 0;
		}

		int maxLength = 0;
		for (String sentence : S.split("[.?!]")) {
			int length = sentence.trim().split("\\s+").length;
			if (length > maxLength) {
				maxLength = length;
			}
		}
		return maxLength;
	}
}

