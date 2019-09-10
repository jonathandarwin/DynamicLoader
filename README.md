# Dynamic Loader
Load Your Loader Anywhere Dynamically

## 1. Add Loader XML

      <LinearLayout
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:gravity="center"
          android:background="@android:color/transparent"
          >

          <ProgressBar
              android:layout_width="50dp"
              android:layout_height="50dp"
              />

      </LinearLayout>
        
Root layout should have width and height with value <b>match_parent</b> 
<br>
The progress bar, either ProgressBar or GifImageLoader, should be in the center of the root layout

## 2. Load Your Root ViewGroup in the Activity/BaseActivity
        
      ViewGroup root;    

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          ...
          root = findViewById(android.R.id.content);
          ...
      }
      
Id that we search in <i>findViewById()</i> is <b>android.R.id.content</b> because we want to get the root layout in the current activity.
<br>
Later we will inflate the loader xml inside this <b>root</b>

## 3. Load Your Loader XML in the Activity/BaseActivity

      View loader;      

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          ...
          loader = LayoutInflater.from(this).inflate(R.layout.loader, null);          
          ...
      }

Load your loader XML and save it to variable. set argument "attachToParent" to null.

## 4. Add Loader XML to Root ViewGroup when Necessary
    
      root.addView(loader);

just use function called "addView" in ViewGroup and set the loader inside this argument

## 5. Remove Loader XML from Root ViewGroup when Needed

    root.removeView(loader);

just use function called "removeView" in ViewGroup and set the loader inside this argument to remove the specific view from ViewGroup
        
