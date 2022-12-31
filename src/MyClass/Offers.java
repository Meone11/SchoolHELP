/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyClass;

import java.io.Serializable;

/**
 *
 * @author meone
 */
public class Offers implements Serializable{
    
    private String reqID, offerDate, remarks, offerStatus;

    public Offers(String reqID, String offerDate, String remarks, String offerStatus) {
        this.reqID = reqID;
        this.offerDate = offerDate;
        this.remarks = remarks;
        this.offerStatus = offerStatus;
    }

    public String getReqID() {
        return reqID;
    }

    public void setReqID(String reqID) {
        this.reqID = reqID;
    }

    public String getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(String offerDate) {
        this.offerDate = offerDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(String offerStatus) {
        this.offerStatus = offerStatus;
    }
}
