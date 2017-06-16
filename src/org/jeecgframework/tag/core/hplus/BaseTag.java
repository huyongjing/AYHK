package org.jeecgframework.tag.core.hplus;

import org.jeecgframework.core.util.oConvertUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author baohy
 *         <p>
 *         使用方式, 其中的 type 对应常量
 *         %lt;hp:base type="listpageCss"/&gt;
 */
public class BaseTag extends TagSupport {
    private static final long                serialVersionUID = 1L;
    // 加载类型
    protected            String              type             = "default"; //按分类插入的CSS样式,JS
    protected            String              plugins          = ""; //插件
    private              String              ctx              = "";
    private              String[]            pluginAry        = null;
    private              Map<String, String> allCss           = new HashMap<String, String>(); // CSS 集合
    private              Map<String, String> allJs            = new HashMap<String, String>(); // JS 集合

    public static final String HOMEPAGE_CSS = "homepageCss";// 首页样式集合
    public static final String HOMEPAGE_JS  = "homepageJs";// 首页js库集合
    public static final String LISTPAGE_CSS = "listpageCss";// 列表页面 样式集合
    public static final String LISTPAGE_JS  = "listpageJs";// 列表页面 JS集合
    public static final String FORMPAGE_CSS = "formpageCss";// 表单页面 样式集合
    public static final String FORMPAGE_JS  = "formpageJs";// 表单页面 JS集合
    public static final String LISTFORM_CSS = "listformCss";// 列表表单页面 样式集合
    public static final String LISTFORM_JS  = "listformJs";// 列表表单页面 JS集合
    public static final String HPLUS_CSS    = "hplusCss";// 普通页面样式集合
    public static final String HPLUS_JS     = "hplusJs";// 普通页面 JS集合
    public static final String EASYUI_CSS     = "easyuiCss";// 普通easyui页面 JS集合
    public static final String EASYUI_JS     = "easyuiJs";// 普通easyui页面页面 JS集合

    public void setType(String type) {
        this.type = type;
    }

