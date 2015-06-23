package mastermind;

public class utils {
	public static String rjust(String s, int len){
		int space = len+1-s.length(), i;
    	for(i=0; space>i; i++){ //.rjust(6)
    		s = " " + s;
    	}
    	return s;
	}
}
