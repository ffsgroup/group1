
package ffsbeans;
public class MemberDepen {

    private String tranid;
    private String lidno;
    private String ini;
    private String sur;
    private String gebdat;
    private String sex;
    private String verwskap;
    private String premie;
    private String status;
    private String statusdate;

    public MemberDepen() {

    }

    public MemberDepen(String tranid, String lidno, String ini, String sur, String gebdat, String sex, String verwskap, String premie, String status, String statusdate) {
        this.tranid = tranid;
        this.lidno = lidno;
        this.ini = ini;
        this.sur = sur;
        this.gebdat = gebdat;
        this.sex = sex;
        this.verwskap = verwskap;
        this.premie = premie;
        this.status = status;
        this.statusdate = statusdate;

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

    public String getini() {
        return ini;
    }

    public void setini(String ini) {
        this.ini = ini;
    }

    public String getsur() {
        return sur;
    }

    public void setsur(String sur) {
        this.sur = sur;
    }

    public String getgebdat() {
        return gebdat;
    }

    public void setgebdat(String gebdat) {
        this.gebdat = gebdat;
    }

    public String getsex() {
        return sex;
    }

    public void setsex(String sex) {
        this.sex = sex;
    }

    public String getverwskap() {
        return verwskap;
    }

    public void setverwskap(String verwskap) {
        this.verwskap = verwskap;
    }

    public String getpremie() {
        return premie;
    }

    public void setpremie(String premie) {
        this.premie = premie;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public String getstatusdate() {
        return statusdate;
    }

    public void setstatusdate(String statusdate) {
        this.statusdate = statusdate;
    }
}
