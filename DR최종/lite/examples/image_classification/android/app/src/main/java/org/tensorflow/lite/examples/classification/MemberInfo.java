package org.tensorflow.lite.examples.classification;

public class MemberInfo {

    private String name;
    private String phoneNumber;
    private String brithDay;
    private String address;

    public MemberInfo(String name , String phoneNumber , String brithDay , String address ){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.brithDay = brithDay;
        this.address = address;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
         this.name =name;
    }
    public String gephoneNumber(){
        return this.phoneNumber;
    }
    public void setphoneNumber(String phoneNumber){ this.phoneNumber = phoneNumber; }
    public String getbrithDay(){
        return this.brithDay;
    }
    public void setbrithDay(String brithDay){
        this.brithDay = brithDay;
    }
    public String getaddress(){
        return this.address;
    }
    public void setaddress(String address){
        this.address = address;
    }
}
