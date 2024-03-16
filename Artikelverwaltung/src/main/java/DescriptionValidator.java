import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;
import org.languagetool.JLanguageTool;
import org.languagetool.Languages;
import org.languagetool.rules.RuleMatch;

import java.io.IOException;
import java.util.List;

@ApplicationScoped
@Named
public class DescriptionValidator
{
    public void check(FacesContext ctx,
            UIComponent cmp, Object value) throws ValidatorException {
        String text = (String) value;

        // Criteria 1: Finish your sentence with a period
        if(!(text.endsWith(".") || text.endsWith("!") || text.endsWith("?")))
            throw new ValidatorException(
                    new FacesMessage("Bitte volle Sätze mit Punktuation machen!"));

        // Criteria 2: Between 100 and 300 characters
        if (text.length()<100)
            throw new ValidatorException(
                    new FacesMessage("Text zu kurz!"));
        if (text.length()>300)
            throw new ValidatorException(
                    new FacesMessage("Text zu lang!"));

        // Criteria 3: Proper grammar
        JLanguageTool langTool = new JLanguageTool(Languages.getLanguageForShortCode("de-DE"));
        try {
            List<RuleMatch> matches = langTool.check(text);
            if (matches!=null && !matches.isEmpty()) {
                StringBuilder str = new StringBuilder("Sprachprobleme: ");
                for (RuleMatch match : matches) {
                    str.append(match.getFromPos()).append("-").append(match.getToPos()).append(": " ).append( match.getMessage()).append("\n");
                    str.append("  Suggested correction(s): " + match.getSuggestedReplacements()).append("\n");
                }
                throw new ValidatorException(new FacesMessage(str.toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }

    }
}
