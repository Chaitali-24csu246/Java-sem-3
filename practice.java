class practice{
    @SuppressWarnings("empty-statement")
    
    public static void main(String args[]){
        //arrays
        int []arr = new int[5];
        //we can also do 
        int[] arr1 = {1,2,3};
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        arr[3]=4;
        arr[4]=5;
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");   
        }    
        System.out.println("\nLength of arr1: " + arr1.length);
        /*int[] marks={};
        marks[0]=1;
        System.out.println(marks[0]);*/
        int a=7;
        int arr2[]=new int[a];
        for(int each:arr){
            System.out.print(each+" ");//for each loop
        }
        int arr2d[][]=new int[3][];//creating column required as they dont exist
        arr2d[0]= new int[2];
        arr2d[1]= new int[]{1,2,3,4,5,6};
        arr2d[2]=new int[3];
        long marks2[];                     // declare 1D array
        long[][] arrnew = new long[3][];   // 2D array with 3 rows
        long[][] marks = new long[20][];   // 2D array with 20 rows
        marks2 = new long[30];             // allocate 30 elements to marks2
        System.out.println(marks.length);    // Number of arrays (rows) in 2D array
        System.out.println(marks2.length);   // Number of elements in 1D array
        
        @SuppressWarnings("unused")
        int[] A;
        A=new int[3];
    }
    }






    /*System.out.print("hello"+"hello");//cursor not on next line
        System.out.println("Hello");//cursor on next line
        System.out.println("bye");
        Scanner scanner=new Scanner(System.in);//scanner object creation
        System.out.print("name: ");
        String name=scanner.nextLine();
        String city=scanner.next();
        int age=scanner.nextInt();
        float gpa=scanner.nextFloat();
        System.out.println("name: "+name);
        System.out.println("city: "+city);   
        System.out.println("age: "+age);
        System.out.println("gpa: "+gpa);
        scanner.close();     //not necessary but preferred              */
        /*boolean a=true;     
        long b=12L;
        long c=9;
        System.out.println(((Object)b).getClass().getName());
        System.out.println(((Object)c).getClass().getName());*/
        /*double a=4.5, b=1.2, c=0.9;
        System.out.println((int)a+" "+(int)b+" "+(int)c);
        byte d=12;
        d*=2;
        System.out.println(d);*/