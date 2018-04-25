# ZFOkHttp

1. 对OkHttp做简单的封装；
2. 简化线程切换；
3. 添加在activity的具体生命周期中结束请求；

#####引入方式：

```
compile 'win.whitelife.zfokhttplibrary:zfokhttplibrary:1.0.1'
```

#####请求方式：

```
 HttpClient.getInstanse().newRequest("Http://www.baidu.com").getEnqueue(new IHttpCallback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, String response) throws IOException {
                Log.e(TAG,response) ;
            }
        });
```
