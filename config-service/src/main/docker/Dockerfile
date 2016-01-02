FROM ${docker.baseimage}
${docker.httpproxy}
${docker.httpsproxy}
VOLUME /tmp/gaia.generate
ADD ${project.artifactId}-${project.version}.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8888
ENTRYPOINT ["java", "-Xmx256m", "-Xss32m", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]