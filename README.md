Foursquare API Venues Search
=========================



Setup
=====

1) Before start using it, you've got to obtain an API key.  Visit the <a href="https://developer.foursquare.com/">developer's guide</a> for more information.

2) Drop the foursquare.jar in the lib folder of your Android project.

3) In order to mismatching issues, I've moved out the Android Support V4 from libs folder (libs/android-support-v4.jar). As a best practice, keep in mind that you might want to include it on your own project instead of the Foursquare Android one.

Usage
=====

Some Examples:

Venue Search
------------

Sending a search request

    Foursquare foursquare = new Foursquare("Your API Client Id", "Your API Secreet ID");
    
    VenuesResult result = foursquare.getVenues("restaurant", 500, -20.28142, -40.301564);
    
