package snap.helper.with.vertical.gravity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.widget.Toast;
import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView topSnapRecyclerView,bottomSnapRecyclerView;
    private ArrayList<RecyclerViewItemModel> recyclerViewItemModelArrayList;
    private RecyclerViewAdapterVertical recyclerViewAdapterVertical;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
        createData();
        setRecyclerViewItem();
    }

    private void initView()
    {
        topSnapRecyclerView     =   findViewById(R.id.topSnapRecyclerView);
        bottomSnapRecyclerView  =   findViewById(R.id.bottomSnapRecyclerView);
    }

    private void createData()
    {
        recyclerViewItemModelArrayList = new ArrayList<>();
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("WhatsApp", R.drawable.ic_whatsapp));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Skype", R.drawable.ic_skype));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Facebook", R.drawable.ic_facebook));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Google+", R.drawable.ic_gplus));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Instagram", R.drawable.ic_instagram));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("LinkedIn", R.drawable.ic_linkedin));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Quora", R.drawable.ic_quora));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Twitter", R.drawable.ic_twitter));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Tumblr", R.drawable.ic_tumblr));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Email", R.drawable.ic_email));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Gallery", R.drawable.ic_gallery));
    }

    private void setRecyclerViewItem()
    {
        topSnap();
        bottomSnap();
    }

    private void topSnap()
    {
        topSnapRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        topSnapRecyclerView.setHasFixedSize(true);
        topSnapRecyclerView.setItemAnimator(new DefaultItemAnimator());

        /**
         * Default Gravity.TOP
         */
        SnapHelper snapHelperEnd = new GravitySnapHelper(Gravity.TOP);
        snapHelperEnd.attachToRecyclerView(topSnapRecyclerView);

        recyclerViewAdapterVertical =new RecyclerViewAdapterVertical(RecyclerViewActivity.this,recyclerViewItemModelArrayList);
        topSnapRecyclerView.setAdapter(recyclerViewAdapterVertical);
    }

    private void bottomSnap()
    {
        bottomSnapRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        bottomSnapRecyclerView.setHasFixedSize(true);
        bottomSnapRecyclerView.setItemAnimator(new DefaultItemAnimator());

        /**
         * Gravity.BOTTOM
         */
        SnapHelper snapHelperEnd = new GravitySnapHelper(Gravity.BOTTOM);
        snapHelperEnd.attachToRecyclerView(bottomSnapRecyclerView);

        recyclerViewAdapterVertical =new RecyclerViewAdapterVertical(RecyclerViewActivity.this,recyclerViewItemModelArrayList);
        bottomSnapRecyclerView.setAdapter(recyclerViewAdapterVertical);
    }
}