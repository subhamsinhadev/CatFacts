package subham.sinha.dev.CatFacts;


import subham.sinha.dev.CatFacts.R;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

public class SubhamUtils {

private static MediaPlayer FnmodsmediaPlayer = null;
    public static final String TAG = "ToolFnmods";

    
	public static void Subham_Toast(Context context, CharSequence msg) {
		GradientDrawable gd= new GradientDrawable();
		gd.setColor(Color.parseColor("#FF2D3538"));
		gd.setCornerRadius(20);
		Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
		View toastView = toast.getView(); // This'll return the default View of the Toast.

		/* And now you can get the TextView of the default View of the Toast. */
		TextView toastMessage = (TextView) toastView.findViewById(android.R.id.message);

		toastMessage.setTextColor(Color.WHITE);
		toastMessage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.subham_toast, 0, 0, 0);
		toastMessage.setGravity(Gravity.CENTER);
		toastMessage.setCompoundDrawablePadding(16);
		toastView.setBackgroundDrawable(gd);
		toast.show();



    } 
    
    
       
    public static int getAnim(Context context, String str) {
        return context.getResources().getIdentifier(str, "anim", context.getPackageName());
    }

    public static int getAttr(Context context, String str) {
        return context.getResources().getIdentifier(str, "attr", context.getPackageName());
    }

    public static int getBool(Context context, String str) {
        return context.getResources().getIdentifier(str, "bool", context.getPackageName());
    }

    public static int getColor(Context context, String str) {
        return context.getResources().getIdentifier(str, "color", context.getPackageName());
    }

    public static int getDimen(Context context, String str) {
        return context.getResources().getIdentifier(str, "dimen", context.getPackageName());
    }

    public static int getDrawable(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    public static int getFnmodsLibraryTool(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static int getId(Context context, String str) {
        return context.getResources().getIdentifier(str, "id", context.getPackageName());
    }

    public static int getLayout(Context context, String str) {
        return context.getResources().getIdentifier(str, "layout", context.getPackageName());
    }

    public static int getManu(Context context, String str) {
        return context.getResources().getIdentifier(str, "menu", context.getPackageName());
    }

    public static int getString(Context context, String str) {
        return context.getResources().getIdentifier(str, "string", context.getPackageName());
    }

    public static int getStyle(Context context, String str) {
        return context.getResources().getIdentifier(str, "style", context.getPackageName());
    }

    public static int getStyleable(Context context, String str) {
        return context.getResources().getIdentifier(str, "styleable", context.getPackageName());
    }

    public static void getToast(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static void getToastCustom(Context context, String str) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        linearLayout.setPadding(20, 20, 20, 20);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setStroke(2, Color.parseColor("#FF00B489"));
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextSize(14.0f);
        textView.setTextColor(Color.parseColor("#212121"));
        linearLayout.addView(textView);
        Toast toast = new Toast(context);
        toast.setView(linearLayout);
        toast.show();
    }

    public static int getXml(Context context, String str) {
        return context.getResources().getIdentifier(str, "xml", context.getPackageName());
    }

    public static void openAssetMusics(Context context, String str) {
        try {
            AssetFileDescriptor openFd = context.getAssets().openFd(str);
            FnmodsmediaPlayer = new MediaPlayer();
            FnmodsmediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            FnmodsmediaPlayer.prepare();
            FnmodsmediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
