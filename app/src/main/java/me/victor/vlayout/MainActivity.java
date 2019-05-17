package me.victor.vlayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 0);
        DelegateAdapter adapters = new DelegateAdapter(layoutManager, true);
        OnePlusNLayoutHelper onePlusNHelper = new OnePlusNLayoutHelper();
//        onePlusNHelper.setColWeights(new float[]{50.0f});
//        onePlusNHelper.setAspectRatio(2.0f);
        adapters.addAdapter(new GridAdapter(getResources().getIntArray(R.array.list_5), onePlusNHelper));
        LinearLayoutHelper linearHelper = new LinearLayoutHelper(20);
        adapters.addAdapter(new LinearAdapter(getResources()
                .getIntArray(R.array.list_1), linearHelper));
        ColumnLayoutHelper columnHelper = new ColumnLayoutHelper();
        columnHelper.setWeights(new float[]{50.0f, 50.0f});
        adapters.addAdapter(new GridAdapter(getResources().getIntArray(R.array.list_2), columnHelper));
        ColumnLayoutHelper columnHelper2 = new ColumnLayoutHelper();
        columnHelper2.setWeights(new float[]{33.33f, 33.33f, 33.33f});
        adapters.addAdapter(new GridAdapter(getResources().getIntArray(R.array.list_3), columnHelper2));
        ColumnLayoutHelper columnHelper3 = new ColumnLayoutHelper();
        columnHelper3.setWeights(new float[]{25.0f, 25.0f, 25.0f, 25.0f});
        adapters.addAdapter(new GridAdapter(getResources().getIntArray(R.array.list_4), columnHelper3));
        ColumnLayoutHelper columnHelper4 = new ColumnLayoutHelper();
        columnHelper4.setWeights(new float[]{20.0f, 20.0f, 20.0f, 20.0f, 20.0f});
        adapters.addAdapter(new GridAdapter(getResources().getIntArray(R.array.list_5), columnHelper4));
        ColumnLayoutHelper columnHelper5 = new ColumnLayoutHelper();
        columnHelper5.setWeights(new float[]{16.66f, 16.66f, 16.66f, 16.66f, 16.66f, 16.66f});
        adapters.addAdapter(new GridAdapter(getResources().getIntArray(R.array.list_6), columnHelper5));
        ColumnLayoutHelper columnHelper6 = new ColumnLayoutHelper();
        columnHelper6.setWeights(new float[]{14.28f, 14.28f, 14.28f, 14.28f, 14.28f, 14.28f});
        adapters.addAdapter(new GridAdapter(getResources().getIntArray(R.array.list_7), columnHelper6));
        GridLayoutHelper gridHelper = new GridLayoutHelper(4);
        gridHelper.setGap(20);
        adapters.addAdapter(new GridAdapter(getResources()
                .getIntArray(R.array.list_8), gridHelper));
        StaggeredGridLayoutHelper staggeredGridHelper = new StaggeredGridLayoutHelper(3);
        adapters.addAdapter(new StaggeredGridAdapter(getResources().getIntArray(R.array.list_9),
                staggeredGridHelper));
        recyclerView.setAdapter(adapters);
    }

    public class LinearAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {
        private LayoutHelper mHelper;
        private int[] mData;

        LinearAdapter(int[] mData, LayoutHelper helper) {
            this.mData = mData;
            this.mHelper = helper;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return mHelper;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_linear_layout, parent, false);
            return new RecyclerViewItemHolder(view);
        }

        @SuppressLint("Recycle")
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            RecyclerViewItemHolder recyclerViewHolder = (RecyclerViewItemHolder) holder;
            recyclerViewHolder.iv_icon.setImageResource(getResources()
                    .obtainTypedArray(R.array.list_1).getResourceId(position, 0));
        }

        @Override
        public int getItemCount() {
            return mData.length;
        }

        private class RecyclerViewItemHolder extends RecyclerView.ViewHolder {
            ImageView iv_icon;

            RecyclerViewItemHolder(View itemView) {
                super(itemView);
                iv_icon = itemView.findViewById(R.id.iv_linear);
            }
        }
    }

    public class GridAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {
        private LayoutHelper mHelper;
        private int[] mData;

        GridAdapter(int[] mData, LayoutHelper helper) {
            this.mData = mData;
            this.mHelper = helper;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return mHelper;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_grid_layout, parent, false);
            return new RecyclerViewItemHolder(view);
        }

        @SuppressLint("Recycle")
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            RecyclerViewItemHolder recyclerViewHolder = (RecyclerViewItemHolder) holder;
            recyclerViewHolder.iv_icon.setImageResource(getResources()
                    .obtainTypedArray(R.array.list_8).getResourceId(position, 0));
        }

        @Override
        public int getItemCount() {
            return mData.length;
        }

        private class RecyclerViewItemHolder extends RecyclerView.ViewHolder {
            ImageView iv_icon;

            RecyclerViewItemHolder(View itemView) {
                super(itemView);
                iv_icon = itemView.findViewById(R.id.iv_grid);
            }
        }
    }

    public class StaggeredGridAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {
        private LayoutHelper mHelper;
        private int[] mData;

        StaggeredGridAdapter(int[] mData, LayoutHelper helper) {
            this.mData = mData;
            this.mHelper = helper;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return mHelper;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_stag_layout, parent, false);
            return new RecyclerViewItemHolder(view);
        }

        @SuppressLint("Recycle")
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            RecyclerViewItemHolder recyclerViewHolder = (RecyclerViewItemHolder) holder;
            ViewGroup.LayoutParams layoutParams = recyclerViewHolder.iv_head.getLayoutParams();
            layoutParams.height = 260 + position * 50;
            recyclerViewHolder.iv_head.setLayoutParams(layoutParams);
            recyclerViewHolder.iv_head.setImageResource(getResources()
                    .obtainTypedArray(R.array.list_9).getResourceId(position, 0));
        }

        @Override
        public int getItemCount() {
            return mData.length;
        }

        private class RecyclerViewItemHolder extends RecyclerView.ViewHolder {
            ImageView iv_head;

            RecyclerViewItemHolder(View itemView) {
                super(itemView);
                iv_head = itemView.findViewById(R.id.iv_head);
            }
        }
    }
}
