# Java Servlet 課程內容
### 先將 settings 裡所有 encoding 都改成 UTF-8
## 如果用的是 Eclipse，啟動後，打上 http://localhost:8080/JavaServlet 報 404，可以試試用內鍵的 new -> Servlet 可能就一切正常了
### 一、URL
1. http://localhost:80/xxx/ooo?key=value&k=v
2. localhost 表示本機，還可以寫成 IP 位址
3. port 預設為 80
### 二、request、response
1. 用戶端向伺服器端發送請求叫 request
2. 伺服器端回應用戶端請求叫 response
### 三、TCP 三向交握、四次揮手
1.Hi! 我可以和你連線嗎？(req)
2.好的沒問題，你有收到我的回應嗎？(res)
3.好的！我們可以開始連線(req)

1.我的資料都傳給你囉！(req)
2.我也都收到了(res)
3.我們可以中斷連線了(res)
4.好的(req)
### 四、HTTP
1.HTTP 1：短連接，10 個文件，10 次握手
2.HTTP 1.1：長連接，10 個文件，1 次握手
3.HTTP 2：長連接+多路複用(一個連接有多個 request)，header 壓縮
4.HTTP 3：QUIC 協議，主要使用 UDP 取代 TCP
### 五、常用請求方法
1.GET
2.POST