    public int doStartTag() throws JspException {

        ctx = ((HttpServletRequest) this.pageContext.getRequest()).getContextPath();
        pluginAry = plugins.split(",");

        //init all css file
        allCss.put("bootstrap", "<link href=\"" + ctx + "/plug-in-ui/hplus/css/bootstrap.min.css?v=3.3.6\" rel=\"stylesheet\">\n");
        allCss.put("fontAwesome", "<link href=\"" + ctx + "/plug-in-ui/hplus/css/font-awesome.min.css?v=4.4.0\" rel=\"stylesheet\">\n");
        allCss.put("toastr", "<link href=\"" + ctx + "/plug-in-ui/hplus/css/plugins/toastr/toastr.min.css\" rel=\"stylesheet\">\n");
        allCss.put("sweetalert", "<link href=\"" + ctx + "/plug-in-ui/hplus/css/plugins/sweetalert/sweetalert.css\" rel=\"stylesheet\">\n");
        allCss.put("animate", "<link href=\"" + ctx + "/plug-in-ui/hplus/css/animate.css\" rel=\"stylesheet\">\n");
        allCss.put("iCheck", "<link href=\"" + ctx + "/plug-in-ui/hplus/css/plugins/iCheck/custom.css\" rel=\"stylesheet\">\n");
        allCss.put("bootstrapTable", "<link href=\"" + ctx + "/plug-in-ui/hplus/css/plugins/bootstrap-table/bootstrap-table.min.css\" rel=\"stylesheet\">\n");
        allCss.put("style", "<link href=\"" + ctx + "/plug-in-ui/hplus/css/style.css?v=4.1.0\" rel=\"stylesheet\">\n");
        allCss.put("content", "<link href=\"" + ctx + "/plug-in-ui/css/content.css?v=1.0\" rel=\"stylesheet\">\n");
        allCss.put("summernote", "<link href=\"" + ctx + "/plug-in-ui/hplus/css/plugins/summernote/summernote.css?v=1.0\" rel=\"stylesheet\">\n<link href=\"" + ctx + "/plug-in-ui/hplus/css/plugins/summernote/summernote-bs3.css?v=1.0\" rel=\"stylesheet\">\n");
        allCss.put("easyui", "<link rel=\"stylesheet\" type=\"text/css\" href=\"plug-in/accordion/css/accordion.css\">\n" +
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"plug-in/accordion/css/icons.css\">" +
                    "<link rel=\"stylesheet\" href=\"plug-in/easyui/themes/metrole/easyui.css\" type=\"text/css\">\n" +
                    "<link rel=\"stylesheet\" href=\"plug-in/easyui/themes/metrole/main.css\" type=\"text/css\">\n" +
                    "<link rel=\"stylesheet\" href=\"plug-in/easyui/themes/icon.css\" type=\"text/css\">\n");

        //init all javascript file
        // 全局 JS
        allJs.put("jquery", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/jquery.min.js?v=2.1.4\"></script>\n");
        allJs.put("bootstrap", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/bootstrap.min.js?v=3.3.6\"></script>\n");
        // 第三方插件
        allJs.put("iCheck", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/iCheck/icheck.min.js\"></script>\n");
        allJs.put("pace", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/pace/pace.min.js\"></script>\n");
        allJs.put("metisMenu", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/metisMenu/jquery.metisMenu.js\"></script>\n");
        allJs.put("slimscroll", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/slimscroll/jquery.slimscroll.min.js\"></script>\n");
        allJs.put("layer", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/layer/layer.min.js\"></script>\n");
        // Sweet alert
        allJs.put("toastr", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/toastr/toastr.min.js\"></script>\n");
        allJs.put("sweetalert", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/sweetalert/sweetalert.min.js\"></script>\n");
        // cookie storageapi
        allJs.put("cookie", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/ui/jquery.cookie.js\"></script>\n");
        allJs.put("storageapi", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in/jquery-plugs/storage/jquery.storageapi.min.js\"></script>\n");
        // bootstrap table
        allJs.put("bootstrapTable", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/bootstrap-table/bootstrap-table.min.js\"></script>\n");
        allJs.put("bootstrapTableMobile", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js\"></script>\n");
        allJs.put("bootstrapTableLocale", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js\"></script>\n");
        // jquery
        allJs.put("jqueryMigrate", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/jquery-migrate-1.2.1.js\"></script>\n");
        allJs.put("jqueryUI", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/jquery-ui/jquery-ui.min.js\"></script>\n");
        allJs.put("WdatePicker", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in/My97DatePicker/WdatePicker.js\"></script>\n");
        allJs.put("prohibitutil", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in/tools/prohibitutil.js\"></script>\n");

        // 自定义js
        allJs.put("hplus", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/hplus.js?v=4.1.0\"></script>\n");
        allJs.put("contabs", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/contabs.js\"></script>\n");
        allJs.put("content", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/content.js?v=1.0.0\"></script>\n");
        allJs.put("privateUtil", "<script type=\"text/javascript\" src=\"" + ctx + "/core/funcs/address/private/js/privateUtil.js\"></script>\n");
        allJs.put("sys", "<script type=\"text/javascript\" src=\"" + ctx + "/core/js/sys.js\"></script>\n");
        allJs.put("jqueryFormJS", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/js/jquery.form.js\"></script>\n");
        allJs.put("laydate", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/layer/laydate/laydate.js\"></script>\n");
        // summernote
        allJs.put("summernote", "<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/summernote/summernote.min.js\"></script>\n<script type=\"text/javascript\" src=\"" + ctx + "/plug-in-ui/hplus/js/plugins/summernote/summernote-zh-CN.js\"></script>\n");
        allJs.put("ckeditor", "<script type=\"text/javascript\" src=\"plug-in/ckeditor/ckeditor.js\"></script>\n<script type=\"text/javascript\" src=\"plug-in/tools/ckeditorTool.js\"></script>\n");
        allJs.put("ckfinder", "<script type=\"text/javascript\" src=\"plug-in/ckfinder/ckfinder.js\"></script>\n<script type=\"text/javascript\" src=\"plug-in/tools/ckfinderTool.js\"></script>\n");
        allJs.put("steps", "<script type=\"text/javascript\" src=\"plug-in-ui/hplus/js/plugins/staps/jquery.steps.min.js\"></script>\n");

        StringBuffer sb = new StringBuffer();
        sb.append("<script type=\"text/javascript\" src=\"plug-in/tools/dataformat.js\"></script>\n");
        sb.append("<script type=\"text/javascript\" src=\"plug-in/easyui/jquery.easyui.min.1.3.2.js\"></script>\n");
        sb.append("<script type=\"text/javascript\" src=\"plug-in/easyui/locale/zh-cn.js\"></script>\n");
        sb.append("<script type=\"text/javascript\" src=\"plug-in/tools/syUtil.js\"></script>\n");
        sb.append("<script type=\"text/javascript\" src=\"plug-in/easyui/extends/datagrid-scrollview.js\"></script>\n");
        allJs.put("easyui", sb.toString());

        return EVAL_PAGE;
    }

