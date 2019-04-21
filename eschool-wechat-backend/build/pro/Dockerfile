# 基于linux alpine系统的java8镜像
FROM java:8-jre-alpine
# 把宿主机的jar包复制到容器
ADD ./eschool.jar ./app.jar
# 声明应该映射的端口
EXPOSE 443
# 指定容器启动时启动jar服务，并指定环境为test（spring boot）
ENTRYPOINT ["/usr/bin/java","-jar", "-Dspring.profiles.active=pro","app.jar"]