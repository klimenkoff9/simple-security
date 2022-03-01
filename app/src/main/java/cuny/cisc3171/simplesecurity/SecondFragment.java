package cuny.cisc3171.simplesecurity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

import cuny.cisc3171.simplesecurity.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    TextView button1;
    TextView button2;
    TextView button3;
    TextView button4;
    List<Integer> combo = new ArrayList<Integer>();
    boolean locked = true;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View fragmentLayout = inflater.inflate(R.layout.fragment_second, container, false);
        getActivity().setTitle("Access Control");
        button1 = fragmentLayout.findViewById(R.id.button_1);
        button2 = fragmentLayout.findViewById(R.id.button_1);
        button3 = fragmentLayout.findViewById(R.id.button_1);
        button4 = fragmentLayout.findViewById(R.id.button_1);


        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return fragmentLayout;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                combo.add(1);
            }
        });

        view.findViewById(R.id.button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                combo.add(2);
            }
        });

        view.findViewById(R.id.button_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                combo.add(3);
            }
        });

        view.findViewById(R.id.button_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                combo.add(4);
            }
        });

        view.findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(combo.toString().compareTo("[1, 2, 3, 4]") == 0 ) {
                    locked = false;
                }

                SecondFragmentDirections.ActionSecondFragmentToFirstFragment action = SecondFragmentDirections.actionSecondFragmentToFirstFragment();
                action.setLocked(locked);
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