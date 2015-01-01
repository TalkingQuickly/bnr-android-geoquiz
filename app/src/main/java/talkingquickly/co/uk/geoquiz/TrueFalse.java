package talkingquickly.co.uk.geoquiz;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by ben on 30/12/2014.
 */
public class TrueFalse implements Parcelable{

    private static final String TAG = "TrueFalse";

    private int mQuestion;
    private boolean mTrueQuestion;
    private boolean mCheated;

    public boolean isCheated() {
        return mCheated;
    }

    public void setCheated(boolean cheated) {
        mCheated = cheated;
    }

    public TrueFalse(int question, boolean trueQuestion) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
        mCheated = false;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }

    // Parcelling part
    public TrueFalse(Parcel in){
        Log.d(TAG, "Reading from Parcel");
        this.mQuestion = in.readInt();
        this.mTrueQuestion = in.readByte() != 0;
        this.mCheated = in.readByte() != 0;
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.d(TAG, "Writing to Parcel");
        dest.writeInt(mQuestion);
        dest.writeByte((byte) (mTrueQuestion ? 1 : 0));
        dest.writeByte((byte) (mCheated ? 1 : 0));
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public TrueFalse createFromParcel(Parcel in) {
            return new TrueFalse(in);
        }

        public TrueFalse[] newArray(int size) {
            return new TrueFalse[size];
        }
    };
}
