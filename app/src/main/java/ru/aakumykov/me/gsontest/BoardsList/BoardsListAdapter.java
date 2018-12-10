package ru.aakumykov.me.gsontest.BoardsList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.aakumykov.me.gsontest.R;
import ru.aakumykov.me.gsontest.models.BoardsList.BoardsTOCItem;

public class BoardsListAdapter extends ArrayAdapter<BoardsTOCItem> {

    private LayoutInflater inflater;
    private int layout;
    private List<BoardsTOCItem> boardsList;

    public BoardsListAdapter(Context context, int resource, List<BoardsTOCItem> boardsList) {
        super(context, resource, boardsList);
        this.boardsList = boardsList;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        BoardsTOCItem boardsTOCItem = boardsList.get(position);

//        viewHolder.imageView.setImageResource(state.getFlagResource());
//        viewHolder.nameView.setText(state.getName());
//        viewHolder.capitalView.setText(state.getCapital());

        viewHolder.titleView.setText(boardsTOCItem.getName());

        return convertView;
    }

//    private class ViewHolder {
    public static class ViewHolder {
        @BindView(R.id.titleView) TextView titleView;
//        final ImageView imageView;
//        final TextView nameView, capitalView;
        ViewHolder(View view){
            ButterKnife.bind(this, view);
//            imageView = (ImageView)view.findViewById(R.id.flag);
//            nameView = (TextView) view.findViewById(R.id.name);
//            capitalView = (TextView) view.findViewById(R.id.capital);
        }
    }
}
