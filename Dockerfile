FROM amazonlinux

USER root

RUN yum install maven -y

#RUN cd /opt &&\
#    tar -xvzf /apache-maven-3.6.1-bin.tar.gz &&\
#    export JAVA_HOME="/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.201.b09-0.amzn2.x86_64/bin/" &&\
#    export M2_HOME="/opt/apache-maven-3.6.1" &&\
#    export PATH=$PATH:/opt/apache-maven-3.6.0/bin/ &&\
#    echo $PATH &&\
#    mvn --version  
