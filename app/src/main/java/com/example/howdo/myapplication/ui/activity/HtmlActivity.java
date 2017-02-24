package com.example.howdo.myapplication.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;
import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.base.BaseActivity;
import java.io.InputStream;
import java.net.URL;

import butterknife.BindView;
/**
 * Created by howdo on 16/10/27.
 */
public class HtmlActivity extends BaseActivity {
    @BindView(R.id.tv_text_pic)
    TextView htmlToTextPic;

    @Override
    protected int getLayoutId() {
        return R.layout.html_text_picture;
    }

    String text = "<p class=\"1\" style=\"margin-top:0cm;margin-right:0cm;margin-bottom:6.0pt;\n" +
            "margin-left:0cm;text-align:justify;text-justify:inter-ideograph;text-indent:\n" +
            "0cm;mso-char-indent-count:0\"><span style=\"font-size:12.0pt;font-family:宋体;\n" +
            "mso-ascii-font-family:&quot;Times New Roman&quot;\">在一列数<img alt=\"\" src=\"http://oap5h7kmq.bkt.clouddn.com/banks_7340c617c9d3343e525f675d00c38d6b.png\" style=\"width: 63px; height: 17px;\" /></span><span lang=\"EN-US\" style=\"font-size:12.0pt\"><span style=\"position:relative;top:5.0pt;mso-text-raise:\n" +
            "-5.0pt\"><!--[if gte vml 1]><v:shapetype id=\"_x0000_t75\" coordsize=\"21600,21600\"\n" +
            " o:spt=\"75\" o:preferrelative=\"t\" path=\"m@4@5l@4@11@9@11@9@5xe\" filled=\"f\"\n" +
            " stroked=\"f\">\n" +
            " <v:stroke joinstyle=\"miter\"/>\n" +
            " <v:formulas>\n" +
            "  <v:f eqn=\"if lineDrawn pixelLineWidth 0\"/>\n" +
            "  <v:f eqn=\"sum @0 1 0\"/>\n" +
            "  <v:f eqn=\"sum 0 0 @1\"/>\n" +
            "  <v:f eqn=\"prod @2 1 2\"/>\n" +
            "  <v:f eqn=\"prod @3 21600 pixelWidth\"/>\n" +
            "  <v:f eqn=\"prod @3 21600 pixelHeight\"/>\n" +
            "  <v:f eqn=\"sum @0 0 1\"/>\n" +
            "  <v:f eqn=\"prod @6 1 2\"/>\n" +
            "  <v:f eqn=\"prod @7 21600 pixelWidth\"/>\n" +
            "  <v:f eqn=\"sum @8 21600 0\"/>\n" +
            "  <v:f eqn=\"prod @7 21600 pixelHeight\"/>\n" +
            "  <v:f eqn=\"sum @10 21600 0\"/>\n" +
            " </v:formulas>\n" +
            " <v:path o:extrusionok=\"f\" gradientshapeok=\"t\" o:connecttype=\"rect\"/>\n" +
            " <o:lock v:ext=\"edit\" aspectratio=\"t\"/>\n" +
            "</v:shapetype><v:shape id=\"对象_x0020_204\" o:spid=\"_x0000_i1025\" type=\"#_x0000_t75\"\n" +
            " style='width:52pt;height:16pt;mso-position-horizontal-relative:page;\n" +
            " mso-position-vertical-relative:page' o:ole=\"\">\n" +
            " <v:imagedata src=\"file://localhost/Users/leeang/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image001.wmz\"\n" +
            "  o:title=\"\"/>\n" +
            "</v:shape><![endif]--><!--[if !vml]--><!--[endif]--></span><!--[if gte mso 9]><xml>\n" +
            " <o:OLEObject Type=\"Embed\" ProgID=\"Equation.DSMT4\" ShapeID=\"对象_x0020_204\"\n" +
            "  DrawAspect=\"Content\" ObjectID=\"_1535964375\">\n" +
            " </o:OLEObject>\n" +
            "</xml><![endif]--></span><span style=\"font-size:12.0pt;font-family:宋体;\n" +
            "mso-ascii-font-family:&quot;Times New Roman&quot;\">中，已知</span><span lang=\"EN-US\" style=\"font-size:12.0pt\"><span style=\"position:relative;top:11.0pt;mso-text-raise:\n" +
            "-11.0pt\"><!--[if gte vml 1]><v:shape id=\"对象_x0020_205\" o:spid=\"_x0000_i1026\"\n" +
            " type=\"#_x0000_t75\" style='width:37pt;height:28pt;\n" +
            " mso-position-horizontal-relative:page;mso-position-vertical-relative:page'\n" +
            " o:ole=\"\">\n" +
            " <v:imagedata src=\"file://localhost/Users/leeang/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image003.wmz\"\n" +
            "  o:title=\"\"/>\n" +
            "</v:shape><![endif]--><!--[if !vml]--><!--[endif]--></span><!--[if gte mso 9]><xml>\n" +
            " <o:OLEObject Type=\"Embed\" ProgID=\"Equation.DSMT4\" ShapeID=\"对象_x0020_205\"\n" +
            "  DrawAspect=\"Content\" ObjectID=\"_1535964376\">\n" +
            " </o:OLEObject>\n" +
            "</xml><![endif]--></span><span style=\"font-size:12.0pt;font-family:宋体;\n" +
            "mso-ascii-font-family:&quot;Times New Roman&quot;\"><img alt=\"\" src=\"http://oap5h7kmq.bkt.clouddn.com/banks_b9c0860a57fb60d896fd40fd96740e33.png\" style=\"width: 47px; height: 32px;\" />，从第二个数起，每个数都等</span><span lang=\"EN-US\" style=\"font-size:12.0pt\">于&ldquo;1&rdquo;</span><span style=\"font-size:12.0pt;font-family:宋体;\n" +
            "mso-ascii-font-family:&quot;Times New Roman&quot;\">与它前面的那个数的差的倒数</span></p>\n" +
            "\n" +
            "<p>⑴ 求<img alt=\"\" src=\"http://oap5h7kmq.bkt.clouddn.com/banks_4e11140150a0808a62f1881d8d00c8dd.png\" style=\"width: 53px; height: 19px;\" />的值</p>\n" +
            "\n" +
            "<p>⑵ 根据以上计算结果，求<img alt=\"\" src=\"http://oap5h7kmq.bkt.clouddn.com/banks_5b8eb2d1d4e9e1d8387168c2b656b52f.png\" style=\"width: 47px; height: 18px;\" />的值</p>\n" +
            "\n" +
            "<p class=\"1\" style=\"margin-top:0cm;margin-right:0cm;margin-bottom:6.0pt;\n" +
            "margin-left:0cm;text-align:justify;text-justify:inter-ideograph;text-indent:\n" +
            "0cm;mso-char-indent-count:0\"><span lang=\"EN-US\" style=\"font-size:12.0pt\"><o:p></o:p></span></p>\n" +
            "";

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        initData();
    }

    private void initData(){
        new Thread(){
            @Override
            public void run(){
                final Spanned spanned = Html.fromHtml(text, new MyImageGetter(), null);
                htmlToTextPic.post(new Runnable(){
                    @Override
                    public void run(){
                        htmlToTextPic.setText(spanned);
                    }
                });
            }
        }.start();
    }

    /**
     * ImageGetter类的实现
     * 当系统解析到<img>标签时就会调用imageGetter对象的getDrawable方法，
     * 并将src属性值传递传入getDrawable方法。
     */
    class MyImageGetter implements Html.ImageGetter {
        @Override
        public Drawable getDrawable(String source) {
            Drawable drawable = null;
            try {
                URL ulr = new URL(source);
                InputStream inputStream = ulr.openStream();
                drawable = Drawable.createFromStream(inputStream, "");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth()*7, drawable.getIntrinsicHeight()*9);
            }

            return drawable;
        }
    }
}
