public class client{
    public static void main(String[] args)throws Exception {
         dynamicstack st = new dynamicstack(10);
         for(int i=1;i<15;i++){
             st.push(i*10);
         }
         while(st.size()!=0){
             System.out.println(st.pop());
         }
    }
}