import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import java.util.ArrayList;
import java.util.List;

@FacesConverter("DimensionenConverter")
public class DimensionenConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        int p=0, q=0;
        List<Double> liste = new ArrayList<>();
        while (q<s.length() && (p=s.indexOf("x", q))>-1) {
            liste.add(Double.parseDouble(s.substring(q,p).trim()));
            q = p+1;
        }
        if (p+1<s.length()) liste.add(Double.parseDouble(s.substring(q, s.length()).trim()));
        return liste.toArray();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        StringBuilder b = new StringBuilder();
        Object[] dd = (Object[]) o;
        int m = dd.length;
        for(int i=0; i<m; i++) {
            if(i>0) b.append(" x ");
            b.append(Double.toString((Double) dd[i]));
        }
        return b.toString();
    }
}
