public class DisplayBinaryObserver extends Observer{

   public DisplayBinaryObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);     // update 
   }

   @Override
   public void update() {  
       // here will be the logic for Binary representation
       System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) ); 
   }
}