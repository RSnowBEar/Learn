<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/raphael/raphael-min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/morris/morris.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/knob/jquery.knob.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/daterangepicker/moment.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/daterangepicker/daterangepicker.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/fastclick/fastclick.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/iCheck/icheck.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/adminLTE/js/app.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/treeTable/jquery.treetable.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/select2/select2.full.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/ckeditor/ckeditor.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/input-mask/jquery.inputmask.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/chartjs/Chart.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/flot/jquery.flot.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="<%=pageContext.getServletContext().getContextPath()%>/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    $(document).ready(function() {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });


    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(function() {
        $("#example1").DataTable();
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });
    });

    $(document).ready(function() {
        // 激活导航位置
        setSidebarActive("admin-index");
    });
</script>


