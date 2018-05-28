# AutoScout24 Android Tech Challenge

This app includes three screens: List, Detail, Fullscreen Photo

### 1. List screen
Vehicles are listed in this screen. Data comes from network
in the first launch and is stored in local database. It may be refreshed
by swiping down. List items include the first image, title,
fuel type and price of the vehicle. There is an advertisement view every third item.

### 2. Detail screen
Detail screen will be navigated when list item is clicked. CollapsingToolbarLayout
is used on this screen. More information of the vehicle is shown such as
first registration, mileage, description. All images may be seen in
ViewPager. Clicking on zoom icon will show full screen mode.

### 3. Fullscreen Photo Screen
Images of vehicles may be seen in fullscreen mode. It also supports
zooming feature.

## Used libraries
- Mosby MVP
- Dagger
- RxJava
- Retrofit
- Room
- Anko
- PhotoView
- CircleIndicator

---

Icons are used from [flaticon.com](https://www.flaticon.com)