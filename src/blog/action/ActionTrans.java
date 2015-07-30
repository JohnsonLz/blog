package blog.action;

public class ActionTrans {

	public String encoding(String str) {
		String encode = "ISO-8859-1"; 
		String s = null;
		String result = null;
		
	    try {      
	    	if (str.equals(new String(str.getBytes(encode), encode)))   
	    		s = encode;         
	    	else {
	    		encode = "UTF-8";      
	    		if (str.equals(new String(str.getBytes(encode), encode)))
	    			s = encode;         	    
	    		else {
	    			encode = "GB2312";      
	    			if (str.equals(new String(str.getBytes(encode), encode)))       
	    				s = encode;       
	    			else {
	    				encode = "GBK";      
	    				if (str.equals(new String(str.getBytes(encode), encode))) 
	    				s = encode;          
	    			}
	    		}
	    	}
	    	result = new String(str.getBytes(s),"UTF-8");
	    }catch (Exception e){
	    }
	    
	    return result;
	    	    
	   }      
}
