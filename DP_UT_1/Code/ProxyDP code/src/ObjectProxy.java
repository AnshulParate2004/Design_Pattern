public class ObjectProxy implements ObjectX
{
    ObjectX ro=new RealObject();
    public void doSomething() 
    {
        //Perform additional logic and security
        //Even we can block the operation execution
        System.out.println("Proxy object Delegating work to real object");
        ro.doSomething();
        //Perform additional logic     
    }
}


//public class ObjectProxy implements ObjectX
//{
//    ObjectX ro=null;
//    public void doSomething() 
//    {
//        //Perform additional logic and security
//        //Even we can block the operation execution
//        if(ro==null)
//            ro=new RealObject();
//        System.out.println("Proxy object Delegating work to real object");
//        ro.doSomething();
//        //Perform additional logic    
//        ro=null;  // ObjectX no longer referenced
//        System.gc(); // Ensures FULL GC before application exits. Garbage collector takes care of freeing memory
//        
//         
//    }
//}