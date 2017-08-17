ScrollMe
=======

An Android library automatically adds scroll up button to RecyclerView

Preview
--------
![alt text](http://www.salyangoz.com.tr/scrollme/sample-android.gif)

For more information please see [the website][1]

Download
--------

Download [the latest JAR][2] or grab via Gradle. (Project's gradle file):
You can pull sample project and run how to use it simply or Basic usage shown below.

```groovy
dependencies {
  compile 'io.salyangoz.scrollme:scrollme:0.1.0'
}
```

or Maven:
```xml
<dependency>
  <groupId>io.salyangoz.scrollmeme</groupId>
  <artifactId>scrollme</artifactId>
  <version>0.1.0</version>
</dependency>
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].

Dependencies 
--------

Project uses AppCompat, Support, Design and Constraint libraries. This section is only inform you that library uses below implementations.

```groovy
dependencies {

    implementation 'com.android.support:appcompat-v7:26.0.1'
    implementation 'com.android.support:support-v4:26.0.1'
    implementation 'com.android.support:design:26.0.1'
    implementation 'com.android.support.constraint:constraint-layout:1.0.2'

}
```

Usage
--------

###### Usage

#### Layout XML

add `xmlns:app="http://schemas.android.com/apk/res-auto"`

You can customize 5 custom attributes shown below.

| Parameter Key  | Default Value | Type |
| ------------- | ------------- | ------------- |
| sm_tint | Floating button up icon color | color |
| sm_backgroundColor | Floating button background color | color |
| sm_icon | Floating up icon | drawable | 
| sm_clickable | Floating button clickable | boolean |
| sm_focusable | Floating button focusable | boolean |
| sm_size | Floating button size | enum(BIG,SMALL) |


```xml

   <io.salyangoz.scrollme.ScrollMeView
        android:id="@+id/scrollMeView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true"
        app:sm_backgroundColor="@android:color/white"
        app:sm_icon="@drawable/ic_up"
        app:sm_size="SMALL"
        app:sm_tint="@color/colorAccent" />

```

#### Code

All you need to do is create ScrollMeView instance and set adapter of ScrollMeView. ScrollMeView uses RecyclerView inside. You can get more info like Adapter and demo data on our sample folder.

```java

	//Define ScrollMeView
	ScrollMeView mScrollMeView = (ScrollMeView) findViewById(R.id.scrollMeView);

	//Set Adapter and populate data this is your custom data you can use whatever data adapter you want
	List<Movie> movieList = new ArrayList<>();

        MoviesAdapter mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        mScrollMeView.getmRecyclerView().setLayoutManager(mLayoutManager);
        mScrollMeView.getmRecyclerView().setItemAnimator(new DefaultItemAnimator());
        mScrollMeView.getmRecyclerView().setAdapter(mAdapter);

```

Special Thanks
--------

Thank you [Emre Aktürk][3] for contributing and helping to create this library 


License
--------

    Copyright 2017 Salyangoz Teknoloji, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


 [1]: http://salyangoz.github.io/scrollme-android/
 [2]: https://search.maven.org/remote_content?g=com.salyangoz.updateme&a=updateme&v=LATEST
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
 [3]: https://github.com/emreaktrk
