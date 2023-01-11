package de.congstar.test.webpagetest;

import de.congstar.pages.CongstarWebShopPage;
import de.congstar.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;


@Slf4j
public class CongstarTest extends BaseTest {

    @Test
    public void testCongstarPage(){

        CongstarWebShopPage page = navigateToPage(CongstarWebShopPage.class);
        sleep(Duration.ofSeconds(2));
        page.closeCookieHint();
        log.info("TEST");

    }
}
