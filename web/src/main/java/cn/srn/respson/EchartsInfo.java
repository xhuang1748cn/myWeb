package cn.srn.respson;

import java.util.List;

/**
 * Created by SRn on 2016/8/14.
 */
public class EchartsInfo extends ResponseInfo {

    List<EchartsData> arrays;

    public EchartsInfo() {
    }

    public EchartsInfo(List<EchartsData> arrays) {
        this.arrays = arrays;
    }

    public List<EchartsData> getArrays() {
        return arrays;
    }

    public void setArrays(List<EchartsData> arrays) {
        this.arrays = arrays;
    }
}
