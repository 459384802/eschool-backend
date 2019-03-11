# 基于linux alpine系统的java8镜像
FROM java:8-jre-alpine
# 由于基础镜像是外国的，时区可能不一样
# RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
# 把宿主机的jar包复制到容器
ADD ./eschool-wechat-backend.jar ./app.jar
# 声明应该映射的端口
EXPOSE 80
# 指定容器启动时启动jar服务，并指定环境为test（spring boot）
ENTRYPOINT ["/usr/bin/java","-jar", "-Dspring.profiles.active=pro","app.jar"]