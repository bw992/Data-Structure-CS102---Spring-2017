
public class palindrone {
		public static boolean is_pal(String x){
			if (x.length()==0 ||x.length()==1)
				return true; 
			if (x.charAt(0) == x.charAt(x.length()-1)){
				is_pal(x.substring(1, -1));}
			return true;
				
			}
				
			}
		