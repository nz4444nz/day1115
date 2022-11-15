new Vue({
    el:'#indexdiv',
    data:{
        user:{userName:'',passWord:''}
    },
    methods:{
        getLogin:function () {
            var _this = this;
            axios.post('../user/getLogin',_this.user).then(function (response) {
                if(response.data.flag){
                    location.href = "../main/toUserList";
                }else {
                    alert(response.data.msg);
                }
            });
        }
    }
});