import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // Initialize ViewPager and TabLayout
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        // Set up ViewPager with a FragmentPagerAdapter
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @Override
            public Fragment getItem(int position) {
                // Return new instances of WeatherAndForecastFragment
                return new WeatherAndForecastFragment();
            }

            @Override
            public int getCount() {
                return 3; // 3 fragments for 3 tabs
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "Tab 1";
                    case 1:
                        return "Tab 2";
                    case 2:
                        return "Tab 3";
                    default:
                        return null;
                }
            }
        });

        // Connect TabLayout with ViewPager
        tabLayout.setupWithViewPager(viewPager);
    }
}
