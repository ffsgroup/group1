package ffsbeans;
import java.io.File;
public class TaskImage {
	 
	   private String Tranid;
	   private String User;
	   private String DateUp;
	   private String ImageDesc;
           private String Taskid;
           private String ImageType;
           private File Imag1;
	   public TaskImage() {
	 
	   }
	 
	   public TaskImage(String Tranid, String User, String DateUp, String ImageDesc, String Taskid, String ImageType, File Imag1) {
	       this.Tranid = Tranid;
	       this.User = User;
	       this.DateUp = DateUp;
               this.ImageDesc = ImageDesc;
               this.Taskid = Taskid;
               this.ImageType = ImageType;
               this.Imag1 = Imag1;
	   }
	 
	   public String getTranid() {
	       return Tranid;
	   }
	 
	   public void setTranid(String Tranid) {
	       this.Tranid = Tranid;
	   }
	 
	   public String getUser() {
	       return User;
	   }
	 
	   public void setUser(String User) {
	       this.User = User;
	   }
	 
	   public String getDateUp() {
	       return DateUp;
	   }
	 
	   public void setDateUp(String DateUp) {
	       this.DateUp = DateUp;
	   }
           
	   public String getImageDesc() {
	       return ImageDesc;
	   }
	 
	   public void setImageDesc(String ImageDesc) {
	       this.ImageDesc = ImageDesc;
	   }	 
	  
           public String getTaskid() {
	       return Taskid;
	   }
	 
	   public void setTaskid(String Taskid) {
	       this.Taskid = Taskid;
	   }
           
           public String getImageType() {
	       return ImageType;
	   }
	 
	   public void setImageType(String ImageType) {
	       this.ImageType = ImageType;
	   }
           
           public File getImag1() {
	       return Imag1;
	   }
	 
	   public void setImag1(File Imag1) {
	       this.Imag1 = Imag1;
	   }
           
	}