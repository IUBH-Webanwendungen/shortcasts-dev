import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesConverter("DimensionenConverter")
@Named
public class DimensionenConverter implements Converter
{
    Pattern pattern = Pattern.compile("([0-9]+)(.|,)?([0-9]*)");

    @Override public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s)
    {
        Matcher m = pattern.matcher(s);
        List<Double> comps = new LinkedList<>();
        while (m.find()) {
            String beforeComma = m.group(1), afterComma = m.group(3);
            if(afterComma == null || afterComma.length()==0)
                comps.add(Double.parseDouble(beforeComma));
            else
                comps.add(Double.parseDouble(beforeComma)
                        + Double.parseDouble(afterComma)*Math.pow(10, -afterComma.length()));
        }
        Double[] co = new Double[comps.size()];
        int i=0; for(Iterator<Double> it = comps.iterator(); it.hasNext(); i++)
            co[i] = it.next();
        return co;
    }

    @Override public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o)
    {
        StringBuilder b = new StringBuilder();
        Double[] dd = (Double[]) o;
        int m = dd.length;
        for(int i=0; i<m; i++) {
            if(i>0) b.append(" x ");
            b.append(dd[i]);
        }
        for(Double d: dd) b.append(d);
        return b.toString();
    }
}
