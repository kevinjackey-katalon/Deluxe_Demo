import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

try {
    WebUI.maximizeWindow()
    WebUI.navigateToUrl('https://www.deluxe.com/')
    WebUI.waitForPageLoad(30)

    def closeChecksModal = findTestObject('Object Repository/Global Navigation/DMWD-7/Close Checks Modal')
    if (WebUI.verifyElementPresent(closeChecksModal, 5, FailureHandling.OPTIONAL)) {
        WebUI.waitForElementClickable(closeChecksModal, 15)
        WebUI.click(closeChecksModal)
        WebUI.waitForElementNotVisible(closeChecksModal, 10)
    }

    def buyChecksMenu = findTestObject('Object Repository/Global Navigation/DMWD-7/Top Menu Buy Checks')
    def buyChecksPanel = findTestObject('Object Repository/Global Navigation/DMWD-7/Panel Buy Checks')
    WebUI.waitForElementClickable(buyChecksMenu, 15)
    WebUI.click(buyChecksMenu)
    WebUI.waitForElementVisible(buyChecksPanel, 15)
    WebUI.verifyElementVisible(buyChecksPanel)
    WebUI.takeScreenshotAsCheckpoint('Buy Checks panel')

    def helpMeToMenu = findTestObject('Object Repository/Global Navigation/DMWD-7/Top Menu Help Me To')
    def helpMeToPanel = findTestObject('Object Repository/Global Navigation/DMWD-7/Panel Help Me To')
    WebUI.waitForElementClickable(helpMeToMenu, 15)
    WebUI.click(helpMeToMenu)
    WebUI.waitForElementVisible(helpMeToPanel, 15)
    WebUI.verifyElementVisible(helpMeToPanel)
    WebUI.takeScreenshotAsCheckpoint('Help Me To panel')

    def solutionsMenu = findTestObject('Object Repository/Global Navigation/DMWD-7/Top Menu Solutions')
    def solutionsPanel = findTestObject('Object Repository/Global Navigation/DMWD-7/Panel Solutions')
    WebUI.waitForElementClickable(solutionsMenu, 15)
    WebUI.click(solutionsMenu)
    WebUI.waitForElementVisible(solutionsPanel, 15)
    WebUI.verifyElementVisible(solutionsPanel)
    WebUI.takeScreenshotAsCheckpoint('Solutions panel')

    def whoWeServeMenu = findTestObject('Object Repository/Global Navigation/DMWD-7/Top Menu Who We Serve')
    def whoWeServePanel = findTestObject('Object Repository/Global Navigation/DMWD-7/Panel Who We Serve')
    WebUI.waitForElementClickable(whoWeServeMenu, 15)
    WebUI.click(whoWeServeMenu)
    WebUI.waitForElementVisible(whoWeServePanel, 15)
    WebUI.verifyElementVisible(whoWeServePanel)
    WebUI.takeScreenshotAsCheckpoint('Who We Serve panel')

    def aboutUsMenu = findTestObject('Object Repository/Global Navigation/DMWD-7/Top Menu About Us')
    def aboutUsPanel = findTestObject('Object Repository/Global Navigation/DMWD-7/Panel About Us')
    WebUI.waitForElementClickable(aboutUsMenu, 15)
    WebUI.click(aboutUsMenu)
    WebUI.waitForElementVisible(aboutUsPanel, 15)
    WebUI.verifyElementVisible(aboutUsPanel)
    WebUI.takeScreenshotAsCheckpoint('About Us panel')
} finally {
    WebUI.closeBrowser()
}