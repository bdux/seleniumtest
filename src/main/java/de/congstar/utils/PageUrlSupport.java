package de.congstar.utils;

import de.congstar.pages.BasePage;

public class PageUrlSupport {


    /**
     * Liefert für ein Selenium Page Object die ggf. annotierte URL und wirft andernfalls eine {@link IllegalStateException}.
     */
    public static <T extends BasePage> String getUrlFor(Class<T> pageObject) {
        PageUrl pageUrl = pageObject.getAnnotation(PageUrl.class);
        if (pageUrl == null)
            throw new IllegalStateException("Es wurde keine Annotation PageUrl an dem PageObject " + pageObject.getCanonicalName() + " gefunden.");
        String url = pageUrl.value();
        return url;
    }

}