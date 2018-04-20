# ZFOkHttp

1. 对OkHttp做简单的封装；
2. 简化线程切换；

请求方式：
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
