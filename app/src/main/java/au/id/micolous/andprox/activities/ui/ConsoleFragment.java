package au.id.micolous.andprox.activities.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import au.id.micolous.andprox.R;

public class ConsoleFragment extends Fragment {
    private static String text = "";
    private static ConsoleFragment current;

    public static void appendCommand(String cmd) {
        append(">" + cmd + "\n");
    }

    public static void append(String text) {
        ConsoleFragment.text += text;

        if(current != null) {
            current.textView.setText(ConsoleFragment.text);
            current.scrollView.post(() -> current.scrollView.fullScroll(ScrollView.FOCUS_DOWN));
        }
    }

    private ScrollView scrollView;
    private TextView textView;

    public ConsoleFragment() {
    }

    public static ConsoleFragment newInstance() {
        ConsoleFragment fragment = new ConsoleFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ConsoleFragment.current = this;

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_console, container, false);
        textView = (TextView) ((ViewGroup) view.getChildAt(0)).getChildAt(0);
        textView.setText(text);
        textView.setMovementMethod(new ScrollingMovementMethod());

        scrollView = (ScrollView) view;
        scrollView.post(() -> current.scrollView.fullScroll(ScrollView.FOCUS_DOWN));

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
