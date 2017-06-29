/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ffsbeans;

/**
 *
 * @author user149
 */
public class MemberImages {

    private String tranId;
    private String user;
    private String description;
    private String dateMod;

    public MemberImages() {

    }

    public MemberImages(String tranId, String user, String description, String dateMod) {
        this.tranId = tranId;
        this.user = user;
        this.description = description;
        this.dateMod = dateMod;
    }

    public String gettranId() {
        return tranId;
    }

    public void settranId(String tranId) {
        this.tranId = tranId;
    }

    public String getuser() {
        return user;
    }

    public void setuser(String user) {
        this.user = user;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getdateMod() {
        return dateMod;
    }

    public void setdateMod(String dateMod) {
        this.dateMod = dateMod;
    }

}
