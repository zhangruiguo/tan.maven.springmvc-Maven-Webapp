<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>dsadas</title>
    <link rel="stylesheet" href="css/kendo.2015.1/kendo.common.min.css" />
    <link rel="stylesheet" href="css/kendo.2015.1/kendo.default.min.css" />
     
    <script src="js/kendo.2015.1/jquery.min.js"></script>
    <script src="js/kendo.2015.1/kendo.web.min.js"></script>
</head>
<body>

<div id="grid"></div>
<script type="text/javascript">
    $(function () {
        var provinces = [{ "ProvinceID": 1, "ProvinceNo": "110000", "ProvinceName": "北京市" }, { "ProvinceID": 2, "ProvinceNo": "120000", "ProvinceName": "天津市" }, { "ProvinceID": 3, "ProvinceNo": "130000", "ProvinceName": "河北省" }, { "ProvinceID": 4, "ProvinceNo": "140000", "ProvinceName": "山西省" }, { "ProvinceID": 5, "ProvinceNo": "150000", "ProvinceName": "内蒙古" }, { "ProvinceID": 6, "ProvinceNo": "210000", "ProvinceName": "辽宁省" }, { "ProvinceID": 7, "ProvinceNo": "220000", "ProvinceName": "吉林省" }, { "ProvinceID": 8, "ProvinceNo": "230000", "ProvinceName": "黑龙江" }, { "ProvinceID": 9, "ProvinceNo": "310000", "ProvinceName": "上海市" }, { "ProvinceID": 10, "ProvinceNo": "320000", "ProvinceName": "江苏省" }, { "ProvinceID": 11, "ProvinceNo": "330000", "ProvinceName": "浙江省" }, { "ProvinceID": 12, "ProvinceNo": "340000", "ProvinceName": "安徽省" }, { "ProvinceID": 13, "ProvinceNo": "350000", "ProvinceName": "福建省" }, { "ProvinceID": 14, "ProvinceNo": "360000", "ProvinceName": "江西省" }, { "ProvinceID": 15, "ProvinceNo": "370000", "ProvinceName": "山东省" }, { "ProvinceID": 16, "ProvinceNo": "410000", "ProvinceName": "河南省" }, { "ProvinceID": 17, "ProvinceNo": "420000", "ProvinceName": "湖北省" }, { "ProvinceID": 18, "ProvinceNo": "430000", "ProvinceName": "湖南省" }, { "ProvinceID": 19, "ProvinceNo": "440000", "ProvinceName": "广东省" }, { "ProvinceID": 20, "ProvinceNo": "450000", "ProvinceName": "广西" }, { "ProvinceID": 21, "ProvinceNo": "460000", "ProvinceName": "海南省" }, { "ProvinceID": 22, "ProvinceNo": "500000", "ProvinceName": "重庆市" }, { "ProvinceID": 23, "ProvinceNo": "510000", "ProvinceName": "四川省" }, { "ProvinceID": 24, "ProvinceNo": "520000", "ProvinceName": "贵州省" }, { "ProvinceID": 25, "ProvinceNo": "530000", "ProvinceName": "云南省" }, { "ProvinceID": 26, "ProvinceNo": "540000", "ProvinceName": "西藏" }, { "ProvinceID": 27, "ProvinceNo": "610000", "ProvinceName": "陕西省" }, { "ProvinceID": 28, "ProvinceNo": "620000", "ProvinceName": "甘肃省" }, { "ProvinceID": 29, "ProvinceNo": "630000", "ProvinceName": "青海省" }, { "ProvinceID": 30, "ProvinceNo": "640000", "ProvinceName": "宁夏" }, { "ProvinceID": 31, "ProvinceNo": "650000", "ProvinceName": "新疆" }, { "ProvinceID": 32, "ProvinceNo": "710000", "ProvinceName": "台湾省" }, { "ProvinceID": 33, "ProvinceNo": "810000", "ProvinceName": "香港" }, { "ProvinceID": 34, "ProvinceNo": "820000", "ProvinceName": "澳门" }];

        $("#grid").kendoGrid({
            dataSource: {
                data: provinces,
                schema: {
                    model: {
                        fields: {
                            ProvinceID: { type: "number" },
                            ProvinceNo: { type: "string" },
                            ProvinceName: { type: "string" }
                        }
                    }
                },
                pageSize: 10
            },
            pageable: {
                input: true,
                numeric: false,
                messages: {
                    display: "{0} - {1} 共 {2} 条数据",
                    empty: "没有数据",
                    page: "页",
                    of: "/ {0}",
                    itemsPerPage: "条每页",
                    first: "第一页",
                    previous: "前一页",
                    next: "下一页",
                    last: "最后一页",
                    refresh: "刷新"
                }
            },
            columns: [{
                field: "ProvinceID",
                title: "省份ID"
            }, {
                field: "ProvinceNo",
                title: "省份编号"
            }, {
                field: "ProvinceName",
                title: "省份名称"
            }]
        });
    });
</script>

</body>
</html>