$(function () {


    new AjaxUpload('#upload', {
        action: '../file/upload',
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
                alert('只支持jpg、png、gif格式的图片！');
                return false;
            }
        },
        onComplete: function (file, r) {
            if (r.code == 0) {
                vm.house.img = r.url
            } else {
                alert(r.msg);
            }
        }
    });

});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            xiaoqu: ''
        },
        showAdd: false,
        showInfo: false,
        showList: true,
        title: null,
        users: [],


        salers: [],


        buyers: [],


        house: {},
    },
    created: function () {

        $.getJSON("../saler/list2", function (r) {
            vm.salers = r.list;
        })
        $.getJSON("../buyer/list2", function (r) {
            vm.buyers = r.list;
        })
        this.showAdd = true;
        this.showList = false;
        this.title = "新增";
        this.house = {

            img: '',

        };

    },
    methods: {
        query: function () {
            vm.reload();
        }
        ,
        add: function () {
            this.showAdd = true;
            this.showList = false;
            this.title = "新增";
            this.house = {

                img: '',

            };
        }
        ,
        update: function (event) {
            var id =
                getSelectedRow();
            if (id == null
            ) {
                return;
            }

            vm.showAdd = true;
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        }
        ,
        saveOrUpdate: function (event) {
            var url = vm
                .house.id ==
            null ? "../house/save" : "../house/update";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(vm.house),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            location.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        }
        ,
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../house/delete",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        }
        ,
        getInfo: function (id) {
            $.get("../house/info/" + id, function (r) {
                vm.house = r.house;
            });
        }
        ,
        info: function (id) {
            if (isNaN(id)) {
                id
                    = getSelectedRow();
                if (id == null
                ) {
                    return;
                }
            }
            vm.showAdd = false;
            vm.showList = false;
            vm.showInfo = true;
            vm.title = "详情";

            vm.getInfo(id)
        }
        ,
        reload: function (event) {
            vm.showList = true;
            vm.showInfo = false;
            vm.showAdd = false;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: vm.q,
                page: page
            }).trigger("reloadGrid");
        }
    }
});