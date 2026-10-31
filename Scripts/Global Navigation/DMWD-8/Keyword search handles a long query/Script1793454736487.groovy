import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys

WebUI.openBrowser('')

try {
    WebUI.maximizeWindow()
    WebUI.navigateToUrl('https://www.deluxe.com/')
    WebUI.waitForPageLoad(30)

    def searchInput = findTestObject('Object Repository/Global Navigation/DMWD-8/Search Input')
    WebUI.verifyElementPresent(searchInput, 15)
    WebUI.takeScreenshotAsCheckpoint('Deluxe homepage opened')

    def closeChecksModal = findTestObject('Object Repository/Global Navigation/DMWD-8/Close Checks Modal')
    if (WebUI.verifyElementPresent(closeChecksModal, 5, FailureHandling.OPTIONAL)) {
        WebUI.waitForElementClickable(closeChecksModal, 15)
        WebUI.click(closeChecksModal)
        WebUI.waitForElementNotVisible(closeChecksModal, 10)
    }

    def longQuery = 'deluxe payments and data solutions for small businesses and financial institutions'
    WebUI.waitForElementClickable(searchInput, 15)
    WebUI.click(searchInput)
    WebUI.clearText(searchInput)
    WebUI.sendKeys(searchInput, longQuery)
    WebUI.sendKeys(searchInput, Keys.chord(Keys.ENTER))
    WebUI.waitForPageLoad(30)

    def searchResultsPageTitle = findTestObject('Object Repository/Global Navigation/DMWD-8/Search Results Page Title')
    WebUI.waitForElementVisible(searchResultsPageTitle, 15)
    WebUI.verifyElementPresent(searchResultsPageTitle, 5)
    WebUI.takeScreenshotAsCheckpoint('Search results page opened')

    def searchResultsCount = findTestObject('Object Repository/Global Navigation/DMWD-8/Search Results Count')
    WebUI.waitForElementVisible(searchResultsCount, 15)
    WebUI.verifyElementPresent(searchResultsCount, 5)
    WebUI.takeScreenshotAsCheckpoint('Long keyword search results displayed')
} finally {
    WebUI.closeBrowser()
}