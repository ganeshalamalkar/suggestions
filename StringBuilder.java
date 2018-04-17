

package com.marketlogic;
import java.util.ArrayList;
import java.util.Array;
import java.util.Iterator;
import java.util.regex.Pattern;

public class StringBuilder {

	static String STOP_WORDS[] = {"is", "a", "can", "the"};
	static String inputString= "The beautiful girl from the farmers market. I like chewing gums";
	static String punctuationMarks[] = {".", "\\?"};
	public static void main(String args[]){
		
		StringBuilder stringBuilder = new StringBuilder();
		
		String inputStringArr[]= inputString.split(" ");
		ArrayList<String> inputStrinList = new ArrayList<String>(Arrays.asList(inputStringArr));
		ArrayList<String> stopTockenList = new ArrayList<String>(Arrays.asList(STOP_WORDS));
		
		ArrayList<String> finalSplitedList = new ArrayList<String>();
		
		ArrayList<String> listAfterWord = stringBuilder.splitWithWorld(inputStrinList, stopTockenList);
		Iterator< String> iteratorFirst =  listAfterWord.iterator();
		while(iteratorFirst.hasNext()){
			finalSplitedList.addAll((stringBuilder.splitPunctuationMarks(punctuationMarks, iteratorFirst.next())));
		}		
//		System.out.println(finalSplitedList);
		Iterator<String> itr1 = finalSplitedList.iterator();
		while(itr1.hasNext()){
			String print1 = itr1.next();
			String printarr[] = print1.split(" ");	
			ArrayList<String> inputList11 = new ArrayList<String>(Arrays.asList(printarr));
			stringBuilder.printString( inputList11);
			while(inputList11.size()>1){
			inputList11.remove(0);
			stringBuilder.printString( inputList11);
			}
		}
		
	}
private void printString(ArrayList<String> printarr){
        int noOfRows = printarr.size();
 
        //Initializing rowCount with 1
 
        int rowCount = 1;
 
        //Implementing the logic
 
        for (int i = noOfRows; i > 0; i--)
        {
 
        	
            for (int j = 1; j <= rowCount; j++)
            {
                System.out.print(printarr.get(j-1)+" ");
                
            }
            System.out.println();
            //Incrementing the rowCount
 
            rowCount++;
        }
    }
    
	private ArrayList<String> splitWithWorld(ArrayList<String> inputList, ArrayList<String> stopTocken ){
		ArrayList<String> listString = new ArrayList<String>();
		Iterator< String> itr =  inputList.iterator();
		StringBuffer buff= new StringBuffer();
		while(itr.hasNext()){
			String singleStr = itr.next();
			singleStr= singleStr.trim();
			if( stopTocken.contains(singleStr.toLowerCase())||
					singleStr.length()==1 ||
					!itr.hasNext()){
				if(buff.toString().trim().length()>1)
					listString.add(buff.toString().trim());
				buff.delete(0, buff.length());
			}else {
				buff.append(" "+singleStr);
			}
		}		
			System.out.println(listString);
			return listString;
		
	}


private ArrayList<String> splitPunctuationMarks(String punctuationMarks[], String orginal ){
		String[] sep_list =punctuationMarks;
		StringBuffer regexp = new StringBuffer("");
		regexp.append("[");
		for(String s : sep_list) {
		    regexp.append("[");
		    Pattern pattern1 = Pattern.compile(s, Pattern.CASE_INSENSITIVE);
		    regexp.append(pattern1);
		    regexp.append("]");
		}
		regexp.append("]");
		 System.out.println(regexp);
		String[] a = orginal.split(regexp.toString());
		ArrayList<String> result = new ArrayList<String>(Arrays.asList(a));
		System.out.println(result);
		return result;
	}
  
 }
