package cn.srn.respson;

/**
 * Created by SRn on 2016/8/14.
 */
public class EchartsData {

    private int value;
    private String date;

    public EchartsData() {
    }

    public EchartsData(int value, String date) {
        this.value = value;
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
