import java.util.Arrays;
public class l05{
    static boolean[] row;
    static boolean[] col;
    static boolean[] diagonal;
    static boolean[] antidiagonal;

    // public static int nqueencombination(int n, int m,int idx, int tqe, String ans){
    //     if(tqe == 0){
    //         System.out.println(ans);
    //         return 1;
    //     }
    //     int count = 0;
    //     for(int i = idx; i<n*m;i++){
    //         int r = i/m;
    //         int c = i%m; 
    //         if(!row[r] && !col[c] &&!diagonal[r+c] && !antidiagonal[r-c +m-1]){
    //             row[r] = col[c] = diagonal[r+c] = antidiagonal[r-c +m-1] = true;
    //             count += nqueencombination(n,m,i+1,tqe-1,ans + "(" + r + ", " + c + ") ");
    //             row[r] = col[c] = diagonal[r+c] = antidiagonal[r-c +m-1] = false;
    //         }
    //     }
    //     return count;
    // }

    // ===================== opti ===========================================

    // what we are doing here is making our for loop run only on coloumn mean m times not n*m time which work on all the cells 
    // so its clear that if theres a queen on the row then we can not place another queen so we will leave the entire row 
    // and doest even need to use boolean for it bcoz 
    
    
    // public static int nqueencombination(int floor, int tqe,int m, String ans){
    //     if(tqe == 0){
    //         //System.out.println(ans);
    //         return 1;
    //     }
    //     int count = 0;
    //     for(int room = 0; room<m;room++){          // row == floor and column == room so 1 queen on  1 floor and then moving on to another so it wont repeat
    //         int r = floor;
    //         int c = room; 
    //         if(!col[c] &&!diagonal[r+c] && !antidiagonal[r-c +m-1]){
    //             col[c] = diagonal[r+c] = antidiagonal[r-c +m-1] = true;
    //             count += nqueencombination(floor+1,tqe-1,m,ans + "(" + r + ", " + c + ") ");
    //             col[c] = diagonal[r+c] = antidiagonal[r-c +m-1] = false;
    //         }
    //     }
    //     return count;
    // }
    
    // public int totalNQueens(int n) {
    //     int m = n,q=n;
    //             row  = new boolean[n];
    //     col = new boolean[m];
    //     diagonal = new boolean[n+m-1];
    //     antidiagonal = new boolean[n+m-1];
    //     return nqueencombination(0,q,m,"");
    // }

    // ============================== Cryptarithmetic Puzzles================================================
    // what we are doing is making an array which contains all the value of character on the ascii value index of character A = 65 example
    //and giving them value between 0 to 9
    // in starting we make i string from all the characters of s1, s2, s3-> str strand giving them all posible value btw 0 to 9
    // toh hmare pass jb value bhr gyi str ki toh s1+s2 = s3 jo h usse print krva liya 
    static String s1 = "send";
    static String s2 = "more";
    static String s3 = "money";
    static boolean[] usednumber = new boolean[10];
    static int[] mapping = new int[128];

    public static int convertStringToNumber(String str){
        int ans=0;
        for(int i=0;i<str.length();i++){
            int num = mapping[str.charAt(i)];
            ans = ans*10 + num;
        }
        return ans;
    }

    public static int crypto(String str, int idx){
        if(str.length()==idx){
            if(mapping[s3.charAt(0)] == 0 || mapping[s2.charAt(0)] == 0 || mapping[s1.charAt(0)] == 0)
                return 0;
            int x = convertStringToNumber(s1);
            int y = convertStringToNumber(s2);
            int z = convertStringToNumber(s3);
            if(x+y==z){
                StringBuilder sb = new StringBuilder();
                for(int i = 'a'; i<'z';i++){
                    if(mapping[i]>=0)
                        sb.append((char)i + "=" +mapping[i]+ " ");
                }
                System.out.println(sb.toString());
                return 1;
            }
            return 0;
        }
        int count = 0;
        
        char ch = str.charAt(idx);
        for(int i=0;i<=9;i++){
            if(!usednumber[i]){
                usednumber[i] = true;
                mapping[ch] = i;
                count += crypto(str,idx+1);
                usednumber[i] = false;
                //mapping[ch] = -1;
            }
        }
        return count;
    }

    public static void crypto(){
        String str = s1+s2+s3;
        int[] freq = new int[26];
        for(int i = 0;i<str.length();i++){
            freq[str.charAt(i) - 'a']++;
        }
        str = "";
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                str += (char)('a'+i);
            }
        }
        Arrays.fill(mapping, -1);

        System.out.println(crypto(str, 0));

    }
    public static void main(String[] args){
        crypto();
    }

    //======================== word break =========================================
    	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for(int i = 0  ; i  < n; i++){
			dict.add(scn.next());
		}
		String sentence = scn.next();
		wordBreak(sentence,"", dict);
	}

	public static int wordBreak(String str, int idx, String ans, int len, HashSet<String> dict){
		// write your code here
		if(idx >= str.length()){
		    System.out.println(ans);
		    return 1;
		}
		int count = 0;
		for(int i=idx;i<=str.length();i++){
		    String word = str.substring(idx,i);
		    if(word.length()>len)
		        break;
		    if(dict.contains(word)){
		        count += wordBreak(str,i,ans+word+ " ",len,dict);
		    }
		}
		return count;
	}
	public static void wordBreak(String str, String ans, HashSet<String> dict){
	    int len = 0;
	    for(String s : dict){
	        len = Math.max(len,s.length());
	    }
	    wordBreak(str,0,ans,len,dict);
	}
		
}