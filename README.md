## Scenario 1

**Requirement:**

1. At this stage, it is reached by making clear cache without deleting the application. Navigate to `App > Activity > Custom Title` menu. In the activity that opens:
    - Verify the default `textBox` and `navigationBar` texts.
    - Change the left and right `textBox` fields.
    - Verify that the relevant `textBox` and `navigationBar` texts have changed accordingly.

## Scenario 2

**Requirement:**

1. At this stage, it is reached without clearing cache and without deleting the application (`noReset=true`). Navigate to `App > Alert Dialogs > List dialog` menu. In the opened activity:
    - Select any element in the list dialog.
    - Verify the order of the selected element and check the element name in the alert message.

## Scenario 3

**Requirement:**

1. At this stage, it is reached without clearing cache and without deleting the application (`noReset=true`). Navigate to `App > Fragment > Context Menu`. In the activity that opens:
    - Check that Menu A and Menu B elements are opened by long-pressing the 'long press me' button.

## Scenario 4

**Requirement:**

1. At this stage, it is reached without clearing cache and without deleting the application (`noReset=true`). Navigate to `App > Fragment > Hide and Show` menus. In the opened activity:
    - Verify that there are two Hide buttons and two `textBox` fields.
    - Click on the second 'Hide' button and check that the `textBox` field displays 'Hide' and the 'Hide' button text changes to 'Show'.
    - By pressing the 'Show' button, verify that the `textBox` field reappears and the button text changes back to 'Hide'.

## Scenario 5

**Requirement:**

1. At this stage, it is reached without clearing cache and without deleting the application (`noReset=true`). Navigate to `App > Notification > Incoming Message`. In the activity that opens:
    - Click the 'Show Notification' button to open the Notification Bar area and check the notification.
    - Click the notification and verify that the notification detail opens and the text in the notification bar area matches the content of the notification.

## Scenario 6

**Requirement:**

1. At this stage, the application is deleted and reinstalled and the flow continues. Navigate to `Views > Tabs menu > 5. Scrollable` menu. In the opened activity:
    - Switch to the Tab which is in the last place.
    - After clicking the Tab, verify that the opened page information corresponds to tab 30.
