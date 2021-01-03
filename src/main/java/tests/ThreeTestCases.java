package tests;

import helpers.OperatingSystemHelper;
import helpers.StartUpHelper;
import helpers.TurnOffHelper;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static constants.GeneralConstants.*;
import static constants.ScreenshotConstants.*;

public class ThreeTestCases {
    public static Screen screen;
    private static OperatingSystemHelper osHelper;
    private static StartUpHelper startUpHelper;
    private static TurnOffHelper turnOffHelper;
    private static SoftAssert softAssert;

    private static final Pattern SESSIONS_PTRN = new Pattern(ThreeTestCases.class.getResource(SESSIONS_LABEL));
    private static final Pattern REQUESTS_PTRN = new Pattern(ThreeTestCases.class.getResource(REQUESTS_LABEL));
    private static final Pattern LIVE_TRAFFIC_CAPTURING_PTRN = new Pattern(ThreeTestCases.class.getResource(LIVE_TRAFFIC_CAPTURING_LABEL));
    private static final Pattern INSPECTORS_PTRN = new Pattern(ThreeTestCases.class.getResource(INSPECTORS_LABEL));
    private static final Pattern COMPOSER_PTRN = new Pattern(ThreeTestCases.class.getResource(COMPOSER_LABEL));
    private static final Pattern AUTO_RESPONDER_PTRN = new Pattern(ThreeTestCases.class.getResource(AUTO_RESPONDER_LABEL));
    private static final Pattern RESPONSE_PTRN = new Pattern(ThreeTestCases.class.getResource(RESPONSE_LABEL));
    private static final Pattern MY_RESOURCES_PTRN = new Pattern(ThreeTestCases.class.getResource(MY_RESOURCES_LABEL));
    private static final Pattern SETTINGS_PROFILE_PTRN = new Pattern(ThreeTestCases.class.getResource(SETTINGS_PROFILE_LABEL));
    private static final Pattern REMOVE_ALL_BUTTON_PTRN = new Pattern(ThreeTestCases.class.getResource(REMOVE_ALL_BUTTON));
    private static final Pattern NO_SESSIONS_TO_DISPLAY_TEXT_PTRN = new Pattern(ThreeTestCases.class.getResource(NO_SESSIONS_TO_DISPLAY_TEXT));
    private static final Pattern TOGGLE_ON_PTRN = new Pattern(ThreeTestCases.class.getResource(TOGGLE_ON));
    private static final Pattern LIFE_TRAFFIC_PAUSED_PTRN = new Pattern(ThreeTestCases.class.getResource(LIVE_TRAFFIC_PAUSED));

    public ThreeTestCases()
    {
        screen = new Screen();
        osHelper = new OperatingSystemHelper();
        startUpHelper = new StartUpHelper();
        turnOffHelper = new TurnOffHelper();
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void initApplication() throws FindFailed {
        if(osHelper.isWindows())
        {
            startUpHelper.startUpApplicationOnWindows(screen);
        }
        else if(osHelper.isLinux())
        {
            startUpHelper.startUpApplicationOnLinux(screen);
        }
        else if(osHelper.isMacOs())
        {
            startUpHelper.startUpApplicationOnMacOS(screen);
        }
    }

    @AfterMethod
    public void tearDownApplication() throws FindFailed {
        if(osHelper.isWindows())
        {
            turnOffHelper.turnOffApplicationOnWindows(screen);
        }
        else if(osHelper.isLinux())
        {
            turnOffHelper.turnOffApplicationOnLinux(screen);
        }
        else if(osHelper.isMacOs())
        {
            turnOffHelper.turnOffApplicationOnMacOS(screen);
        }
    }

    @Test
    public static void whenApplicationIsStartedThenAllApplicationSectionsAreAvailable() {
        softAssert.assertNotNull(screen.exists(SESSIONS_PTRN.similar((float) 0.90)));
        softAssert.assertNotNull(screen.exists(REQUESTS_PTRN.similar((float) 0.90)));
        softAssert.assertNotNull(screen.exists(LIVE_TRAFFIC_CAPTURING_PTRN.similar((float) 0.90)));
        softAssert.assertNotNull(screen.exists(INSPECTORS_PTRN.similar((float) 0.90)));
        softAssert.assertNotNull(screen.exists(COMPOSER_PTRN.similar((float) 0.90)));
        softAssert.assertNotNull(screen.exists(AUTO_RESPONDER_PTRN.similar((float) 0.90)));
        softAssert.assertNotNull(screen.exists(RESPONSE_PTRN.similar((float) 0.90)));
        softAssert.assertNotNull(screen.exists(MY_RESOURCES_PTRN.similar((float) 0.90)));
        softAssert.assertNotNull(screen.exists(SETTINGS_PROFILE_PTRN.similar((float) 0.90)));
    }

    @Test
    public static void whenRemoveAllButtonIsClickedThenAllTempDataIsDeleted() throws FindFailed {
        softAssert.assertNotNull(screen.exists(LIVE_TRAFFIC_CAPTURING_PTRN.similar((float) 0.90)));

        screen.click(REMOVE_ALL_BUTTON_PTRN);

        softAssert.assertNotNull(screen.exists(NO_WEB_SESSIONS_MESSAGE));
        softAssert.assertNotNull(screen.exists(NO_SESSIONS_TO_DISPLAY_TEXT_PTRN.similar((float) 0.90)));
    }

    @Test
    public static void whenLiveCapturingIsPausedThenToggleIsDisabled() throws FindFailed {
        softAssert.assertNotNull(screen.exists(LIVE_TRAFFIC_CAPTURING_PTRN.similar((float) 0.90)));

        screen.click(TOGGLE_ON_PTRN);

        softAssert.assertNotNull(screen.exists(LIFE_TRAFFIC_PAUSED_PTRN.similar((float) 0.90)));
    }
}
