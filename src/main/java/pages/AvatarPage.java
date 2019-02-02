package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AvatarPage {

    @Step
    public AvatarPage hoverOverAvatarNumber(String numberOfAvatar) {
        $("div:nth-child(" + numberOfAvatar + ") > img").hover();
        return this;
    }

    @Step
    public AvatarPage verifyTextUnderAvatar(String numberOfAvatar, String nameOfAvatar) {
        $("div:nth-child(" + numberOfAvatar + ") .figcaption").shouldHave(Condition.text(nameOfAvatar));
        return this;
    }

    @Step
    public AvatarPage openAvatarPage(String avatarUrl) {
        open(avatarUrl);
        return this;
    }

}
