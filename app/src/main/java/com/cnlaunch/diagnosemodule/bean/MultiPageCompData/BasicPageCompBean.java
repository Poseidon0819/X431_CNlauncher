package com.cnlaunch.diagnosemodule.bean.MultiPageCompData;

import android.view.View;
import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class BasicPageCompBean extends BasicBean {
    public static int STDD_COMPATTR_CENT = 4;
    public static int STDD_COMPATTR_DISABL = 2;
    public static int STDD_COMPATTR_ENABLE = 1;
    public static int STDD_COMPBUTS_CLICK = 1;
    public static int STDD_COMPBUTS_POP = 4;
    public static int STDD_COMPBUTS_PUSH = 2;
    public static int STDD_COMPBUTT_PUSH = 8;
    public static int STDD_COMPCHK_SEL = 64;
    public static int STDD_COMPCOMB_INPUT = 16;
    public static int STDD_COMPCOMB_VER = 32;
    public static int STDD_COMPFONT_BLUE = 64;
    public static int STDD_COMPFONT_BOLD = 1;
    public static int STDD_COMPFONT_CENT = 8;
    public static int STDD_COMPFONT_ITAL = 4;
    public static int STDD_COMPFONT_LEFT = 16;
    public static int STDD_COMPFONT_RED = 32;
    public static int STDD_COMPFONT_UNDL = 2;
    public static int STDD_COMPHTML_FILE = 128;
    public static int STDD_COMPKEY_DEC = 1;
    public static int STDD_COMPKEY_HEX = 2;
    public static int STDD_COMPKEY_VIN = 4;
    public static int STDD_COMPTEXT_UPPER = 128;
    public static final int STDD_COMP_BUTTON = 3;
    public static final int STDD_COMP_CHKBOX = 8;
    public static final int STDD_COMP_COMB = 5;
    public static final int STDD_COMP_CPROC = 12;
    public static final int STDD_COMP_CTPLAN = 13;
    public static final int STDD_COMP_CTREE = 11;
    public static final int STDD_COMP_HTML = 10;
    public static final int STDD_COMP_INPBOX = 4;
    public static final int STDD_COMP_LIST = 7;
    public static final int STDD_COMP_PICT = 9;
    public static final int STDD_COMP_PROC = 1;
    public static final int STDD_COMP_SLIP = 6;
    public static final int STDD_COMP_STATIC = 2;
    private int columsForList;
    private int compAttributes;
    private int compType;
    private String content;
    private int horizontalRadios;
    private int horizontalSplitRadios;
    private ArrayList<ArrayList<String>> itemContent;
    private ArrayList<ArrayList<Integer>> itemTextAtt;
    private int keyAttributes;
    private int rowsForList;
    private int sliderMax;
    private int sliderMin;
    private int sliderValue;

    /* renamed from: sn */
    private int f7278sn;
    private BasicTestPlanBean testPlanBean;
    private int textAttributes;
    private String title;
    private int verticalRadios;
    private int verticalSplitRadios;
    public View compView = null;
    private ArrayList<String> arrCombInput = new ArrayList<>();
    private ArrayList<String> arrTitleForList = new ArrayList<>();
    private ArrayList<Integer> arrTitleScaleForList = new ArrayList<>();
    private int sliderStep = 1;
    private int sliderTimes = 1;
    private boolean ifCombCheckInit = false;
    private boolean combChecked = false;
    private int btnClickStatus = 0;
    private int valueProgressBar = 0;
    private HashMap<Integer, ArrayList<Integer>> mapFather2Child = new HashMap<>();
    private HashMap<Integer, BasicMultiPageTreeBean> mapNodeSn2treeBean = new HashMap<>();
    private int currNodeSn = 0;
    private int currNodeSNStatus = 0;
    private int testPlanRetDiagBtnSN = 0;

    public int getTestPlanRetDiagBtnSN() {
        return this.testPlanRetDiagBtnSN;
    }

    public void setTestPlanRetDiagBtnSN(int i) {
        this.testPlanRetDiagBtnSN = i;
    }

    public BasicTestPlanBean getTestPlanBean() {
        return this.testPlanBean;
    }

    public void setTestPlanBean(BasicTestPlanBean basicTestPlanBean) {
        this.testPlanBean = basicTestPlanBean;
    }

    public int getBtnClickStatus() {
        return this.btnClickStatus;
    }

    public void setBtnClickStatus(int i) {
        this.btnClickStatus = i;
    }

    public boolean isCombChecked() {
        return this.combChecked;
    }

    public void setCombChecked(boolean z) {
        this.combChecked = z;
    }

    public boolean getIfCombCheckInit() {
        return this.ifCombCheckInit;
    }

    public void setIfCombCheckInit(boolean z) {
        this.ifCombCheckInit = z;
    }

    public int getSn() {
        return this.f7278sn;
    }

    public void setSn(int i) {
        this.f7278sn = i;
    }

    public int getCompType() {
        return this.compType;
    }

    public void setCompType(int i) {
        this.compType = i;
    }

    public int getHorizontalRadios() {
        return this.horizontalRadios;
    }

    public void setHorizontalRadios(int i) {
        this.horizontalRadios = i;
    }

    public int getVerticalRadios() {
        return this.verticalRadios;
    }

    public void setVerticalRadios(int i) {
        this.verticalRadios = i;
    }

    public int getHorizontalSplitRadios() {
        return this.horizontalSplitRadios;
    }

    public void setHorizontalSplitRadios(int i) {
        this.horizontalSplitRadios = i;
    }

    public int getVerticalSplitRadios() {
        return this.verticalSplitRadios;
    }

    public void setVerticalSplitRadios(int i) {
        this.verticalSplitRadios = i;
    }

    public int getCompAttributes() {
        return this.compAttributes;
    }

    public void setCompAttributes(int i) {
        this.compAttributes = i;
    }

    public int getKeyAttributes() {
        return this.keyAttributes;
    }

    public void setKeyAttributes(int i) {
        this.keyAttributes = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getTextAttributes() {
        return this.textAttributes;
    }

    public void setTextAttributes(int i) {
        this.textAttributes = i;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public ArrayList<String> getArrCombInput() {
        return this.arrCombInput;
    }

    public void setArrCombInput(ArrayList<String> arrayList) {
        this.arrCombInput = arrayList;
    }

    public int getRowsForList() {
        return this.rowsForList;
    }

    public void setRowsForList(int i) {
        this.rowsForList = i;
    }

    public int getColumsForList() {
        return this.columsForList;
    }

    public void setColumsForList(int i) {
        this.columsForList = i;
    }

    public ArrayList<String> getArrTitleForList() {
        return this.arrTitleForList;
    }

    public ArrayList<Integer> getArrTitleScaleForList() {
        return this.arrTitleScaleForList;
    }

    public ArrayList<ArrayList<Integer>> getItemTextAtt() {
        return this.itemTextAtt;
    }

    public void setItemTextAtt(ArrayList<ArrayList<Integer>> arrayList) {
        this.itemTextAtt = arrayList;
    }

    public ArrayList<ArrayList<String>> getItemContent() {
        return this.itemContent;
    }

    public void setItemContent(ArrayList<ArrayList<String>> arrayList) {
        this.itemContent = arrayList;
    }

    public int getSliderValue() {
        return this.sliderValue;
    }

    public void setSliderValue(int i) {
        this.sliderValue = i;
    }

    public int getSliderStep() {
        return this.sliderStep;
    }

    public void setSliderStep(int i) {
        this.sliderStep = i;
    }

    public int getSliderTimes() {
        return this.sliderTimes;
    }

    public void setSliderTimes(int i) {
        this.sliderTimes = i;
    }

    public int getSliderMax() {
        return this.sliderMax;
    }

    public void setSliderMax(int i) {
        this.sliderMax = i;
    }

    public int getSliderMin() {
        return this.sliderMin;
    }

    public void setSliderMin(int i) {
        this.sliderMin = i;
    }

    public int getValueProgressBar() {
        return this.valueProgressBar;
    }

    public void setValueProgressBar(int i) {
        this.valueProgressBar = i;
    }

    public HashMap<Integer, ArrayList<Integer>> getMapFather2Child() {
        return this.mapFather2Child;
    }

    public HashMap<Integer, BasicMultiPageTreeBean> getMapNodeSn2treeBean() {
        return this.mapNodeSn2treeBean;
    }

    public int getCurrNodeSn() {
        return this.currNodeSn;
    }

    public void setCurrNodeSn(int i) {
        this.currNodeSn = i;
    }

    public int getCurrNodeSNStatus() {
        return this.currNodeSNStatus;
    }

    public void setCurrNodeSNStatus(int i) {
        this.currNodeSNStatus = i;
    }
}
