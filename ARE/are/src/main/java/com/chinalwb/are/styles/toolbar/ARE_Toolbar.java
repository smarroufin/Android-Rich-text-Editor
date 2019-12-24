package com.chinalwb.are.styles.toolbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Layout.Alignment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chinalwb.are.AREditText;
import com.chinalwb.are.R;
import com.chinalwb.are.colorpicker.ColorPickerListener;
import com.chinalwb.are.colorpicker.ColorPickerView;
import com.chinalwb.are.styles.ARE_Alignment;
import com.chinalwb.are.styles.ARE_BackgroundColor;
import com.chinalwb.are.styles.ARE_Bold;
import com.chinalwb.are.styles.ARE_FontColor;
import com.chinalwb.are.styles.ARE_FontSize;
import com.chinalwb.are.styles.ARE_Fontface;
import com.chinalwb.are.styles.ARE_Hr;
import com.chinalwb.are.styles.ARE_IndentLeft;
import com.chinalwb.are.styles.ARE_IndentRight;
import com.chinalwb.are.styles.ARE_Italic;
import com.chinalwb.are.styles.ARE_Link;
import com.chinalwb.are.styles.ARE_ListBullet;
import com.chinalwb.are.styles.ARE_ListNumber;
import com.chinalwb.are.styles.ARE_Quote;
import com.chinalwb.are.styles.ARE_Strikethrough;
import com.chinalwb.are.styles.ARE_Subscript;
import com.chinalwb.are.styles.ARE_Superscript;
import com.chinalwb.are.styles.ARE_Underline;
import com.chinalwb.are.styles.IARE_Style;

import java.util.ArrayList;
import java.util.List;

/**
 * A fixed toolbar, for including only static tool items.
 * Not friendly for extending.
 * See {@link IARE_Toolbar} and {@link ARE_ToolbarDefault} for more info about dynamic toolbar.
 */
public class ARE_Toolbar extends LinearLayout {

	/**
	 * Request code for selecting an image.
	 */
	public static final int REQ_IMAGE = 1;

	/**
	 * Request code for choosing a people to @.
	 */
	public static final int REQ_AT = 2;

	/**
	 * Request code for choosing a video.
	 */
	public static final int REQ_VIDEO_CHOOSE = 3;

	/**
	 * Request code for inserting a video
	 */
	public static final int REQ_VIDEO = 4;


	private Activity mContext;

	private AREditText mEditText;

	/**
	 * Supported styles list.
	 */
	private ArrayList<IARE_Style> mStylesList = new ArrayList<>();

	/**
	 * Font-size Style
	 */
	private ARE_FontSize mFontsizeStyle;

	/**
	 * Font-face Style
	 */
	private ARE_Fontface mFontfaceStyle;

	/**
	 * Bold Style
	 */
	private ARE_Bold mBoldStyle;

	/**
	 * Italic Style
	 */
	private ARE_Italic mItalicStyle;

	/**
	 * Underline Style
	 */
	private ARE_Underline mUnderlineStyle;

	/**
	 * Strikethrough Style
	 */
	private ARE_Strikethrough mStrikethroughStyle;

	/**
	 * Horizontal rule style
	 */
	private ARE_Hr mHrStyle;

	/**
	 * Subscript Style
	 */
	private ARE_Subscript mSubscriptStyle;

	/**
	 * Superscript Style
	 */
	private ARE_Superscript mSuperscriptStyle;

	/**
	 * Quote style
	 */
	private ARE_Quote mQuoteStyle;

	/**
	 * Font color Style
	 */
	private ARE_FontColor mFontColorStyle;

	/**
	 * Background color Style
	 */
	private ARE_BackgroundColor mBackgroundColoStyle;

	/**
	 * Link Style
	 */
	private ARE_Link mLinkStyle;

	/**
	 * List number Style
	 */
	private ARE_ListNumber mListNumberStyle;

	/**
	 * List bullet Style
	 */
	private ARE_ListBullet mListBulletStyle;

	/**
	 * Indent to right Style.
	 */
	private ARE_IndentRight mIndentRightStyle;

	/**
	 * Indent to left Style.
	 */
	private ARE_IndentLeft mIndentLeftStyle;

	/**
	 * Align left.
	 */
	private ARE_Alignment mAlignLeft;

	/**
	 * Align center.
	 */
	private ARE_Alignment mAlignCenter;

	/**
	 * Align right.
	 */
	private ARE_Alignment mAlignRight;

	/**
	 * Absolute font size button.
	 */
	private ImageView mFontsizeImageView;

	/**
	 * Absolute font face button.
	 */
	private ImageView mFontfaceImageView;

	/**
	 * Bold button.
	 */
	private ImageView mBoldImageView;

