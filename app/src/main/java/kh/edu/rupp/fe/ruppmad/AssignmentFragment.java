package kh.edu.rupp.fe.ruppmad;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kh.edu.rupp.fe.ruppmad.adapter.Assignment;
import kh.edu.rupp.fe.ruppmad.adapter.AssignmentAdapter;
import kh.edu.rupp.fe.ruppmad.adapter.RecyclerViewItemClickListener;

/**
 * Created by MK COMPUTER on 5/5/2017.
 */

public class AssignmentFragment extends Fragment implements RecyclerViewItemClickListener{

    private RecyclerView rclAssignment;
    private AssignmentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentview = inflater.inflate(R.layout.fragment_assignment, container, false);

        //Reference to Recylcerview
        rclAssignment = (RecyclerView)fragmentview.findViewById(R.id.rcl_assignment);

        //Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rclAssignment.setLayoutManager(layoutManager);

        //Adapter
        adapter = new AssignmentAdapter(loadAssignment());
        adapter.setRecyclerViewItemClickListener(this);
        rclAssignment.setAdapter(adapter);

        return fragmentview;
    }

    // Temporary List of Assingment
    private Assignment[] loadAssignment(){
        Assignment a1 = new Assignment("Group Project", "", 1);
        Assignment a2 = new Assignment("Individual Project", "", 2);
        Assignment a3 = new Assignment("Project for the Free", "", 1);
        Assignment a4 = new Assignment("Good Old Project", "", 3);
        Assignment a5 = new Assignment("Badass Project", "", 2);
        Assignment[] assignment = {a1, a2, a3, a4, a5};
        return assignment;
    }

    @Override
    public void onRecyclerViewItemClick(int position) {
        Log.d("rupp", "Recycler item click: " + position);
    }
}
