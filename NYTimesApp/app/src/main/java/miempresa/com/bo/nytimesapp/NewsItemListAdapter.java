package miempresa.com.bo.nytimesapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import java.util.List;

public class NewsItemListAdapter extends RecyclerView.Adapter<NewsItemListAdapter.NewsItemListViewHolder> {

    private List<NewsItem> lista;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public NewsItemListAdapter(List<NewsItem> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public NewsItemListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news, parent, false);
        return new NewsItemListAdapter.NewsItemListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsItemListViewHolder holder, int position) {
        final NewsItem news = lista.get(position);
        holder.txtTitle.setText(news.getHeadline());
        holder.txtDate.setText(news.getPub_date());
        holder.txtSource.setText(news.getSource());
        if (news.getUrl_image_thumbnail().length()>0){
            Picasso.with(context).load(ConstantsRestApi.URL_IMAGE + news.getUrl_image_thumbnail()).into(holder.imageView);
        } else {
            holder.imageView.setImageResource(R.drawable.no_image);
        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(news);
            }
        };
        holder.txtTitle.setOnClickListener(listener);
        holder.txtDate.setOnClickListener(listener);
        holder.txtSource.setOnClickListener(listener);
        holder.imageView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }

    public static class NewsItemListViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private TextView txtDate;
        private TextView txtSource;
        private ImageView imageView;

        public NewsItemListViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_news_title);
            txtDate =( TextView) itemView.findViewById(R.id.txt_news_date);
            txtSource =( TextView) itemView.findViewById(R.id.txt_news_source);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
