package cuny.cisc3171.simplesecurity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import cuny.cisc3171.simplesecurity.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    TextView textView;


    //Inflate the layout for this fragment:w


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        // Get the count text view
        textView = fragmentFirstLayout.findViewById(R.id.textview_first);
        if(SecondFragmentArgs.fromBundle(getArguments()).getLocked()) {
            textView.setText("Welcome to the App! The App is LOCKED!");
        } else {
            textView.setText("The App is UNLOCKED!");
        }

        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.unlock_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });








    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}