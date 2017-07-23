package lsw.newboost3.ItemResource;

/**
 * Created by lsw38 on 2017-07-19.
 */

public class Item {
    String resName;
    String resAddress;
    String resPhoneNum;
    String resContext;

    public Item() {
    }

    public Item(String resName, String resAddress, String resPhoneNum, String resContext) {
        this.resName = resName;
        this.resAddress = resAddress;
        this.resPhoneNum = resPhoneNum;
        this.resContext = resContext;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }

    public String getResPhoneNum() {
        return resPhoneNum;
    }

    public void setResPhoneNum(String resPhoneNum) {
        this.resPhoneNum = resPhoneNum;
    }

    public String getResContext() {
        return resContext;
    }

    public void setResContext(String resContext) {
        this.resContext = resContext;
    }
}
