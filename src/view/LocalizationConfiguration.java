package view;
import java.util.Locale;
import java.util.ResourceBundle;

public enum LocalizationConfiguration {
    INSTANCE;
    private ResourceBundle bundle;
    private String bundleName = "localization";
    LocalizationConfiguration() {
        bundle = ResourceBundle.getBundle(bundleName, Locale.getDefault());
    }
    public void changeLanguage(Locale locale) {
        bundle = ResourceBundle.getBundle(bundleName, locale);
    }
    public String getLocalized(String text) {
        return bundle.getString(text);
    }
}