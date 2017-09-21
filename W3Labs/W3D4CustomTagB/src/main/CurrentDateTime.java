package main;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.*;

public class CurrentDateTime extends SimpleTagSupport {

    String color;
    String size;
    String dateFormat;
    String timeFormat;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

        if (this.color != null || this.size != null) {
            out.write(String.format("<span style='color:%s;size:%s;'>"
                    + "%s</span>", this.color, this.size, ft.format(dNow)));
        } else {
            out.write(String.format("<span>%s</span>", ft.format(dNow)));
        }
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }
    
}
