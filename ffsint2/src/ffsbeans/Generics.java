package ffsbeans;
public class Generics {
	 
	   private String GenGroupId;
	   private String GenericId;
	   private String GenericDescriptionAfr;
	   private String GenericDescriptionEng;
	   public Generics() {
	 
	   }
	 
	   public Generics(String GenGroupId, String GenericId, String GenericDescriptionAfr, String GenericDescriptionEng) {
	       this.GenGroupId = GenGroupId;
	       this.GenericId = GenericId;
	       this.GenericDescriptionAfr = GenericDescriptionAfr;
               this.GenericDescriptionEng = GenericDescriptionEng;
	   }
	 
	   public String getGenGroupId() {
	       return GenGroupId;
	   }
	 
	   public void setGenGroupId(String GenGroupId) {
	       this.GenGroupId = GenGroupId;
	   }
	 
	   public String getGenericId() {
	       return GenericId;
	   }
	 
	   public void setGenericId(String GenericId) {
	       this.GenericId = GenericId;
	   }
	 
	   public String getGenericDescriptionAfr() {
	       return GenericDescriptionAfr;
	   }
	 
	   public void setGenericDescriptionAfr(String GenericDescriptionAfr) {
	       this.GenericDescriptionAfr = GenericDescriptionAfr;
	   }
	   public String getGenericDescriptionEng() {
	       return GenericDescriptionEng;
	   }
	 
	   public void setGenericDescriptionEng(String GenericDescriptionEng) {
	       this.GenericDescriptionEng = GenericDescriptionEng;
	   }	 
	  
           
	}