//nginx反向代理配置服务器
// https://www.jianshu.com/p/cc5167032525
//server {
//        listen 80;
//        server_name dreamkmobi.com www.dreamkmobi.com;
//        location / {
//        proxy_set_header Host $host;
//        proxy_set_header X-Real-IP $remote_addr;
//        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
//        proxy_pass http://192.168.192.75:8009;
//        index index.html;
//        }
//        }
//
//        server {
//        listen 80;
//        server_name mobplus.net www.mobplus.net;
//        location / {
//        proxy_set_header Host $host;   //设置服务器地址
//        proxy_set_header X-Real-IP $remote_addr;  设置客户端真实ip 端口
//        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for; 设置服务器地址ip和真实端口
//        proxy_pass http://192.168.192.75:9000; 通过代理服务器后的访问地址
//        index index.html;   //设置默认跳转地址
//        }
//        }