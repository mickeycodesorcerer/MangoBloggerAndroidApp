# MangoBlogger Android App
Digital Marketing Assistant for your business

This is the code for our mangoblogger.com Android app. 

# Recently Changes (change Log)

#Just added Network connection listener

Just watch toast and internet connection 

Using this you can make your own layout which appears when internet connected or disconnected 

![ezgif com-video-to-gif 1](https://user-images.githubusercontent.com/22986571/31533403-a92132aa-b00f-11e7-99e2-f0028beebaf6.gif)

JAVA
-----

```java
  /* It's just a listener this is abstraction you need to do coding for listen every time for internet connection */
          /* If you want to know how it's done then check [ CheckNetworkReceiver.java , Manifest] */
  @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if (isConnected)
            Toast.makeText(MainActivity.this, "Internet is connected", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Internet is not connected", Toast.LENGTH_SHORT).show();

    }
```

We have made the code open source under the Mozilla Public License 2.0. 

In the future as we continue building our own app the the plan is to make it into an Android Template that businessess can use to quickly spin up Android Apps which integerate well with their websites. The app will have all the analytics tracking built in.

All the feedback and contributions to the project are welcome. :) 
