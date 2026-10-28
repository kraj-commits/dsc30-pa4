import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class WebBrowserTest {

    WebBrowser wb = new WebBrowser();

    @Test
    public void constructorTest() {
        assertEquals(0, wb.getNumOpenTabs());
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            wb.getCurrentTab();
        });
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            wb.openNextTab();
        });
        Assertions.assertThrows(EmptyStackException.class, () -> {
            wb.reopenClosedTab();
        });

    }

    @Test
    public void addToQueueTest() {
        wb = new WebBrowser();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wb.addToQueue(null);
        });
        wb.addToQueue("a");
        wb.addToQueue("b");
        assertEquals(0, wb.getNumOpenTabs());
        assertEquals("a", wb.openNextTab());

    }

    @Test
    public void openNextTabTest() {
        wb = new WebBrowser();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            wb.openNextTab();
        });
        wb.addToQueue("a");
        wb.addToQueue("b");
        assertEquals("a", wb.openNextTab());
        assertEquals("a", wb.getCurrentTab());
        wb.openNextTab();
        assertEquals("b", wb.getCurrentTab());
        wb.switchTab(0);
        assertEquals("a", wb.getCurrentTab());

    }

    @Test
    public void closeCurrentTabTest() {
        wb = new WebBrowser();
        wb.addToQueue("a");
        wb.addToQueue("b");
        wb.openNextTab();
        wb.openNextTab();
        wb.switchTab(0);
        assertEquals("a", wb.closeCurrentTab());
        assertEquals("b", wb.getCurrentTab());

        wb = new WebBrowser();
        wb.addToQueue("a");
        wb.addToQueue("b");
        wb.openNextTab();
        wb.openNextTab();
        wb.closeCurrentTab();
        assertEquals("a", wb.getCurrentTab());
        wb.closeCurrentTab();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            wb.closeCurrentTab();
        });

    }

    @Test
    public void reopenClosedTabTest() {
        wb = new WebBrowser();
        wb.addToQueue("a");
        wb.addToQueue("b");
        wb.openNextTab();
        wb.openNextTab();
        wb.closeCurrentTab();
        wb.closeCurrentTab();
        assertEquals("a", wb.reopenClosedTab());
        assertEquals("b", wb.reopenClosedTab());
        assertEquals("b", wb.getCurrentTab());
        wb.switchTab(1);
        assertEquals("a", wb.getCurrentTab());
        Assertions.assertThrows(EmptyStackException.class, () -> {
            wb.reopenClosedTab();
        });

    }

    @Test
    public void switchTabTest() {
        wb = new WebBrowser();
        wb.addToQueue("a");
        wb.addToQueue("b");
        wb.openNextTab();
        wb.openNextTab();
        wb.switchTab(0);
        assertEquals("a", wb.getCurrentTab());
        wb.switchTab(1);
        assertEquals("b", wb.getCurrentTab());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            wb.switchTab(-1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            wb.switchTab(2);
        });

    }

    @Test
    public void getCurrentTabTest() {
        wb = new WebBrowser();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            wb.getCurrentTab();
        });
        wb.addToQueue("a");
        wb.addToQueue("b");
        wb.openNextTab();
        assertEquals("a", wb.getCurrentTab());
        wb.openNextTab();
        assertEquals("b", wb.getCurrentTab());

    }

    @Test
    public void getNumOpenTabsTest() {
        wb = new WebBrowser();
        wb.addToQueue("a");
        wb.addToQueue("b");
        assertEquals(0, wb.getNumOpenTabs());
        wb.openNextTab();
        assertEquals(1, wb.getNumOpenTabs());
        wb.openNextTab();
        assertEquals(2, wb.getNumOpenTabs());
        wb.closeCurrentTab();
        assertEquals(1, wb.getNumOpenTabs());
        wb.reopenClosedTab();
        assertEquals(2, wb.getNumOpenTabs());

    }

    @Test
    public void clearTest() {
        wb = new WebBrowser();
        wb.addToQueue("a");
        wb.addToQueue("b");
        wb.openNextTab();
        wb.openNextTab();
        wb.clear();
        assertEquals(0, wb.getNumOpenTabs());
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            wb.getCurrentTab();
        });

        wb = new WebBrowser();
        wb.addToQueue("a");
        wb.clear();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            wb.openNextTab();
        });

        wb = new WebBrowser();
        wb.addToQueue("a");
        wb.openNextTab();
        wb.closeCurrentTab();
        wb.clear();
        Assertions.assertThrows(EmptyStackException.class, () -> {
            wb.reopenClosedTab();
        });

    }


}

