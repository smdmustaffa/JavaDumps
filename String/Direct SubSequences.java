Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.


public int numberSubSequences(String S,String T)
{
  int[][] table = new int[S.length() + 1][T.length() + 1];

  for(int i =0;i<S.length();i++)
    table[i][0] = 1;    

  for(i = 1;i<S.length();i++)
  {
    for(j=1;j<T.length();j++) 
    {
      if(S.charAt(i)==T.charAt(j))
        table[i][j] += table[i-1][j-1] + table[i-1][j];
      else
        table[i][j] += table[i-1][j];
    
    }
  }
  return table[S.length()][T.length()];
}
