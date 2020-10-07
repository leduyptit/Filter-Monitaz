package tokenizer; 
public final class PennTokenizer {

	public static String tokenize(String str) {
		str = str.replaceAll("( \\. html)","\\.html");
		str = str.replaceAll("``", " `` ");
		str = str.replaceAll("''", "  '' ");
		str = str.replaceAll("\"", "  \" ");
		str = str.replaceAll("([?!\";#$&])", " $1 ");                
		str = str.replaceAll("\\.\\.\\.", " ... ");
		str = str.replaceAll("([^.])([.])([\\])}>\"']*)\\s*$", "$1 $2$3 ");		
		str = str.replaceAll("([\\[\\](){}<>])", " $1 ");
		str = str.replaceAll("--", " -- ");

		str = str.replaceAll("$", " ");
		str = str.replaceAll("^", " ");

		str = str.replaceAll("\"", " '' ");
		str = str.replaceAll("([^'])' ", "$1 ' ");
		str = str.replaceAll("'([sSmMdD]) ", " '$1 ");
		str = str.replaceAll("'ll ", " 'll ");
		str = str.replaceAll("'re ", " 're ");
		str = str.replaceAll("'ve ", " 've ");
		str = str.replaceAll("n't ", " n't ");
		str = str.replaceAll("'LL ", " 'LL ");
		str = str.replaceAll("'RE ", " 'RE ");
		str = str.replaceAll("'VE ", " 'VE ");
		str = str.replaceAll("N'T ", " N'T ");

		str = str.replaceAll(" ([Cc])annot ", " $1an not ");
		str = str.replaceAll(" ([Dd])'ye ", " $1' ye ");
		str = str.replaceAll(" ([Gg])imme ", " $1im me ");
		str = str.replaceAll(" ([Gg])onna ", " $1on na ");
		str = str.replaceAll(" ([Gg])otta ", " $1ot ta ");
		str = str.replaceAll(" ([Ll])emme ", " $1em me ");
		str = str.replaceAll(" ([Mm])ore'n ", " $1ore 'n ");
		str = str.replaceAll(" '([Tt])is ", " $1 is ");
		str = str.replaceAll(" '([Tt])was ", " $1 was ");
		str = str.replaceAll(" ([Ww])anna ", " $1an na ");
		str = str.replaceAll(" ([A-Z])\\. ", " $1 . ");
//	    str = str.replaceAll(",([^0-9])", ", $1");
		str = str.replaceAll("'([^'])", "' $1");   
		str = str.replaceAll("([^\\xBB])(\\xBB)", "$1 $2");					
		str = str.replaceAll("(\\u201C)([^'])", "$1 $2");    				
		str = str.replaceAll("([^'])(\\u201D)", "$1 $2");
		
    	str = str.replaceAll("\\,([^0-9])", "\\, $1"); 			                
		str = str.replaceAll("([^\\s]),([\\s])", "$1 , $2");	 					
		//str = str.replaceAll("([^\\s:/0-9])/([^\\s:/0-9])", "$1;$2"); 	
		str = str.replaceAll("([^\\s0-9]+)-"," $1 -"); 						
		str = str.replaceAll("-([^\\s0-9]+)","- $1");
		str = str.replaceAll("([^\\s]):([\\s])", "$1 : $2"); 				
		str = str.replaceAll("([^\\s]):([^0-9]+)", "$1 : $2"); 				
	    str = str.replaceAll("([^0-9]+):([^\\s])", "$1 : $2");
    	str = str.replaceAll(" -([^\\s]+)", " - $1");
    	str = str.replaceAll("|", "");
    	str = str.replaceAll("[\u2026\u201C\u201D]", "");   
    	str = str.replaceAll("([^\\p{L}0-9\\.\\,:\\-/])", " $1 "); 			
		str = str.replaceAll("[ \t]+", " ");
		str = str.replaceAll("^\\s+", "");	
		str = str.replaceAll("\\. \\.\\.", "...");
		str = str.replaceAll("hok", "không");
	//	str = str.replaceAll("\\"," \\ ");
		str = str.replaceAll("(http \\: \\/\\/)","http\\:\\/\\/");
		str = str.replaceAll(" @ ([a-zA-Z0-9]).([a-zA-Z])","@$1$2");
		//str = str.replaceAll("\\."," \\. ");
		str = str.replaceAll("(https \\: \\/\\/)","https\\:\\/\\/");
		str = str.replaceAll("(www \\.)","www\\.");
		str = str.replaceAll("( \\. com)","\\.com");
		str = str.replaceAll("( \\. vn)","\\.vn");
		str = str.replaceAll("\\/ \\.","/.");
		str = str.replaceAll("\\. \\/","./");
		str = str.replaceAll("\\."," . ");
	//	str = str.replaceAll("youtu.be //; ", "youtu.be;");
		
		str = str.replaceAll("([^http ])(html$)", "http$2");
		str=web(str);
		
		//str = str.replaceAll(" @ ([a-zA-Z0-9]\\.[a-zA-Z])","@$1");
		str = str.trim();
		return str;
	}
	public static String web(String str) {
		str = str.trim();
		String s="http";
		String k="html";
		String k2 ="ufi";
		String k3="ts";
		String k4="com";
		int n=str.indexOf(s);
		int m=str.indexOf(k);
		int m1=str.indexOf(k2);
		int m2=str.indexOf(k3);
		int m3=str.indexOf(k4);
		char [ ] ch=str.toCharArray( );
		if((n!=-1)&&(m!=-1||m2!=-1||m1!=-1||m3!=-1)){
		for(int i=n;i<=m;i++){
		if(ch[i]==' '){
			ch[i]='#';
		}			
		}
		for(int i=n;i<=m1;i++){
			if(ch[i]==' '){
				ch[i]='#';
			}			
			}
		for(int i=n;i<=m2;i++){
			if(ch[i]==' '){
				ch[i]='#';
			}}
			for(int i=n;i<=m3;i++){
				if(ch[i]==' '){
					ch[i]='#';
				}		
			}	
		String kq = new String(ch);
		kq=kq.replaceAll("#","");
		return kq;}
		else 
			return str;
	}	
}