    public int doEndTag() throws JspException {
        String types[] = type.split(",");
        try {
            JspWriter    out = this.pageContext.getOut();
            StringBuffer sb  = new StringBuffer();

            //首页样式
            if (oConvertUtils.isIn(HOMEPAGE_CSS, types)) {
                sb.append(allCss.get("bootstrap"));
                sb.append(allCss.get("fontAwesome"));
                sb.append(allCss.get("sweetalert"));
                sb.append(allCss.get("animate"));
                sb.append(allCss.get("style"));
            }
            //首页样式 JS
            if (oConvertUtils.isIn(HOMEPAGE_JS, types)) {
                sb.append(allJs.get("jquery"));
                sb.append(allJs.get("bootstrap"));
                sb.append(allJs.get("cookie"));
                sb.append(allJs.get("storageapi"));
                sb.append(allJs.get("metisMenu"));
                sb.append(allJs.get("slimscroll"));
                sb.append(allJs.get("layer"));
                sb.append(allJs.get("hplus"));
                sb.append(allJs.get("contabs"));
            }
            //表格页面CSS
            if (oConvertUtils.isIn(LISTPAGE_CSS, types)) {
                sb.append(allCss.get("bootstrap"));
                sb.append(allCss.get("fontAwesome"));
                sb.append(allCss.get("toastr"));
                sb.append(allCss.get("sweetalert"));
                sb.append(allCss.get("animate"));
                sb.append(allCss.get("iCheck"));
                sb.append(allCss.get("bootstrapTable"));
                sb.append(allCss.get("style"));
                sb.append(allCss.get("content"));
            }
            //表格页面JS
            if (oConvertUtils.isIn(LISTPAGE_JS, types)) {
                sb.append(allJs.get("jquery"));
                sb.append(allJs.get("bootstrap"));
                sb.append(allJs.get("cookie"));
                sb.append(allJs.get("storageapi"));
                sb.append(allJs.get("bootstrapTable"));
                sb.append(allJs.get("bootstrapTableMobile"));
                sb.append(allJs.get("bootstrapTableLocale"));
                sb.append(allJs.get("slimscroll"));
                sb.append(allJs.get("iCheck"));
                sb.append(allJs.get("toastr"));
                sb.append(allJs.get("sweetalert"));
                sb.append(allJs.get("content"));
                sb.append(allJs.get("sys"));
            }
            //表单页面CSS
            if (oConvertUtils.isIn(FORMPAGE_CSS, types)) {
                sb.append(allCss.get("bootstrap"));
                sb.append(allCss.get("fontAwesome"));
                sb.append(allCss.get("toastr"));
                sb.append(allCss.get("sweetalert"));
                sb.append(allCss.get("animate"));
                sb.append(allCss.get("iCheck"));
                sb.append(allCss.get("summernote"));
                sb.append(allCss.get("style"));
                sb.append(allCss.get("content"));
            }
            //表单页面JS
            if (oConvertUtils.isIn(FORMPAGE_JS, types)) {
                sb.append(allJs.get("jquery"));
                sb.append(allJs.get("bootstrap"));
                sb.append(allJs.get("cookie"));
                sb.append(allJs.get("storageapi"));
                sb.append(allJs.get("slimscroll"));
                sb.append(allJs.get("iCheck"));
                sb.append(allJs.get("toastr"));
                sb.append(allJs.get("sweetalert"));
                sb.append(allJs.get("summernote"));
                sb.append(allJs.get("content"));
                sb.append(allJs.get("jqueryFormJS"));
                sb.append(allJs.get("sys"));
            }

            //表单列表页面CSS
            if (oConvertUtils.isIn(LISTFORM_CSS, types)) {
                sb.append(allCss.get("bootstrap"));
                sb.append(allCss.get("fontAwesome"));
                sb.append(allCss.get("toastr"));
                sb.append(allCss.get("sweetalert"));
                sb.append(allCss.get("animate"));
                sb.append(allCss.get("iCheck"));
                sb.append(allCss.get("bootstrapTable"));
                sb.append(allCss.get("summernote"));
                sb.append(allCss.get("style"));
                sb.append(allCss.get("content"));
            }
            //表单列表页面JS
            if (oConvertUtils.isIn(LISTFORM_JS, types)) {
                sb.append(allJs.get("jquery"));
                sb.append(allJs.get("bootstrap"));
                sb.append(allJs.get("cookie"));
                sb.append(allJs.get("storageapi"));
                sb.append(allJs.get("slimscroll"));
                sb.append(allJs.get("bootstrapTable"));
                sb.append(allJs.get("bootstrapTableMobile"));
                sb.append(allJs.get("bootstrapTableLocale"));
                sb.append(allJs.get("iCheck"));
                sb.append(allJs.get("toastr"));
                sb.append(allJs.get("sweetalert"));
                sb.append(allJs.get("summernote"));
                sb.append(allJs.get("laydate"));
                sb.append(allJs.get("content"));
                sb.append(allJs.get("jqueryFormJS"));
                sb.append(allJs.get("sys"));
            }

            //普通页面CSS
            if (oConvertUtils.isIn(HPLUS_CSS, types)) {
                appendHplusCss(sb);
            }

            if (oConvertUtils.isIn(HPLUS_JS, types)) {
                appendHplusJs(sb);
            }

            //easyui 普通页面CSS
            if (oConvertUtils.isIn(EASYUI_CSS, types)) {
                sb.append(allCss.get("easyui"));
                appendHplusCss(sb);
            }

            if (oConvertUtils.isIn(EASYUI_JS, types)) {
                sb.append(allJs.get("jquery"));
                sb.append(allJs.get("jqueryMigrate"));
                sb.append(allJs.get("cookie"));
                sb.append(allJs.get("storageapi"));
                sb.append(allJs.get("layer"));
                sb.append(allJs.get("easyui"));
            }

            out.print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    /**
     * 根据插件名称插入CSS
     *
     * @param sb
     * @return
     */
    private StringBuffer appendHplusCss(StringBuffer sb) {
        sb.append(allCss.get("bootstrap"));
        sb.append(allCss.get("fontAwesome"));
        sb.append(allCss.get("animate"));
        sb.append(allCss.get("sweetalert"));
        sb.append(allCss.get("style"));
        if (oConvertUtils.isIn("iCheck", pluginAry)) {
            sb.append(allCss.get("iCheck"));
        }
        if (oConvertUtils.isIn("bootstrapTable", pluginAry)) {
            sb.append(allCss.get("bootstrapTable"));
        }
        return sb;
    }

    /**
     * 根据插件名称插入JS
     *
     * @param sb
     * @return
     */
    private StringBuffer appendHplusJs(StringBuffer sb) {
        sb.append("<!-- 全局js -->\n");
        sb.append(allJs.get("jquery"));
        sb.append(allJs.get("bootstrap"));
        sb.append(allJs.get("layer"));
        sb.append(allJs.get("cookie"));
        sb.append(allJs.get("storageapi"));
        if (oConvertUtils.isIn("jqueryMigrate", pluginAry)) {
            sb.append(allJs.get("jqueryMigrate"));
        }
        if (oConvertUtils.isIn("jqueryUI", pluginAry)) {
            sb.append(allJs.get("jqueryUI"));
        }
        if (oConvertUtils.isIn("DatePicker", pluginAry)) {
            sb.append(allJs.get("WdatePicker"));
        }
        if (oConvertUtils.isIn("laydate", pluginAry)) {
            sb.append(allJs.get("laydate"));
        }
        if (oConvertUtils.isIn("prohibit", pluginAry)) {
            sb.append(allJs.get("prohibitutil"));
        }
        if (oConvertUtils.isIn("metisMenu", pluginAry)) {
            sb.append(allJs.get("metisMenu"));
        }
        if (oConvertUtils.isIn("slimscroll", pluginAry)) {
            sb.append(allJs.get("slimscroll"));
        }
        if (oConvertUtils.isIn("iCheck", pluginAry)) {
            sb.append("<!-- iCheck -->\n");
            sb.append(allJs.get("iCheck"));
        }
        if (oConvertUtils.isIn("pace", pluginAry)) {
            sb.append("<!-- 第三方插件 -->\n");
            sb.append(allJs.get("pace"));
        }
        if (oConvertUtils.isIn("bootstrapTable", pluginAry)) {
            sb.append(allJs.get("bootstrapTable"));
            sb.append(allJs.get("bootstrapTableMobile"));
            sb.append(allJs.get("bootstrapTableLocale"));
        }
        if (oConvertUtils.isIn("steps", pluginAry)) {
            sb.append(allJs.get("steps"));
        }
        sb.append("<!-- Sweet alert -->\n");
        sb.append(allJs.get("sweetalert"));
        sb.append("<!-- 自定义js -->\n");
        sb.append(allJs.get("content"));
        sb.append(allJs.get("jqueryFormJS"));
//        sb.append(allJs.get("sys"));
//        sb.append("<script type=\"text/javascript\" src=\"").append(ctx).append("/core/funcs/address/private/js/privateUtil.js\"></script>\n");
        return sb;
    }


    public String getPlugins() {
        return plugins;
    }

    public void setPlugins(String plugins) {
        this.plugins = plugins;
    }


}
