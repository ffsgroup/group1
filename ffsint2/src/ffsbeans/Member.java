package ffsbeans;
import java.util.Date;
public class Member {
	 
	   private String tranid;
	   private String lidno;
	   private String sur;
	   private String ini;
           private String shortname;
           private String orgid;
           private String lidtipe;
           private String gebdat;
           private String aanstdat;
           private String troustat;
           private String pobox;
           private String street;
           private String city;
           private String zip;
           private String physline1;
           private String physline2;
           private String physline3;
           private String physcode;
           private String idno;
           private String sex;
           private String taal;
           private String verwlidno;
           private String telh;
           private String telw;
           private String newprelidno;
           private String eisdat;
           private String krediet;
           private String bettot;
           private String joindat;           
           private String status;
	   public Member() {
	 
	   }
	 
	   public Member(String tranid, String lidno, String sur, String ini, String shortname, String orgid, String lidtipe, String gebdat, String aanstdat, String troustat, String pobox, String street, String city, String zip, String physline1, String physline2, String physline3, String physcode, String idno, String sex, String taal, String verwlidno, String telh, String telw, String newprelidno, String eisdat, String krediet, String bettot, String joindat, String status) {
	       this.tranid = tranid;
	       this.lidno = lidno;
	       this.sur= sur;
               this.ini = ini;
               this.shortname = shortname;
               this.orgid = orgid;
               this.lidtipe = lidtipe;
               this.gebdat = gebdat;
               this.aanstdat = aanstdat;
               this.troustat = troustat;
               this.pobox = pobox;
               this.street = street;
               this.city = city;
               this.zip = zip;
               this.physline1 = physline1;
               this.physline2 = physline2;
               this.physline3 = physline3;
               this.physcode = physcode;
               this.idno = idno;
               this.sex = sex;
               this.taal = taal;
               this.verwlidno = verwlidno;
               this.telh = telh;
               this.telw = telw;
               this.newprelidno = newprelidno;
               this.eisdat = eisdat;
               this.krediet = krediet;
               this.bettot = bettot;
               this.joindat = joindat;              
               this.status = status;
	   }
	 
	   public String getTranid() {
	       return tranid;
	   }
	 
	   public void setTranid(String tranid) {
	       this.tranid = tranid;
	   }
	 
	   public String getlidno() {
	       return lidno;
	   }
	 
	   public void setlidno(String lidno) {
	       this.lidno = lidno;
	   }
	 
	   public String getsur() {
	       return sur;
	   }
	 
	   public void setsur(String sur) {
	       this.sur = sur;
	   }
	   public String getini() {
	       return ini;
	   }
	 
	   public void setini(String ini) {
	       this.ini = ini;
	   }	 
	   public String getshortname() {
	       return shortname;
	   }
	 
	   public void setshortname(String shortname) {
	       this.shortname = shortname;
	   }           
           
           public String getorgid() {
	       return orgid;
	   }
	 
	   public void setorgid(String orgid) {
	       this.orgid = orgid;
	   }           

           public String getlidtipe() {
	       return lidtipe;
	   }
	 
	   public void setlidtipe(String lidtipe) {
	       this.lidtipe = lidtipe;
	   }    

           public String getgebdat() {
	       return gebdat;
	   }
	 
	   public void setgebdat(String gebdat) {
	       this.gebdat = gebdat;
	   }               
           
           public String getaanstdat() {
	       return aanstdat;
	   }
	 
	   public void setaanstdat(String aanstdat) {
	       this.aanstdat = aanstdat;
	   }               
           
           public String gettroustat() {
	       return troustat;
	   }
	 
	   public void settroustat(String troustat) {
	       this.troustat = troustat;
	   }               
           
           public String getpobox() {
	       return pobox;
	   }
	 
	   public void setpobox(String pobox) {
	       this.pobox = pobox;
	   }               
           
           public String getstreet() {
	       return street;
	   }
	 
	   public void setstreet(String street) {
	       this.street = street;
	   }               
           
           public String getcity() {
	       return city;
	   }
	 
	   public void setcity(String city) {
	       this.city = city;
	   }               
           
           public String getzip() {
	       return zip;
	   }
	 
	   public void setzip(String zip) {
	       this.zip = zip;
	   }               
           
           public String gephysline1() {
	       return physline1;
	   }
	 
	   public void setphysline1(String physline1) {
	       this.physline1 = physline1;
	   }               
           
           public String physline2() {
	       return physline2;
	   }
	 
	   public void setphysline2(String physline2) {
	       this.physline2 = physline2;
	   }               
           
           public String getphysline3() {
	       return physline3;
	   }
	 
	   public void setphysline3(String physline3) {
	       this.physline3 = physline3;
	   }               
           
           public String getphyscode() {
	       return physcode;
	   }
	 
	   public void setphyscode(String physcode) {
	       this.physcode = physcode;
	   }               
           
           public String getidno() {
	       return idno;
	   }
	 
	   public void setidno(String idno) {
	       this.idno = idno;
	   }               
           
           public String getsex() {
	       return sex;
	   }
	 
	   public void setsex(String sex) {
	       this.sex = sex;
	   }               
           
           public String gettaal() {
	       return taal;
	   }
	 
	   public void settaal(String taal) {
	       this.taal = taal;
	   }               
           
           public String getverwlidno() {
	       return verwlidno;
           }
	 
	   public void setverwlidno(String verwlidno) {
	       this.verwlidno = verwlidno;
	   }               
           
           public String gettelh() {
	       return telh;
	   }
	 
	   public void settelh(String telh) {
	       this.telh = telh;
	   }               
           
           public String gettelw() {
	       return telw;
	   }
	 
	   public void settelw(String telw) {
	       this.telw = telw;
	   }               
           
           public String getnewprelidno() {
	       return newprelidno;
	   }
	 
	   public void setnewprelidno(String newprelidno) {
	       this.newprelidno = newprelidno;
	   }               
           
           public String geteisdat() {
	       return eisdat;
	   }
	 
	   public void seteisdat(String eisdat) {
	       this.eisdat = eisdat;
	   }               
           
           public String getkrediet() {
	       return krediet;
	   }
	 
	   public void setkrediet(String krediet) {
	       this.krediet= krediet;
	   }               
           
           public String getbettot() {
	       return bettot;
	   }
	 
	   public void setbettot(String bettot) {
	       this.bettot = bettot;
	   }               
           
           public String getjoindat() {
	       return joindat;
	   }
	 
	   public void setjoindat(String joindat) {
	       this.joindat = joindat;
	   }                
           
           public String getstatus() {
	       return status;
	   }
	 
	   public void setstatus(String status) {
	       this.status = status;
	   }             
           
	}