package no.westerdals.pg4600.testingexercise;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class GreetingActivityTest {
    @Rule
    public ActivityTestRule<GreetingActivity> activityRule = new ActivityTestRule<>(GreetingActivity.class);

    @Before
    public void startActivity() {
        activityRule.getActivity();
    }

    @Test
    public void flow() {
        final String name = "Liam";
        final String expectedMessage = "Hello, " + name + "!";

        onView(withId(R.id.nameEditText))
                .perform(typeText(name), closeSoftKeyboard());

        onView(withId(R.id.greetButton))
                .perform(click());

        onView(withId(R.id.greetingTextView))
                .check(matches(withText(expectedMessage)));
    }
}