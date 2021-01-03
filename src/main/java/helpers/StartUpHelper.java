package helpers;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.awt.event.KeyEvent;

import static constants.GeneralConstants.*;
import static constants.ScreenshotConstants.*;

public class StartUpHelper {
    public void startUpApplicationOnWindows(Screen screen) throws FindFailed {
        Pattern searchButton = new Pattern(StartUpHelper.class.getResource((WINDOWS_SEARCH_BUTTON)));
        Pattern searchFieldField = new Pattern(StartUpHelper.class.getResource((WINDOWS_SEARCH_FIELD)));
        Pattern applicationLogo = new Pattern(StartUpHelper.class.getResource((APPLICATION_LOGO)));

        screen.click(searchButton);
        screen.wait(searchFieldField.similar((float) 0.90), 2).click(searchFieldField);
        screen.type(APPLICATION_NAME);
        screen.keyDown(KeyEvent.VK_ENTER);
        screen.keyUp(KeyEvent.VK_ENTER);
        screen.wait(applicationLogo.similar((float) 0.90));
    }

    //TODO
    public void startUpApplicationOnLinux(Screen screen) {

    }

    //TODO
    public void startUpApplicationOnMacOS(Screen screen) {

    }
}
