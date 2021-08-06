#基础镜像
FROM java:8
#镜像的制作人
MAINTAINER mengqizhang
ENV APP_NAME="better-registry-0.0.1"
#定义jar包名称 给个默认值
ARG JAR_NAME=${APP_NAME}.jar
#此处必须这么指定，ARG参数在最终的ENTRYPOINT执行时会出现问题
ENV FILE_NAME="better-registry-0.0.1.jar"
ENV WORK_DIR="/home/mqz/${APP_NAME}"
ENV CONFIG_DIR="/home/mqz/${APP_NAME}/config"
ENV JAVA_MS="1G"
RUN mkdir -p  ${CONFIG_DIR}
#此处指定springboot的启动配置文件（容器内部）
ENV JAVA_OPTS="-Dspring.config.location=${CONFIG_DIR}/application.yml -Djava.security.egd=file:/dev/./urandom -Dlog4j.defaultInitOverride=true -Dorg.apache.tomcat.util.http.ServerCookie.ALLOW_EQUALS_IN_VALUE=true -Dorg.apache.tomcat.util.http.ServerCookie.ALLOW_HTTP_SEPARATORS_IN_V0=true -server  -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -Xmn256m -XX:SurvivorRatio=10 -XX:+UseConcMarkSweepGC -XX:CMSMaxAbortablePrecleanTime=5000 -XX:+CMSClassUnloadingEnabled -XX:CMSInitiatingOccupancyFraction=80 -XX:+UseCMSInitiatingOccupancyOnly -XX:+ExplicitGCInvokesConcurrent -Dsun.rmi.dgc.server.gcInterval=2592000000 -Dsun.rmi.dgc.client.gcInterval=2592000000 -XX:ParallelGCThreads=4 -Djava.awt.headless=true -Dsun.net.client.defaultConnectTimeout=10000 -Dsun.net.client.defaultReadTimeout=30000  -Dfile.encoding=utf-8"
RUN mkdir -p  ${WORK_DIR}
#目的解决docker容器和宿主机时差的问题！
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
WORKDIR ${WORK_DIR}
# 把可执行jar包复制到基础镜像的根目录下
COPY target/${FILE_NAME} ${FILE_NAME}
#声明了容器应该打开的端口并没有实际上将它打开
EXPOSE 1008
#健康检查
#Docker 打包异常 ： [ERROR] Unknown flag: start-period  （ 暂时关闭 ）
#本地打包正常并且能上传到阿里云成功
#docker版本问题，本地docker（macos）：Docker version 20.10.6, build 370c289
#服务器（centOS）： Docker version 1.13.1, build 0be3e21/1.13.1
#HEALTHCHECK --start-period=160s --interval=160s --timeout=160s --retries=10 CMD curl --fail localhost:2000/actuator/health || exit 1
#指定容器启动时要执行的命令，但如果存在CMD指令，CMD中的参数会被附加到ENTRYPOINT指令的后面
ENTRYPOINT ["sh","-c","java ${JAVA_OPTS} -jar ${FILE_NAME}"]