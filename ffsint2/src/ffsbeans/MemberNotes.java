
package ffsbeans;

public class MemberNotes {
           private String tranId;
	   private String lidNo;
	   private String tranDate;
	   private String tranDescr;
           private String tranComment;
           private String tranUserId;
           private String dateMod;
    public MemberNotes() {
	 
	   }
     public MemberNotes(String tranId, String lidNo, String tranDate, String tranDescr, String tranComment, String tranUserId, String dateMod){
               this.tranId = tranId;
	       this.lidNo = lidNo;
	       this.tranDate= tranDate;
               this.tranDescr = tranDescr;
               this.tranComment = tranComment;
               this.tranUserId = tranUserId;
               this.dateMod = dateMod;
     }
     
    public String gettranId() {
	       return tranId;
	   }
	 
	   public void settranId(String tranId) {
	       this.tranId = tranId;
	   }
           public String getlidNo() {
	       return lidNo;
	   }
	 
	   public void setlidNo(String lidNo) {
	       this.lidNo = lidNo;
	   }
           public String gettranDate() {
	       return tranDate;
	   }
	 
	   public void settranDate(String tranDate) {
	       this.tranDate = tranDate;
	   }
           public String gettranDescr() {
	       return tranDescr;
	   }
	 
	   public void settranDescr(String tranDescr) {
	       this.tranDescr = tranDescr;
	   }
           public String gettranComment() {
	       return tranComment;
	   }
	 
	   public void settranComment(String tranComment) {
	       this.tranComment = tranComment;
	   }
           public String gettranUserId() {
	       return tranUserId;
	   }
	 
	   public void settranUserId(String tranUserId) {
	       this.tranUserId = tranUserId;
	   }
           public String getdateMod() {
	       return dateMod;
	   }
	 
	   public void setdateMod(String dateMod) {
	       this.dateMod = dateMod;
	   }
}
