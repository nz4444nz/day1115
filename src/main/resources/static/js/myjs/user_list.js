new Vue({
    el:'#app',
    data:{
        list:[],
        pageNum:1,
        pageSize:5,
        pageInfo:{},
        searchEntity:{}
    },
    methods:{
        paging:function(pageNum){
            if(pageNum==0){
                pageNum = 1;
            }
            this.pageNum = pageNum;
            this.findAll();
        },
        findAll() {
            var _this = this
            var url = "../user/findAll?pageNum="+this.pageNum+"&pageSize="+this.pageSize;
            axios.post(url,_this.searchEntity).then(function (response) {
                _this.list = response.data.list
                _this.pageNum = response.data.pageNum;
                _this.pageInfo = response.data;
            })
        },
        deleteUser:function (id) {
            var _this = this;
            var url1 = '../user/deleteUserById?id='+id;
            var url2 = '../user/deleteUserById/'+id;
            axios.get(url2).then(function (response) {
                if(response.data.flag){
                    _this.findAll();
                }else {
                    alert(response.data.msg);
                }
            });
        }
    },
    created(){
        this.findAll();
    }
});