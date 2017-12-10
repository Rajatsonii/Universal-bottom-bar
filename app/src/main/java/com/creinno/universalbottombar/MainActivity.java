package com.creinno.universalbottombar;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.creinno.universalbottombar.fragment.CartFragment;
import com.creinno.universalbottombar.fragment.FavouriteFragment;
import com.creinno.universalbottombar.fragment.ListingFragment;
import com.creinno.universalbottombar.fragment.MapFragment;
import com.creinno.universalbottombar.fragment.ProfileFragment;


/**
 * Created by Rajat on 7/5/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivMenu, ivList, ivFavourite, ivProfile, ivCart;
    private LinearLayout llDrawer;
    private RelativeLayout rlTransparentPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llDrawer = (LinearLayout) findViewById(R.id.ll_drawer);

        ivMenu = (ImageView) findViewById(R.id.iv_menu);
        ivMenu.setOnClickListener(this);
        ivList = (ImageView) findViewById(R.id.iv_list);
        ivList.setOnClickListener(this);
        ivFavourite = (ImageView) findViewById(R.id.iv_favourite);
        ivFavourite.setOnClickListener(this);
        ivProfile = (ImageView) findViewById(R.id.iv_profile);
        ivProfile.setOnClickListener(this);
        ivCart = (ImageView) findViewById(R.id.iv_cart);
        ivCart.setOnClickListener(this);

        rlTransparentPart = (RelativeLayout) findViewById(R.id.rl_transparentpPart);
        rlTransparentPart.setOnClickListener(this);


        ChangeFragment(1);

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void ChangeFragment(int mPos) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        switch (mPos) {
            case 1://List
                ft.replace(R.id.container, ListingFragment.newInstance(""));
                break;
            case 2://Map
                ft.replace(R.id.container, MapFragment.newInstance(""));
                break;
            case 3://Fav
                ft.replace(R.id.container, FavouriteFragment.newInstance(""));
                break;
            case 4://Profile
                ft.replace(R.id.container, ProfileFragment.newInstance(""));
                break;
            case 5://Cart
                ft.replace(R.id.container, CartFragment.newInstance(""));
                break;

            default:
                break;
        }
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_menu:
                if (ivMenu.isSelected()) {
                    closeDrawer();
                    ivMenu.setSelected(false);
                } else {
                    openDrawer();
                    ivMenu.setSelected(true);
                }
                break;
            case R.id.iv_list:
                if (ivMenu.isSelected()) {
                    ivMenu.setSelected(false);
                    closeDrawer();
                }

                if (ivFavourite.isSelected()) {
                    ivFavourite.setSelected(false);
                }
                if (ivProfile.isSelected()) {
                    ivProfile.setSelected(false);
                }
                if (ivCart.isSelected()) {
                    ivCart.setSelected(false);
                }

                if (ivList.isSelected()) {
                    ChangeFragment(1);
                    ivList.setSelected(false);
                } else {
                    ChangeFragment(2);
                    ivList.setSelected(true);
                }

                break;
            case R.id.iv_favourite:
                if (ivMenu.isSelected()) {
                    ivMenu.setSelected(false);
                    closeDrawer();
                }

                if (ivProfile.isSelected()) {
                    ivProfile.setSelected(false);
                }
                if (ivCart.isSelected()) {
                    ivCart.setSelected(false);
                }

                if (!ivFavourite.isSelected()) {
                    ChangeFragment(3);
                    ivFavourite.setSelected(true);
                }
                break;

            case R.id.iv_profile:
                if (ivMenu.isSelected()) {
                    ivMenu.setSelected(false);
                    closeDrawer();
                }
                if (ivFavourite.isSelected()) {
                    ivFavourite.setSelected(false);
                }

                if (ivCart.isSelected()) {
                    ivCart.setSelected(false);
                }

                if (!ivProfile.isSelected()) {
                    ChangeFragment(4);
                    ivProfile.setSelected(true);
                }

                break;
            case R.id.iv_cart:

                if (ivMenu.isSelected()) {
                    ivMenu.setSelected(false);
                    closeDrawer();
                }
                if (ivFavourite.isSelected()) {
                    ivFavourite.setSelected(false);
                }
                if (ivProfile.isSelected()) {
                    ivProfile.setSelected(false);
                }

                if (!ivCart.isSelected()) {
                    ChangeFragment(5);
                    ivCart.setSelected(true);
                }

                break;

            case R.id.rl_transparentpPart:
                if (ivMenu.isSelected()) {
                    ivMenu.setSelected(false);
                    closeDrawer();
                }
                break;

        }
    }


    private void closeDrawer() {
        Animation RightSwipe = AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_to_left);
        RightSwipe.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                llDrawer.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        llDrawer.startAnimation(RightSwipe);
        llDrawer.setVisibility(View.GONE);
    }

    private void openDrawer() {
        llDrawer.setVisibility(View.VISIBLE);
        Animation RightSwipe = AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_to_right);
        llDrawer.startAnimation(RightSwipe);
    }


}