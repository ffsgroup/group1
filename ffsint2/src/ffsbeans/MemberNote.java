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
public class MemberNote {

    private String tranId;
    private String tranUserId;
    private String tranComment;
    private String dateMod;

    public MemberNote() {

    }

    public MemberNote(String tranId, String tranUserId, String tranComment, String dateMod) {
        this.tranId = tranId;
        this.tranUserId = tranUserId;
        this.tranComment = tranComment;
        this.dateMod = dateMod;
    }

    public String gettranId() {
        return tranId;
    }

    public void settranId(String tranId) {
        this.tranId = tranId;
    }

    public String gettranUserId() {
        return tranUserId;
    }

    public void settranUserId(String tranUserId) {
        this.tranUserId = tranUserId;
    }

    public String gettranComment() {
        return tranComment;
    }

    public void settranComment(String tranComment) {
        this.tranComment = tranComment;
    }

    public String getdateMod() {
        return dateMod;
    }

    public void setdateMod(String dateMod) {
        this.dateMod = dateMod;
    }

}
