package vip.zjko.tag;


import vip.zjko.model.Grade;
import vip.zjko.util.DaoFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class GradeListTag extends SimpleTagSupport {
  
    private int gid;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        StringBuilder str = new StringBuilder();
        List<Grade> grades = DaoFactory.getGradeDao().getAll();
        str.append("<select class=\"input\" name=\"gid\" id=\"gid\" data-validate=\"required:请选择学生班级\">");
        str.append("<option value=\"\">请选择学生班级</option>");
        for (Grade grade : grades) {
            if (grade.getGid() == gid) {
                str.append("<option value='").append(grade.getGid()).append("' selected>").append(grade.getGname()).append("</option>");
            } else {
                str.append("<option value='").append(grade.getGid()).append("'>").append(grade.getGname()).append("</option>");
            }
        }
        str.append("</select>");
        out.print(str.toString());
    }
}
