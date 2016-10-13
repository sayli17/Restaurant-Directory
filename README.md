# Restaurant-Directory

This is an Android App that use the concept of ListViews, adapters, menus, dialogs, and intents.

It has 3 activities:
1) Main activity has a ListView wherein each row has an image of a food item and item description.
2) Detail activity pops up when a ListView item is clicked. It shows a large image of the food item, detailed decription and price.
3) Restaurant Information activity has a photo of the restaurant, hours of operation and a call button. When a customer clicks on the Call Button, a call is placed to the Restaurant's phone number.(This is done using permission ACTION_CALL)

There are 2 menus in ActionBar - Information and Uninstall.

When the user clicks on Information, Restaurant Information activity is opened. And if the user clicks on Uninstall, the application gets uninstalled from the user's phone.

When the last item in the ListView i.e. Chocolate Pastry is clicked, a dialog pops up showing the user Allergin Information and asking if they want to proceed. If the user click "yes", the detail activity for pastry pops up if he/she selects "no", the same activity i.e. ListView appears.
