package helpers;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import static constants.ScreenshotConstants.*;

public class TurnOffHelper {
    public void turnOffApplicationOnWindows(Screen screen) throws FindFailed {
        Pattern applicationLogo = new Pattern(StartUpHelper.class.getResource((APPLICATION_LOGO)));
        Pattern closeIcon = new Pattern(StartUpHelper.class.getResource((CLOSE_ICON)));

        screen.wait(applicationLogo.similar((float) 0.90));
        screen.click(closeIcon);
    }

    //TODO
    public void turnOffApplicationOnLinux(Screen screen) {

    }

    //TODO
    public void turnOffApplicationOnMacOS(Screen screen) {

    }


}
