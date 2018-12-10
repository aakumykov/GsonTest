package ru.aakumykov.me.gsontest.boards_list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.aakumykov.me.gsontest.R;
import ru.aakumykov.me.gsontest.models.BoardsList.BoardsTOCItem;

public class BoardsListAdapter extends ArrayAdapter<BoardsTOCItem> {

    private LayoutInflater inflater;
    private int layout;
    private List<BoardsTOCItem> lsit;

    BoardsListAdapter(Context context, int resource, List<BoardsTOCItem> lsit) {
        super(context, resource, lsit);
        this.lsit = lsit;
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

        BoardsTOCItem boardsTOCItem = lsit.get(position);

        viewHolder.titleView.setText(boardsTOCItem.getName());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.titleView) TextView titleView;

        ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
