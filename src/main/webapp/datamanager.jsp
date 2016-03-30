<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/kendo.2015.1/kendo.common.min.css" />
<link rel="stylesheet" href="css/kendo.2015.1/kendo.default.min.css" />

<script src="js/kendo.2015.1/jquery.min.js"></script>
<script src="js/kendo.2015.1/kendo.web.min.js"></script>
</head>
<body>
	<div>
		<input id="search_report" style="width:280px;" />
		<textarea id="sqltext" rows="10" cols="80" class="k-content">show tables;</textarea>
		<input id="limit" type="checkbox" checked="checked">最多100行数据</input>

	</div>
	<div>
		<button id="sqlsubmit" class="k-button">提交</button>

	</div>
	运行结果
	<div id="gridwraper">
		<div id="ResultGrid" style="width: 750px"></div>
	</div>
	<script type="text/javascript">
    function initGrid(cols, datasource) {
        var grid = $('#ResultGrid').kendoGrid({
            dataSource:datasource,
            pageable: {
                pageSize: 10
            },
            height: 470,
            filterable: true,
            sortable: true,
  
            resizable: true,
            columns: cols
      });
    }
    $(function () {
        $.post("<%=request.getContextPath()%>/book.do?method=getdata",
           {
        	sql: $('#sqltext').val(),
           },
           function (data, status) {
               initGrid(data.columns, data.rows);
       });
        
        $('#sqlsubmit').click(function (e) {
            e.preventDefault();
            var grid = $('#ResultGrid');
            grid.removeData('kendoGrid');
            grid.empty();
            $.post("<%=request.getContextPath()%>/book.do?method=getdata",
												{
													sql : $('#sqltext').val(),
												}, function(data, status) {
													initGrid(data.columns,
															data.rows);
												});
							});
        
        $("#search_report").kendoComboBox({
            dataTextField: "Value",
            dataValueField: "Key",
            change: function (e) {
                location.href = $('#search_report').val();
            },
            dataSource: {
                // serverFiltering: true,
                transport: {
                    read: {
                        url: function (options) {
                            return "<%=request.getContextPath()%>/book.do?method=getmenu";
                        },
                        dataType: "json" // use "json" for same-domain requests;"jsonp" is required for cross-domain requests; 
                    }
                }
            },
            filter: "contains"
        });
		});
	</script>
</body>
</html>