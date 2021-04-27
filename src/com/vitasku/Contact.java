/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitasku;

/**
 *
 * @author vitco
 */
public class Contact {
    
   private Long contactId;
   private String surName;
   private String givenName;
   private String eMail;
   private String mPhone;

   public Contact(){
       
   }

    public Contact(long contactId, String surName, String givenName, String eMail, String mPhone) {
        this.contactId = contactId;
        this.surName = surName;
        this.givenName = givenName;
        this.eMail = eMail;
        this.mPhone = mPhone;
    }
   
   
   
    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    @Override
    public String toString() {
        
        return "Contact(" + "contactId=" +  contactId + ", surName=" +  surName + ", givenName=" + givenName + ", eMail="
                       + eMail + ", mPhone=" + mPhone + ")";
    }
    
    
}