	/**
	 * Italic button.
	 */
	private ImageView mItalicImageView;

	/**
	 * Underline button.
	 */
	private ImageView mUnderlineImageView;

	/**
	 * Strikethrough button.
	 */
	private ImageView mStrikethroughImageView;

	/**
	 * Horizontal rule button.
	 */
	private ImageView mHrImageView;

	/**
	 * Subscript button.
	 */
	private ImageView mSubscriptImageView;

	/**
	 * Superscript button.
	 */
	private ImageView mSuperscriptImageView;

	/**
	 * Quote button.
	 */
	private ImageView mQuoteImageView;

	/**
	 * The color palette.
	 */
	private ColorPickerView mColorPalette;

	/**
	 * Foreground color image view.
	 */
	private ImageView mFontColorImageView;

	/**
	 * Background button.
	 */
	private ImageView mBackgroundImageView;

	/**
	 * Add link button.
	 */
	private ImageView mLinkImageView;

	/**
	 * List number button.
	 */
	private ImageView mRteListNumber;

	/**
	 * List bullet button.
	 */
	private ImageView mRteListBullet;

	/**
	 * Increase. Indent to right.
	 */
	private ImageView mRteIndentRight;

	/**
	 * Align left.
	 */
	private ImageView mRteAlignLeft;

	/**
	 * Align center.
	 */
	private ImageView mRteAlignCenter;

	/**
	 * Align right.
	 */
	private ImageView mRteAlignRight;

	/**
	 * Decrease. Indent to left.
	 */
	private ImageView mRteIndentLeft;

	public ARE_Toolbar(Context context) {
		this(context, null);
	}

	public ARE_Toolbar(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ARE_Toolbar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.mContext = (Activity) context;
		init();
	}

	private void init() {
		LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
		layoutInflater.inflate(getLayoutId(), this, true);
		this.setOrientation(LinearLayout.VERTICAL);
		initViews();
		initStyles();
	}

	private int getLayoutId() {
		return R.layout.are_toolbar;
	}

	private void initViews() {

		this.mFontsizeImageView = this.findViewById(R.id.rteFontsize);

		this.mFontfaceImageView = this.findViewById(R.id.rteFontface);

		this.mBoldImageView = this.findViewById(R.id.rteBold);

		this.mItalicImageView = this.findViewById(R.id.rteItalic);

		this.mUnderlineImageView = this.findViewById(R.id.rteUnderline);

		this.mQuoteImageView = this.findViewById(R.id.rteQuote);

		this.mColorPalette = this.findViewById(R.id.rteColorPalette);

		this.mFontColorImageView = this.findViewById(R.id.rteFontColor);

		this.mStrikethroughImageView = this.findViewById(R.id.rteStrikethrough);

		this.mHrImageView = this.findViewById(R.id.rteHr);

		this.mSubscriptImageView = this.findViewById(R.id.rteSubscript);

		this.mSuperscriptImageView = this.findViewById(R.id.rteSuperscript);

		this.mBackgroundImageView = this.findViewById(R.id.rteBackground);

		this.mLinkImageView = this.findViewById(R.id.rteLink);

		this.mRteListNumber = this.findViewById(R.id.rteListNumber);

		this.mRteListBullet = this.findViewById(R.id.rteListBullet);

		this.mRteIndentRight = this.findViewById(R.id.rteIndentRight);

		this.mRteIndentLeft = this.findViewById(R.id.rteIndentLeft);

		this.mRteAlignLeft = this.findViewById(R.id.rteAlignLeft);

		this.mRteAlignCenter = this.findViewById(R.id.rteAlignCenter);

		this.mRteAlignRight = this.findViewById(R.id.rteAlignRight);

	}

