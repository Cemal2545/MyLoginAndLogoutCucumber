package com.perfleet.pages;

import com.github.dockerjava.core.exec.WaitContainerCmdExec;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    public WebElement usernameDropdown;

    @FindBy(xpath = "//a[@class='no-hash']")
    public WebElement logoutBtn;
}
