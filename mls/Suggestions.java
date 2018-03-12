import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Suggestions
{
   static ArrayList<String> list = new ArrayList<String>();
   static TreeSet<String> treeSet = new TreeSet<String>();
   public static void main(String[] args)
   {
      String[] stopWords = {"is", "a", "can", "the",":",".","?","i"};
      String[] tokenStream = {"The", "beautiful", "girl", "from", "the", "farmers", "market", ".", "I", "like",
                              "chewing", "gum", "." };
      List<String> stopWordsList = Arrays.asList(stopWords);
      int i=0;
      ArrayList<String> tempSuggestions = new ArrayList<String>();
      ArrayList<ArrayList<String>> suggestions = new ArrayList<ArrayList<String>>();
      while(i<tokenStream.length) {
          if(stopWordsList.contains(tokenStream[i].toLowerCase())) {
              suggestions.add(tempSuggestions);
              tempSuggestions = new ArrayList<String>();
              i++;
              continue;
          }
          else {
              tempSuggestions.add(tokenStream[i]);
              i++;
          }
      }
      for(int j=0;j<suggestions.size();j++) {
          String[] sArray = suggestions.get(j).toArray(new String[0]);
          permutation(0,sArray);
      }
      System.out.println(list);
   }

   static void swap(int pos1, int pos2, String[] sArray)
   {
      String temp = sArray[pos1];
      sArray[pos1] = sArray[pos2];
      sArray[pos2] = temp;
   }

   public static void permutation(int start, String[] sArray)
   {
      if (start != 0)
      {
    	 String s = new String();
         for (int i = 0; i < start; i++) {
            s = s + sArray[i];
            if(i!=start) {
            	s = s + " ";
            }
         }
         if(!contains(s)) {
        	 list.add(s);
         }
      }

      for (int i = start; i < sArray.length; i++)
      {
         swap(start, i, sArray);
         permutation(start + 1, sArray);
         swap(start, i, sArray);
      }
   }
   
   public static boolean contains(String s) {
	   String[] sArr = s.split(" ");
	   TreeSet<String> ts = new TreeSet<String>(Arrays.asList(sArr));
	   for(String l : list) {
		   String[] tempSArr = l.split(" ");
		   TreeSet<String> tempTs = new TreeSet<String>(Arrays.asList(tempSArr));
		   if(ts.size()==tempTs.size() && ts.containsAll(tempTs)) {
			   return true;
		   }
	   }
	return false;
   }
}