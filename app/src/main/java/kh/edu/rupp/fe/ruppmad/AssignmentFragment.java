package kh.edu.rupp.fe.ruppmad;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kh.edu.rupp.fe.ruppmad.DB.DbManager;
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

        View fragmentView = inflater.inflate(R.layout.fragment_assignment, container, false);

        //Reference to Recylcerview
        rclAssignment = (RecyclerView)fragmentView.findViewById(R.id.rcl_assignment);

        //Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rclAssignment.setLayoutManager(layoutManager);

        //Adapter
        adapter = new AssignmentAdapter(loadAssignment());
        adapter.setRecyclerViewItemClickListener(this);
        rclAssignment.setAdapter(adapter);

        return fragmentView;
    }

    // Temporary List of Assingment
    private Assignment[] loadAssignment(){
        DbManager dbManager = new DbManager(getActivity());
        return dbManager.getAllAssignments();
    }

    @Override
    public void onRecyclerViewItemClick(int position) {
        Log.d("rupp", "Recycler item click: " + position);
    }
}
