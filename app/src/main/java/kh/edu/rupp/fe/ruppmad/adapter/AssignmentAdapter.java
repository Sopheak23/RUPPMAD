package kh.edu.rupp.fe.ruppmad.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kh.edu.rupp.fe.ruppmad.R;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {

    private Assignment[] assignments;
    private RecyclerViewItemClickListener recyclerViewItemClickListener;

    public AssignmentAdapter(Assignment[] assignment){
        this.assignments = assignment;
    }

    public void setAssignment(Assignment[] assignments) {
        this.assignments = assignments;
        notifyDataSetChanged();
    }

    public void setRecyclerViewItemClickListener(RecyclerViewItemClickListener recyclerViewItemClickListener) {
        this.recyclerViewItemClickListener = recyclerViewItemClickListener;
    }

    @Override
    public AssignmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_assignment, parent, false);
        AssignmentViewHolder viewHolder = new AssignmentViewHolder(holderView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AssignmentViewHolder holder, int position) {

        Assignment assignment = assignments[position];
        holder.txtTitle.setText(assignment.getTitle());
        holder.txtDeadline.setText(assignment.getFormatSize());

    }

    @Override
    public int getItemCount() {
        return assignments.length;
    }

    class AssignmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgThumbnail;
        private TextView txtTitle;
        private TextView txtDeadline;

        public AssignmentViewHolder(View itemView) {
            super(itemView);

            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            txtTitle = (TextView)itemView.findViewById(R.id.txt_title);
            txtDeadline = (TextView)itemView.findViewById(R.id.txt_deadline);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(recyclerViewItemClickListener != null){
                recyclerViewItemClickListener.onRecyclerViewItemClick(getAdapterPosition());
            }
        }
    }

}
