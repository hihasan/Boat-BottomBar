package com.hihasan.boat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class Main extends AppCompatActivity {
    private static final String TAG = Main.class.getSimpleName();
    private AppCompatImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        imageView = findViewById (R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_home));

        ExpandableBottomBar bottomBar = findViewById(R.id.expandable_bottom_bar);
        Menu menu = bottomBar.getMenu();

        menu.add(new MenuItemDescriptor.Builder(this, R.id.icon_home, R.drawable.ic_home, R.string.text, getResources().getColor(R.color.red)).build());

        menu.add(new MenuItemDescriptor.Builder(this, R.id.icon_likes, R.drawable.ic_likes, R.string.text2, getResources().getColor(R.color.red)).build());

        menu.add(new MenuItemDescriptor.Builder(this, R.id.icon_bookmarks, R.drawable.ic_bookmarks, R.string.text3, getResources().getColor(R.color.red)).build());

        menu.add(new MenuItemDescriptor.Builder(this, R.id.icon_settings, R.drawable.ic_settings, R.string.text4, getResources().getColor(R.color.red)).build());

        bottomBar.setOnItemSelectedListener((view, item, byUser) -> {
            switch (item.getId()){
                case R.id.icon_home:
                    System.out.println(1);
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_home));
                    break;

                    case R.id.icon_likes:
                        System.out.println(2);
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_likes));
                        break;

                case R.id.icon_bookmarks:
                    System.out.println(3);
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_bookmarks));
                    break;

                case R.id.icon_settings:
                    System.out.println(4);
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_settings));
                    break;
            }
            Log.d(TAG, "selected: " + item.toString());
            return null;
        });

        bottomBar.setOnItemReselectedListener((view, item, byUser) -> {
            switch (item.getId()){
                case R.id.icon_home:
                    System.out.println(1);
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_home));
                    break;

                case R.id.icon_likes:
                    System.out.println(2);
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_likes));
                    break;

                case R.id.icon_bookmarks:
                    System.out.println(3);
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_bookmarks));
                    break;

                case R.id.icon_settings:
                    System.out.println(4);
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_settings));
                    break;
            }
            Log.d(TAG, "reselected: " + item.toString());
            return null;
        });

    }
}
