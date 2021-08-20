class EmployeeData
{
   private int ID;
   private String Name;
   private int Age;
   public EmployeeData()
   {
       ID = 100;
       Name = "New Employee";
       Age = 18;
   }
   public EmployeeData(int num1, String str, int num2)
   {
       ID = num1;
       Name = str;
       Age = num2;
   }
   public int ID() {
       return ID;
   }

   public String Name() {
       return Name;
   }

   public int Age() {
       return Age;
   }

   public static void main(String[] args)
   {
       EmployeeData myobj = new EmployeeData();
       System.out.println("EMPLOYEE Name is: " + myobj.Name());
       System.out.println("EMPLOYEE Age is: " + myobj.Age());
       System.out.println("EMPLOYEE ID is: " + myobj.ID());
       EmployeeData myobj2 = new EmployeeData(555, "Shivam Kumar Garg", 25);
       System.out.println("EMPLOYEE Name is: " + myobj2.Name());
       System.out.println("EMPLOYEE Age is: " + myobj2.Age());
       System.out.println("EMPLOYEE ID is: " + myobj2.ID()); 
  }
}