	/**
	 *
	 */
	private void initStyles() {
		this.mFontsizeStyle = new ARE_FontSize(this.mFontsizeImageView, this);
		this.mFontfaceStyle = new ARE_Fontface(this.mFontfaceImageView, this);
		this.mBoldStyle = new ARE_Bold(this.mBoldImageView);
		this.mItalicStyle = new ARE_Italic(this.mItalicImageView);
		this.mUnderlineStyle = new ARE_Underline(this.mUnderlineImageView);
		this.mStrikethroughStyle = new ARE_Strikethrough(this.mStrikethroughImageView);
		this.mHrStyle = new ARE_Hr(this.mHrImageView, this);
		this.mSubscriptStyle = new ARE_Subscript(this.mSubscriptImageView);
		this.mSuperscriptStyle = new ARE_Superscript(this.mSuperscriptImageView);
		this.mQuoteStyle = new ARE_Quote(this.mQuoteImageView);
		this.mFontColorStyle = new ARE_FontColor(this.mFontColorImageView, this);
		this.mBackgroundColoStyle = new ARE_BackgroundColor(this.mBackgroundImageView, Color.YELLOW);
		this.mLinkStyle = new ARE_Link(this.mLinkImageView, this);
		this.mListNumberStyle = new ARE_ListNumber(this.mRteListNumber, this);
		this.mListBulletStyle = new ARE_ListBullet(this.mRteListBullet, this);
		this.mIndentRightStyle = new ARE_IndentRight(this.mRteIndentRight, this);
		this.mIndentLeftStyle = new ARE_IndentLeft(this.mRteIndentLeft, this);
		this.mAlignLeft = new ARE_Alignment(this.mRteAlignLeft, Alignment.ALIGN_NORMAL, this);
		this.mAlignCenter = new ARE_Alignment(this.mRteAlignCenter, Alignment.ALIGN_CENTER, this);
		this.mAlignRight = new ARE_Alignment(this.mRteAlignRight, Alignment.ALIGN_OPPOSITE, this);

		this.mStylesList.add(this.mFontsizeStyle);
		this.mStylesList.add(this.mFontfaceStyle);
		this.mStylesList.add(this.mBoldStyle);
		this.mStylesList.add(this.mItalicStyle);
		this.mStylesList.add(this.mUnderlineStyle);
		this.mStylesList.add(this.mStrikethroughStyle);
		this.mStylesList.add(this.mHrStyle);
		this.mStylesList.add(this.mSubscriptStyle);
		this.mStylesList.add(this.mSuperscriptStyle);
		this.mStylesList.add(this.mQuoteStyle);
		this.mStylesList.add(this.mFontColorStyle);
		this.mStylesList.add(this.mBackgroundColoStyle);
		this.mStylesList.add(this.mLinkStyle);
		this.mStylesList.add(this.mListNumberStyle);
		this.mStylesList.add(this.mListBulletStyle);
		this.mStylesList.add(this.mIndentRightStyle);
		this.mStylesList.add(this.mIndentLeftStyle);
		this.mStylesList.add(this.mAlignLeft);
		this.mStylesList.add(this.mAlignCenter);
		this.mStylesList.add(this.mAlignRight);
	}

	public void setEditText(AREditText editText) {
		this.mEditText = editText;
		bindToolbar();
	}

	private void bindToolbar() {
		this.mFontsizeStyle.setEditText(this.mEditText);
		this.mBoldStyle.setEditText(this.mEditText);
		this.mItalicStyle.setEditText(this.mEditText);
		this.mUnderlineStyle.setEditText(this.mEditText);
		this.mStrikethroughStyle.setEditText(this.mEditText);
		this.mHrStyle.setEditText(this.mEditText);
		this.mSubscriptStyle.setEditText(this.mEditText);
		this.mSuperscriptStyle.setEditText(this.mEditText);
		this.mQuoteStyle.setEditText(this.mEditText);
		this.mFontColorStyle.setEditText(this.mEditText);
		this.mBackgroundColoStyle.setEditText(this.mEditText);
		this.mLinkStyle.setEditText(this.mEditText);
	}

	public AREditText getEditText() {
		return this.mEditText;
	}

	public IARE_Style getBoldStyle() {
		return this.mBoldStyle;
	}

	public ARE_Italic getItalicStyle() {
		return this.mItalicStyle;
	}

	public ARE_Underline getUnderlineStyle() {
		return mUnderlineStyle;
	}

	public ARE_Strikethrough getStrikethroughStyle() {
		return mStrikethroughStyle;
	}

	public ARE_Hr getHrStyle() {
		return mHrStyle;
	}

	public ARE_Subscript getSubscriptStyle() {
		return this.mSubscriptStyle;
	}

	public ARE_Superscript getSuperscriptStyle() {
		return this.mSuperscriptStyle;
	}

	public ARE_Quote getQuoteStyle() {
		return mQuoteStyle;
	}

	public ARE_FontColor getTextColorStyle() { return  this.mFontColorStyle; }

	public ARE_BackgroundColor getBackgroundColoStyle() {
		return mBackgroundColoStyle;
	}

	public List<IARE_Style> getStylesList() {
		return this.mStylesList;
	}

	public void toggleColorPalette(ColorPickerListener colorPickerListener) {
		int visibility = this.mColorPalette.getVisibility();
		this.mColorPalette.setColorPickerListener(colorPickerListener);
		if (View.VISIBLE == visibility) {
			this.mColorPalette.setVisibility(View.GONE);
		} else {
			this.mColorPalette.setVisibility(View.VISIBLE);
		}
	}

	public void setColorPaletteColor(int color) {
		this.mColorPalette.setColor(color);
	}
}
