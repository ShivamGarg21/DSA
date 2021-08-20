class Outer
{
        public void display()
        {
            Inner aa = new Inner();
            aa.show();
            System.out.println("Outer Loop");
        }
        class Inner
        {       
            public void show()
            {
                    System.out.println("Inner Loop");
            }
        }
}
public class Nested_Class
{
        public static void main(String[]args)
        {
            Outer bb=new Outer();
            bb.display();
        }
}