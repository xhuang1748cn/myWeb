package cn.srn.jsptag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by SRn on 2016/12/25.
 */
public class JspTagTest extends TagSupport {

    private String tagProperty;

    public String getTagProperty() {
        return tagProperty;
    }

    public void setTagProperty(String tagProperty) {
        this.tagProperty = tagProperty;
    }

    @Override
    public int doStartTag() throws JspException {
        if (tagProperty.equalsIgnoreCase("txt")) {
            return EVAL_BODY_INCLUDE;
        } else {
            return SKIP_BODY;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        return super.doEndTag();
    }
}
