package util;

public class CiGenerator {
	
	private int validation_digit(String ci){
		  int a = 0;
		  int i = 0;
		  if(ci.length() <= 6){
		    for(i = ci.length(); i < 7; i++){
		      ci = '0' + ci;
		    }
		  }
		  int[] validadores = {2,9,8,7,6,3,4};
		  for(i = 0; i < 7; i++){
			  a += (validadores[i] * Integer.parseInt(ci.charAt(i) + "")) % 10;
		  }
		  if(a%10 == 0){
		    return 0;
		  }else{
		    return 10 - a % 10;
		  }
		}

		public String random_ci(){

		  int x = (int) Math.floor(Math.random()*10000000);
		  String str_ci = Integer.toString(x);
		  if(str_ci.length() <= 6){
			    for(int i = str_ci.length(); i < 7; i++){
			      str_ci = '0' + str_ci;
			    }
			  }
		  return str_ci.substring(0,7) + validation_digit(str_ci);
		}
		
}
