package ck.itheima.com.phoneplay.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import ck.itheima.com.phoneplay.R;
import ck.itheima.com.phoneplay.beans.YueDanListBean;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

import static ck.itheima.com.phoneplay.R.id.mv_image;

/**
 * 类名:    YueDanListItemView
 * 创建者:  ckqu
 * 创建时间:2017/1/18 0018 下午 9:06
 * 包名:    ck.itheima.com.phoneplay.widget
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class YueDanListItemView extends RelativeLayout {
    @BindView(mv_image)
    ImageView mMvImage;
    @BindView(R.id.avatar)
    ImageView mAvatar;
    @BindView(R.id.title)
    TextView  mTitle;
    @BindView(R.id.author)
    TextView  mAuthor;
    @BindView(R.id.mv_count)
    TextView  mMvCount;

    public YueDanListItemView(Context context) {
        this(context, null);
    }

    public YueDanListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yue_list_item, this);
        ButterKnife.bind(this, this);
    }


    public void bingView(YueDanListBean.PlayListsBean playListsBean) {

        //刷新标题
        mTitle.setText(playListsBean.getTitle());
        //刷新悦单创建者昵称
        mAuthor.setText(playListsBean.getCreator().getNickName());
        //刷新mv个数
        String count = String.format(getContext().getString(R.string.mv_count), playListsBean.getVideoCount());//格式化字符串
        mMvCount.setText(count);

        Picasso.with(getContext()).load(playListsBean.getCreator().getLargeAvatar()).transform(new CropCircleTransformation())
                .into(mAvatar);

        Picasso.with(getContext()).load(playListsBean.getPlayListBigPic()).into(mMvImage);
    }
       //网上拷贝的代码
/*    public class CircleTransform implements Transformation {
        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());

            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
            if (squaredBitmap != source) {
                source.recycle();//回收垃圾
            }

            Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            BitmapShader shader = new BitmapShader(squaredBitmap,
                    BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);//定义一个渲染器
            paint.setShader(shader);//设置渲染器
            paint.setAntiAlias(true);

            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);//绘制图形

            squaredBitmap.recycle();
            return bitmap;
        }

        @Override
        public String key() {
            return "circle";
        }
    }*/
}
