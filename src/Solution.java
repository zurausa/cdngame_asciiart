import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        List<Integer> tList = new ArrayList<>();
        in.nextLine();
        String tmp = in.nextLine();
        tList = nthAlpa(tmp);
        Pattern p = Pattern.compile("[\\s\\S]{1,"+ L +"}");
        Matcher m;
        String[][] matList = new String[H][27];
        for (int i = 0; i < H; i++) {
        	int j = 0;
        	m = p.matcher(in.nextLine());
        	while(m.find()){
        		matList[i][j] = m.group();
        		j++;
        	}
        }
        for(int i=0;i<H;i++){
        	StringBuilder sb = new StringBuilder();
        	for(int j=0;j<tList.size();j++){
        		sb.append(matList[i][tList.get(j)]);
        	}
            System.out.println(sb.toString());
        }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
    }

    public static List<Integer> nthAlpa(String T){
    	char a = "A".charAt(0);
    	String target = T.toUpperCase();
    	List<Integer> retList = new ArrayList<>();
		int tmp;
    	for(int i=0;i<T.length();i++){
    		tmp = target.charAt(i)-a;
    		if(tmp >= 0 && tmp <= 25) retList.add(tmp);
    		else retList.add(26);
    	}
    	return retList;
    }
}