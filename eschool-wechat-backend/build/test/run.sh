#!/bin/sh
cd /root/docker_data/dockerfile/eschool-wechat-backend
# 删除原来的镜像
aa=$(docker images|grep yhc/eschool|awk '{print $1}')
if [ "$aa" != "" ] ; then
echo delete image $aa ...
docker rmi $aa
fi
# 使用当前目录下的dockerfile构建镜像
docker build -t yhc/eschool:test .
# 删除原来的容器
aa=$(docker ps -a|grep eschool|awk '{print $1}')
if [ "$aa" != "" ] ; then
echo delete container $aa ...
docker rm -f $aa
fi
echo run new CONTAINER ...
# 启动容器
docker run -v /etc/timezone:/etc/timezone -v /etc/localtime:/etc/localtime -v /data/logs/eschool-wechat-backend:/logs -d --name eschool -p 80:80 --restart=always yhc/eschool:test