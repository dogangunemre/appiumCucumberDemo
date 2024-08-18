Feature: Demo Feature

  Scenario: 101001 Scenario Success Custom Title Change
    * Open Application
    * click "App_button"
    * click "Activity_button"
    * click "Custom_Title_button"
    * Find element by "left_text_edit_input" clear
    * Find element by "left_text_edit_input" and send keys "left text edit"
    * click "left_text_button"
    * Find element by "right_text_edit_input" clear
    * Find element by "right_text_edit_input" and send keys "right text edit"
    * click "right_text_button"

  Scenario: 101002 Scenario Success List Dialog
    * Open Application
    * click "App_button"
    * click "Alert_Dialogs_button"
    * click "List_dialog_button"
    * Wait 1 seconds
    * Randomly select and check the element with "select_dialog_listview"
    * Wait 1 seconds

  Scenario: 101003 Scenario Success Context Menu
    * Open Application
    * click "App_button"
    * click "Fragment_button"
    * click "Context_Menu_button"
    * long press "long_press_button"
    * Wait 1 seconds
    * "Menu_A_Text" verify if element exists
    * "Menu_B_Text" verify if element exists

  Scenario: 101004 Scenario Success Hide and Show
    * Open Application
    * click "App_button"
    * click "Fragment_button"
    * click "Hide_and_Show_button"
    * Check element "Hide_buttons" count 2
    * Check element "Initial_texts" count 2
    * click "Hide_button1"
    * click "Show_button1"
    * Check element "Hide_buttons" count 2
    * Check element "Initial_texts" count 2

  Scenario: 101005 Scenario Success Incoming Message
    * Open Application
    * click "App_button"
    * click "Notification_button"
    * click "IncomingMessage_button"
    * click "permission_allow_button"
    * click "notify_app_button"
    * Wait 1 seconds
    * Swipe 500,0,800,2000,1
    * Click "notification" Notification and Check the Notification

  Scenario: 101006 Scenario Success Scrollable
    * Open Application
    * click "Views_button"
    * Swipe 540,1170,540,585,4
    * click "Tabs_button"
    * click "FifthScrollable_button"
    * Swipe 177,304,0,458,30
    * click "Tab_30_button"
    * "Tab_30_text" verify if element exists





