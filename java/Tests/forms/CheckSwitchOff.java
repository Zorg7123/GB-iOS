package Tests.forms;

import BASE.BASETest;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListener;

@Listeners(AllureListener)

public class CheckSwitchOff extends BASETest {
    public static final String Switch_OFF = "Click to turn the switch OFF";
    @Test
    @Description("Проверяем сообщение")
    public void CheckOff() {
        openApp()
                .clickFormsMenuButton()
                .clickSwitchButton()
                .checkSwitchText(Switch_OFF);
    }
}
